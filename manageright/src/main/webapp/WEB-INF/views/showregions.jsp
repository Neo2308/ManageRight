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
                Region ID
            </th>
            <th>
                Name
            </th>
            <th>
                Located In
            </th>
            <th>
            </th>
            <th>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${regions}" var="obj">
            <tr>
                    <td>
                        <c:out value="${obj.Region_ID}" />
                    </td>
                    <td>
                        <c:out value="${obj.Name}" />
                    </td>
                    <td>
                        <c:out value="${obj.LocatedIn}" />
                    </td>
                    <td>
                        <button onclick="location.href='${obj.nextlink1}'"><c:out value="${obj.nextlinktext1}" /></button>
                    </td>
                    <td>
                        <button onclick="location.href='${obj.nextlink2}'"><c:out value="${obj.nextlinktext2}" /></button>
                    </td>
                </a>
            </tr>
        </c:forEach>
    </tbody>
    </table>

</jsp:body>

</t:wrapper >