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
    <h1>Welcome HR</h1>
    <hr size="4" color="gray" />
    <h2>Leaves</h2>
    <div id="leavesinfo">
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
            <p><span class="infolabel">
                    Leave ID </span><span class="infovalue"> ${obj.getLeave_ID()}
            </span></p>
            <p><span class="infolabel">
                    Name </span><span class="infovalue"> ${obj.getName()}
            </span></p>
            <p><span class="infolabel">
                    Min. Duration </span><span class="infovalue"> ${obj.getMinDuration()}
            </span></p>
            <p><span class="infolabel">
                    Max. Duration </span><span class="infovalue"> ${obj.getMaxDuration()}
            </span></p>
            <input type="SUBMIT" value="Submit" />
    </div>
</jsp:body>
</t:wrapper>