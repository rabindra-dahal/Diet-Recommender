<%@page import="com.dietManager.model.Nutrition.Contains"%>
<%@page import="com.dietManager.database.Nutrition.ContainsDAO.ContainsDAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.Choices"%>
<%@page import="com.dietManager.database.UserDetails.ChoicesDAO.ChoicesDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.dietManager.recommendation.algorithmImpl.KarlPearsonSimilarity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page session="true" %>

<head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/jquery/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="DietList/lunch.js"></script>
  <script type="text/javascript" src="DietList/breakfast.js"></script>
  <script type="text/javascript" src="DietList/dinner.js"></script>
    <script>
            function show(){
                var str=document.getElementById('myInput').value;
                if(str.length==0){
                alert("You must type something");
                var win = window.event;
		win.stopPropagation();
                    }
                else{
                document.getElementById('food_name').innerHTML=str;
                showDetails(str);
            }
            }
            function recommendshow(name){
                document.getElementById('food_name').innerHTML=name;
                showDetails(name);
            }
            function showDetails(str) {
            var xhttp;
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("food_table").innerHTML = this.responseText;
                }
            };
  xhttp.open("GET", "NutritionDetails.jsp?q="+str, true);
  xhttp.send();   
}
window.onload=function(){
            var xhttp;
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("total_energy").innerHTML = this.responseText;
                showEnergy();
                requirement_fun();
            }
            };
  xhttp.open("GET", "Energyconsumed.jsp", true);
  xhttp.send();   
}

                    </script>
<style>
	*{	margin:0;padding:0;
	}
	#left-container{
		position:static;
		margin-top:80px;
		margin-left:2%;
		width:30%;
		height:500px;
		border:black 1px solid;
		float:left;
		font-size:26px;
		text-align:center;
		background:#eeffee;
	}
	#middle-container{
            	display:block;
		position:static;
		background:grey;
		margin-top:5%;
		margin-left:2%;
		width:40%;
		height:500px;
		border:black 1px solid;
		float:left;
	}
	.meals{
		position:relative;
		margin:7px auto 7px auto;
		border: black 1px dotted;
		width:90%;
		height:40px;
		font-size:20px;
	}
	.meals:hover,.meals:focus{
		text-decoration:none;
		cursor:pointer;
		color:red;
	}
	.selection-box{
		position:relative;
		width:90%;
		margin:15px auto 5px auto;
		border:black 1px dotted;
		background:white;
	}
	#search-box{
		height:195px;
		
	}
	#recommend-box{
		height:250px;
		
	}
	.box-label{
		width:100%;
		position:relative;
		height:40px;
		text-align:center;
		font-size:30px;
		background:green;
		color:white;
	}
	.search-field{
		height:23%;
		width:80%;
		margin:5%;
		float:left;
		display:block-inline;
		position:absolute;
	}
	#addbutton{
		margin:5%;
		right:2%;
		height:23%;
		float:left;
		width:70px;
		background:white;
                text-align: center;
		border:green 1px solid;
		position:absolute;
		
	}
	#addbutton:hover{
		background:#eeffee;
	}
	
	ol{
		position:relative;
		margin-left:4%;
		width:90%;
		padding:2px;
		font-size:16px;
		color:blue;
		line-height:25px;
		list-style-type:none;
	}
	li{
		position:relative;
	}
	ol li{
		cursor:pointer;
	}
	ol li:hover {
	background: #ddd;
	}
	.close1 {
	position:absolute;
	width:30px;
	text-align:center;
	line-height:100%;
        height: 100%;
	right: 0;
	top: 0;
	padding:5px;
	}
	.close1:hover {
	background-color: #f44336;
	color: white;
	}
        
</style>

</head>
<body>
    <div class="container" style="text-align:center;font-size:25px;">
    <b style="color:green;margin-right: 10px;">Consumed Calorie: 
        <span id="consumed_energy" class="badge" style="font-size:20px;">0.0</span></b>
        <b style="color:blue;margin-right: 10px;">Required Calorie:
        <span id="total_energy" class="badge" style="font-size:20px;"></span></b>
        <b style="color:red;margin-right: 10px;">Calories Left:
        <span id="required_energy" class="badge" style="font-size:20px;">0.0
            <script>
                function requirement_fun(){
                    document.getElementById('required_energy').innerHTML=document.getElementById('total_energy').childNodes[0].nodeValue-document.getElementById('consumed_energy').childNodes[0].nodeValue;
                }
            </script>
        </span></b>
  </div>
    <div id="sample" style="font-size:15px;background:red;color:white;"></div>
<div id="left-container">
	<span style="color:blue;">Meals</span>
	<div class="meals" id="breakfast_nav" >Food List<button id="save" onclick="send_to_save()" style="position:relative;border:none;background:green;right:-45px;top:2px;height:25px;width:60px;font-size: 15px;color:white;">Save</button></div>
	<div>
		<ol id="myol1">
		<%
                    String u_name=(String)session.getAttribute("u_name");
                    GeneralDAOInterfaceImpl gdii=new GeneralDAOInterfaceImpl();
                    General g=gdii.findByName(u_name);
                    double u_id=g.getU_id();
                    ChoicesDAOInterfaceImpl cdii=new ChoicesDAOInterfaceImpl();
                    List<Choices> li=cdii.findByUserId(u_id);
                    for(Choices ch:li){
                        FoodDAOInterfaceImpl fdii=new FoodDAOInterfaceImpl();
                        Food f=fdii.findByPK(ch.getF_id());
                        ContainsDAOInterfaceImpl cddii=new ContainsDAOInterfaceImpl();
                        List<Contains> con=cddii.findByFoodId(ch.getF_id());
                        for(Contains c:con){
                            if(c.getN_id()==6.0){
                                out.println("<li>"+f.getF_name()+"<span class='energy' style='visibility:hidden;'>"+c.getAmount()+"</span><span class='close1'>x</span></li>");
                            }
                        }
                        
                    }
                %>
		</ol>
	</div>
        
     
</div>
<div id="middle-container">
	<div class="selection-box" id="search-box">
		<div class="box-label">Search for Food:</div>
                <!--New EDIT-->
                <form action="#" autocomplete="off"> 
		<input type="text" id="myInput"  onkeyup="showHint(this.value)" class="search-field" style="position:absolute;" placeholder="Enter a food ....."/>
		<!--<button id="addbutton" style="position:absolute;" onclick="newElement()">Add</button>-->
                <div class="container">
  
  <!-- Trigger the modal with a button -->
  <button type="button" id="addbutton" style="position:absolute;color:black;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="show()">Show</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Food Details</h4><input type="number" id="measure" style="width:55px;" value="100" oninput="change()">&nbsp;gram
        </div>
        <div class="modal-body">
            <b>Food Name: </b><span id="food_name"></span>
            <div id="food_table" style="height:250px;">
                <script>
                    function change(){
                 var input=document.getElementById('measure').value;
                 var i=2;
                 while(i<=28){
                 var original=document.getElementById('food_table').childNodes[1].childNodes[1].childNodes[i].childNodes[3].childNodes[0].nodeValue;
                 document.getElementById('food_table').childNodes[1].childNodes[1].childNodes[i].childNodes[3].childNodes[0].nodeValue=((original/100)*input).toFixed(2);
                 i=i+2;
                }
                    }
                </script>
            </div>
            </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" onclick="newElement(document.getElementById('food_name').childNodes[0].nodeValue,document.getElementById('food_table').childNodes[1].childNodes[1].childNodes[12].childNodes[3].childNodes[0].nodeValue)" data-dismiss="modal">Add</button>
        </div>
      </div>
    </div>
  </div>
</div>

                
                
                
                </form>
                	<div style="position:relative;clear:left;"></div><br/>
                 <div class="container">
                 <div style="height:60px;"></div>
                 <ul  class="list-group" id="txtHint" style="position:absolute;top:105;margin:5;left:30;width:80%;max-height: 90px;overflow: auto;"></ul>
    
    
                </div>
	
                
	</div>
   
    <script>
        //saving the food
        function send_to_save() {
  
  var len=document.getElementsByClassName('energy').length;
    var total=0;
    var selected_food=new Array();
    for(var i=0;i<len;i++){
        if(document.getElementsByClassName('energy')[i].parentNode.style.display!='none'){
                selected_food[total]=document.getElementsByClassName('energy')[i].parentNode.childNodes[0].nodeValue;
                total=total+1;
    }}
if(total==0){alert("Nothing to save");}
else{
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("sample").innerHTML = this.responseText;
      }
  };
  var query_string="savefood.jsp?";
  for(var x=0;x<total;x++){
      query_string=query_string+"x"+x+"="+selected_food[x]+"&";
  }
  query_string=query_string+"total="+total;
  xhttp.open("GET",query_string, true);
  xhttp.send();  
  }
}
        
        
        
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
      });
    }
  };
  xhttp.open("GET", "SuggestionGrabber.jsp?q="+str, true);
  xhttp.send();   
}

</script>
    


	<div class="selection-box" id="recommend-box">
	<div class="box-label">Recommended for you:</div>
	<div style="overflow:auto;position:absolute;width:95%;height:65%;margin-left:5%;">
		<ol>
                    <%
                        /*(long)(Math.random()*1000*5)*/
                     KarlPearsonSimilarity ks=new KarlPearsonSimilarity();
                     List<Food> f=ks.obtainRecommendedFoodNameForUserId("C:\\Users\\WannaCry\\Documents\\NetBeansProjects\\DietManager\\src\\java\\com\\dietManager\\recommendation\\algorithmImpl\\test1.csv",(long)u_id,10);
                      for(Food rec:f)
                             {
                    %>
                    
                    <button style="width:100%;color:black;height:35px;background: white;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onmousedown='recommendshow(this.childNodes[0].nodeValue)'><%=rec.getF_name()%></button><br>  
                    <%
                            }
                        %>
                        </ol>
		</div>
	</div>
                                  
              
</div>
                        <div id="trending" style="position:relative;float:left;height:500px;width:20%;border:1px solid black;color:black;top:60px;text-align:center; margin-left:20px;overflow:auto;">
                        <div id="trending-header"><h3>Most Trending</h3></div>    
                        <div>
                            
                            <script>
                                var d=new Date();
                                var hr=d.getHours();
                                if(hr<10){
                                    for(var i=0;i<breakfast.length;i++){
                            document.write('<button style="width:100%;color:black;height:35px;background: white;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onmousedown="recommendshow(this.childNodes[0].nodeValue)">');
                            document.write(breakfast[i].f_name);
                            document.write('</button><br>');
                                }
                            }
                                else if(hr>10 && hr<=18){
                                for(var i=0;i<lunch.length;i++){
                            document.write('<button style="width:100%;color:black;height:35px;background: white;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onmousedown="recommendshow(this.childNodes[0].nodeValue)">');
                            document.write(lunch[i].f_name);
                            document.write('</button><br>');
                        }
                    }
                    else if(hr>18 && hr<=24){
                        for(var i=0;i<dinner.length;i++){
                            document.write('<button style="width:100%;color:black;height:35px;background: white;" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onmousedown="recommendshow(this.childNodes[0].nodeValue)">');
                            document.write(dinner[i].f_name);
                            document.write('</button><br>');
                    }
                }
                            </script>
                            
                        </div>
                        </div>
                        <div style="clear:left;"></div>
<script>
	var close1 = document.getElementsByClassName("close1");
	var i;
		for (i = 0; i < close1.length; i++) {
		  close1[i].onclick = function() {
			var div = this.parentElement;
			div.style.display = "none";
			var win = window.event;
			win.stopPropagation();
		  };
		}
		
	
	function newElement(value,energy) {
  var li = document.createElement("li");
  var inputValue = value;
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  
  var contain=document.createElement("span");
  contain.className="energy";
  var enertext=document.createTextNode(energy);
  contain.appendChild(enertext);
  li.appendChild(contain);
  
  if (inputValue === '') {
    alert("You must write something!");
  } else {

		document.getElementById("myol1").appendChild(li);
    
  }
  for(var i=0;i<document.getElementsByClassName('energy').length;i++){
  document.getElementsByClassName('energy')[i].style.visibility='hidden';}
  document.getElementById("myInput").value = "";
  showEnergy();
  requirement_fun();
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close1";
  span.appendChild(txt);
  li.appendChild(span);

  for (i = 0; i < close1.length; i++) {
    close1[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
      showEnergy();
      requirement_fun();
        };
  }
	}



function showEnergy(){
    var len=document.getElementsByClassName('energy').length;
    var total=0;
    for(var i=0;i<len;i++){
        if(document.getElementsByClassName('energy')[i].parentNode.style.display!='none'){
        total=total+parseFloat(document.getElementsByClassName('energy')[i].childNodes[0].nodeValue);
    }}
    document.getElementById('consumed_energy').innerHTML=total;
}

</script>


</body>
