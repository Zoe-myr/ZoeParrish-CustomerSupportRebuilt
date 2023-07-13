<%--@elvariable id="ticketId" type="java.lang.String"--%>
<%--@elvariable id="ticket" type="com.example.zoeparrishcustomersupport"--%>

<html>
<body>
    <h2>Ticket #<c:out value="${ticketId}"/></h2>

    Customer Name: <c:out value="${ticket.customerName}"/><br>
    Subject: <c:out value="${ticket.subject}"/><br>
    Issue: <c:out value="${ticket.body}"/> <br>


    <c:if test="${ticket.numOfAttachments > 0}">
        Attachments:
        <c:forEach items="${ticket.attachments}" var="attachment" varStatus="status">
            <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value="/ticket">
                    <c:param name="action" value="downlaod" />
                    <c:param name="ticketId" value="${ticketId}" />
                    <c:param name="attachemnt" value="${attachment.name}" />
                    </c:url>"><c:out value="${attachment.name}"/></a>
        </c:forEach>
    </c:if>
    <br>
    <a href="<c:url value="/ticket" /> ">Return to tickets</a>
</body>
</html>