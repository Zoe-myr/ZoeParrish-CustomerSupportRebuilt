
<html>
<head>
    <title>Customer Support Login</title>
</head>
<body>
    <h2>Login</h2>
    Please log in to access customer support tickets <br>
    <c:if test="${loginFailed == true}">
        <b><c:out value="The username or password is invalid"/></b>
    </c:if>

    <form:form method="POST" action="login" modelAttribute="loginForm">
        <form:label path="username">Username: </form:label>
        <form:input path="username"/> <br>
        <form:label path="password">Password:</form:label>
        <form:input path="password"/> <br>
        <input type="submit">
    </form:form>
</body>
</html>
