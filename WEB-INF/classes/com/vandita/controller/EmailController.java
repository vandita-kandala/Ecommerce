/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.controller;

/**
 *
 * @author vandita
 */
import com.vandita.pkg.Email;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmailController")
public class EmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String body = request.getParameter("body");
		String subject = request.getParameter("subject");
		String from = "vegangrocerystore@gmail.com";
		String password = "password7";
		Email.send(from, password, email, subject, body);
		RequestDispatcher rd = request.getRequestDispatcher("startpage.jsp");
		rd.forward(request,response);
	}

}