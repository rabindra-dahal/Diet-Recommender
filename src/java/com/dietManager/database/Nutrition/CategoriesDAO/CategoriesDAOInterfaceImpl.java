package com.dietManager.database.Nutrition.CategoriesDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.Nutrition.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOInterfaceImpl implements CategoriesDAOInterface{
private Connection con;
    @Override
    public int save(Categories c) throws Exception {
con=ConnectionManagement.connect_nutrition();
    String sql="insert into categories values (?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getC_id());
        ps.setString(2,c.getC_name());
        int i=ps.executeUpdate();
        con.close();
        return i;       
    }

    @Override
    public boolean update(Categories c, String c_name) throws Exception {
        con=ConnectionManagement.connect_nutrition();
    String sql="update categories set c_name=? where c_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, c.getC_name());
        ps.setString(2,c_name);
        int i=ps.executeUpdate();
        con.close();
        return true; 
          }

    @Override
    public boolean delete(Categories c) throws Exception {
    con=ConnectionManagement.connect_nutrition();
    String sql="delete from categories where c_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, c.getC_name());
        int i=ps.executeUpdate();
        con.close();
        return true;     
    }

    @Override
    public Categories findByPK(double id) throws Exception {
    Categories c=new Categories();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from categories where c_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            c.setC_id(rs.getDouble(1));
            c.setC_name(rs.getString(2));
           
        }
        con.close();
       
    return c;     
    }

    @Override
    public Categories findByCategoriesName(String c_name) throws Exception {
      Categories c=new Categories();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from categories where c_name=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,c_name);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            c.setC_id(rs.getDouble(1));
            c.setC_name(rs.getString(2));
           
        }
        con.close();
       
    return c;     
    }

    @Override
    public List<Categories> findAll() throws Exception {
        con=ConnectionManagement.connect_nutrition();
        String sql="select * from categories";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Categories> l=new ArrayList<>();
        while(rs.next()){
            Categories c=new Categories();
            c.setC_id(rs.getDouble(1));
            c.setC_name(rs.getString(2));
            l.add(c);
               
        }
        con.close();
        return l;      
    }
    
}
