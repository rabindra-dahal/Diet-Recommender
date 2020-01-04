package com.dietManager.database.UserDetails.GoalTableDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.UserDetails.GoalTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoalTableDAOImpl implements GoalTableDAOinterface{
private Connection con;
    @Override
    public int save(GoalTable gt) throws Exception {
    con=ConnectionManagement.connect();
    String sql="insert into goal_table values (?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, gt.getAge());
        ps.setDouble(2, gt.getEnergyLimit());
        int i=ps.executeUpdate();
        con.close();
        return i;       
    
    }

    @Override
    public boolean update(GoalTable gt) throws Exception {
        con=ConnectionManagement.connect();
    String sql="update goal_table  set energy_limit=? where age=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, gt.getAge());
        ps.setDouble(2, gt.getEnergyLimit());
        int i=ps.executeUpdate();
        con.close();
        return true;       
    
    }

    @Override
    public boolean delete(GoalTable gt) throws Exception {
      con=ConnectionManagement.connect();
    String sql="delete from goal_table where age=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, gt.getAge());
        ps.executeUpdate();
        con.close();
        return true;   
    }

    @Override
    public GoalTable findByAge(double age) throws Exception {
    GoalTable gt=new GoalTable();
     con=ConnectionManagement.connect();
    String sql="select * from goal_table where age=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,age);
        ResultSet rs=ps.executeQuery();
           if(rs.next()){
           
            gt.setAge(rs.getDouble(1));
            gt.setEnergyLimit(rs.getDouble(2));
            
        }
       con.close();
    return gt;    
    
    
    }

    @Override
    public GoalTable findByEnergyLimit(double energyLimit) throws Exception {
       GoalTable gt=new GoalTable();
     con=ConnectionManagement.connect();
    String sql="select * from goal_table where energy_limit=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,energyLimit);
        ResultSet rs=ps.executeQuery();
           if(rs.next()){
           
            gt.setAge(rs.getDouble(1));
            gt.setEnergyLimit(rs.getDouble(2));
            
        }
       con.close();
    return gt;   
    
    }

    @Override
    public List<GoalTable> findAll() throws Exception {
        Connection con=ConnectionManagement.connect();
        String sql="select * from  goal_table";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<GoalTable> l=new ArrayList<>();
        while(rs.next()){
            GoalTable gt=new GoalTable();
             gt.setAge(rs.getDouble(1));
            gt.setEnergyLimit(rs.getDouble(2));
            l.add(gt);
               
        }
        con.close();
        return l;
    }
    
    
}
