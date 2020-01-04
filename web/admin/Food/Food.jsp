<%@page import="com.dietManager.model.Nutrition.Nutrients"%>
<%@page import="com.dietManager.database.Nutrition.NutrientsBAO.NutrientsBAOInterfaceImpl"%>
<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    <head>

        <title>Diet Expert</title>

        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //Meta-Tags -->

        <!-- Style --> <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all">

    </head>

    <!-- Body -->
    
    <body>
        <div class="banner">
            <div class="dietexpert-dot">
                <h1>Welcome To Diet Expert </h1>

                <div class="layoutscontainer">
                    <h2>Nutrients Data</h2>
                    <form action="./fsave.jsp" autocomplete="off" name="additionalData" method="post">

                       <!-- <input type="hidden" name="u_id" value=""/>-->
                        <table id="mytable" name="mytable" style="margin:auto;">
                            <div class="container">
                                 <tr><th> <label style="color:white;margin-right: 20px;"><b>Food Name</b></label></th>
                                    <td><input type="text" id="f_name" placeholder="Enter Food Name" required="" name="f_name"></td></tr>


                                
                               

                                
                                 
                        </table>
    

                        <div class="sendbutton">
                            <input type="submit"  id="mysubmit" value="Submit">
                            <div class="clear"></div>
                        </div>

                    </form>
                </div>
                            
                 


                <div class="dietexpertfooter">
                    <p> &copy; 2017 Diet Expert. All Rights Reserved 
                </div>
            </div>

        </div>
          

    </body>



        </html>
