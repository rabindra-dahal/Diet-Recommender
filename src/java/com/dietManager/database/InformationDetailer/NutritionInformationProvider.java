package com.dietManager.database.InformationDetailer;

import com.dietManager.connectionManager.ConnectionManagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NutritionInformationProvider {
    private double f_id;
    private double n_id;
    private double amount;
    private String f_name;
    private String n_name;
    private String unit;

    private Connection con;
    public NutritionInformationProvider() {
    }

    public double getF_id() {
        return f_id;
    }
    
    public String getF_name(){
        return f_name;
    }

    public void setF_id(double f_id) {
        this.f_id = f_id;
    }
    
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public double getN_id() {
        return n_id;
    }

    public void setN_id(double n_id) {
        this.n_id = n_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        return "NutritionInformationProvider{" + "f_id=" + f_id + ", n_id=" + n_id + ", amount=" + amount + ", n_name=" + n_name + ", unit=" + unit + '}';
    }
    
    
    
     public List<NutritionInformationProvider> findFoodNutritionInformation(double f_id) throws Exception {
        con=ConnectionManagement.connect_nutrition();
        String sql=" select c.f_id FoodId,c.n_id NutritionId,n.n_name NutritionName,c.amount NutrientAmount," +
                    "n.unit NutritionUnit " +
                    "from contains c,nutrients n" +
                    " where " +
                    " c.n_id=n.n_id and c.f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ResultSet rs=ps.executeQuery();
        List<NutritionInformationProvider> l=new ArrayList<>();
        while(rs.next()){
            NutritionInformationProvider n=new NutritionInformationProvider();
            n.setF_id(rs.getDouble("FoodId"));
            n.setN_id(rs.getDouble("NutritionId"));
            n.setN_name(rs.getString("NutritionName"));
             n.setUnit(rs.getString("NutritionUnit"));
              n.setAmount(rs.getDouble("NutrientAmount"));
            l.add(n);
               
        }
        con.close();
        return l;  
    }
     
     public List<NutritionInformationProvider> findFoodNutritionInformation2(double f_id) throws Exception {
        con=ConnectionManagement.connect_nutrition();
        //select n.n_name,c.amount,n.unit from food f,nutrients n,contains c where f.f_id=c.f_id and c.n_id=n.n_id and f.f_id=2
        String sql=" select n.n_name Nutrient,c.amount Amount,n.unit NutritionUnit from food f,nutrients n,contains c where f.f_id=c.f_id and c.n_id=n.n_id and f.f_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDouble(1, f_id);
        ResultSet rs=ps.executeQuery();
        List<NutritionInformationProvider> l=new ArrayList<>();
        while(rs.next()){
            NutritionInformationProvider n=new NutritionInformationProvider();
            n.setN_name(rs.getString("Nutrient"));
            n.setAmount(rs.getDouble("Amount"));
             n.setUnit(rs.getString("NutritionUnit"));
            l.add(n);
               
        }
        con.close();
        return l;  
    }
    

}
