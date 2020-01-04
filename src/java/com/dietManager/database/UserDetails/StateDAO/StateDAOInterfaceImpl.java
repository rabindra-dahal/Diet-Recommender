package com.dietManager.database.UserDetails.StateDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterface;
import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterfaceImpl;
import com.dietManager.model.UserDetails.General;
import com.dietManager.model.UserDetails.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StateDAOInterfaceImpl implements StateDAOInterface{
private Connection con; 
    @Override
    public int save(State s) throws Exception {
      con=ConnectionManagement.connect();
    String sql="insert into state values (?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, s.getU_id());
        ps.setDouble(2, s.getHeight());
        ps.setDouble(3, s.getWeight());
        ps.setDouble(4, s.getWorking_hrs());
        ps.setDouble(5, s.getAge());
        ps.setString(6, s.getFood_habbit());
        int i=ps.executeUpdate();
        return i;       
      
    }

    @Override
    public boolean update(State s) throws Exception {
        
        String sql="update state set height=?,weight=?,working_hrs=?,age=?,food_habbit=?,u_id=? where u_id=?";
        Connection con=ConnectionManagement.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, s.getHeight());
        ps.setDouble(2, s.getWeight());
        ps.setDouble(3, s.getWorking_hrs());
        ps.setDouble(4, s.getAge());
        ps.setString(5, s.getFood_habbit());
        ps.setDouble(6, s.getU_id());
         ps.setDouble(7,s.getU_id() );
        int i=ps.executeUpdate();
        
        
     //con=ConnectionManagement.connect();
    // GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
      //  General g=new General();
       // g.setU_name(u_name);
       // g=imp.generalFindByName(g.getU_name());  
                
    /*String sql="update state set height=?,weight=?,working_hrs=?,age=?,food_habbit=?,u_id=? where u_id=?";
    
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, s.getHeight());
        ps.setDouble(2, s.getWeight());
        ps.setDouble(3, s.getWorking_hrs());
        ps.setDouble(4, s.getAge());
        ps.setString(5, s.getFood_habbit());
        ps.setDouble(6, s.getU_id());
         ps.setDouble(7, s.getU_id());
        int i=ps.executeUpdate();*/
        return true;          
    
    }

    @Override
    public boolean delete(State s,String u_name) throws Exception {
      con=ConnectionManagement.connect();
     GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
        General g=new General();
        g.setU_name(u_name);
        g=imp.generalFindByName(g.getU_name());     
    String sql="delete  from state where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, g.getU_id());
        int i=ps.executeUpdate();
        return true;           
    
    }

    @Override
    public State findByPK(double u_id) throws Exception {
    State s=new State();
     con=ConnectionManagement.connect();
    String sql="select * from state where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1,u_id);
        ResultSet rs=ps.executeQuery();
           if(rs.next()){
           
            s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            
        }
       
    return s;    
    }

    @Override
    public List<State> findByHeight(double height) throws Exception {
     Connection con=ConnectionManagement.connect();
        String sql="select * from state where height=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, height);
        ResultSet rs=ps.executeQuery();
        List<State> l=new ArrayList<>();
        while(rs.next()){
            State s=new State();
             s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            l.add(s);
               
        }
        con.close();
        return l;
        
          
    }

    @Override
    public List<State> findByWorkingHrs(double working_hrs) throws Exception {
          Connection con=ConnectionManagement.connect();
        String sql="select * from state where working_hrs=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, working_hrs);
        ResultSet rs=ps.executeQuery();
        List<State> l=new ArrayList<>();
        while(rs.next()){
            State s=new State();
             s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            l.add(s);
               
        }
        con.close();
        return l;
        
          
    }

    @Override
    public List<State> findByAge(double age) throws Exception {
        
       Connection con=ConnectionManagement.connect();
        String sql="select * from state where age=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, age);
        ResultSet rs=ps.executeQuery();
        List<State> l=new ArrayList<>();
        while(rs.next()){
            State s=new State();
             s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            l.add(s);
               
        }
        con.close();
        return l;
    }

    @Override
    public List<State> findByFoodHabbit(String food_habbit) throws Exception {
      
       Connection con=ConnectionManagement.connect();
        String sql="select * from state where food_habbit=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, food_habbit);
        ResultSet rs=ps.executeQuery();
        List<State> l=new ArrayList<>();
        while(rs.next()){
            State s=new State();
             s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            l.add(s);
               
        }
        con.close();
        return l;  
    }

    @Override
    public List<State> findAll() throws Exception {
        Connection con=ConnectionManagement.connect();
        String sql="select * from state";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<State> l=new ArrayList<>();
        while(rs.next()){
            State s=new State();
             s.setU_id(rs.getDouble(1));
            s.setHeight(rs.getDouble(2));
            s.setWeight(rs.getDouble(3));
            s.setWorking_hrs(rs.getDouble(4));
            s.setAge(rs.getDouble(5));
            s.setFood_habbit(rs.getString(6));
            l.add(s);
               
        }
        con.close();
        return l;   
    
    }

  

}
