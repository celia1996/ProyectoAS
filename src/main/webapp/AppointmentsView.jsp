<%-- 
    Document   : AppointmentsView
    Created on : 19-mar-2020, 17:31:33
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My appointments</title>
        <link rel="stylesheet" href="css/appointmentsviewstyle.css">
        <link rel="stylesheet" href="css/navbarstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="navbar">
            <a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
            <a class="active" href="SelectAppointment.jsp"><i class="fa fa-clock-o"></i> Cita</a>
            <a href="Login.jsp"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
        </div>
        <h1>Mis citas</h1>
        <%
            if (session.getAttribute("appointment") == null) {
                out.println("<h3>Usted no tiene citas pendientes.</h3>");
            } else {
                out.println("<p>" + session.getAttribute("appointment") + "</p>");
                out.println("<form action=FrontController method=post><button class=btn"
                        + " type=submit name=cmd value=CancelCommand>Cancelar</button>"
                        + "<button class = btn2 type=submit name=cmd value=ModifyCommand>Modificar</button></form>");
            }
        %>

    </body>
</html>
