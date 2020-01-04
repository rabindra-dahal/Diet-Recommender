package com.dietManager.model.Nutrition;

import com.dietManager.connectionManager.ConnectionManagement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Nutrients {
    private double n_id;
    private String n_name;
    private String unit;
    private Connection con;
     public double key_generator() throws Exception{
        con=ConnectionManagement.connect_nutrition();
        String counter="select count(*) count from nutrients";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            double incrementer=0;
            while(rs.next()){
                incrementer+=rs.getDouble("count");
                       
            }
            incrementer+=1;
            return incrementer;
        
    }

    public Nutrients() {
    }

    public Nutrients(String n_name, String unit) throws Exception {
        double nid;
        nid=key_generator();
        this.n_id = nid;
        this.n_name = n_name;
        this.unit = unit;
    }

    public double getN_id() {
        return n_id;
    }

    public void setN_id(double n_id) {
        this.n_id = n_id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Nutrients{" + "n_id=" + n_id + ", n_name=" + n_name + ", unit=" + unit + '}';
    }
    
    
    
}
