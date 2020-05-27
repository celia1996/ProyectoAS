<%-- 
    Document   : SetTimer
    Created on : 09-may-2020, 17:45:56
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programar timer</title>
        <link rel="stylesheet" href="css/settimerstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h1>Introduzca el tiempo en segundos: </h1>
        <form action="FrontController">

            <div class="icono-input">
                
                <label for="time"></label>
                <input name="time" type="text" placeholder="Time">
            </div>
            <div class="button">
                <button class="btn" name="cmd" type="submit" value="TimerCommand">Establecer</button>
            </div>
        </form>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
