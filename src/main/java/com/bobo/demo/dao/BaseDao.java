package com.bobo.demo.dao;

import com.sun.xml.internal.ws.api.ResourceLoader;

import java.sql.*;

public class BaseDao {


    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/fruit";
            String username="root";
            String password="root";
            conn= DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            pstmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
