<%@page import="com.dietManager.model.Nutrition.Contains"%>
<%@page import="com.dietManager.model.Nutrition.Belongs"%>
<%@page import="com.dietManager.model.Nutrition.Categories"%>
<%@page import="com.dietManager.model.Nutrition.Food"%>
<%@page import="com.dietManager.database.Nutrition.ContainsBAO.ContainsBAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.BelongsBAO.BelongsBAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.CategoriesBAO.CategoriesBAOInterfaceImpl"%>
<%@page import="com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterfaceImpl"%>
<%@page import="com.dietManager.connectionManager.ConnectionManagement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dietManager.model.Nutrition.Nutrients"%>
<%@page import="com.dietManager.database.Nutrition.NutrientsBAO.NutrientsBAOInterfaceImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 
                Connection con=ConnectionManagement.connect_nutrition();
                /*String f_name,c_name,n_name,unit;
                double amt;
                f_name=request.getParameter("f_name");
                c_name=request.getParameter("c_name");
                n_name=request.getParameter("n_name");
                unit=request.getParameter("unit");
                amt=Double.parseDouble(request.getParameter("amt"));
                
                FoodBAOInterfaceImpl fb=new FoodBAOInterfaceImpl();
                CategoriesBAOInterfaceImpl cb=new CategoriesBAOInterfaceImpl();
                NutrientsBAOInterfaceImpl nb=new NutrientsBAOInterfaceImpl();
                BelongsBAOInterfaceImpl bb=new BelongsBAOInterfaceImpl();
                ContainsBAOInterfaceImpl contains=new ContainsBAOInterfaceImpl();
                Food f=new Food(f_name);
                Categories c=new Categories(c_name);
                Nutrients n=new Nutrients(n_name, unit);
                Belongs b=new Belongs(f.getF_id(), c.getC_id());
                Contains cc=new Contains(f.getF_id(), n.getN_id(), amt);
                fb.foodSave(f);
                cb.categoriesSave(c);
                nb.nutrientsSave(n);
                bb.belongsSave(b);
                contains.containsSave(cc);*/
                ContainsBAOInterfaceImpl contains=new ContainsBAOInterfaceImpl();
                
                 Contains cc=new Contains(Double.parseDouble(request.getParameter("f_id")), Double.parseDouble(request.getParameter("c_id")), Double.parseDouble(request.getParameter("amt")));
                
               contains.containsSave(cc);
                response.sendRedirect("./Contains.jsp");
       %>
    </body>
</html>
