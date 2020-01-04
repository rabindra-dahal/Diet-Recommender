<%-- 
    Document   : userExistCheck
    Created on : Jun 13, 2017, 8:52:39 PM
    Author     : WannaCry
--%>

<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterfaceImpl"%>
<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String query=request.getParameter("q");
        GeneralBAOInterfaceImpl gbi=new GeneralBAOInterfaceImpl();
        General g=gbi.generalFindByName(query);
        if(query.equals(g.getU_name())){
            out.println("UserName already exists..Please try with different Username");
        }

       
          
        
        
        %>
        
    </body>
</html>
