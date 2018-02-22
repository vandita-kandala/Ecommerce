<%-- 
    Document   : cart
    Created on : Apr 27, 2017, 12:01:09 PM
    Author     : vandita
--%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="header_text sub">
        <h4><span>Shopping Cart</span></h4>
    </section>
    <section class="main-content">				
        <div class="row">
            <div class="span9">					
                <h4 class="title"><span class="text"><strong>Your</strong> Cart</span></h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Product Name</th> 
                            <th>Rewards</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="p" value="${0}"/>
                        
                        <c:forEach items="${theCartList}" var="cartItem">
                            <tr>      
                               <td><img alt="" src="images/${cartItem.getImage()}"></td>
                            <td>${cartItem.getName()}</td>
                            <td>50</td>
                            <td>${cartItem.getQuantity()}</td>
                            <td>$${cartItem.getTotalprice()}</td> 
                            </tr>
                            <c:set var="p" value="${p + cartItem.getTotalprice()}" />
                            

                        </c:forEach>
                        	<c:if test="${empty theCartList}">	  
                                <c:set var="finaltotal" value="${0}"/>
                                </c:if>
                                                    	<c:if test="${not empty theCartList}">	  

                        <c:set var="finaltotal" value="${100+2+17.50+p}"/>
                                </c:if>

                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>		  
                    </tbody>
                </table>
                <h4 class="cart-total right">Your Total Bill </h4>


                <hr>
                <p class="cart-total right">
                    <strong>Sub-Total</strong>:	$100.00<br>
                    <strong>Eco Tax (-2.00)</strong>: $2.00<br>
                    <strong>VAT (17.5%)</strong>: $17.50<br>
                    <strong>Total</strong>:$${finaltotal}<br>
                </p>
                <hr/>
                <form action="invoice.jsp" method="post">

                    <input type="hidden" name="list" value="${theCartList}">
                    <input type="hidden" name="finalpricing" value="${finaltotal}">

                    <p class="buttons center">	
                    <a href="startpage.jsp" class="btn" />Cancel</a>
                    <button class="btn btn-inverse" type="submit" id="checkout">Checkout</button>
                </p>					
            </div>
        </div>
    </section>
    <%@ include file="footer.jsp" %>

</div>
