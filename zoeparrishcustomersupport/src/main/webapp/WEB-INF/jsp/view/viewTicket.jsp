<%--@elvariable id="ticketId" type="java.lang.String"--%>
<%--@elvariable id="ticket" type="com.example.zoeparrishcustomersupport.Ticket"--%>

<html>
<body>
    <a href="<c:url value='/logout'/>">LogOut</a>
    <h2>Ticket #<c:out value="${ticketId}"/></h2>

    Customer Name: <c:out value="${ticket.customerName}"/><br>
    Subject: <c:out value="${ticket.subject}"/><br>
    Issue: <c:out value="${ticket.body}"/> <br>


    <c:if test="${not empty ticket.attachments}">
        Attachments:
        <c:forEach items="${ticket.attachments}" var="attachment" varStatus="status">
            <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value='/ticket/${ticketId}/attachment/${attachment.name}'/>"><c:out value="${attachment.name}"/></a>
        </c:forEach>
    </c:if>
    <br>
    <a href="<c:url value="/ticket/list" /> ">Return to tickets</a>
</body>
</html>