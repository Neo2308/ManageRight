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
    <div id="employeeinfo">
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
            <p style="margin:0px auto;">
                    <button onclick="location.href='/HR/updateemployee/${obj.getEmployee_ID()}'">Update</button>
                    <button onclick="location.href='/HR/setmanager/${obj.getEmployee_ID()}'">Set Manager</button>
                    <button onclick="location.href='/HR/setoffice/${obj.getEmployee_ID()}'">Set Office</button>
                    <button onclick="location.href='/HR/setshift/${obj.getEmployee_ID()}'">Set Shift</button>
                    <button onclick="location.href='/HR/addemployment/${obj.getEmployee_ID()}'">Add Employment</button>
                    <button onclick="location.href='/HR/terminate/${obj.getEmployee_ID()}'">Terminate</button>
                    <button onclick="location.href='/HR/unterminate/${obj.getEmployee_ID()}'">Unterminate</button>
                    <button onclick="location.href='/HR/addemployment/${obj.getEmployee_ID()}'">Add new Employment</button>
                    <button onclick="location.href='/HR/employmentofemp/${obj.getEmployee_ID()}'">View Employment</button>
            </p>
            <br>
            <br>
            <h2><b>
                Employee Details
                </b>
            </h2>
            <p><span class="infolabel">
                    Employee ID </span><span class="infovalue"> ${obj.getEmployee_ID()}
            </span></p>
            <p><span class="infolabel">
                    First Name </span><span class="infovalue"> ${obj.getFirstName()}
            </span></p>
            <p><span class="infolabel">
                    Last Name </span><span class="infovalue"> ${obj.getLastName()}
            </span></p>
            <p><span class="infolabel">
                    Date of Birth </span><span class="infovalue"> ${obj.getDOB()}
            </span></p>
            <p><span class="infolabel">
                    Gender </span><span class="infovalue"> ${obj.getGender()}
            </span></p>
            <p><span class="infolabel">
                    Base Salary </span><span class="infovalue"> ${obj.getBaseSalary()}
            </span></p>
            <p><span class="infolabel">
                    Origin </span><span class="infovalue"> ${obj.getOrigin()}
            </span></p>
            <p><span class="infolabel">
                    Nationality </span><span class="infovalue"> ${obj.getNationality()}
            </span></p>
            <p><span class="infolabel">
                    Marital Status </span><span class="infovalue"> ${obj.getMaritalStatus()}
            </span></p>
            <p><span class="infolabel">
                    Home Address </span><span class="infovalue"> ${obj.getHomeAddress()}
            </span></p>
            <p><span class="infolabel">
                    Work Email </span><span class="infovalue"> ${obj.getWorkEmail()}
            </span></p>
            <p><span class="infolabel">
                    Work Mobile </span><span class="infovalue"> ${obj.getWorkMobile()}
            </span></p>
            <p><span class="infolabel">
                    Mailing Address </span><span class="infovalue"> ${obj.getMailingAddress()}
            </span></p>
            <p><span class="infolabel">
                    Education Level </span><span class="infovalue"> ${obj.getEduLevel()}
            </span></p>
            <p><span class="infolabel">
                    Tax Identification Number </span><span class="infovalue"> ${obj.getTaxIdentification()}
            </span></p>
            <p><span class="infolabel">
                    Works For </span><span class="infovalue"> ${obj.getWorksFor()}
            </span></p>
            <p><span class="infolabel">
                    Managed By </span><span class="infovalue"> ${obj.getManagedBy()}
            </span></p>
            <p><span class="infolabel">
                    Shift </span><span class="infovalue"> ${obj.getShift()}
            </span></p>
            
        </div>
</jsp:body>
</t:wrapper>