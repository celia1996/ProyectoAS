<%-- 
    Document   : AppointmentsView
    Created on : 19-mar-2020, 17:31:33
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My appointments</title>
        <link rel="stylesheet" href="css/appointmentsviewstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h1>Mis citas</h1>
        <%
            if (session.getAttribute("appointment") == null) {
                out.println("<h3>Usted no tiene citas pendientes.</h3>");
            } else {
                out.println("<p>" + session.getAttribute("appointment") + "</p>");
                out.println("<form action=FrontController method=post><button class=btn"
                        + " type=submit name=cmd value=CancelCommand>Cancelar</button>"
                        + "<button class = btn2 type=submit name=cmd value=ModifyCommand>Modificar</button></form>");
            }
        %>

    </body>
</html>
