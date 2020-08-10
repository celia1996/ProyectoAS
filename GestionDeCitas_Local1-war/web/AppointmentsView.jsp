<%-- 
    Document   : AppointmentsView
    Created on : 19-mar-2020, 17:31:33
    Author     : celia
--%>


<%@page import="control.CategoryFacade"%>
<%@page import="control.LocationinformationFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="control.AppointmentFacade"%>
<%@page import="entities.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="control.CalendarFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
            LocationinformationFacade locationinfoEM = (LocationinformationFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/LocationinformationFacade!control.LocationinformationFacade");
            CategoryFacade category = (CategoryFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CategoryFacade!control.CategoryFacade");

            if (calendars.isEmpty()) {
                out.println("<h3>Usted no tiene citas pendientes.</h3>");
            } else {
                int employeeID;
                int categoryID;
                for (Calendar appointment : calendars) {
                    appointmentID = appointment.getAppointmentid();
                    employeeID = appointments.find(appointmentID).getEmployeeid();
                    categoryID = appointments.find(appointmentID).getCategoryid();

                    out.println("<p> Asunto de la cita: <b> " + category.find(categoryID).getDescription() + "</b></p>");
                    out.println("<p> El día: <b>" + appointments.find(appointmentID).getDate() + " </b> a las <b>" + appointments.find(appointmentID).getTime() + "</b></p>");
                    out.println("<p> Le atenderá: <b>" + locationinfoEM.find(employeeID).getEmployeename().getEmployeeName() + "</b></p>");
                    out.println("<p> Identificador de cita: <b>" + appointments.find(appointmentID).getAppointmentid() + "</b></p>");
                    out.println("<form action=FrontController method=post>"
                            + "<button class='btn btn-danger' type=submit name=cmd value=CancelCommand>Cancelar</button>"
                            + "<input name='appointmentID' value='" + appointmentID + "' hidden=true>"
                            + "<button class='btn btn-warning' type=submit name=cmd value=ModifyCommand>Modificar</button></form>");
                    
                }
            }

        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
