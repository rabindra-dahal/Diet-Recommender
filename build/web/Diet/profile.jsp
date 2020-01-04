<%-- 
    Document   : profile
    Created on : Jun 13, 2017, 4:53:00 PM
    Author     : Anoor
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.dietManager.model.UserDetails.State"%>
<%@page import="com.dietManager.database.UserDetails.StateDAO.StateDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diet Expert - Profile</title>
        <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Temporary navbar container fix -->
    <style>
    .navbar-toggler {
        z-index: 1;
    }
    
    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }
    </style>
    <style>
        table{
            margin:auto;
        }
        td{
            width: 130px;
            text-align:left;
        }
        
    </style>
    <script>
        
    </script>
    </head>
    <body>
        <div class="tagline-upper text-center text-heading text-shadow text-white mt-4 hidden-md-down">Diet Expert</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-4 hidden-md-down">EAT CLEAN, LOOK LEAN</div>
<!-- Navigation -->
    <nav class="navbar navbar-toggleable-md navbar-light navbar-custom bg-faded py-lg-4">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold hidden-lg-up" href="#">Start Bootstrap</a>
            <div class="collapse navbar-collapse" id="navbarExample">
                <%
                    String u_name=(String)session.getAttribute("u_name");
                    String gender=(String)session.getAttribute("gender");
                    
                %>
                <a href="profile.jsp">
                <% 
                if(gender.equalsIgnoreCase("m")){
                %>
                <img src="img/m.png" style="float: right;" alt="Logout" height="25px" width="25px"/>&nbsp;<h4 style="color: lightblue;float: left">Hello Mr.
                    <%
                    
                    out.println(u_name);
                    %></h4>
                 <% }
                 
   else if(gender.equalsIgnoreCase("f")){%>
   <img src="img/f.png" style="float: right;" alt="Logout" height="25px" width="25px"/>&nbsp;<h4 style="color: lightblue;float: left">Hello Miss.
                    <%
                    
                    out.println(u_name);
                    %></h4>
                    <% } %>
                </a>
                <ul class="navbar-nav mx-auto">
                     <li class="nav-item active px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="diary.jsp">Diary</a>
                    </li>
                    
                    <li class="nav-item active px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="about.jsp">About</a>
                    </li>
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="blog.jsp">Blog</a>
                    </li>
                    <li class="nav-item px-lg-4">
                        <a class="nav-link text-uppercase text-expanded" href="contact.jsp">Contact</a>
                    </li>
                </ul>
                <a href="../redirect.jsp" title="Logout"><img src="img/logout.ico" style="float: right;" alt="Logout" height="25px" width="25px"/></a>
                
            </div>
        </div>
    </nav>
             
     <div class="container">

        <div class="bg-faded p-4 my-4">
            <hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0">Profile: <strong><%=u_name%></strong></h2>
            <hr class="divider">
            <div class="row" id="saved_details">
                <div class="col-lg-6" style="text-align:center;">
                    <h3>General Information</h3>
                    <%
                        GeneralDAOInterfaceImpl gdii=new GeneralDAOInterfaceImpl();
                        General user=gdii.findByName(u_name);
                        double u_id=user.getU_id();
                        StateDAOInterfaceImpl sdii=new StateDAOInterfaceImpl();
                        State info=sdii.findByPK(u_id);
                    %>
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td><%=u_name%></td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td><%=user.getGender()%></td>
                        </tr>
                        <tr>
                            <td>Age:</td>
                            <td><%=(int)info.getAge()%> years</td>
                        </tr>
                        <tr>
                            <%
                            DecimalFormat df=new DecimalFormat("#0.99");
                            %>
                            <td>Height:</td>
                            <td><%=Math.round((info.getHeight()/30.48)*100.0)/100.0%> ft</td>
                        </tr>
                        <tr>
                            <td>Weight:</td>
                            <td><%=info.getWeight()%> kg</td>
                        </tr>
                        <tr>
                            <td>Working Hours:</td>
                            <td><%=info.getWorking_hrs()%> hours</td>
                        </tr>
                        <tr>
                            <td>Food Habit:</td>
                            <td><%=info.getFood_habbit()%></td>
                        </tr>
                        </table>
                </div>
                <div class="col-lg-6">
  
  <!-- Trigger the modal with a button -->
  <button class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Edit</button>

  <!-- Modal -->
  <form action="./updateprofile.jsp" method="post">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title" >Edit Details</h4>
            <button class="close" data-dismiss="modal">&times;</button>
        </div>
          
        <div class="modal-body">
            <b>User Name: </b><span id="user_name"><%=u_name%></span>
            <div id="food_table" style="height:250px;">
                
                    <input type="hidden" name="user_name" value="<%=u_name%>"/>
                    <input type="hidden" name="u_id" value="<%=u_id%>"/>
                <table>
                        <tr>
                            <td>Age:</td>
                            <td><input name="age" type="text" value="<%=(int)info.getAge()%>"/></td>
                        </tr>
                        <tr>
                            <td>Height:</td>
                            <td><input name="height" type="text" value="<%=Math.round((info.getHeight()/30.48)*100.0)/100.0%>"/></td>
                        </tr>
                        <tr>
                            <td>Weight:</td>
                            <td><input name="weight" type="text" value="<%=info.getWeight()%>"/></td>
                        </tr>
                        <tr>
                            <td>Working Hours:</td>
                            <td><input name="work_hr" type="text" value="<%=info.getWorking_hrs()%>"/></td>
                        </tr>
                        <tr>
                            <td>Food Habit:</td>
                            <td><input type="radio" name="food_habit" value="Veg">Veg &nbsp; <input type="radio" name="food_habit" value="Non-Veg">Non-Veg</td>
                        </tr>
                        </table>
                        
            </div>
            </div>
                        
        <div class="modal-footer">
            <button type="submit"  class="btn btn-primary">Done</button>
            <!--<input type="submit" class="btn btn-primary"  value="Done" data-dismiss="modal"/>-->
        </div>
      </div>
    </div>
  </div>
   </form>
                        
                </div>
        </div>
       

    </div>
        
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
        <div class="container">
            <p class="m-0">Copyright &copy; Diet Expert 2017</p>
        </div>
    </footer>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>            
                    
    
    </body>
</html>
