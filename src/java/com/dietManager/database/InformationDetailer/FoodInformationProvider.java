package com.dietManager.database.InformationDetailer;

import com.dietManager.connectionManager.ConnectionManagement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodInformationProvider {

    private double f_id;
    private double c_id;
    private String f_name;
    private String c_name;
    private Connection con;

    public FoodInformationProvider() {
    }

    public double getF_id() {
        return f_id;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }

    public double getC_id() {
        return c_id;
    }

    public void setC_id(double c_id) {
        this.c_id = c_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "FoodInformationProvider{" + "f_id=" + f_id + ", c_id=" + c_id + ", f_name=" + f_name + ", c_name=" + c_name + '}';
    }
     public FoodInformationProvider findFoodCategoryInformation(double fid) throws Exception {
       FoodInformationProvider f=new FoodInformationProvider();
     con=ConnectionManagement.connect_nutrition();
    /*String sql="select f.f_id FoodId,c.c_id categoryId,f.f_name foodName,c.c_name categoryName from food f,categories c,belongs b " +
                " where " +
                " f.f_id=b.f_id " +
                " and " +
                " b.c_id=c.c_id " +
                " and " +
                " b.f_id=?";*/
    String sql;
    sql="select f.f_id FoodId,c.c_id categoryId,f.f_name foodName,c.c_name categoryName from food f,categories c,belongs b where f.f_id=b.f_id and b.c_id=c.c_id and b.f_id="+fid+""; 
                
              
        Statement ps=con.createStatement();
        
        ResultSet rs=ps.executeQuery(sql);
        if(rs.next()){
            f.setF_id(rs.getDouble("FoodId"));
             f.setC_id(rs.getDouble("categoryId"));
            f.setF_name(rs.getString("foodName"));
            f.setC_name(rs.getString("categoryName"));           
        }
        con.close();
       
    return f;      
    }

    
}
