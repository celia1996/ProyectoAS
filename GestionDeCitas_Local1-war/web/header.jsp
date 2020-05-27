<%-- 
    Document   : header
    Created on : 30-mar-2020, 17:59:02
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbarstyle.css">
    </head>
    <body>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="navbar">
            <a class="active" href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
            <a  href="SelectAppointment.jsp"><i class="fa fa-clock-o"></i> Cita</a>
            <a href="CounterView.jsp"><i class="fa fa-bar-chart "></i> Estadísticas</a>
            <a href="Logs.jsp"><i class="fa fa-comment "></i> Logs</a>
            <a href="Login.jsp"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
        </div>
    </body>
</html>
