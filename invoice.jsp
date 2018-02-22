<%-- 
    Document   : invoice
    Created on : Apr 27, 2017, 2:31:52 PM
    Author     : vandita
--%>

<%@ include file="header.jsp" %>


    <section class="header_text sub">
        <img class="pageBanner" src="images/banner.jpeg" alt="New products" >
        <h4><span>Check Out</span></h4>
    </section>	
    <section class="main-content">
        <div class="row">
            <div class="span12">
                <div class="accordion" id="accordion2">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">Checkout Options</a>
                        </div>
                        <div id="collapseOne" class="accordion-body in collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="span6">
                                        <p> YOU MAY USE EITHER DEBIT OR CREDIT CARD FOR YOUR TRANSACTION. THANK YOU!
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">Account &amp; Billing Details</a>
                        </div>
                        <div id="collapseTwo" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="span6">
                                        <h4>Your Personal Details</h4>
                                        <div class="control-group">
                                            <label class="control-label"><b>Name</b></label>
                                            <div class="controls">
                                                <p>${theUser}</p>
                                            </div>
                                        </div>
                                        
                                        <div class="control-group">
                                            <label class="control-label"><b>Credit/Debit Card Number</b></label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                        <label class="control-label"><b>Cvv</b></label>
                                        <div class="controls">
                                            <input type="text" placeholder="" class="input-xlarge">
                                        </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label"><b>Telephone</b></label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>

                                    </div>
                                    <div class="span6">
                                        <h4>Your Address</h4>
                                        <div class="control-group">
                                            <label class="control-label">Company</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">Company ID:</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>					  
                                        <div class="control-group">
                                            <label class="control-label"><span class="required">*</span> Address 1:</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">Address 2:</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label"><span class="required">*</span> City, State, Country:</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label"><span class="required">*</span> Post Code:</label>
                                            <div class="controls">
                                                <input type="text" placeholder="" class="input-xlarge">
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">Confirm Order</a>
                        </div>
                        <div id="collapseThree" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="control-group">
                                        <label for="textarea" class="control-label">Comments</label>
                                        <div class="controls">
                                            <textarea rows="3" id="textarea" class="span12"></textarea>
                                        </div>
                                    </div>	
                                    
                                    
<!--                                    <form action="cart?action=cartremove" method="post">

                    <input type="hidden" name="finalpricing" value="${finaltotal}">

                   
                    <button class="btn btn-inverse" type="submit" id="checkout">Confirm order</button>
                                    </form>-->
                                    
                                    
                                    <a href="cart?action=cartremove" class="btn btn-inverse pull-right">Confirm order</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>				
            </div>
        </div>
    </section>			
    <%@ include file="footer.jsp" %>

</div>
