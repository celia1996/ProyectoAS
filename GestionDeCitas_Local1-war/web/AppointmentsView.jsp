<%-- 
    Document   : AppointmentsView
    Created on : 19-mar-2020, 17:31:33
    Author     : celia
--%>


<%@page import="javax.naming.InitialContext"%>
<%@page import="control.AppointmentFacade"%>
<%@page import="entities.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="control.CalendarFacade"%>
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
            int appointmentID;
            List<Calendar> calendars = (List<Calendar>) session.getAttribute("userCalendar");

            AppointmentFacade appointments = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");

            if ( calendars.isEmpty()) {
                out.println("<h3>Usted no tiene citas pendientes.</h3>");
            } else {

                for (Calendar appointment : calendars) {
                    appointmentID = appointment.getAppointmentid();
                    out.println("<p>" + appointments.find(appointmentID).getDate() + " a las " + appointments.find(appointmentID).getTime() + "</p>");
                    out.println("<form action=FrontController method=post>"
                            + "<button class=btn type=submit name=cmd value=CancelCommand>Cancelar</button>"
                            + "<input name='appointmentID' value='" + appointmentID + "' hidden=true>"
                            + "<button class = btn2 type=submit name=cmd value=ModifyCommand>Modificar</button></form>");
                }
            }

        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
