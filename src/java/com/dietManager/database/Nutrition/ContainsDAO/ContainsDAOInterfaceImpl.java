package com.dietManager.database.Nutrition.ContainsDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.Nutrition.Contains;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContainsDAOInterfaceImpl implements ContainsDAOInterface {

    private Connection con;
    @Override
    public int save(Contains c) throws Exception {
        con=ConnectionManagement.connect_nutrition();
    String sql="insert into contains values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getF_id());
        ps.setDouble(2,c.getN_id());
        ps.setDouble(3,c.getAmount());
        int i=ps.executeUpdate();
        con.close();
        return i;  

    }

    @Override
    public boolean update(Contains c,double f_id) throws Exception {
        con=ConnectionManagement.connect_nutrition();
    String sql="update contains  set f_id=?,n_id=?,amount=? where f_id=? ";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getF_id());
        ps.setDouble(2,c.getN_id());
        ps.setDouble(3,c.getAmount());
        ps.setDouble(4, f_id);
        int i=ps.executeUpdate();
        con.close();
        return true; 
    }

    @Override
    public boolean delete(Contains c) throws Exception {
    con=ConnectionManagement.connect_nutrition();
    String sql="delete from  contains   where f_id=? ";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, c.getF_id());
        int i=ps.executeUpdate();
        con.close();
        return true;     
    }

    @Override
    public List<Contains> findByFoodId(double f_id) throws Exception {
        con=ConnectionManagement.connect_nutrition();
        String sql="select * from contains where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ResultSet rs=ps.executeQuery();
        List<Contains> l=new ArrayList<>();
        while(rs.next()){
            Contains c=new Contains();
            c.setF_id(rs.getDouble(1));
            c.setN_id(rs.getDouble(2));
             c.setAmount(rs.getDouble(3));
            l.add(c);
               
        }
        con.close();
        return l;  
    }

    @Override
    public List<Contains> findAll() throws Exception {
        con=ConnectionManagement.connect_nutrition();
        String sql="select * from contains";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Contains> l=new ArrayList<>();
        while(rs.next()){
            Contains c=new Contains();
            c.setF_id(rs.getDouble(1));
            c.setN_id(rs.getDouble(2));
             c.setAmount(rs.getDouble(3));
            l.add(c);
               
        }
        con.close();
        return l;  
    }

}
