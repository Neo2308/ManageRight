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
    <h2>Update Holiday</h2>
    <div id="updateholiday">
        <form action="/Admin/updateholiday/${obj.getHoliday_ID()}" method="post">
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
                <input name="Name" value="${obj.getName()}"/>
            </p>
            <p>
                <label>Start Date</label>
                <input name="StartDate" type="date" value="${obj.getStartDate()}"/>
            </p>
            <p>
                <label>End Date</label>
                <input name="EndDate" type="date" value="${obj.getEndDate()}"/>
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="SUBMIT" value="Submit" />
        </form>
    </div>
</jsp:body>
</t:wrapper>