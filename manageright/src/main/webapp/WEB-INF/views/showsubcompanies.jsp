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
                Company ID
            </th>
            <th>
                Company Name
            </th>
            <th>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${companies}" var="obj">
            <tr>
                    <td>
                        <c:out value="${obj.Company_ID}" />
                    </td>
                    <td>
                        <c:out value="${obj.CompanyName}" />
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