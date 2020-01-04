<%-- 
    Document   : fsave
    Created on : Jun 4, 2017, 7:17:15 PM
    Author     : WannaCry
--%>

<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterfaceImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% 
                 Connection con=ConnectionManagement.connect_nutrition();
                 FoodBAOInterfaceImpl imp=new FoodBAOInterfaceImpl();
                 Food f=new Food(request.getParameter("f_name"));
                 imp.foodSave(f);
                 response.sendRedirect("./Food.jsp");
       %>
    </body>
</html>
