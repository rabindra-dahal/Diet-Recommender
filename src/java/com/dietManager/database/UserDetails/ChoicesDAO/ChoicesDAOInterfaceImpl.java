package com.dietManager.database.UserDetails.ChoicesDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.UserDetails.Choices;
import com.dietManager.model.UserDetails.FoodHabbit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChoicesDAOInterfaceImpl implements ChoicesDAOInterface {

    private Connection con;
    @Override
    public int save(Choices c) throws Exception {
      con=ConnectionManagement.connect();
    String sql="insert into choices values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getU_id());
        ps.setDouble(2,c.getF_id());
        ps.setDouble(3, c.getNo_of_times());
        int i=ps.executeUpdate();
        con.commit();
        con.close();
        return i;  
    }

    @Override
    public boolean update(Choices c, double u_id) throws Exception {
        con=ConnectionManagement.connect();
    String sql="update choices set no_of_times=? where u_id=? and f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getNo_of_times());
        ps.setDouble(2,u_id);
        ps.setDouble(3, c.getF_id());
        int i=ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public boolean delete(Choices c) throws Exception {
    con=ConnectionManagement.connect();
    String sql="delete from  choices where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getU_id());
        int i=ps.executeUpdate();
        con.close();
        return true;    
    }
    
    public List<Choices> findByUF_Id(double u_id,double f_id) throws Exception {
    con=ConnectionManagement.connect();
        String sql="select * from choices where f_id=? and u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ps.setDouble(2,u_id);
        ResultSet rs=ps.executeQuery();
        List<Choices> l=new ArrayList<>();
        while(rs.next()){
            Choices c=new Choices();
            c.setU_id(rs.getDouble(1));
            c.setF_id(rs.getDouble(2));
            c.setNo_of_times(rs.getDouble(3));
            l.add(c);
        }
        con.close();
        return l;       
    }
    

    @Override
    public List<Choices> findByFoodId(double f_id) throws Exception {
    con=ConnectionManagement.connect();
        String sql="select * from choices where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ResultSet rs=ps.executeQuery();
        List<Choices> l=new ArrayList<>();
        while(rs.next()){
            Choices c=new Choices();
            c.setU_id(rs.getDouble(1));
            c.setF_id(rs.getDouble(2));
            c.setNo_of_times(rs.getDouble(3));
            l.add(c);
               
        }
        con.close();
        return l;       
    }
    

    @Override
    public List<Choices> findByUserId(double u_id) throws Exception {
       con=ConnectionManagement.connect();
        String sql="select * from choices where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, u_id);
        ResultSet rs=ps.executeQuery();
        List<Choices> l=new ArrayList<>();
        while(rs.next()){
            Choices c=new Choices();
            c.setU_id(rs.getDouble(1));
            c.setF_id(rs.getDouble(2));
            c.setNo_of_times(rs.getDouble(3));
            l.add(c);
               
        }
        con.close();
        return l;   
    }

    @Override
    public List<Choices> findAll() throws Exception {
    con=ConnectionManagement.connect();
        String sql="select * from choices";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Choices> l=new ArrayList<>();
        while(rs.next()){
            Choices c=new Choices();
            c.setU_id(rs.getDouble(1));
            c.setF_id(rs.getDouble(2));
            c.setNo_of_times(rs.getDouble(3));
            l.add(c);
               
        }
        con.close();
        return l;       
    }

}
