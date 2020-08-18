<%-- 
    Document   : AppointmentConfirmed
    Created on : 10-mar-2020, 16:42:19
    Author     : celia
--%>

<%@page import="control.EmployeeFacade"%>
<%@page import="control.LocationFacade"%>
<%@page import="control.CategoryFacade"%>
<%@page import="entities.Systemuser"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="control.SystemuserFacade"%>
<%@page import="entities.Appointment"%>
<%@page import="java.util.ArrayList"%>
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
            SystemuserFacade user = (SystemuserFacade) InitialContext
                    .doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/SystemuserFacade!control.SystemuserFacade");
            CategoryFacade category = (CategoryFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CategoryFacade!control.CategoryFacade");
            LocationFacade location = (LocationFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/LocationFacade!control.LocationFacade");
            EmployeeFacade employee = (EmployeeFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/EmployeeFacade!control.EmployeeFacade");

            Appointment appointmentConfirmed = (Appointment) session.getAttribute("appointmentConfirmed");
            
            int userID = (Integer) session.getAttribute("userID");
            int categoryID = appointmentConfirmed.getCategoryid();
            int locationID = appointmentConfirmed.getLocationid();
            int employeeID = appointmentConfirmed.getEmployeeid();
            
            out.println("<p>" + user.find(userID).getUsername() + " su cita ha sido confirmada para el día: <b>"
                    + appointmentConfirmed.getDate() + " a las " + appointmentConfirmed.getTime() + "</b></p>");

            out.println("<p> Asunto de la cita: <b>" + category.find(categoryID).getDescription() + "</b></p>");
            out.println("<p> Por favor, al llegar diríjase a la sala: <b>" + location.find(locationID).getFloor() + location.find(locationID).getRoom() + "</b></p>");
            out.println("<p> Le atenderá: <b>" + employee.find(employeeID).getName() + "</b></p>");
            out.println("<p> Tenga consigo el siguiente identificador de cita: <b>" + appointmentConfirmed.getAppointmentid() + "</b></p>");
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
