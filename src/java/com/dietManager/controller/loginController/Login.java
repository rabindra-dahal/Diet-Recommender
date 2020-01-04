package com.dietManager.controller.loginController;

import com.dietManager.connectionManager.Encrypter;
import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterface;
import com.dietManager.database.UserDetails.GeneralBAO.GeneralBAOInterfaceImpl;
import com.dietManager.model.UserDetails.General;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class Login extends HttpServlet {

    private Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            String user = config.getInitParameter("username");
            String password = config.getInitParameter("password");
            ServletContext sc = config.getServletContext();
            String driver = sc.getInitParameter("driver");
            String url = sc.getInitParameter("url");
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void destroy() {
        try {
            con.close();
            super.destroy();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        HttpSession session;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            session = request.getSession();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            String user = request.getParameter("Username");
            String pass = Encrypter.md5Encrypt(request.getParameter("Password").trim());
            GeneralBAOInterface imp = new GeneralBAOInterfaceImpl();
            General g ;
           // g.setU_name(user);
            //g.setPassword(pass);
            //General g1;
            g = imp.generalFindByNameAndPassword(user, pass);
            String uname, psw, gen;
            uname = g.getU_name();
            psw = g.getPassword();
            gen = g.getGender();
            session.setAttribute("gender", gen);
            session.setAttribute("u_name", uname);

            if(user.equals(uname) && pass.equals(psw)) {
                
                response.sendRedirect("./Diet/index.jsp");
            }
            else  {
                JOptionPane.showMessageDialog(null, "UserName or Password mismatch\n Please try again ", "Authentication Failure", JOptionPane.ERROR_MESSAGE);
            
                //response.sendError(501, "Need Authentication !!! Username Password not matched...");
               //response.setIntHeader("Refresh", 5);
              // out.println("<script type='text/javascript'>alert('Hello World');</script>");
                  response.sendRedirect("./index.jsp");
                }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex ) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Login Controller";
    }

}
