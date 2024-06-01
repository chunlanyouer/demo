package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;
import com.bobo.demo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private FruitDao fruitDao;

    @Override
    public void init() throws ServletException {
        super.init();
        fruitDao = new FruitDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String phone = request.getParameter("phone");


        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty()) {
            request.setAttribute("errorMessage", "所有字段都是必填的。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }


        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "密码和确认密码不一致。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (fruitDao.isUsernameRegistered(username)) {
            request.setAttribute("errorMessage", "该用户名已被注册。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (fruitDao.isPhoneRegistered(phone)) {
            request.setAttribute("errorMessage", "该手机号已被注册。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!isValidUsername(username)) {
            request.setAttribute("errorMessage", "用户名只能包含字母和数字。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setUserpwd(password);
        user.setUserph(phone);

        int rowsInserted = fruitDao.register(user);
        if (rowsInserted > 0) {
            request.setAttribute("successMessage", "注册成功！即将跳转到登录页面...");
            request.getRequestDispatcher("registersuccess.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "注册失败，请稍后再试。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private boolean isValidUsername(String username) {
        String pattern = "^[a-zA-Z0-9]+$";
        return Pattern.matches(pattern, username);
    }
}
