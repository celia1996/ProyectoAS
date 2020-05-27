<%-- 
    Document   : CommandPageJSP
    Created on :copy, 8:54:45
    Author     : celia
--%>

<%@page import="database.Appointment"%>
<%@page import="java.util.ArrayList"%>

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

            ArrayList<Appointment> appointments = (ArrayList<Appointment>) session.getAttribute("appointment");

            for (Appointment appointment : appointments) {
                if (appointment.getAvailable() == 0) {
                    out.println("<p>" + appointment.getDate()+ " a las " + appointment.getTime() + "</p>");
                    %>
                    <form action=FrontController method=post> <input name='appointmentItem' value="<%=appointment.getId()%>" hidden=true>
                        <button type=submit name=cmd value=AskForAppointmentCommand>Select</button>
                    </form>
                    <%
                }
            }
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
