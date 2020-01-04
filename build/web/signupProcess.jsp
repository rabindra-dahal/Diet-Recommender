<%@page import="java.sql.Driver"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" %>
<%@ page session="true" %>
<%!
    double incrementer;
%>
<!DOCTYPE html>
<html>
    <head>

        <title>Diet Expert</title>

        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //Meta-Tags -->

        <!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

    </head>

    <!-- Body -->
    <%
      Driver d=(Driver) Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        Properties p=new Properties();
        p.put("user","user_details");
        p.put("password", "1234");
         try (Connection con = d.connect("jdbc:oracle:thin:@localhost:1521:xe", p)) {
             String counter="select count(*) count from general";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            
            while(rs.next()){
                incrementer=rs.getDouble("count");
                              
            }
            
    }
    
    
    %>
    <body>
        <div class="banner">
            <div class="dietexpert-dot">
                <h1>Welcome To Diet Expert </h1>

                <div class="layoutscontainer">
                    <h2>Additional Data</h2>
                    <form action="./signupadd" autocomplete="off" name="additionalData" method="post">

                       <!-- <input type="hidden" name="u_id" value=""/>-->
                        <table id="mytable" name="mytable" style="margin:auto;">
                            <div class="container">
                                <tr><th> <label style="color:white;margin-right: 20px;"><b>Height</b></label></th>
                                    <td><input type="text"  id="height" placeholder="Enter Height in ft" name="height" required></td></tr>

                                <tr><th> <label style="color:white;margin-right: 20px;"><b>Weight</b></label></th>
                                    <td><input type="text" id="weight" placeholder="Enter Weight in kg" required="" name="weight"></td></tr>


                                <tr><th> <label style="color:white;margin-right: 20px;"><b>Food Habit</b></label></th>
                                    <td><input type="radio" name="foodhabbit" value="Veg" required=""> <label style="color:white;margin-right: 20px;">Veg</label>
                                        <input type="radio" name="foodhabbit" value="Non-Veg" required=""> <label style="color:white;margin-right: 20px;">Non-Veg</label></td></tr>

                                <tr><th> <label style="color:white;margin-right: 20px;"><b>Working Hours</b></label></th>
                                    <td><input type="text" id="working_hour" placeholder="Enter Working Hour" name="working_hour" required></td></tr>
             <tr><th> <label style="color:white;margin-right: 20px;"><b>Age</b></label></th>
                                    <td><input type="text" id="age" placeholder="Enter Age" name="age" required></td></tr>
                            
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
