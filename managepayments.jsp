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
                                User Email

            </th>
            
                <th>
Transaction ID
            </th>
            <th>
Date of Transaction
            </th>
            <th>
Action            </th>
            </thead>
            <tbody>
            <c:forEach items="${thePayment}" var="payment">

                <tr>
                    <td>
                        ${payment.getUseremail()}
                    </td>
                    <td>
                        ${payment.getTransid()}
                    </td>
                    <td>
                        ${payment.getDate()}
                    </td>
                    <td>
                    <form action="managepayments" method="get">
                    <input type="hidden" name="action" value="deletepayment">

                    <input type="hidden" name="id" value="${payment.getTransid()}">
                    <button class="btn btn-inverse" type="submit" id="checkout">Delete</button>
                    </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    <%@ include file="footer.jsp" %>
