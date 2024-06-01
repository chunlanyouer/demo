package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;
import com.bobo.demo.entity.Fruit;
import com.bobo.demo.entity.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shopfruitinsert")
public class ShopFruitInsert extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer id = Integer.valueOf(request.getParameter("id"));

        FruitDao fruitDao = new FruitDao();
        Fruit fruit = fruitDao.selectById(id);
        Shop shop = new Shop();
        shop.setSid(fruit.getId());
        shop.setName(fruit.getName());
        shop.setPrice(fruit.getPrice());
        shop.setWeight(fruit.getWeight());
        shop.setLocations(fruit.getLocations());

        int i = fruitDao.shopInsert(shop);
        String str=null;
        if(i>0){
            str="添加成功";

        }else {
            str="添加失败";
        }
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('"+str+"');");
        out.print("location.href='selectAll'");
        out.print("</script>");
        out.close();
    }
}

