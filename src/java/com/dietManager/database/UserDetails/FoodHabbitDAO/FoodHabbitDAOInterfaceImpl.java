package com.dietManager.database.UserDetails.FoodHabbitDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.model.UserDetails.FoodHabbit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodHabbitDAOInterfaceImpl implements FoodHabbitDAOInterface {

    private Connection con;
    @Override
    public int save(FoodHabbit f) throws Exception {
    con=ConnectionManagement.connect();
    String sql="insert into food_habbit values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f.getU_id());
        ps.setDouble(2,f.getU_id());
        ps.setString(3, f.getMeal());
        int i=ps.executeUpdate();
        con.close();
        return i;
        
    }

    @Override
    public boolean update(FoodHabbit f,double u_id) throws Exception {
    con=ConnectionManagement.connect();
    String sql="update food_habbit set u_id=?,f_id=?,meal=? where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f.getU_id());
        ps.setDouble(2,f.getU_id());
        ps.setString(3, f.getMeal());
        ps.setDouble(4, u_id);
        int i=ps.executeUpdate();
        con.close();
        return true;
    }

    @Override
    public boolean delete(FoodHabbit f) throws Exception {
       con=ConnectionManagement.connect();
    String sql="delete from food_habbit where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f.getU_id());
        int i=ps.executeUpdate();
        con.close();
        return true; 
    }

    @Override
    public List<FoodHabbit> findByFoodId(double f_id) throws Exception {
        con=ConnectionManagement.connect();
        String sql="select * from food_habbit where f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ResultSet rs=ps.executeQuery();
        List<FoodHabbit> l=new ArrayList<>();
        while(rs.next()){
            FoodHabbit f=new FoodHabbit();
            f.setU_id(rs.getDouble(1));
            f.setF_id(rs.getDouble(2));
            f.setMeal(rs.getString(3));
            l.add(f);
               
        }
        con.close();
        return l;   
    
    
    }

    @Override
    public List<FoodHabbit> findByMealType(String meal) throws Exception {
    con=ConnectionManagement.connect();
        String sql="select * from food_habbit where meal=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, meal);
        ResultSet rs=ps.executeQuery();
        List<FoodHabbit> l=new ArrayList<>();
        while(rs.next()){
            FoodHabbit f=new FoodHabbit();
            f.setU_id(rs.getDouble(1));
            f.setF_id(rs.getDouble(2));
            f.setMeal(rs.getString(3));
            l.add(f);
               
        }
        con.close();
        return l;       
    }

    @Override
    public List<FoodHabbit> findByUserId(double u_id) throws Exception {
        con=ConnectionManagement.connect();
        String sql="select * from food_habbit where u_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, u_id);
        ResultSet rs=ps.executeQuery();
        List<FoodHabbit> l=new ArrayList<>();
        while(rs.next()){
            FoodHabbit f=new FoodHabbit();
            f.setU_id(rs.getDouble(1));
            f.setF_id(rs.getDouble(2));
            f.setMeal(rs.getString(3));
            l.add(f);
               
        }
        con.close();
        return l;   
    }

    @Override
    public List<FoodHabbit> findAll() throws Exception {
     con=ConnectionManagement.connect();
        String sql="select * from food_habbit";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<FoodHabbit> l=new ArrayList<>();
        while(rs.next()){
            FoodHabbit f=new FoodHabbit();
            f.setU_id(rs.getDouble(1));
            f.setF_id(rs.getDouble(2));
            f.setMeal(rs.getString(3));
            l.add(f);
               
        }
        con.close();
        return l;       
    
    
    }

}
