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

    <title>Diet Expert</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

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
    /* Temporary fix for img-fluid sizing within the carousel */
    
    .carousel-item.active,
    .carousel-item-next,
    .carousel-item-prev {
        display: block;
    }
    </style>

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
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold hidden-lg-up" href="#">Diet Expert</a>
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
            <!-- Image Carousel -->
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block img-fluid w-100" src="img/slide-1(1).jpg" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h3 class="text-shadow"></h3>
                            <p class="text-shadow"><kbd>Inspiring Food Lovers Everywhere.</kbd></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid w-100" src="img/slide-3(1).jpg" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h3 class="text-shadow"></h3>
                            <p class="text-shadow"><kbd>Good Food, Good Mood.</kbd></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid w-100" src="img/slide-2(1).jpeg" alt="">
                        <div class="carousel-caption d-none d-md-block">
                            <h3 class="text-shadow"><kbd>Keep Going</kbd></h3>
                            <p class="text-shadow"></p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <!-- Welcome Message -->
            <div class="text-center mt-4">
                <div class="text-heading text-muted text-lg">Welcome To</div>
                <h1 class="my-2">Diet Expert</h1>
                <div clas
            </div>
        </div>

        <div class="bg-faded p-4 my-4">
            <hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0">Your Decision!</strong></h2>
            <hr class="divider">
            <img class="img-fluid float-left hidden-md-down mr-lg-4" src="img/intro-pic(1).jpg" alt="">
            <p> When keeping a diet, people need to think of the long term impacts.</p>
			<p>Are you willing to consume junk food that you craved for an hour or you want the body you've craved for a lifetime?</p>
			<p>Everybody has a craving for some chocolates, or some high calory food that satisfies your soul within, but these cravings need to be fought. It is tough for poeple to maintain a diet because of these cravings. Gradually they learn to control it and know that it is not worth it.
			<p> <strong>Discipline</strong> is doing what you know needs to be done, even though you don't want to.
		</div>

        <div class="bg-faded p-4 my-4">
            <hr class="divider">
            <h2 class="text-center text-lg text-uppercase my-0"> Calories</h2>
            <hr class="divider">
            <p> Tiny creatures that live in your closet and sew your clothes a little bit tighter every night.
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
