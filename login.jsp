<%-- 
    Document   : loginRegister
    Created on : Apr 27, 2017, 8:28:28 AM
    Author     : vandita
--%>

<%@ include file="header.jsp" %>
<div id="wrapper" class="container">
    <section class="header_text sub">
        <img class="pageBanner" src="images/woodward.jpg" alt="woodward hall" style="height:100px;"/>
        <h4><span>Login or Register</span></h4>
    </section>	

    <section class="main-content">				
        <div class="row">
            <div class="span5">					
                <h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
                <form action="login" method="post">

                    <input type="hidden" name="action" value="login"/>
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label">Username</label>
                            <div class="controls">
                                <input type="email" placeholder ="Enter your email" name="email1" required> 
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Password</label>
                            <div class="controls">
                                <input type="password" placeholder="Enter your password!" name="password1" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <input tabindex="3" class="btn btn-inverse large" type="submit" value="Log in" name="login">
                            <hr>
                            <p class="reset" id="error_msg">${msg} </a></p>
                        </div>
                    </fieldset>
                </form>				
            </div>
            <div class="span7">					
                <h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
                <form action="login" method="post" name="signup_form">
                    <input type="hidden" name="action" value="signup" />

                    <fieldset>
                        <div class="control-group">
                            <label class="control-label">Username</label>
                            <div class="controls">
                                <input type="text" placeholder="Enter your name" name="name" class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Email address:</label>
                            <div class="controls">
                                <input type="email" placeholder="Enter your email" name="email"class="input-xlarge">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Password:</label>
                            <div class="controls">
                                <input type="password" placeholder="Enter your password" name="password"class="input-xlarge">
                            </div>
                        </div>							                            
                        <div class="control-group">
                            <span id="error_msg">${msgg} </span>

                        </div>
                        <hr>
                        <div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Create Account" id="signup_button"></div>
                    </fieldset>
                </form>					
            </div>				
        </div>
    </section>	
    <%@ include file="footer.jsp" %>
</div>
