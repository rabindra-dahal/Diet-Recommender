<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.dietManager.recommendation.algorithmImpl.KarlPearsonSimilarity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Diet Expert Blog</title>

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

</head>

<body>

    <div class="tagline-upper text-center text-heading text-shadow text-white mt-4 hidden-md-down">Diet Expert</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-4 hidden-md-down">Eat Clean, Look Lean</div>

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
            <div class="card card-inverse">
                <img class="card-img img-fluid w-100" src="img/slide-1.jpg" alt="">
                <div class="card-img-overlay bg-overlay">
                    <h2 class="card-title text-shadow text-uppercase mb-0">
                        Post Log
                        
                    </h2>
                    <h4 class="text-shadow text-white">March 1, 2017</h4>
                    <p class="lead card-text text-shadow text-white w-50 hidden-md-down">Body of the post</p>
                    <a href="" class="btn btn-secondary">Read More</a>
                </div>
            </div>
        </div>

        <div class="bg-faded p-4 my-4">
            <div class="card card-inverse">
                <img class="card-img img-fluid w-100" src="img/slide-2.jpg" alt="">
                <div class="card-img-overlay bg-overlay">
                    <h2 class="card-title text-shadow text-uppercase mb-0">Post Title</h2>
                    <h4 class="text-shadow text-white">March 1, 2017</h4>
                    <p class="lead card-text text-shadow text-white w-50 hidden-md-down">Other Contents</p>
                    <a href="" class="btn btn-secondary">Read More</a>
                </div>
            </div>
        </div>

        <div class="bg-faded p-4 my-4">
            <div class="card card-inverse">
                <img class="card-img img-fluid w-100" src="img/slide-3.jpg" alt="">
                <div class="card-img-overlay bg-overlay">
                    <h2 class="card-title text-shadow text-uppercase mb-0">Post Title</h2>
                    <h4 class="text-shadow text-white">March 1, 2017</h4>
                    <p class="lead card-text text-shadow text-white w-50 hidden-md-down">Other Contents</p>
                    <a href="" class="btn btn-secondary">Read More</a>
                </div>
            </div>
        </div>

        <!-- Pagination -->
        <div class="bg-faded p-4 my-4">
            <ul class="pagination justify-content-center mb-0">
                <li class="page-item"><a class="page-link" href="#">&larr; Older</a></li>
                <li class="page-item disabled"><a class="page-link" href="#">Newer &rarr;</a></li>
            </ul>
        </div>

    </div>
    <!-- /.container -->

    <footer class="bg-faded text-center py-5">
        <div class="container">
            <p class="m-0">Copyright &copy; Diet Expert 2017</p>
        </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
