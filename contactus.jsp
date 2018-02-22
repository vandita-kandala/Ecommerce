<%-- 
    Document   : contactus
    Created on : May 2, 2017, 9:49:42 PM
    Author     : vandita
--%>

<%@ include file="header.jsp" %>
<section class="main-content">

<div class="container">
    <form action="EmailController" method="post">
        <input type="hidden" name="email" value="vandita.kandala7@gmail.com" />
        <div class="container" >
            <div>
                <div class="col-md-6 col-md-push-4">
                    <label>Please Enter Your Email!</label>
                    <input type="email" name="subject" required> <br><br>
                </div>
            </div>
            
            
            <div class="container" >
            <div >
                <div >
                    <label>Body</label>
                    <textarea rows="4" cols="50"  name="body" required></textarea> <br><br>
                </div>
            </div>
            
            <div >
                <div >
                    <button type="submit">Submit</button>                
                </div>
            </div>
    </form>
</div>
        </div>
</div>

</section>
<%@ include file="footer.jsp" %>
