<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>
    <h1>Login</h1>
</title>
<body>
<h1>Enter the chat</h1>
<form class="table_dark" method="post" action="${pageContext.request.contextPath}/login">
    Nickname <input type="text" name="nickname">
    <button type="submit">Confirm</button>
</form>
</body>
</html>
