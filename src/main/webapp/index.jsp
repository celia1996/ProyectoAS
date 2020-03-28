<%-- 
    Document   : index
    Created on : 14-mar-2020, 19:40:28
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/indexstyle.css">
        <link rel="stylesheet" href="css/navbarstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <div class="navbar">
            <a class="active" href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
            <a href="CommandPageJSP.jsp"><i class="fa fa-clock-o"></i> Cita</a>
            <a href="Login.jsp"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
        </div>
        
        <h1>¿En qué podemos ayudarte?</h1>
        
        <div class="buttons">
            <a href=CommandPageJSP.jsp ><button class="btn"><i class="fa fa-clock-o"></i> Pedir cita</button></a>
            <a href=AppointmentsView.jsp ><button type="submit" name="cmd" value="ViewMyAppointmentsCommand" class="btn"><i class="fa fa-calendar"></i> Mis citas</button></a>
        </div>
    </body>
</html>
