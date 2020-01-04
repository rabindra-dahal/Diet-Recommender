<%-- 
    Document   : Suggestion
    Created on : Jun 7, 2017, 8:39:14 PM
    Author     : WannaCry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/jquery/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
        
        <title> Food Suggestor </title>
    </head>
<body>

<h1>The XMLHttpRequest Object</h1>

<h3>Start typing a name in the input field below:</h3>

<form action="#"> 
First name: <input type="text" id="myInput" onkeyup="showHint(this.value)">
</form>

<div class="container">
    <h3> Suggestions:</h3>
    
        <ul class="list-group" id="txtHint"></ul>
        <br>
    
    
</div>

<script>
function showHint(str) {
  var xhttp;
  if (str.length == 0) { 
    document.getElementById("txtHint").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("txtHint").innerHTML = this.responseText;
      $('#txtHint').on('click','li',function(){
          var c=$(this).text().split('|');
          $('#myInput').val($.trim(c[0]));
          $('#txtHint').html('');
      })
    }
  };
  xhttp.open("GET", "SuggestionGrabber.jsp?q="+str, true);
  xhttp.send();   
}
</script>

</body>

<!-- Mirrored from www.w3schools.com/js/tryit.asp?filename=tryjs_ajax_suggest_php by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 10 Dec 2016 18:09:57 GMT -->
</html>
