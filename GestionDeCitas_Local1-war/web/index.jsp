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
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <h1>¿En qué podemos ayudarte?</h1>

        <div class="buttons">
            <form class="form-inline" action="FrontController">
                <input type="hidden" name="cmd" value="GoToSelectAppointmentCommand">
                <button type="sumbmit" class="btn"><i class="fa fa-clock-o"></i> Pedir cita</button>
            </form>

            <form class="form-inline" action="FrontController">
                <input type="hidden" name="cmd" value="ViewMyAppointmentsCommand">
                <button type="submit" class="btn"><i class="fa fa-calendar"></i> Mis citas</button>
            </form>
            
            <a href=SetTimer.jsp ><button type="submit" class="btn"><i class="fa fa-cogs"></i> Programar timer</button></a>
        </div>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
