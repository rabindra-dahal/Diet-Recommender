package com.dietManager.model.UserDetails;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.connectionManager.Encrypter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class General {
    private double u_id;
    private String u_name;
    private String gender;
    private String password;
    private Connection con;

    @Override
    public String toString() {
        return "u_id :"+u_id+"u_name : "+u_name+" gender : "+gender+" "+"password : "+password+" ";
    }
    
    public double key_generator() throws Exception{
        con=ConnectionManagement.connect();
        String counter="select count(*) count from general";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            double incrementer=0;
            while(rs.next()){
                incrementer+=rs.getDouble("count");
                       
            }
            incrementer+=1;
            return incrementer;
        
    }

    public General() {
    }

    public General(String u_name, String gender, String password) throws Exception {
        double uid;
        uid=key_generator();
        this.u_id = uid;
        this.u_name = u_name;
        this.gender = gender;
        this.password=Encrypter.md5Encrypt(password);
        
    }

    public double getU_id() {
        return u_id;
    }

    public void setU_id(double u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pswd) {
        this.password=pswd;
    }
    
    
}
