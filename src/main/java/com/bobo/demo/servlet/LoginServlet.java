package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;
import com.bobo.demo.entity.Fruit;
import com.bobo.demo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private FruitDao fruitDao;

    @Override
    public void init() throws ServletException {
        super.init();
        fruitDao = new FruitDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String agreement = request.getParameter("agreement");




        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "用户名和密码不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (agreement == null || !agreement.equals("on")) {
            request.setAttribute("errorMessage", "请阅读并同意用户协议");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        User user = fruitDao.login(username, password);
        if (user != null) {
            response.sendRedirect("selectAll");
            request.getSession().setAttribute("username",username);
        } else {
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
