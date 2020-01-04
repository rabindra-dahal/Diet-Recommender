package com.dietManager.database.UserDetails.GeneralDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.UserDetails.General;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneralDAOInterfaceImpl implements GeneralDAOInterface {

    private Connection con;

    @Override
    public int save(General g) throws Exception {
        con = ConnectionManagement.connect();
        String sql = "insert into general values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, g.getU_id());
        ps.setString(2, g.getU_name());
        ps.setString(3, g.getGender());
        ps.setString(4, g.getPassword());
        int i = ps.executeUpdate();
        return i;
    }

    @Override
    public boolean update(General g, String u_name) throws Exception {
        con = ConnectionManagement.connect();
        String sql = "update general set u_name=?,gender=?,password=? where u_name=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, g.getU_name());
        ps.setString(2, g.getGender());
        ps.setString(3, g.getPassword());
        ps.setString(4, u_name);
        ps.executeUpdate();

        return true;
    }

    @Override
    public boolean delete(General g) throws Exception {
        con = ConnectionManagement.connect();
        String sql = "delete from general where u_name=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, g.getU_name());
        ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public General findByPK(double id) throws Exception {
        General g = new General();
        con = ConnectionManagement.connect();
        String sql = "select u_id,u_name,gender,password from general where u_id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
        }
        con.close();
        return g;
    }

    @Override
    public General findByName(String name) throws Exception {
        General g = new General();
        con = ConnectionManagement.connect();
        String sql = "select u_id,u_name,gender,password from general where u_name=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
        }
        con.close();
        return g;

    }

    @Override
    public List<General> findAll() throws Exception {
        Connection con = ConnectionManagement.connect();
        String sql = "select * from general";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<General> l = new ArrayList<>();
        while (rs.next()) {
            General g = new General();
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
            l.add(g);
        }
        con.close();
        return l;

    }

    @Override
    public General findByNameAndPassword(String u_name, String password) throws Exception {
        General g = new General();
        con = ConnectionManagement.connect();
        String sql = "select u_id,u_name,gender,password from general where u_name=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u_name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
        }
        con.close();
        return g;

    }

    @Override
    public boolean verifyUserLoginData(String u_name, String password) throws Exception {
     General g = new General();
     con = ConnectionManagement.connect();
        String sql = "select u_id,u_name,gender,password from general where u_name=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u_name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
        }
        con.close();
        return true;   
    
    
    }

}
