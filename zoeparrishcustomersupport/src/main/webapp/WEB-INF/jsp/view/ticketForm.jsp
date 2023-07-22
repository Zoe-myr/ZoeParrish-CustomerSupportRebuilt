<html>
    <head>
        <title>Create a New Ticket</title>
    </head>
    <body>
        <a href="<c:url value='/login'><c:param name='logout' /></c:url>">LogOut</a>
        <h2>Create a ticket</h2>

        <form:form method="POST" action="create" modelAttribute="ticket" enctype="multipart/form-data">
            <form:label path="name">Name: </form:label>
            <form:input path="name"/><br>
            <form:label path="subject">Subject: </form:label>
            <form:input path="subject"/><br>
            <form:label path="body">Issue: </form:label><br>
            <form:textarea path="body" rows="50" cols="25"/><br>
            <form:input path="attachment" type="file"/><br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>