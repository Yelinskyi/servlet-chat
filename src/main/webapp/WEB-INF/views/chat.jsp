<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat!</title>
</head>
<body>

<form class="table_dark" method="get" action="${pageContext.request.contextPath}/chat">
    <button type="get">Refresh</button>
</form>

<form class="table_dark" method="post" action="${pageContext.request.contextPath}/chat">
    Message <input type="text" name="message">
    <button type="submit">Send</button>
</form>

<table>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td>
                <c:out value="${message.toString()}"/>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
