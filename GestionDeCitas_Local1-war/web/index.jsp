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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Home</title>
        <link rel="stylesheet" href="css/indexstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body> 
        <h1>¿En qué podemos ayudarle?</h1>

        <div class="buttons">
            <form class="form-inline" action="FrontController">
                <input type="hidden" name="cmd" value="GoToSelectAppointmentCommand">
                <button type="sumbmit" class="btn btn-info"><span class="glyphicon glyphicon-clock"></span>Pedir cita</button>
            </form>

            <form class="form-inline" action="FrontController">
                <input type="hidden" name="cmd" value="ViewMyAppointmentsCommand">
                <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-clock"></span> Mis citas</button>
            </form>


        </div>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
