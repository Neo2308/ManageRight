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
    <h1>Welcome Admin</h1>
    <hr size="4" color="gray" />
    <h2>Add a new Shift</h2>
    <div id="addshift">
        <form action="/Admin/addshift" method="post">
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
                <label>Enter Timings</label>
                <input name="Timings" />
            </p>
            <p>
                <label>Days of Week</label>
                <select input multiple name="days" id="days" path="days">
                    <option value="1">
                        Monday
                    </option>
                    <option value="2">
                        Tuesday
                    </option>
                    <option value="3">
                        Wednesday
                    </option>
                    <option value="4">
                        Thursday
                    </option>
                    <option value="5">
                        Friday
                    </option>
                    <option value="6">
                        Saturday
                    </option>
                    <option value="7">
                        Sunday
                    </option>
                </select>
            </p>
            <p>
                <label>Hours per Week</label>
                <input name="HoursPerWeek" />
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="SUBMIT" value="Submit" />
        </form>
    </div>
</jsp:body>
</t:wrapper>