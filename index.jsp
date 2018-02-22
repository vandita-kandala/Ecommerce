<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<section class="main-content">
    <div class="row">
        <div class="span12">													
            <div class="row">
                <div class="span12">
                    <div id="myCarousel" class="myCarousel carousel slide">
                        <div class="carousel-inner">
                            <div class="active item">
                                <ul class="thumbnails">


                                    <c:forEach items="${theProductList}" var="product">

                                        <c:choose>
                                        <c:when test="${product.getCategory()=='used'}">
                                            <li class="span3">
                                            <div class="product-box">
                                                <span class="sale_tag"></span>
                                                <p><a href="product_detail?id=${product.getProductid()}"><img alt="" src="images/${product.getImage()}"></a></p>
                                                <a href="product_detail?id=${product.getProductid()}" class="title">${product.getName()}</a><br/>
                                                <a href="product_detail?id=${product.getProductid()}" class="category">USED</a>
                                                <p class="price">${product.getPrice()}</p>
                                            </div>
                                        </li>
                                        </c:when>    
                                        
                                        </c:choose>
                                        
                                        
                                        
                                    </c:forEach>
<!--                                    <li class="span3">
                                        <div class="product-box">
                                            <span class="sale_tag"></span>
                                            <p><a href="product_detail?id=1"><img src="images/car1used.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=1" class="title">Mitsubishi Lancer</a><br/>
                                            <a href="product_detail?id=1" class="category">USED</a>
                                            <p class="price">$20000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <span class="sale_tag"></span>
                                            <p><a href="product_detail?id=2"><img src="images/car2used.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=2" class="title">Lamborgini GT</a><br/>
                                            <a href="product_detail.jsp?id=2" class="category">USED</a>
                                            <p class="price">$30000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <p><a href="product_detail?id=3"><img src="images/car3used.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=3" class="title">AMC Avalon KZ400</a><br/>
                                            <a href="product_detail?id=3" class="category">USED</a>
                                            <p class="price">$25000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <p><a href="product_detail?id=4"><img src="images/car4used.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=4" class="title">Rolls Royce Merlin</a><br/>
                                            <a href="product_detail?id=4" class="category">USED</a>
                                            <p class="price">$40000</p>
                                        </div>
                                    </li>-->
                                </ul>
                            </div>
                        </div>							
                    </div>
                </div>						
            </div>
            <br/>
            <div class="row">
                <div class="span12">

                    <div id="myCarousel-2" class="myCarousel carousel slide">
                        <div class="carousel-inner">
                            <div class="active item">
                                <ul class="thumbnails">	
                                     <c:forEach items="${theProductList}" var="product">

                                        <c:choose>
                                        <c:when test="${product.getCategory()=='new'}">
                                            <li class="span3">
                                            <div class="product-box">
                                                <span class="sale_tag"></span>
                                                <p><a href="product_detail?id=1"><img alt="" src="images/${product.getImage()}"></a></p>
                                                <a href="product_detail?id=1" class="title">${product.getName()}</a><br/>
                                                <a href="product_detail?id=1" class="category">USED</a>
                                                <p class="price">${product.getPrice()}</p>
                                            </div>
                                        </li>
                                        </c:when>    
                                        
                                        </c:choose>
                                        
                                        
                                        
                                    </c:forEach>
<!--                                    <li class="span3">
                                        <div class="product-box">
                                            <span class="sale_tag"></span>
                                            <p><a href="product_detail?id=5"><img src="images/car1new.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=5" class="title">Lykan Hypersport</a><br/>
                                            <a href="product_detail?id=5" class="category">NEW</a>
                                            <p class="price">$50000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <p><a href="product_detail?id=6"><img src="images/car2new.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=6" class="title">Ferrari F60 America</a><br/>
                                            <a href="product_detail?id=6" class="category">NEW</a>
                                            <p class="price">$60000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <p><a href="product_detail?id=7"><img src="images/car3new.png" alt="" /></a></p>
                                            <a href="product_detail?id=7" class="title">1995 McLaren F1 LM</a><br/>
                                            <a href="product_detail?id=7" class="category">NEW</a>
                                            <p class="price">$70000</p>
                                        </div>
                                    </li>
                                    <li class="span3">
                                        <div class="product-box">
                                            <p><a href="product_detail?id=8"><img src="images/car4new.jpg" alt="" /></a></p>
                                            <a href="product_detail?id=8" class="title">2007 Bugatti 16/4 Veyron Pur Sang</a><br/>
                                            <a href="product_detail?id=8" class="category">NEW</a>
                                            <p class="price">$65000</p>
                                        </div>
                                    </li>-->
                                </ul>
                            </div>
                        </div>							
                    </div>
                </div>						
            </div>
        </div>				
    </div>
</section>
<%@ include file="footer.jsp" %>
