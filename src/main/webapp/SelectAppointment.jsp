<%-- 
    Document   : CommandPageJSP
    Created on : 10-mar-2020, 8:54:45
    Author     : celia
--%>

<%@page import="java.util.Date"%>
<%@page import="Model.Appointments"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedir cita</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h1>Por favor, escoja una de las siguientes citas disponibles</h1>
        <%
            for (String appointment : Appointments.appointments) {
                out.println("<p>" + appointment + "</p>");
        %>
        <form action=FrontController method=post> <input name='appointment' value="<%=appointment%>"hidden=true>
            <button type=submit name=cmd value=AskForAppointmentCommand>Select</button>
        </form>
        <%
        }
        %>

    </body>
</html>
