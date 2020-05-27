<%-- 
    Document   : Register
    Created on : 08-may-2020, 19:51:05
    Author     : celia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/registerstyle.css">
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <div class="imgcontainer">
            <img src="images/avatar3.png" class="avatar">
        </div>

        <form action="FrontController">
            <div class="icono-input">
                <i class="fa fa-user icon"></i>
                <label for="name"></label>
                <input name= "newUser" type="name" placeholder="Usuario">
            </div>
            <div class="icono-input">
                <i class="fa fa-key icon"></i>
                <label for="username"></label>
                <input name= "newPassword" type="password" placeholder="Contraseña">
            </div>
            <div class="icono-input">
                <i class="fa fa-key icon"></i>
                <label for="username"></label>
                <input name= "password2" type="password" placeholder="Repetir Contraseña">
            </div>
            <div id="lower">
                <button name="cmd" type="submit" value="RegisterCommand">Registrarse</button>
            </div>

        </form>   
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
