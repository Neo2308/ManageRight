<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


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
                Employment ID
            </th>
            <th>
                Worker Type
            </th>
            <th>
                Job Title
            </th>
            <th>
                Department
            </th>
            <th>
                Hire Date
            </th>
            <th>
                Start Date
            </th>
            <th>
                End Date
            </th>            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employments}" var="obj">
            <tr>
                    <td>
                        <c:out value="${obj.Employment_ID}" />
                    </td>
                    <td>
                        <c:out value="${obj.WorkerType}" />
                    </td>
                    <td>
                        <c:out value="${obj.JobTitle}" />
                    </td>
                    <td>
                        <c:out value="${obj.Department}" />
                    </td>
                    <td>
                        <c:out value="${obj.HireDate}" />
                    </td>
                    <td>
                        <c:out value="${obj.StartDate}" />
                    </td>
                    <td>
                        <c:out value="${obj.EndDate}" />
                    </td>
                </a>
            </tr>
        </c:forEach>
    </tbody>
    </table>

</jsp:body>

</t:wrapper >