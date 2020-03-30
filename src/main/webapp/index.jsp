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
        <h1>¿En qué podemos ayudarte?</h1>

        <div class="buttons">
            <a href=SelectAppointment.jsp ><button class="btn"><i class="fa fa-clock-o"></i> Pedir cita</button></a>
            <a href=AppointmentsView.jsp ><button type="submit" name="cmd" value="ViewMyAppointmentsCommand" class="btn"><i class="fa fa-calendar"></i> Mis citas</button></a>
        </div>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
