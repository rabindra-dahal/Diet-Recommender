<%-- 
    Document   : redirect
    Created on : Jun 10, 2017, 5:46:27 PM
    Author     : WannaCry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirect Page</title>
    </head>
    <body>
        <%
        session.invalidate();
        response.sendRedirect("./admin.jsp");
        %>
    </body>
</html>