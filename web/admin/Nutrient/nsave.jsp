<%-- 
    Document   : nsave
    Created on : Jun 4, 2017, 2:34:48 PM
    Author     : WannaCry
--%>

<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dietManager.model.Nutrition.Nutrients"%>
<%@page import="com.dietManager.database.Nutrition.NutrientsBAO.NutrientsBAOInterfaceImpl"%>
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
                 NutrientsBAOInterfaceImpl imp=new NutrientsBAOInterfaceImpl();
                 Nutrients n=new Nutrients(request.getParameter("n_name"), request.getParameter("unit"));
                 imp.nutrientsSave(n);
                 response.sendRedirect("./Nutrients.jsp");
       %>
    </body>
</html>
