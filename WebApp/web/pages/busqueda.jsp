<%--
    Document   : busqueda
    Created on : Sep 27, 2015, 7:32:36 PM
    Author     : marccio
--%>

<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!--<title>Resultados de busqueda</title>-->
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
    </header>
    <body>

        <% Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
            int contador = 1;
            for (DTMinServicio servicio : servicios) {
        %>
        <p> toString : <%= servicio.toString()%> </p>
        <%
            }
        %>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
