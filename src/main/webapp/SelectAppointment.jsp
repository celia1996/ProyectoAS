<%-- 
    Document   : CommandPageJSP
    Created on : 10-mar-2020, 8:54:45
    Author     : celia
--%>

<%@page import="java.util.Date"%>
<%@page import="Model.Appointments"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedir cita</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <link rel="stylesheet" href="css/navbarstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="navbar">
            <a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
            <a class="active" href="CommandPageJSP.jsp"><i class="fa fa-clock-o"></i> Cita</a>
            <a href="Login.jsp"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
        </div>
        <h1>Por favor, escoja una de las siguientes citas disponibles</h1>
        <%
            for ( String appointment : Appointments.appointments) {
                out.println("<p>" + appointment + "</p>" + "<form action=FrontController method=post> <input name='appointment' value="
                        + appointment +
                        " hidden=true><button type=submit name=cmd value=AskForAppointmentCommand>Select</button></form>");
            }
        %>

    </body>
</html>
