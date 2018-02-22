<%-- 
    Document   : header
    Created on : Apr 26, 2017, 8:18:13 PM
    Author     : vandita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>New and Used Cars Ecommerce</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

        <link href="themes/css/bootstrappage.css" rel="stylesheet"/>

        <link href="themes/css/main.css" rel="stylesheet"/>

        <script src="themes/js/jquery-1.7.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>	
            <link href='http://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet' type='text/css'>
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="styles/style.css">

    </head>
    <body>
        <div id="top-bar" class="container">
            <div class="row">
                <div class="span4" style="height:30px;">
                    <img src="images/hire.png" alt="" style="height:30px;"/>
                </div>
                <div class="span8">
                    <div class="account pull-right">
                        <ul class="user-menu">	
                            
                            <c:if test="${empty theUser && empty theAdmin}">
                            <li><a href="cart.jsp">Your Cart</a></li>
                            <li><a href="login.jsp">Login/Register</a></li>	
                            </c:if>
                           
                            <c:if test="${not empty theUser && empty theAdmin}">
                            <li><a href="cart?action=cart">Your Cart</a></li>
                            <li>${theUser}</li>
                            <li><a href="cart?action=logout">logout </a></li>
                            </c:if>
                            
                            <c:if test="${not empty theAdmin  && empty theUser}">
                            <li>${theAmin.getName()}</li>
                            <li><a href="cart?action=logout">logout </a></li>
                            </c:if>
                            	
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="wrapper" class="container">

         <section class="navbar main-menu">
                <div class="navbar-inner main-menu">				
                    <nav id="menu" class="pull-left">
                        <ul>	
                            <c:if test="${empty theUser && empty theAdmin}">
                             <li><a href="home.jsp">Home</a></li>
                            <li><a href="index.jsp">Products</a></li>		
                            </c:if>
                            <c:if test="${not empty theAdmin && empty theUser}">
                            <li><a href="home.jsp">Home</a></li>
                            <li><a href="index">Products</a></li>
                            <li><a href="manageproducts">Manage Products</a></li>		
                            <li><a href="managepayments?action=managepayments">Manage Payments</a></li>
                            <li><a href="manageusers?action=manageusers">Manage Users</a></li>		

                            </c:if>
                           																										
                            <div class="span4">
                                
                            </div>
                        </ul>
                    </nav>
                </div>
            </section>