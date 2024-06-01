package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;
import com.bobo.demo.entity.Fruit;
import com.bobo.demo.entity.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/shopfruitservlet")
public class ShopFruitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);

    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        FruitDao fd = new FruitDao();
        List<Shop> shops = fd.shopFruit();
        request.getSession().setAttribute("f",shops);
        request.getRequestDispatcher("shopFruit.jsp").forward(request,response);
    }

}
