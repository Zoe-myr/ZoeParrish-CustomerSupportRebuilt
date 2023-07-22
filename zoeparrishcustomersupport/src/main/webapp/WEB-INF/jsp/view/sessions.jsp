<c:set var="now" value="<%=System.currentTimeMillis()%>"/>
<html>
<head>
  <title>Sessions Admin</title>
</head>
<body>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h2>Sessions</h2>
    There are <c:out value="${numSessions}"/> active sessions.

    <ul>
        <c:forEach items="${sessionList}" var="s">
          <li><c:out value="${s.id} - ${s.getAttribute('username')} last active ${(now-s.getLastAccessedTime())/60000} minutes ago."/></li>
        </c:forEach>
    </ul>
</body>
</html>
