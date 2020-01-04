<%-- 
    Document   : savefood
    Created on : Jun 14, 2017, 9:09:45 PM
    Author     : Anoor
--%>

<%@page import="com.dietManager.model.UserDetails.Choices"%>
<%@page import="java.util.List"%>
<%@page import="com.dietManager.database.UserDetails.ChoicesDAO.ChoicesDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="com.dietManager.database.Nutrition.FoodDAO.FoodDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <body>
        <%
            String u_name=(String)session.getAttribute("u_name");
            int total=Integer.parseInt(request.getParameter("total"));
            int count=0;
            GeneralDAOInterfaceImpl gdii=new GeneralDAOInterfaceImpl();
            General g=gdii.findByName(u_name);
            double u_id=g.getU_id();
            FoodDAOInterfaceImpl fdii=new FoodDAOInterfaceImpl();
            for(int i=0;i<total;i++){
            String name=request.getParameter("x"+i);
            Food f=fdii.findByFoodName1(name);
            double f_id=f.getF_id();
            ChoicesDAOInterfaceImpl cdii=new ChoicesDAOInterfaceImpl();
            List<Choices> li=cdii.findByUserId(u_id);
            List<Choices> li1=cdii.findByUF_Id(u_id, f_id);
            if(li.isEmpty()){
                    Choices firstdata=new Choices();
                    firstdata.setU_id(u_id);
                    firstdata.setF_id(f_id);
                    firstdata.setNo_of_times(1.0);
                    if(cdii.save(firstdata)!=0){
                        count=count+1;
                    }
            }
            else if(li1.isEmpty()){
                    Choices temp2=new Choices();
                    temp2.setF_id(f_id);
                    temp2.setU_id(u_id);
                    temp2.setNo_of_times(1);
                    if(cdii.save(temp2)!=0){
                    count=count+1;
                    }
            }
            else{
                for(Choices temp1:li1){
                    double nots=temp1.getNo_of_times()+1;
                    temp1.setNo_of_times(nots);
                    if(cdii.update(temp1, u_id)){
                        count=count+1;
                    }
                }
            }
            
            }
            if(count==total){
                out.println("All food successfully inserted");
            }
            else{
                out.println("One or more food not inserted");
            }
             
        %>
    </body>