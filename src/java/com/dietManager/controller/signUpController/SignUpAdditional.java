package com.dietManager.controller.signUpController;

import com.dietManager.database.UserDetails.StateBAO.StateBAOInterface;
import com.dietManager.database.UserDetails.StateBAO.StateBAOInterfaceImpl;
import com.dietManager.model.UserDetails.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SignUpAdditional extends HttpServlet {
    /*private Connection con;
   
    @Override
     public void init(ServletConfig config) throws ServletException {
        try {
            String user=config.getInitParameter("username");
            String password=config.getInitParameter("password");
            ServletContext sc=config.getServletContext();
            String driver=sc.getInitParameter("driver");
            String url=sc.getInitParameter("url");
            Class.forName(driver);
            try {
                con=DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
*/
   /* @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpAdditional.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.destroy(); 
    }*/
     
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
         HttpSession session;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            session=request.getSession();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpAdditional</title>");            
            out.println("</head>");
            out.println("<body>");
            String food_habbit;
            double height,weight,working_hour,age;
            double u_id=(Double)session.getAttribute("u_id");
           // out.println("User_id"+ui);
            
            
            //double u_id=Double.parseDouble(request.getParameter("u_id"));
            food_habbit=request.getParameter("foodhabbit");
             height=Double.parseDouble(request.getParameter("height"));
             height=height*30.48;
           age=Double.parseDouble(request.getParameter("age"));
           weight=Double.parseDouble(request.getParameter("weight"));
           working_hour=Double.parseDouble(request.getParameter("working_hour"));
           
           State s= new State(u_id, height, weight, working_hour, age, food_habbit);
            StateBAOInterface sbi=new StateBAOInterfaceImpl();
            int i=sbi.stateSave(s);
           
           /*
           String sql="insert into state values (?,?,?,?,?,?)";
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setDouble(1,u_id);
           ps.setDouble(2,height);
           ps.setDouble(3,weight);
           ps.setDouble(4,working_hour);
           ps.setDouble(5,age);
           ps.setString(6,food_habbit);*/
           //int i=ps.executeUpdate();
           if(i!=0)
               response.sendRedirect("./Diet/index.jsp");
           else 
               response.sendRedirect("./signupProcess.jsp");
           
          
           
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SignUpAdditional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SignUpAdditional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
