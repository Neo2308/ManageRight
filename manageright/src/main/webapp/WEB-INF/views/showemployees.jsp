<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:wrapper>

<jsp:attribute name = "head">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ManageRight</title>
</jsp:attribute>

<jsp:body>

    <h1><c:out value="Hello HR"></c:out></h1>
    <!-- <h1><p>Welcome HR </p></h1> -->
    <!-- <hr size="4" color="gray" /> -->
    <table>
        <thead>
        <tr>
            <th>
                Employee ID
            </th>
            <th>
                Name
            </th>
            <th>
                Nationality
            </th>
            <th>
                Date of Birth
            </th>
            <th>
                Work Email
            </th>
            <th>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="obj">
            <tr>
                <a href="/HR/employee/${obj.Employee_ID}">
                    <td>
                        <a href="/HR/employee/${obj.Employee_ID}">
                            <c:out value="${obj.Employee_ID}" />
                        </a>
                    </td>
                    <td>
                        <c:out value="${obj.FirstName} ${obj.LastName}" />
                    </td>
                    <td>
                        <c:out value="${obj.Nationality}" />
                    </td>
                    <td>
                        <c:out value="${obj.DOB}" />
                    </td>
                    <td>
                        <c:out value="${obj.WorkEmail}" />
                    </td>
                    <td>
                        <button onclick="location.href='${obj.nextlink}'"><c:out value="${obj.nextlinktext}" /></button>
                    </td>
                </a>
            </tr>
        </c:forEach>
    </tbody>
    </table>

</jsp:body>

</t:wrapper >