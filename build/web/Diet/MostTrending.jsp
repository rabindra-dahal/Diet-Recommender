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
        <script src="DietList/breakfast.js"></script>
        <script src="DietList/dinner.js"></script>
        <script src="DietList/lunch.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
        <title> Diet List</title>
    </head>
    <body>
        <script>
          for(var i=0;i<lunch.length;i++)
              document.write(lunch[i].f_name);
        </script>
        
    </body>
</html>
