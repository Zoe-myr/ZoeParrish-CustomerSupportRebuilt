
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
    <form action="<c:url value='/login'/>" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <br>
        <input type="submit" value="Log In">
    </form>
</body>
</html>
