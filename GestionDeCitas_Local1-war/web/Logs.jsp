<%-- 
    Document   : Logs
    Created on : 09-may-2020, 12:02:54
    Author     : celia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejbs.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logs</title>
        <link rel="stylesheet" href="css/logsviewstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>

        <%Log logs = (Log) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Log");
            ArrayList<String> logsArray = logs.getLogArray();

        %> <h3>Logs del sistema: </h3>
        <%            for (String log : logsArray) {
                out.println("<h4>" + log + "</h4>");
            }
        %>
        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
