<%-- 
    Document   : product_detail
    Created on : Apr 27, 2017, 10:02:41 AM
    Author     : vandita
--%>

<%@ include file="header.jsp" %>


<c:choose>
    <c:when test="${empty theUser}">
        <% response.sendRedirect("login.jsp");%>
    </c:when>
</c:choose>



    <section class="header_text sub">
        <img class="pageBanner" src="images/banner.jpeg" style="height: 100px;" alt="New products" >
        <h4><span>Product Details</span></h4>
    </section>
    <section class="main-content">				
        <div class="row">						
            <div class="span9">
                <div class="row">
                    <div class="span4">
                        <img alt="" src="images/${theProduct.getImage()}"></a>												

                    </div>
                    <div class="span5">
                        <address>
                            <strong>Brand:</strong> <span>Toyota</span><br>
                            <strong>Product Code:</strong> <span>Product ${theProduct.getProductid()}</span><br>
                            <strong>Reward Points:</strong> <span>50</span><br>
                            <strong>Availability:</strong> <span>vailable!</span><br>								
                        </address>									
                        <h4><strong>Price: $${theProduct.getPrice()}</strong></h4>
                    </div>
                    <div class="span5">
                        <form class="form-inline" action="cart" method="post">

                            <p>&nbsp;</p>
                            <label>Qty:</label>
                             <input type="hidden" name="pid" value="${theProduct.getProductid()}">

                            <input type="hidden" name="price" value="${theProduct.getPrice()}">
                            <input type="text" name="quantity" class="span1" value="1">
                            <button class="btn btn-inverse" type="submit" name="cart">Add to cart</button>
                        </form>
                    </div>							
                </div>
                <br>
                <br>
                <br>
                <div class="row">
                    <div class="span9">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active"><a href="#home">Description</a></li>
                        </ul>							 
                        <div class="tab-content">
                            <div class="tab-pane active" id="home"> ${theProduct.getDescription()}</div>

                        </div>							
                    </div>						

                </div>
                <br>
                <br>
                <br>
                <br>
            </div>

        </div>
    </section>			

    <%@ include file="footer.jsp" %>


