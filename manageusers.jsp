<%-- 
    Document   : managepayments
    Created on : Apr 30, 2017, 4:21:55 PM
    Author     : vandita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


        <table class="table table-striped">
            <thead>
            <th>
                                User Name

            </th>
            
                <th>
Email            </th>
            <th>
Type            </th>
            
            </thead>
            <tbody>
            <c:forEach items="${userlist}" var="user">

                <tr>
                    <td>
                        ${user.getName()}
                    </td>
                    <td>
                        ${user.getEmail()}
                    </td>
                    <td>
                        ${user.getType()}
                    </td>
                    <td>
                    <form action="manageusers" method="get">
                    <input type="hidden" name="action" value="deleteuser">

                    <input type="hidden" name="id" value="${user.getEmail()}">
                    <button class="btn btn-inverse" type="submit" id="checkout">Delete</button>
                    </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                    <form action="adduser.jsp" method="get">

                    <button class="btn btn-inverse" type="submit" id="checkout">Add</button>
                    </form>
                    
    <%@ include file="footer.jsp" %>
