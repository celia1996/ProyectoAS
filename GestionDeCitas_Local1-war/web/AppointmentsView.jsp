<%-- 
    Document   : AppointmentsView
    Created on : 19-mar-2020, 17:31:33
    Author     : celia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="database.Appointment"%>
<%@page import="ejbs.CalendarEJB"%>
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

            CalendarEJB myCalendar = (CalendarEJB) session.getAttribute("myCalendar");
            ArrayList<Appointment> myAppointments = myCalendar.getMyAppointments();

            if (myAppointments.isEmpty()) {
                out.println("<h3>Usted no tiene citas pendientes.</h3>");
            }

            for (Appointment appointment : myAppointments) {
                out.println("<p>" + appointment.getDate() + " a las " + appointment.getTime() + "</p>");
                out.println("<form action=FrontController method=post>"
                        + "<button class=btn type=submit name=cmd value=CancelCommand>Cancelar</button>"
                        + "<input name='appointmentItem' value='" + appointment.getId() + "' hidden=true>"
                        + "<button class = btn2 type=submit name=cmd value=ModifyCommand>Modificar</button></form>");
            }


        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
