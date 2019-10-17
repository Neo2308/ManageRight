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
    <h2><b>SubCompany Details</b></h2>
    <div id="subcompanyinfo">
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
                    Company ID </span><span class="infovalue">${obj.getCompany_ID()}
            </span></p>
            <p><span class="infolabel">
                    Company Name</span><span class="infovalue">${obj.getCompanyName()}
            </span></p>
            <p><span class="infolabel">
                    Head Office</span><span class="infovalue">${obj.getHeadOffice()}
            </span></p>
            <p>
            <button onclick="location.href='/Admin/setcompanydept/${obj.getCompany_ID()}'">Add Department</button>
            <button onclick="location.href='/Admin/setcompanyholiday/${obj.getCompany_ID()}'">Add Holiday</button>
            <button onclick="location.href='/Admin/showcompanyholidays/${obj.getCompany_ID()}'">View Holidays</button>
            </p>
            <input type="SUBMIT" value="Submit" />
    </div>
</jsp:body>
</t:wrapper>