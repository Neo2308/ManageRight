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
    <h2>Add a new Employee</h2>
    <div id="addemployee">
        <form action="/HR/addemployee" method="post">
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
                <label>Enter First Name</label>
                <input name="FirstName" />
            </p>
            <p>
                <label>Enter Last Name</label>
                <input name="LastName" />
            </p>
            <p>
                <label>Date of Birth</label>
                <input name="DOB" type="date" />
            </p>
            <p>
                <label>Gender</label>
                <input name="Gender" />
            </p>
            <p>
                <label>Base Salary</label>
                <input name="BaseSalary" type="number"/>
            </p>
            <p>
                <label>Origin</label>
                <input name="Origin" />
            </p>
            <p>
                <label>Nationality</label>
                <input name="Nationality" />
            </p>
            <p>
                <label>Marital Status</label>
                <input name="MaritalStatus" />
            </p>
            <p>
                <label>Home Address</label>
                <input name="HomeAddress" />
            </p>
            <p>
                <label>Work Email</label>
                <input name="WorkEmail" />
            </p>
            <p>
                <label>Work Mobile</label>
                <input name="WorkMobile" type="number"/>
            </p>
            <p>
                <label>Mailing Address</label>
                <input name="MailingAddress" />
            </p>
            <p>
                <label>Education Level</label>
                <input name="EduLevel" />
            </p>
            <p>
                <label>Tax Identification Number</label>
                <input name="TaxIdentification" type="number"/>
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="SUBMIT" value="Submit" />
        </form>
    </div>
</jsp:body>
</t:wrapper>