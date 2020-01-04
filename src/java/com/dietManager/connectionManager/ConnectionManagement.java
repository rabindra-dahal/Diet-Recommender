package com.dietManager.connectionManager;

import java.sql.Connection;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class ConnectionManagement {
    public static Connection connect()throws Exception{
        BasicDataSource bds=new BasicDataSource();
        bds.setDriverClassName("oracle.jdbc.OracleDriver");
        bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        bds.setUsername("user_details");
        bds.setPassword("1234");
        bds.setMinIdle(5);
        bds.setMaxWait(5000);
        bds.setMaxActive(20);
        Connection con;
        con=bds.getConnection();
        return con;
    }
     public static Connection connect_nutrition()throws Exception{
        BasicDataSource bds=new BasicDataSource();
        bds.setDriverClassName("oracle.jdbc.OracleDriver");
        bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        bds.setUsername("nutrition");
        bds.setPassword("1234");
        bds.setMinIdle(5);
        bds.setMaxWait(5000);
        bds.setMaxActive(20);
        Connection con;
        con=bds.getConnection();
        return con;
    }
    
}
