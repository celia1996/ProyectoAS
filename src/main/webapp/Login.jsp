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
        <link rel="stylesheet" href="css/loginstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <div class="imgcontainer">
            <img src="images/avatar3.png" class="avatar">
        </div>
        <div id="container">
            <form action="FrontController">
                <div class="icono-input">
                    <i class="fa fa-user icon"></i>
                    <label for="name"></label>
                    <input name= "user" type="name" placeholder="Usuario">
                </div>
                <div class="icono-input">
                    <i class="fa fa-key icon"></i>
                    <label for="username"></label>
                    <input name= "password" type="password" placeholder="Contraseña">
                </div>
                <div id="lower">
                    <button name="cmd" type="submit" value="LoginCommand">¡Vamos!</button>
                </div>
            </form>       
        </div>
    </body>
</html>
