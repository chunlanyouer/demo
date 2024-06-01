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


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");
        Integer id =Integer.valueOf(request.getParameter("id"));
        Integer price =Integer.valueOf(request.getParameter("price"));
        Integer weight =Integer.valueOf(request.getParameter("weight"));
        String locations = request.getParameter("locations");
        Fruit fruit = new Fruit();
        fruit.setLocations(locations);
        fruit.setWeight(weight);
        fruit.setPrice(price);
        fruit.setName(name);
        fruit.setId(id);


        FruitDao fd = new FruitDao();
        int count = fd.update(fruit);
        String str=null;
        if(count>0){
            str="修改成功";

        }else {
            str="修改失败";
        }
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('"+str+"');");
        out.print("location.href='selectAll'");
        out.print("</script>");
        out.close();



    }
}
