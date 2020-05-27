<%-- 
    Document   : CounterView
    Created on : 02-may-2020, 18:51:33
    Author     : celia
--%>

<%@page import="java.util.HashMap"%>
<%@page import="ejbs.Counter"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics</title>
        <link rel="stylesheet" href="css/counterviewstyle.css">
        <jsp:include page="./header.jsp" flush="true" />
    </head>
    <body>
        <h3>Estadísticas del sistema: </h3>
        <%
            Counter counter = (Counter) InitialContext.doLookup("java:global/GestionDeCitas_Local1/GestionDeCitas_Local1-ejb/Counter");
            HashMap<String, Integer> map = counter.getMap();

        %> <h4> Numero de calendarios: <%=map.size()%> </h4> <%
            for (HashMap.Entry<String, Integer> ent : map.entrySet()) {
        %> <h4>Citas:</h4><h4> <%=ent.getKey()%>: <%=ent.getValue()%></h4> <%
                }

                String loginCount = String.valueOf(counter.getLoginCount());
                out.println("<h4> Inicios de sesión: " + loginCount + "</h4>");
        %>


        <jsp:include page="./footer.jsp" flush="true" />
    </body>
</html>
