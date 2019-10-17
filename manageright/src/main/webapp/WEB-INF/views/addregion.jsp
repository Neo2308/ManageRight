<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>

<jsp:attribute name = "head">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ManageRight</title>
</jsp:attribute>

<jsp:body>
    <!-- <c:out value="Hello"></c:out> -->
    <div id="addregion">
        <form action="/Admin/addregion" method="post">
            <!--<p>
                <label>Username</label>
                <input name="username" name="username" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <span>${error}</span>
            </p>
            <p>
                <label>Password</label>
                <input name="Password" name="Password" type="password" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            </p>
            <p>
                <label>Confirm Password</label>
                <input name="Confirmpassword" name="Confirmpassword" type="password" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                ${error2}

            </p>-->
            <p>
                <label>Name</label>
                <input name="Name" />
            </p>
            <!-- <p>
                <label>Located In</label>
                <input name="LocatedIn" />
            </p> -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="SUBMIT" value="Submit" />
        </form>
    </div>
</jsp:body>
</t:wrapper>