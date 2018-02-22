/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;

import com.vandita.pkg.Payment;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author vandita
 */

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

@WebServlet(urlPatterns = {"/managepayments"})

public class PaymentController extends HttpServlet{
    
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
            String url = "/managepayments.jsp";
               ArrayList<Payment> plist = new ArrayList();

  
        if(action.equals("deletepayment")){
            String id = request.getParameter("id");

                     try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");

                    Statement statement = con.createStatement();
                String query = "DELETE FROM payments WHERE transactionid='"+id+"'";
                PreparedStatement preparedStmt = con.prepareStatement(query);

                preparedStmt.execute();


                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                             url = "/managepayments.jsp";

                }
          
            
        try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");

                    Statement statement = con.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM payments");


                    while (rs.next()) {
                        String useremail = rs.getString("useremail");
                        String transid = rs.getString("transactionid");
                        String date = rs.getString("date");
                        Payment p = new Payment(useremail,transid, date);
                       plist.add(p);

                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        request.getSession().setAttribute("thePayment", plist);
                    url = "/managepayments.jsp";

        getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
        }
        
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
        }
}
