package com.dietManager.model.Nutrition;

import com.dietManager.connectionManager.ConnectionManagement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Food {
    private double f_id;
    private String f_name;
    private Connection con;
     public double key_generator() throws Exception{
        con=ConnectionManagement.connect_nutrition();
        String counter="select count(*) count from food";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            double incrementer=0;
            while(rs.next()){
                incrementer+=rs.getDouble("count");
                       
            }
            incrementer+=1;
            return incrementer;
        
    }

    public Food() {
    }

    public Food( String f_name) throws Exception {
        double fid;
        fid=key_generator();
        this.f_id = fid;
        this.f_name = f_name;
    }

    public double getF_id() {
        return f_id;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    @Override
    public String toString() {
        return "Food{" + "f_id=" + f_id + ", f_name=" + f_name + '}';
    }

}
