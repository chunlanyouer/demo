package com.bobo.demo.servlet;

import com.bobo.demo.dao.FruitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/deleteshopservlet")
public class DeleteShopServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Integer id =Integer.valueOf(request.getParameter("id"));
        String mai = request.getParameter("mai");


        FruitDao fd = new FruitDao();
        int count = fd.deleteshop(id);
        String str=null;
        if(count>0){
            if (mai.equals("1")){
                response.sendRedirect("shopsuccess.jsp");
            }else {
                str = "删除成功";
            }

        }else {
            str="删除失败";
        }
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('"+str+"');");
        out.print("location.href='shopfruitservlet'");
        out.print("</script>");
        out.close();



    }
}
