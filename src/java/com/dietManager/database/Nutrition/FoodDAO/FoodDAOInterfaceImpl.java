package com.dietManager.database.Nutrition.FoodDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.Nutrition.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDAOInterfaceImpl implements FoodDAOInterface{

    private Connection con;
    @Override
    public int save(Food f) throws Exception {
    con=ConnectionManagement.connect_nutrition();
    String sql="insert into food values (?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f.getF_id());
        ps.setString(2,f.getF_name());
        int i=ps.executeUpdate();
        con.close();
        return i;
       
    }

    @Override
    public boolean update(Food f, String f_name) throws Exception {
       con=ConnectionManagement.connect_nutrition();
    String sql="update food set f_name=? where f_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,f.getF_name());
        ps.setString(2,f_name);
        ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public boolean delete(Food f) throws Exception {
        
         con=ConnectionManagement.connect_nutrition();
    String sql="delete from food where f_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,f.getF_name());
        ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public Food findByPK(double id) throws Exception {
     Food f=new Food();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from food where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            f.setF_id(rs.getDouble(1));
            f.setF_name(rs.getString(2));
           
        }
        con.close();
       
    return f;  
    
    }

    @Override
    public Food findByFoodName(String f_name) throws Exception {
    Food f=new Food();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from food where f_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,f_name+" ");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            f.setF_id(rs.getDouble(1));
            f.setF_name(rs.getString(2));
           
        }
        con.close();
       
    return f;  
        
    
    }

    
    public Food findByFoodName1(String f_name) throws Exception {
    Food f=new Food();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from food where f_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,f_name);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            f.setF_id(rs.getDouble(1));
            f.setF_name(rs.getString(2));
           
        }
        con.close();
       
    return f;  
        
    
    }
    
    @Override
    public List<Food> findAll() throws Exception {
    con=ConnectionManagement.connect_nutrition();
        String sql="select * from food";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Food> l=new ArrayList<>();
        while(rs.next()){
            Food f=new Food();
            f.setF_id(rs.getDouble(1));
            f.setF_name(rs.getString(2));
            l.add(f);
               
        }
        con.close();
        return l;   
    
    }
    
    
}
