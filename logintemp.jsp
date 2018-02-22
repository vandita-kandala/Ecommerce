<%-- Include tag is used to import header page --%>

<%@include file="header.jsp" %>

<section id="login_form">
    <form action="login" method="post">
        <input type="hidden" name="action" value="login"/>
        <label >Email Address *
        </label>
        <input type="email" name="email" required> 
        <br>
        <br>
        <label >Password *
        </label>
        <input type="password" name="password" required>
        <br>
        <label>&nbsp;
        </label>
        <input type="submit" value="Log in" id="button" name="login">
        &nbsp;
        <span id="error_msg">${msg} </span>
        <br>
    </form>
    <a href="signup.jsp" id="sign_up_link">Sign up
    </a>
</section>
<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>
