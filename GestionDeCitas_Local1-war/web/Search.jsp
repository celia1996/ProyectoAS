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
        <title>Pedir cita</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h2>Por favor, escoja una de las siguientes citas disponibles o utilice nuestro buscador</h2>
        <form action="FrontController" method="GET">
            <input type="text" id="myInput" name="searchCategory" placeholder="¿Qué gestión desea realizar?..." style="width: 30%;">
            <button type="submit" class="search" name="cmd" value="SearchCommand">Search</button>
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
                        out.println("<div class ='row'><table>");
                        out.println("<tr>");
                        out.println("<td>" + appointment.getDate() + " </td><td> "
                                + appointment.getTime() + "</td><td>" + categoryEM.find(category.getCategoryid()).getDescription() + "</td>");

                        out.println("<td><form action=FrontController method=post>");
                        out.println("<input name='appointmentID' value=" + appointment.getAppointmentid() + " hidden=true>");
                        out.println("<button type=submit name=cmd value=AskForAppointmentCommand>Select</button></form>"
                                + "</td></tr></table></div>");

                    }
                }
            }
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
