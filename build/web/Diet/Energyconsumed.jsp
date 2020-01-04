<%-- 
    Document   : Energyconsumed
    Created on : Jun 12, 2017, 2:33:44 PM
    Author     : jiwan
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.dietManager.model.UserDetails.State"%>
<%@page import="com.dietManager.database.UserDetails.StateDAO.StateDAOInterfaceImpl"%>
<%@page import="com.dietManager.model.UserDetails.General"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterfaceImpl"%>
<%@page import="com.dietManager.database.UserDetails.GeneralDAO.GeneralDAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <body>
        <%
            String u_name=(String)session.getAttribute("u_name");
            GeneralDAOInterfaceImpl gdii=new GeneralDAOInterfaceImpl();
            General user=gdii.findByName(u_name);
            double user_id=user.getU_id();
            char gen=user.getGender().charAt(0);
            StateDAOInterfaceImpl sdii=new StateDAOInterfaceImpl();
            State user_det=sdii.findByPK(user_id);
            DecimalFormat df=new DecimalFormat("#0.99");
            double energy=0;
            if(gen=='M'){
            energy= (float)(10 * user_det.getWeight())+ (6.25*user_det.getHeight())-(5*user_det.getAge())+5;
            }
            else if(gen=='F'){
            energy= (float)(10 * user_det.getWeight())+ (6.25*user_det.getHeight())-(5*user_det.getAge())-161;
            }
            out.println(df.format(energy));
        %>
    </body>
