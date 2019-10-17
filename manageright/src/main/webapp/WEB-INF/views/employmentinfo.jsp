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
    <h2>Employment</h2>
    <div id="employmentinfo">
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
                    Employee ID </span><span class="infovalue"> ${obj.getEmployee_ID()}
            </span></p>
            <p><span class="infolabel">
                    Worker Type </span><span class="infovalue"> ${obj.getWorkerType()}
            </span></p>
            <p><span class="infolabel">
                    Job Title </span><span class="infovalue"> ${obj.getJobTitle()}
            </span></p>
            <p><span class="infolabel">
                    Department </span><span class="infovalue"> ${obj.getDepartment()}
            </span></p>
            <p><span class="infolabel">
                    Hire Date </span><span class="infovalue"> ${obj.getHireDate()}
            </span></p>
            <p><span class="infolabel">
                    Start Date </span><span class="infovalue"> ${obj.getStartDate()}
            </span></p>
            <p><span class="infolabel">
                    End Date </span><span class="infovalue"> ${obj.getEndDate()}
            </span></p>
            <button onclick="location.href='/HR/updateemployment/${obj.getEmployee_ID()}'">Update</button>
            <button onclick="location.href='/HR/setempdept/${obj.getEmployee_ID()}'">Set Department</button>
            <input type="SUBMIT" value="Submit" />
    </div>
</jsp:body>
</t:wrapper>