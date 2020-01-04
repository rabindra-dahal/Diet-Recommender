<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin Panel</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/jquery/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="newcss.css">
        <script type="text/javascript" src="new.js"></script>
    </head>
    <body>
        <div class="container">
            <ul class="nav navbar-nav navbar-right" >
                <li ><a href="../redirect.jsp" ><span class="glyphicon glyphicon-log-out" ></span> Logout</a></li>
            </ul>
            <div class="row">
                <div class="col-lg-5 col-md-5 col-sm-8 col-xs-9 bhoechie-tab-container">
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 bhoechie-tab-menu">
                        <div class="list-group">
                            <a href="#" class="list-group-item active text-center">
                                <br/>Food
                            </a>
                            <a href="#" class="list-group-item text-center">
                                <br/>Nutrient
                            </a>
                            <a href="#" class="list-group-item text-center">
                                <br/>Belongs
                            </a>
                            <a href="#" class="list-group-item text-center">
                                <br/>Categories
                            </a>
                            <a href="#" class="list-group-item text-center">
                                <br/>Contains
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 bhoechie-tab">
                        <!-- flight section -->
                        <div class="bhoechie-tab-content active">
                            <center>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <iframe  class="embed-responsive-item" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="../Food/Food.jsp"></iframe>
                                </div>
                            </center>
                        </div>
                        <!-- train section -->
                        <div class="bhoechie-tab-content">
                            <center>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <iframe  class="embed-responsive-item" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="../Nutrient/Nutrients.jsp"></iframe>
                                </div>
                            </center>
                        </div>

                        <!-- hotel search -->
                        <div class="bhoechie-tab-content">
                            <center>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <iframe  class="embed-responsive-item" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="../Belongs/Belongs.jsp"></iframe>
                                </div>
                            </center>
                        </div>
                        <div class="bhoechie-tab-content">
                            <center>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <iframe  class="embed-responsive-item" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="../Categories/Categories.jsp"></iframe>
                                </div>
                            </center>
                        </div>
                        <div class="bhoechie-tab-content">
                            <center>
                                <div class="embed-responsive embed-responsive-16by9">
                                    <iframe  class="embed-responsive-item" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="../Contains/Contains.jsp"></iframe>
                                </div>
                            </center>
                        </div>
                        <div>



                        </div>
                        </body>
                        </html>




