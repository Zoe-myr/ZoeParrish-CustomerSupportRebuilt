<%@ page session="false" %>
<%
    String ticketId = (String)request.getAttribute("ticketId");
    Ticket ticket = (Ticket)request.getAttribute("ticket");
%>
<html>
<body>
    <h1>Ticket</h1>


    Customer Name: <%= ticket.getCustomerName() %> <br>
    Subject: <%= ticket.getSubject() %> <br>
    Issue: <%= ticket.getBody() %> <br>

    <%
        if(ticket.getNumOfAttachments() > 0){
    %>Attachments: <%
            int i = 0;
            for(Attachment a : ticket.getAttachments()){
                %><a href="<c:url value="/tickets">
                    <c:param name="action" value="downlaod"/>
                    <c:param name="ticketId" value="<%= ticketId %>"/>
                    <c:param name="attachemnt" value="<%= a.getName()%>"/>
                    </c:url>"><%= a.getName() %></a><%
            }
        }
    %>
    <a href=\"ticket\">Return to tickets</a>
</body>
</html>