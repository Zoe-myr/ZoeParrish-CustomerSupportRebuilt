<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--@elvariable id="ticketDB" type="java.util.HashMap<Integer,com.example.zoeparrishcustomersupport.Ticket>"--%>

<!doctype html>
<html>
<body>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h2>Tickets</h2>
    <a href="<c:url value="/ticket/create"/>">Create Ticket</a><br>

    <c:choose>
        <c:when test="${ticketDB.size() == 0}">
            <i>There are no tickets currently</i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${ticketDB}" var="entry">
                Ticket ${entry.key}: <a href="<c:url value='/ticket/view/${entry.key}'/>"><c:out value="${entry.value.subject}"/></a><br>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>