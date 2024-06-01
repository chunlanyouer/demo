package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/deleteuserservlet")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doPost(request, response);
    }



    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = (String) request.getSession().getAttribute("username");

        FruitDao fruitDao = new FruitDao();
        int delete = fruitDao.deleteUser(username);
        String str=null;
        if(delete>0){
            request.setAttribute("successMessage", "注销成功！即将跳转到登录页面...");
            request.getRequestDispatcher("deletesuccess.jsp").forward(request, response);
        }else {
            str="注销失败，用户已注销或用户不存在！";
        }
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('"+str+"');");
        out.print("location.href='selectAll'");
        out.print("</script>");
        out.close();
    }
}



