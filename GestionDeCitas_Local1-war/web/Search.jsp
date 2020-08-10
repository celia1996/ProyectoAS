<%-- 
    Document   : CommandPageJSP
    Created on :copy, 8:54:45
    Author     : celia
--%>

<%@page import="entities.Category"%>
<%@page import="control.CategoryFacade"%>
<%@page import="control.AppointmentFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="entities.Appointment"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script><
        <title>Pedir cita</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <form action="FrontController" method="GET">
            <input type="text" id="myInput" name="searchCategory" placeholder="¿Qué gestión desea realizar?..." style="width: 30%;">
            <button type="submit" class="btn btn-info" name="cmd" value="SearchCommand"><span class="glyphicon glyphicon-search"></span>Search</button>
        </form>

        <%
            String description = request.getParameter("searchCategory");

            CategoryFacade categoryEM = (CategoryFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CategoryFacade!control.CategoryFacade");
            AppointmentFacade appointmentEM = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");

            List<Category> categories = categoryEM.search(description);

            List<Appointment> appointments;

            for (Category category : categories) {
                appointments = appointmentEM.getAppointmetByCategoryOrderedByDate(category.getCategoryid());
                for (Appointment appointment : appointments) {
                    if (appointment.getAvailability() == 0) {
                        out.println("<div class ='table-responsive'><table class='table table-striped'>");
                        out.println("<thead><tr> <th>Fecha</th> <th>Hora</th> <th>Descripción</th></tr></thead>");
                        out.println("<tr><td>" + appointment.getDate() + " </td><td> "
                                + appointment.getTime() + "</td><td>" + categoryEM.find(category.getCategoryid()).getDescription() + "</td>");

                        out.println("<td><form action=FrontController method=post>");
                        out.println("<input name='appointmentID' value=" + appointment.getAppointmentid() + " hidden=true>");
                        out.println("<button class='btn btn-success' type=submit name=cmd value=AskForAppointmentCommand>Select</button></form>"
                                + "</td></tr><tbody></table></div>");

                    }
                }
            }
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
