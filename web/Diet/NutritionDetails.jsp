<%-- 
    Document   : NutritionDetails
    Created on : Jun 12, 2017, 7:47:06 AM
    Author     : Anoor
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dietManager.database.InformationDetailer.NutritionInformationProvider"%>
<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                        <%
                        //int measure=Integer.parseInt(request.getParameter("measure"));
                        String food_name=request.getParameter("q");
                        FoodDAOInterfaceImpl food=new FoodDAOInterfaceImpl();
                        Food f=food.findByFoodName(food_name);
                        double food_id=f.getF_id();
                        if(f.getF_id()==0.0){
                            out.println("<h3>There is no such food in database</h3>");
                        }
                        else{
                        NutritionInformationProvider prov=new NutritionInformationProvider();
                        List<NutritionInformationProvider> details=prov.findFoodNutritionInformation2(food_id);
                        %>
                        
                        <table style="margin:10px;">
                            <tr><th>Nutrients</th><th>Amount</th><th>Unit</th></tr>
              <%     for(NutritionInformationProvider d:details){         %>              
                            <tr>
                                <td style="width:150px;"><%=d.getN_name()%></td>
                                <td style="width:100px;"><%=d.getAmount()%></td>
                                <td><%=d.getUnit()%></td>
                            </tr>
              <% } %>
                        </table> 
                            <% } %>
                            