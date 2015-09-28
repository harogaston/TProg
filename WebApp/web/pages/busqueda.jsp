<%--
    Document   : busqueda
    Created on : Sep 27, 2015, 7:32:36 PM
    Author     : marccio
--%>

<%@page import="tprog.logica.dt.DTMinPromocion"%>
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

        <h2>Servicios:</h2>

        <% Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
            if (!servicios.isEmpty()) {
                for (DTMinServicio servicio : servicios) {
        %>
        <p> toString : <%= servicio.toString()%> </p>
        <%
            }
        } else { %>
        <p> No hay servicios para esa búsqueda </p>
        <%
            }
        %>

        <h2>Promociones:</h2>

        <% Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
            if (!promociones.isEmpty()) {
                for (DTMinPromocion promocion : promociones) {
        %>
        <p> toString : <%= promocion.toString()%> </p>
        <%
            }
        } else {
        %>
        <p> No hay promociones para esa búsqueda </p>
        <%
            }
        %>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
