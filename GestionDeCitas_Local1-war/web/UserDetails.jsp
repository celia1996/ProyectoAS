<%-- 
    Document   : Register
    Created on : 08-may-2020, 19:51:05
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Datos</title>
        <link rel="stylesheet" href="css/appointmentstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <div class="container">
            <h3>Por favor, rellene el siguiente formulario:</h3>
            <form action="FrontController">
                <div class="form-group">
                    <label for="dni">DNI:</label>
                    <input type="dni" class="form-control" id="dni" placeholder="47890345D" name="personalID">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Número de teléfono:</label>
                    <input type="phoneNumber" class="form-control" id="pwd" placeholder="+34678905432"
                           name="phoneNumber">
                </div>

                <div class="checkbox">
                    <p>Seleccione esta opción si desea recibir el aviso de su turno mediante una notificación móvil:</p>
                    <label><input type="checkbox" name="notification">Recibir notificación móvil</label>
                </div>
                <button class='btn btn-success'type="submit" name=cmd value=UserDetailsCommand class="btn btn-default">Submit</button>
            </form>
        </div>


        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
