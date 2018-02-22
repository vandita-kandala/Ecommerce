/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;

import com.vandita.database.UserDB;
import com.vandita.pkg.Cartt;
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

/**
 *
 * @author vandita
 */
@WebServlet(urlPatterns = {"/login"})
public class UserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/login.jsp";

        String message = null;

        String action = request.getParameter("action");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/login.jsp";
        String msg = null;
        String signupmsg = null;
        String action = request.getParameter("action");
        if (action == null) {
            url = "/index.jsp";
        } else if (action.equals("login")) {
            String email1 = request.getParameter("email1");
            String password1 = request.getParameter("password1");
            String adminrole ="admin";
            String userrole="user";

            if (email1 == null || password1 == null
                    || email1.isEmpty() || password1.isEmpty()) {

                msg = "Please fill in all values";
                url = "/login.jsp";
            } else {
                
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");

                    Statement statement = con.createStatement();

                    ResultSet rs = statement.executeQuery("SELECT * FROM user");

//                    String query = "SELECT * FROM user";
//                    PreparedStatement preparedStmt = con.prepareStatement(query);
//
//                    preparedStmt.executeUpdate();
                    while (rs.next()) {
                        String e = rs.getString("email");
                        String p = rs.getString("password");
                        String name1 = rs.getString("name");
                        String type = rs.getString("type");

                        if (e.equals(email1) && p.equals(password1)) {
                            if(adminrole.equals(type)){
                             request.getSession().setAttribute("theAdmin", type);

                                                                                url = "/startpage.jsp";

                            }
                            else if(userrole.equals(type)){
                             request.getSession().setAttribute("theUser", name1);
                                                                                url = "/startpage.jsp";

                            }

                        }

                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (action.equals("signup")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String type = "user";
            String password = request.getParameter("password");
            if (name == null || name.isEmpty()
                    || email == null || email.isEmpty()
                    || password == null || password.isEmpty()) {

                signupmsg = "Please fill all the fields";
                url = "/login.jsp";
            } else {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection con2 = null;
                try {
                    con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Statement statement2 = null;
                try {
                    statement2 = con2.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {

                    boolean count = false;

                    ResultSet rs = statement2.executeQuery("SELECT * FROM user");

                    while (rs.next()) {

                        String e = rs.getString("email");
                        if (e.equals(email)) {
                            count = true;
                            signupmsg = "Email already exists! Please chose another one.";
                            url = "/login.jsp";

                        }

                    }
                    if (count == false) {
                        String query = "insert into user values ('" + name + "','" + email + "','" + password + "','" + type + "')";
                        PreparedStatement preparedStmt = con2.prepareStatement(query);

                        preparedStmt.executeUpdate();
                        request.getSession().setAttribute("theUser", name);
                        url = "/index.jsp";
                    }

                    // statement2.executeUpdate("insert into user values ('"+name+"','"+email+"','"+password+"','"+type+"')");
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        request.setAttribute("msg", msg);
        request.setAttribute("msgg", signupmsg);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
