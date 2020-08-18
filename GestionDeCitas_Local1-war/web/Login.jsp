<%-- 
    Document   : LogIn
    Created on : 14-mar-2020, 19:32:02
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/loginstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="imgcontainer">
            <h1>NoWalls</h1>
            <img src="images/avatar3.png" class="avatar">
        </div>
        <div id="container">
            <form action="FrontController">
                <div class="form-group">
                    <i class="fa fa-user icon"></i>
                    <label for="name"></label>
                    <input name= "user" type="name" placeholder="Usuario">
                </div>
                <div class="form-group">
                    <i class="fa fa-key icon"></i>
                    <label for="username"></label>
                    <input name= "password" type="password" placeholder="Contraseña">
                </div>
                <div id="lower">
                    <button class="btn btn-success" name="cmd" type="submit" value="LoginCommand">¡Vamos!</button>
                    <a href=Register.jsp ><button type="button" class="btn btn-link">Registrarse</button></a>
                </div>
            </form>     
        </div>
    </body>
</html>
