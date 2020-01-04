<%-- 
    Document   : SuggestionGrabber
    Created on : Jun 7, 2017, 8:41:05 PM
    Author     : WannaCry
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/jquery/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        //FoodBAOInterface fbo=new FoodBAOInterfaceImpl();
        //Food f=new Food();
        String query=request.getParameter("q");
        //f.setF_name(query);
        ///List<Food> ls=new ArrayList<>();
        ///ls=findAll(query);
        //f=fbo.foodFindByFoodName(f.getF_name());
        /*if(query.equals(""))
            out.println("No data to display");
        else
        {
            for(Food f1:ls)
            out.println(f1.getF_name());
        }
        */

        Connection con=ConnectionManagement.connect_nutrition();
        String sql="select * from food where f_name like '%"+query+"%' ";
        Statement ps=con.createStatement();
        //ps.setString(1, query);
        ResultSet rs=ps.executeQuery(sql);
        List<Food> l=new ArrayList<>();
        while(rs.next()){
            Food f=new Food();
            f.setF_id(rs.getDouble(1));
            f.setF_name(rs.getString(2));
            l.add(f);
               
        }
        
        if(query.equals(""))
            out.println("No data to display");
        else
        {
           // out.println("<li class='list-group-item link-class'>");
            
            for(Food f1:l){
                
            out.println("<li class='list-group-item link-class' style='cursor:pointer;height:35px;'>"+f1.getF_name()+"</li>");
                
            }
           //out.println("</table> </div>");
            //out.println("");}
        }
        
          
        
        
        %>
        
    </body>
</html>
