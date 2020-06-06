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
        <title>Pedir cita</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h1>Por favor, escoja una de las siguientes citas disponibles</h1>
        <%
          
            CategoryFacade category = (CategoryFacade) InitialContext.
                    doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/CategoryFacade!control.CategoryFacade");
            
            List<Appointment> appointments = (List<Appointment>) session.getAttribute("appointments");
            int appointmentID;
            int categoryID;
            
            for (Appointment appointment : appointments) {
                if (appointment.getAvailability() == 0) {
                    categoryID = appointment.getCategoryid(); 
                    out.println("<p>" + appointment.getDate()+ " a las " + 
                            appointment.getTime() + " asunto: " + category.find(categoryID).getDescription() + "</p>");
                    
                    appointmentID = appointment.getAppointmentid();
                    %>
                    <form action=FrontController method=post> <input name='appointmentID' value="<%=appointmentID%>" hidden=true>
                        <button type=submit name=cmd value=AskForAppointmentCommand>Select</button>
                    </form>
                    <%
                }
            }
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
