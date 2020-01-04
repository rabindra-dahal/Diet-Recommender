<%-- 
    Document   : updateprofile
    Created on : Jun 14, 2017, 1:06:57 PM
    Author     : WannaCry
--%>

<%@page import="com.dietManager.database.UserDetails.StateBAO.StateBAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.State"%>
<%@page import="com.dietManager.database.UserDetails.StateDAO.StateDAOInterfaceImpl"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update</title>
    </head>
    <body>
        <%
            String u_name=request.getParameter("user_name");
            double u_id=Double.parseDouble(request.getParameter("u_id"));
            double age=Double.parseDouble(request.getParameter("age"));
            double height=Double.parseDouble(request.getParameter("height"));
            height=height*30.48;
            double weight=Double.parseDouble(request.getParameter("weight"));
            String food_habit=request.getParameter("food_habit");
            double work_hr=Double.parseDouble(request.getParameter("work_hr"));
            
           StateBAOInterfaceImpl sdii=new StateBAOInterfaceImpl();
            State s=new State();
            s.setU_id(u_id);
            s.setAge(age);
            s.setFood_habbit(food_habit);
            s.setWeight(weight);
            s.setWorking_hrs(work_hr);
            s.setHeight(height);
            
            //out.println(s);
            boolean check=sdii.stateUpdate(s);
            
            
            if(check){
                response.sendRedirect("./profile.jsp");
            }
            else{
                response.sendError(501, "Updation Failed!!!");
            }


        %>
        
    </body>
</html>
