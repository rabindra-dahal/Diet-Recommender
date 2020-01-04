package com.dietManager.model.Nutrition;

import com.dietManager.connectionManager.ConnectionManagement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Categories {
    private double c_id;
    private String c_name;
     private Connection con;
     public double key_generator() throws Exception{
        con=ConnectionManagement.connect_nutrition();
        String counter="select count(*) count from categories";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            double incrementer=0;
            while(rs.next()){
                incrementer+=rs.getDouble("count");
                       
            }
            incrementer+=1;
            return incrementer;
        
    }

    public Categories(String c_name) throws Exception {
        double cid;
        cid=key_generator();
        this.c_id = cid;
        this.c_name = c_name;
    }

    public Categories() {
    }

    public double getC_id() {
        return c_id;
    }

    public void setC_id(double c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "Categories{" + "c_id=" + c_id + ", c_name=" + c_name + '}';
    }

    
}
