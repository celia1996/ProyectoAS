<%-- 
    Document   : AppointmentConfirmed
    Created on : 10-mar-2020, 16:42:19
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ConfirmedAppointment</title>
        <link rel="stylesheet" href="css/appointmentconfirmedstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body> 
        <h1>La cita ha sido creada correctamente</h1>
        <%
            out.println("<p>" + session.getAttribute("user") + " tu cita ha sido confirmada para el día: </p>");
            out.println("<p>" + session.getAttribute("appointment") + "</p>");
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
