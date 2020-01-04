package com.dietManager.controller.signUpController;

import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterface;
import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterfaceImpl;
import com.dietManager.model.UserDetails.General;
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
import javax.swing.JOptionPane;
public class SignUp extends HttpServlet {

    //private Connection con;
   
    /*@Override
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
            out.println("<title>Servlet SignUp</title>");            
            out.println("</head>");
            out.println("<body>");
            String uname,psw,gender;
            //double age;
            uname=request.getParameter("uname");
            psw=request.getParameter("psw");
            gender=request.getParameter("gender");
            //age=Double.parseDouble(request.getParameter("age"));
            /*String sql="insert into general values (?,?,?,?)";
            String counter="select count(*) count from general";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(counter);
            double incrementer=0;
            while(rs.next()){
                incrementer+=rs.getDouble("count");
               // out.println(" "+incrementer);
                
            }
            incrementer+=1;
            session.setAttribute("gender",gender);
            session.setAttribute("u_id", incrementer);
            session.setAttribute("u_name",uname);*/
           /* PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, incrementer);
            ps.setString(2, uname);
            ps.setString(3, gender);
            ps.setString(4, psw);*/
            //oop
            General g=new General(uname, gender, psw);
            GeneralBAOInterface gbi=new GeneralBAOInterfaceImpl();
            int i=gbi.generalSave(g);
            session.setAttribute("gender",g.getGender());
            session.setAttribute("u_id", g.getU_id());
            session.setAttribute("u_name",g.getU_name());
            //int i=ps.executeUpdate();
            if(i!=0){
                //JOptionPane.showMessageDialog(null, "Sucess");
                response.sendRedirect("./signupProcess.jsp");
            }
            
            else
                JOptionPane.showMessageDialog(null, "Failure to Sign you up ..");
            
            
            
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
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "SignUp Controller";
    }

   /* @Override
    public void destroy() {
        try {
            con.close();
            super.destroy();
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    

}
