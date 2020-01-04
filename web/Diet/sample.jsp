<%-- 
    Document   : sample
    Created on : Jun 8, 2017, 1:52:24 PM
    Author     : WannaCry
--%>

<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.dietManager.recommendation.algorithmImpl.KarlPearsonSimilarity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="food_table"></div><button onclick="showDetails()">show</button>
        <script>
 function showDetails() {
            var xhttp;
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("food_table").innerHTML = this.responseText;
                }
            };
  xhttp.open("GET", "NutritionDetails.jsp?q=Jowar", true);
  xhttp.send();   
}
               
		</script>	
		

    </body>
</html>
<!--< %
                     KarlPearsonSimilarity ks=new KarlPearsonSimilarity();
                     List<Food> f=ks.obtainRecommendedFoodNameForUserId("C:\\Users\\WannaCry\\Documents\\NetBeansProjects\\DietManager\\src\\java\\com\\dietManager\\recommendation\\algorithmImpl\\test.csv",10, 10);
                     //List<Food> f=ks.obtainRecommendedFoodNameForUserId("../../src/java/com/dietManager/recommendation/algorithmImpl/test.csv",10, 10);
                     
                    int i=0;
                         for(Food rec:f)
                             {
                                 //out.println("<li class='recommend-list'>"+rec.getF_name()+"</li>");
                             
                    
                    %>
			<p>< out.println(i++);%>< %=rec.getF_name()%></p>
                        < %
                        }
                        %>-->