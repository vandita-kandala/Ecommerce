/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;

import com.vandita.pkg.Cartt;
import com.vandita.pkg.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
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
@WebServlet(urlPatterns = {"/cart"})

public class CartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cartt> alist = new ArrayList();
        ArrayList<Integer> finalp = new ArrayList();

        String username = (String) request.getSession().getAttribute("theUser");

        String url = "/startpage.jsp";
        String action = request.getParameter("action");
        if (action.equals("cart")) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cond = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");
                Statement statementd = cond.createStatement();

                ResultSet rs = statementd.executeQuery("SELECT * FROM cart");
                while (rs.next()) {
                    String cartid = rs.getString("cartid");

                    if (username.equals(cartid)) {

                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        String image = rs.getString("image");
                        String category = rs.getString("category");
                        String productid = rs.getString("id");
                        String tp = rs.getString("totalprice");
                        String q = rs.getString("quantity");

                        Cartt c1 = new Cartt(cartid, name, description, productid, image, tp, q, category);
                        alist.add(c1);

                    }

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("theCartList", alist);

            url = "/cart.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        } else if (action.equals("cartremove")) {
            request.getSession().removeAttribute("theCartList");
            request.getSession().removeAttribute("cartlist");
            alist.removeAll(alist);

            String fp1 = request.getParameter("finalpricing");

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");
                Statement statement = con.createStatement();

                UUID tansid = UUID.randomUUID();

                String transactionid = String.valueOf(tansid);
                DateFormat df = new SimpleDateFormat();

                Date date = new Date();

                String query2 = "INSERT INTO payments " + "VALUES ('" + username + "','" + transactionid + "','" + date + "')";

                PreparedStatement ps = con.prepareStatement(query2);

                ps.execute();

                String query = "DELETE FROM cart WHERE cartid='"+username+"'";
                PreparedStatement preparedStmt = con.prepareStatement(query);

                preparedStmt.execute();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("theCartList", null);
            request.setAttribute("cartlist", null);

            url = "/startpage.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("logout")) {
            if (request.getSession().getAttribute("theUser") == null
                    && request.getSession().getAttribute("theAdmin") == null) {
                request.getSession().invalidate();

                alist.removeAll(alist);

                url = "/login.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);

            } else {
                request.getSession().invalidate();
                alist.removeAll(alist);

                url = "/login.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {

        ArrayList<Cartt> alist = new ArrayList();

        String url = "/startpage.jsp";
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String pid = request.getParameter("pid");
        int p = Integer.parseInt(price);
        int q = Integer.parseInt(quantity);
        int total = p * q;

        String cartid = (String) request.getSession().getAttribute("theUser");
        String total_price = String.valueOf(total);
        request.getSession().setAttribute("total", total_price);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?serverTimezone=UTC", "root", "");
            Statement statements = cons.createStatement();

            ResultSet rs = statements.executeQuery("SELECT * FROM products");
            while (rs.next()) {

                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String category = rs.getString("category");
                String productid = rs.getString("productid");
                if (productid.equals(pid)) {

                    Cartt c = new Cartt(cartid, name, description, productid, image, total_price, quantity, category);
                    String query = "INSERT INTO cart " + "VALUES ('" + cartid + "','" + name + "','" + productid + "','" + description + "','" + category + "','" + image + "','" + total_price + "','" + quantity + "')";
                    PreparedStatement preparedStmt = cons.prepareStatement(query);

                    preparedStmt.executeUpdate();
                    //statements.executeUpdate("INSERT INTO cart " + "VALUES ('"+name+"','"+productid+"','"+description+"','"+category+"','"+image+"','"+total_price+"','"+quantity+"')");

                    alist.add(c);
                    request.setAttribute("theCartList", alist);
                    request.setAttribute("theCart", c);

                    url = "/startpage.jsp";
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
