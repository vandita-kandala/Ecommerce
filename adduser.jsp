<%-- 
    Document   : adduser
    Created on : May 2, 2017, 2:03:36 PM
    Author     : vandita
--%>
<%@ include file="headeradd.jsp" %>

<div id="content">
    <h1>Add a User</h1>

    <form action="manageusers" method="get">
                    <input type="hidden" name="action" value="add">
        <p>
            <label for="username" class="icon-user"> Add Name
                <span class="required">*</span>
            </label>
            <input type="text" name="name" id="name" required="required" placeholder="User's Name" />
        </p>

        <p>
            <label for="usermail" class="icon-envelope"> Add E-mail address
                <span class="required">*</span>
            </label>
            <input type="email" name="email" id="email" placeholder="User's Email" required="required" />
        </p>
        <p>
            <label for="usermail" class="icon-envelope"> Add the Password
                <span class="required">*</span>
            </label>
            <input type="password" name="password" id="password" placeholder="User's Password" required="required" />
        </p>
        <p>
            <label for="usersite" class="icon-link"> Add Type</label>
            <input type="text" name="usersite" id="type" placeholder="user" />
        </p>

        
        <p class="indication">Fields with
            <span class="required"> * </span>are required</p>

        <input type="submit"  value="Add the User to DB!" />

    </form>
</div>
   <%@ include file="footer.jsp" %>
