package com.dietManager.database.Nutrition.BelongsDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.Nutrition.Belongs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BelongsDAOInterfaceImpl implements BelongsDAOInterface {
    private Connection con;
    @Override
    public int save(Belongs b) throws Exception {
         con=ConnectionManagement.connect_nutrition();
    String sql="insert into belongs values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, b.getF_id());
        ps.setDouble(2,b.getC_id());
        int i=ps.executeUpdate();
        con.close();
        return i;  
    }

    @Override
    public boolean update(Belongs b, double f_id) throws Exception {
       con=ConnectionManagement.connect_nutrition();
    String sql="update belongs set f_id=?,c_id=? where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, b.getF_id());
        ps.setDouble(2,b.getC_id());
        ps.setDouble(3, f_id);
        int i=ps.executeUpdate();
        con.close();
        return true;      
    }

    @Override
    public boolean delete(Belongs b) throws Exception {
    con=ConnectionManagement.connect_nutrition();
    String sql="delete from belongs where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(3, b.getF_id());
        int i=ps.executeUpdate();
        con.close();
        return true;    
    }

    @Override
    public Belongs findByFoodId(double f_id) throws Exception {
    Belongs b=new Belongs();
     con=ConnectionManagement.connect_nutrition();
    String sql="select * from belongs where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,f_id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            b.setC_id(rs.getDouble(1));
            b.setF_id(rs.getDouble(2));
           
        }
        con.close();
       
    return b;       
    
    }

    @Override
    public List<Belongs> findByCategoriesId(double c_id) throws Exception {
    con=ConnectionManagement.connect_nutrition();
        String sql="select * from belongs where c_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c_id);
        ResultSet rs=ps.executeQuery();
        List<Belongs> l=new ArrayList<>();
        while(rs.next()){
            Belongs b=new Belongs();
             b.setC_id(rs.getDouble(1));
             b.setF_id(rs.getDouble(2));
            l.add(b);
               
        }
        con.close();
        return l;       
    
    }

    @Override
    public List<Belongs> findAll() throws Exception {
    con=ConnectionManagement.connect_nutrition();
        String sql="select * from belongs";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Belongs> l=new ArrayList<>();
        while(rs.next()){
            Belongs b=new Belongs();
             b.setC_id(rs.getDouble(1));
             b.setF_id(rs.getDouble(2));
            l.add(b);
               
        }
        con.close();
        return l;      
    
    }

}
