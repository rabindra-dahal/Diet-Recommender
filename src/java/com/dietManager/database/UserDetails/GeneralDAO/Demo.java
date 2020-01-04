package com.dietManager.database.UserDetails.GeneralDAO;

import com.dietManager.connectionManager.ConnectionManagement;
import com.dietManager.database.UserDetails.StateBAO.StateBAOInterfaceImpl;
import com.dietManager.model.UserDetails.General;
import com.dietManager.model.UserDetails.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
       /* GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
        General g=new General();
        g.setU_name("rabindra");
        g.setPassword("12345");
            g=imp.generalFindByNameAndPassword(g.getU_name(),g.getPassword());
        System.out.println(g);*/
           //message digest code//SHA//MD5
          /* String pswd="12345";
         MessageDigest md=MessageDigest.getInstance("MD5");
        md.reset();
         md.update(pswd.getBytes("UTF-8"));
        byte[] digest=md.digest();
        BigInteger bigINT=new BigInteger(1,digest);
        String hash=bigINT.toString(16);
        while(hash.length()<32)
            hash="0"+hash;
                System.out.println(hash);
                //end of message digest*/
                /*General g1=new General();
                g1.setPassword("12345");
                System.out.println("Hash "+g1.getPassword());*/
            /* GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();   
          General s=new General("admin", "M", "admin");
          imp.generalSave(s);
          System.out.println("ID "+s.getU_id());*/
          
         /* System.out.println("General Data");
          Demo demo=new Demo();
          List<General> ge=demo.showAll();
          for(General hs:ge)
              System.out.println(hs);*/
          /*GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
            General g=new General();
            g.setU_name("Laxman");
            g.setPassword("12345");
            //General g1=new General();
            g=imp.generalFindByNameAndPassword(g.getU_name(),g.getPassword());
            System.out.println(g);*/
               /* GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
        General g=new General();
        g.setU_name("Laxman");
        g.setPassword(Encrypter.md5Encrypt("12345"));
            g=imp.generalFindByNameAndPassword(g.getU_name(),g.getPassword());
        System.out.println(g);*/
               //Connection con=ConnectionManagement.connect_nutrition();
                 /*FoodBAOInterfaceImpl imp=new FoodBAOInterfaceImpl();
                 Food f=new Food();
                 List<Food> ge=imp.foodFindAll();
                 int i=0;
          for(Food hs:ge){
              System.out.println(hs.getF_id());
          i++;}
          System.out.println("i"+i);
                */
   
        
         
       
        /*ConnectionManagement connectionManagement=new ConnectionManagement();
        Connection con=ConnectionManagement.connect();
        System.out.println("con "+con);*/
        
       /* 
        //User Profile
        GeneralBAOInterface gbi=new GeneralBAOInterfaceImpl();
        General g=new General();
        g.setU_id(5516);
        g=gbi.generalFindByPK(g.getU_id());
        StateBAOInterface sb=new StateBAOInterfaceImpl();
        State s= new State();
        s.setU_id(g.getU_id());
        s=sb.stateFindByPK(s.getU_id());
        System.out.println(" User Name : "+g.getU_name());
        System.out.println("Gender : "+g.getGender());
        System.out.println("Height : "+s.getHeight()+" feet");
        System.out.println("Weight : "+Double.toString(s.getWeight())+" kg");
        System.out.println("Working Hours : "+s.getWorking_hrs()+" hr ");
        System.out.println("Age : "+s.getAge());
        System.out.println("Food Habit : "+s.getFood_habbit());
        
        */
 StateBAOInterfaceImpl sdii=new StateBAOInterfaceImpl();
            State s=new State();
            s.setU_id(5495);
            s.setAge(28);
            s.setFood_habbit("V");
            s.setWeight(90);
            s.setWorking_hrs(8);
            s.setHeight(5);
            boolean check=sdii.stateUpdate(s);
            
            if(check)
                System.out.println("Updation Sucess");
            else
                System.out.println("Failed");
/* String sql="update state set height=?,weight=?,working_hrs=?,age=?,food_habbit=?,u_id=? where u_id=?";
    
        Connection con=ConnectionManagement.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        State s=new State();
            s.setU_id(5495);
            s.setAge(25);
            s.setFood_habbit("V");
            s.setWeight(87);
            s.setWorking_hrs(8);
            s.setHeight(5.8);
        ps.setDouble(1, s.getHeight());
        ps.setDouble(2, s.getWeight());
        ps.setDouble(3, s.getWorking_hrs());
        ps.setDouble(4, s.getAge());
        ps.setString(5, s.getFood_habbit());
        ps.setDouble(6, s.getU_id());
         ps.setDouble(7,s.getU_id() );
        int i=ps.executeUpdate();
        if(i!=0)
            System.out.println("Sucess");
        else
        System.out.println("Fail");
   */         
            
/*GeneralBAOInterface imp=new GeneralBAOInterfaceImpl();
        General g=new General();
        g.setU_name("Rahul");
        g=imp.generalFindByName(g.getU_name());
        System.out.println("Name : "+g.getU_name());
        System.out.println("Gender : "+g.getGender());
        System.out.println("ID : "+g.getU_id());
      */  
    }
    public List<General> showAll() throws Exception{
          
        Connection con=ConnectionManagement.connect();
        String sql="select * from general";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<General> l=new ArrayList<>();
        while(rs.next()){
            General g=new General();
            g.setU_name(rs.getString("u_name"));
            g.setGender(rs.getString("gender"));
            g.setU_id(rs.getDouble("u_id"));
            g.setPassword(rs.getString("password"));
            l.add(g);
               
        }
        con.close();
        return l;
        
      
    }
 
}
