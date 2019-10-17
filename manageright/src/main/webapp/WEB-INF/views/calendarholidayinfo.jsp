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
    <h2>Calendar Holiday</h2>
    <div id="calendarholidayinfo">
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
                    Holiday ID </span><span class="infovalue"> ${obj.getHoliday_ID()}
            </span></p>
            <p>
                    Name </span><span class="infovalue"> ${obj.getName()}
            </span></p>
            <p>
                    Start Date </span><span class="infovalue"> ${obj.getStartDate()}
            </span></p>
            <p>
                    End Date </span><span class="infovalue"> ${obj.getEndDate()}
            </span></p>
            <button onclick="location.href='/Admin/updateholiday/${obj.getHoliday_ID()}'">Update</button>
            <button onclick="location.href='/Admin/setholidayregion/${obj.getHoliday_ID()}'">Set ApplicableAt</button>
            <input type="SUBMIT" value="Submit" />
    </div>
</jsp:body>
</t:wrapper>