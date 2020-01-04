<%-- 
    Document   : admincheck
    Created on : Jun 10, 2017, 5:32:29 PM
    Author     : WannaCry
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterfaceImpl"%>
<%@page import="com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterface"%>
<%@page import="com.dietManager.connectionManager.Encrypter"%>
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
        String user = request.getParameter("username");
            String pass = Encrypter.md5Encrypt(request.getParameter("password").trim());
            GeneralBAOInterface imp = new GeneralBAOInterfaceImpl();
            General g = new General();
            g.setU_name(user);
            g.setPassword(pass);
            g = imp.generalFindByNameAndPassword(g.getU_name(), g.getPassword());
            String uname, psw, gen;
            uname = g.getU_name();
            psw = g.getPassword();
            gen = g.getGender();
            //session.setAttribute("gender", gen);
            session.setAttribute("u_name", uname);

            if (uname.equals(user) && psw.equals(pass)) {
                /*RequestDispatcher requestDispatcher =request.getRequestDispatcher("./Diet/index.jsp");
		requestDispatcher.forward(request, response);
                requestDispatcher.include(request, response);*/
                response.sendRedirect("./adminpanel/new.jsp");
            } else {
                JOptionPane.showMessageDialog(null, "UserName or Password mismatch\n Please try again ", "Authentication Failure", JOptionPane.ERROR_MESSAGE);
                /* RequestDispatcher requestDispatcher =request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);*/
                response.sendRedirect("./admin.jsp");
            }
       
       %>
       
    </body>
</html>
