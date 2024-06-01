package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;
import com.bobo.demo.entity.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/selectById")
public class SelectByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer id =Integer.valueOf(request.getParameter("id"));



        FruitDao fd = new FruitDao();
        Fruit fruit = fd.selectById(id);
        request.setAttribute("f",fruit);
        request.getRequestDispatcher("update.jsp").forward(request,response);



    }
}
