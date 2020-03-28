<%-- 
    Document   : AppointmentConfirmed
    Created on : 10-mar-2020, 16:42:19
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ConfirmedAppointment</title>
        <link rel="stylesheet" href="css/appointmentconfirmedstyle.css">
        <link rel="stylesheet" href="css/navbarstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="navbar">
            <a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
            <a class="active" href="SelectAppointment.jsp"><i class="fa fa-clock-o"></i> Cita</a>
            <a href="Login.jsp"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
        </div>
        <h1>La cita ha sido creada correctamente</h1>
        <%
                out.println("<p>" + session.getAttribute("user") + " tu cita ha sido confirmada para el día: </p>" );
                out.println("<p>" + session.getAttribute("appointment") + "</p>");
            %>
    </body>
</html>
