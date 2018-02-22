/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;


import com.vandita.pkg.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manageusers"})

public class AdminUserController extends HttpServlet{
    
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
            String url = "/manageusers.jsp";
               ArrayList<User> ulist = new ArrayList();

  
        if(action.equals("deleteuser")){
            
            
            
            
            
            String id = request.getParameter("id");

                     try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");

                    
                    
                    
                    
                    Statement statement = con.createStatement();
                String query = "DELETE FROM user WHERE email='"+id+"'";
                PreparedStatement preparedStmt = con.prepareStatement(query);

                preparedStmt.execute();


                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                             url = "/manageusers.jsp";

                }
        else if(action.equals("add")){
             try {
                             String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

                    

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");
                    String type="user";
                    Statement statement = con2.createStatement();
                    String query = "insert into user values ('" + name + "','" + email + "','" + password + "','user')";
                    PreparedStatement preparedStmt = con2.prepareStatement(query);

                        preparedStmt.executeUpdate();
                        url = "/manageusers.jsp";

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                             url = "/manageusers.jsp";

                
        }
          
            
        try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");

                    Statement statement = con.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM user");


                    while (rs.next()) {
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String pwd = rs.getString("password");

                        String type = rs.getString("type");
                        User p = new User(name,email,pwd, type);
                        ulist.add(p);

                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        request.getSession().setAttribute("userlist", ulist);
                    url = "/manageusers.jsp";

        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
        }
        
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
        }
}