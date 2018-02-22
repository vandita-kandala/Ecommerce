/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;
import com.vandita.pkg.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author vandita
 */
@WebServlet(urlPatterns = {"/product_detail"})
public class ProductController extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/index.jsp";
      ArrayList<Integer> pid = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
      String id = request.getParameter("id");
      int id1 = Integer.parseInt(id);
      if(pid.contains(id1)){
          
      
          try {
                   
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC","root","");
                    Statement statement = con.createStatement(); 
                    
                   ResultSet rs = statement.executeQuery("SELECT * FROM products");
                    while(rs.next()) {
                        
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        String image = rs.getString("image");
                        String category = rs.getString("category");
                        String price = rs.getString("price");
                        String productid = rs.getString("productid");
                        Product p1 = new Product(name, productid, description, price, category, image);
                        request.setAttribute("theProduct", p1);
                        if(productid.equals(id)){
                            Product p = new Product(name, productid, description, price, category, image);
                        request.setAttribute("theProduct", p);
                        request.setAttribute("theProduct", p);
                        url = "/product_detail.jsp";
                        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

                        }
         
                    } 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
      
      }
      
     
     }
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         }
     
}
