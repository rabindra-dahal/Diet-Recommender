<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

</head>
<!-- //Head -->
<style>
/* Full-width input fields */
#email,#age, #psw1,#psw2,#suname {
    width: 50%;
    color: red;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;

}
#email:focus,#age:focus, #psw1:focus,#psw2:focus ,#suname:focus{
    width: 100%;
}
/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn {width:100%;}
.signupbtn {width:100%;}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fffefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    color: white;
    font-size: 40px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}


/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 50%;
    }
}
</style>

<!-- Body -->
<body>
<div class="banner">
<div class="dietexpert-dot">
Don't have an account yet? Sign up here
<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign Up</button>

<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form name="signup" method="post" onsubmit="return checkUserCrediantials(this);" class="modal-content animate" autocomplete="off" action="./signup">
  
    <div class="container">
        <table id="mytable" name="mytable" style="margin:auto;">
      <tr><th><label><b>User Name</b></label></th>
          <td><input type="text" onkeyup="checkUserAlreadyExists(this.value);" id="suname" placeholder="Enter UserName" name="uname" required></td></tr>
 <p id="sug" style="color:blueviolet;"></p>

      <tr><th><label><b>Password</b></label></th>
      <td><input type="password" id="psw1" placeholder="Enter Password" name="psw"></td></tr>

      <tr><th><label><b>Repeat Password</b></label></th>
      <td><input type="password" id="psw2" placeholder="Repeat Password" name="psw-repeat" required></td></tr>
	  
	  <tr><th><label><b>Gender</b></label></th>
	  <td><input type="radio" id="mgender" name="gender" value="M"><label>Male</label>
	  <input type="radio" id="fgender" name="gender" value="F"><label>Female</label></td></tr>
	  
	   <!--<tr><th><label><b>Age</b></label></th>
      <td><input type="text" id="age" placeholder="Age" name="age" required></td></tr> -->
	  
       <tr ><td colspan="2"><p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p></td></tr>

       <tr><div class="clearfix">
       <th><button type="button" onclick="document.getElementById('id01').style.display='none'" 
        class="cancelbtn">Cancel</button></th>
        <th><button type="submit"  class="signupbtn">Sign Up</button></th>
         </tr>
       
      </table>
      </div>
     
  </form>
 
    </div>

	<h1>Welcome To Diet Expert </h1>

	<div class="layoutscontainer">
	<h2>Sign In</h2>
        <form action="./login"   autocomplete="off" name="signin" method="post">
			<input type="text" Name="Username" placeholder="USERNAME" required="" style="text-align:center;">
			<input type="password" Name="Password" placeholder="PASSWORD" required=" " 
			style="text-align:center;">
			<ul class="dietexpert">
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span></span>Remember me</label>
					<a href="#">Forgot password?</a>
				</li>
			</ul>
			<div class="sendbutton">
				<input type="submit"  id="mysubmit" value="SIGNIN">
				<div class="clear"></div>
			</div>
		</form>
	</div>
	
	
	<div class="dietexpertfooter">
		<p> &copy; 2017 Diet Expert. All Rights Reserved 
	</div>

</div>

	

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

 <script>
     
   function checkUserAlreadyExists(str) {
  var xhttp;
  if (str.length == 0) { 
    document.getElementById("sug").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("sug").innerHTML = this.responseText.trim();
      document.getElementById("suname").focus();  
      
    }
  };
  xhttp.open("GET", "userExistCheck.jsp?q="+str, true);
  xhttp.send();   
}   
function checkUserCrediantials(form){
    var returnValue = true;
    var username=form.suname.value;
    var password1 = form.psw1.value;
    var password2 = form.psw2.value;
    var ptag=document.getElementById('sug').childNodes[4].nodeValue.trim();
    if(ptag =="UserName already exists..Please try with different Username"){
        returnValue=false;
        alert("Username already exists\nPlease try again.");
            signup.suname.value="";
            signup.suname.focus();
        
    }
    if(username.length < 6) {
  returnValue = false;
  alert("Your username must be at least\n6 characters long.\nPlease try again.");
            signup.suname.value="";
            signup.suname.focus();
}

if (password1.length < 6) {
  returnValue = false;
  alert("Your password must be at least\n6 characters long.\nPlease try again.");
  signup.psw1.value = "";
  signup.psw2.value = "";
  signup.psw1.focus();
}

if (password1 != password2) {
  returnValue = false;
  alert("Your password entries did not match.\nPlease try again.");
  signup.psw1.value = "";
  signup.psw2.value = "";
  signup.psw1.focus();
}
 return returnValue; 
}
     
      
  </script>
	

</body>
<!-- //Body -->


</html>