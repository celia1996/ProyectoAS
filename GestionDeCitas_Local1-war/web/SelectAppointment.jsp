<%-- 
    Document   : CommandPageJSP
    Created on :copy, 8:54:45
    Author     : celia
--%>

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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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

            CategoryFacade category = (CategoryFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CategoryFacade!control.CategoryFacade");
            AppointmentFacade appointmentEM = (AppointmentFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/AppointmentFacade!control.AppointmentFacade");

            int pag = Integer.parseInt(request.getParameter("page"));
            if (request.getParameter("page") == null) {
                pag = 1;
            }

            List<Appointment> appointments = appointmentEM.setPagination(pag);
            int categoryID;

            for (Appointment appointment : appointments) {
                if (appointment.getAvailability() == 0) {
                    categoryID = appointment.getCategoryid();
                    out.println("<div class ='table-responsive'><table class='table table-striped'>");
                    out.println("<thead><tr> <th>Fecha</th> <th>Hora</th> <th>Descripción</th></tr></thead>");
                    out.println("<tr><td>" + appointment.getDate() + " </td><td> "
                            + appointment.getTime() + "</td><td>" + category.find(categoryID).getDescription() + "</td>");

                    out.println("<td><form action=FrontController method=post>");
                    out.println("<input name='appointmentID' value=" + appointment.getAppointmentid() + " hidden=true>");
                    out.println("<button class='btn btn-success' type=submit name=cmd value=AskForAppointmentCommand>Select</button></form>"
                            + "</td></tr><tbody></table></div>");

                }
            }
        %>
        <section style="text-align: center;">
            <ul class="pagination">
                <li class="active"><a href="SelectAppointment.jsp?page=1">1</a></li>
                <li><a href="SelectAppointment.jsp?page=2">2</a></li>
                <li><a href="SelectAppointment.jsp?page=3">3</a></li>
            </ul>
        </section>
        <%--<jsp:include page="./footer.jsp" flush="true" />--%>
    </body>
</html>
