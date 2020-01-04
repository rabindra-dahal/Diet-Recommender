package com.dietManager.database.Nutrition.NutrientsDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.Nutrition.Nutrients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NutrientsDAOInterfaceImpl implements NutrientsDAOInterface{
private Connection con;
    @Override
    public int save(Nutrients n) throws Exception {
     con=ConnectionManagement.connect_nutrition();
    String sql="insert into nutrients values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, n.getN_id());
        ps.setString(2,n.getN_name());
        ps.setString(3,n.getUnit());
        int i=ps.executeUpdate();
        con.close();
        return i;      
    
    }

    @Override
    public boolean update(Nutrients n, String n_name) throws Exception {
      con=ConnectionManagement.connect_nutrition();
    String sql="update nutrients set n_name=?,unit=? where n_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, n.getN_name());
        ps.setString(2,n.getUnit());
        ps.setString(3,n_name);
        int i=ps.executeUpdate();
        con.close();
        return true;      
       
    }

    @Override
    public boolean delete(Nutrients n) throws Exception {
    con=ConnectionManagement.connect_nutrition();
    String sql="delete from nutrients where n_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, n.getN_id());
        int i=ps.executeUpdate();
        con.close();
        return true;        
    
    }

    @Override
    public Nutrients findByPK(double n_id) throws Exception {
        Nutrients n=new Nutrients();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from nutrients where n_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,n_id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            n.setN_id(rs.getDouble(1));
            n.setN_name(rs.getString(2));
            n.setUnit(rs.getString(3));           
        }
        con.close();
       
    return n;     
    }
    

    @Override
    public Nutrients findByNutrientsName(String n_name) throws Exception {
       Nutrients n=new Nutrients();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from nutrients where n_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,n_name);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            n.setN_id(rs.getDouble(1));
            n.setN_name(rs.getString(2));
            n.setUnit(rs.getString(3));           
        }
        con.close();
       
    return n;      
    }

    @Override
    public List<Nutrients> findAll() throws Exception {
        con=ConnectionManagement.connect_nutrition();
        String sql="select * from nutrients";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Nutrients> l=new ArrayList<>();
        while(rs.next()){
            Nutrients n=new Nutrients();
            n.setN_id(rs.getDouble(1));
            n.setN_name(rs.getString(2));
             n.setUnit(rs.getString(3));
            l.add(n);
               
        }
        con.close();
        return l;  
    }

}
