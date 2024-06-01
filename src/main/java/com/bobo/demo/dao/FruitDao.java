package com.bobo.demo.dao;

import com.bobo.demo.entity.Fruit;
import com.bobo.demo.entity.Shop;
import com.bobo.demo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitDao {
    public List<Fruit> selectAll(){
        List<Fruit> list=new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("select * from fruit");
            rs=pstmt.executeQuery();
            while (rs.next()){
                Fruit f=new Fruit(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                list.add(f);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return list;
    }


    public int insert(Fruit f){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("insert into fruit(name,price,weight,locations) values (?,?,?,?)");
            pstmt.setString(1,f.getName());
            pstmt.setInt(2,f.getPrice());
            pstmt.setInt(3,f.getWeight());
            pstmt.setString(4,f.getLocations());
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }

        return count;
    }


    public Fruit selectById(int id){
        Fruit f= new Fruit();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("select * from fruit where id=?");
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){
                f=new Fruit(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return f;
    }

    public int update(Fruit f){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("update fruit set name=?,price=?,weight=?,locations=? where id=?");
            pstmt.setString(1,f.getName());
            pstmt.setInt(2,f.getPrice());
            pstmt.setInt(3,f.getWeight());
            pstmt.setString(4,f.getLocations());
            pstmt.setInt(5,f.getId());
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }

        return count;
    }

    public int delete(int id){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("delete from fruit where id=?");
            pstmt.setInt(1,id);
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return count;
    }

    public User login(String username, String userpwd) {
        User user = null;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM tb_user WHERE username = ? AND userpwd = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, userpwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(conn, pstmt, rs);
        }
        return user;
    }

    public int register(User user) {
        int count = 0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO tb_user(username, userpwd,userph) VALUES (?, ?,?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getUserpwd());
            pstmt.setString(3, user.getUserph());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeConnection(conn, pstmt, rs);
        }
        return count;
    }

    public boolean isPhoneRegistered(String userph){
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM tb_user WHERE userph = ?");
            pstmt.setString(1, userph);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    public boolean isUsernameRegistered(String username){
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM tb_user WHERE username = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    public int deleteUser(String username){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("delete from tb_user where username=?");
            pstmt.setString(1,username);
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return count;
    }

    public List<Shop> shopFruit(){
        List<Shop> list=new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("select * from shopfruit");
            rs=pstmt.executeQuery();
            while (rs.next()){
                Shop f=new Shop(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
                list.add(f);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return list;
    }


    public int shopInsert(Shop f){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("insert into shopfruit(sid,name,price,weight,locations) values (?,?,?,?,?)");
            pstmt.setInt(1,f.getSid());
            pstmt.setString(2,f.getName());
            pstmt.setInt(3,f.getPrice());
            pstmt.setInt(4,f.getWeight());
            pstmt.setString(5,f.getLocations());
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return count;
    }

    public int deleteshop(int id){
        int count=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            pstmt=conn.prepareStatement("delete from shopfruit where id=?");
            pstmt.setInt(1,id);
            count=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeConnection(conn,pstmt,rs);
        }
        return count;
    }



}





