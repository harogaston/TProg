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
        <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
        <link href='https://fonts.googleapis.com/css?family=Alegreya+Sans+SC:400,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <script src="js/jquery-2.1.4.js"></script>
        <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#accordionServicios").accordion();
                $("#accordionPromociones").accordion();
            });
        </script>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
    </header>
    <body style="font-family: 'Alegreya Sans SC', sans-serif">

        <div class="container-fluid" style="padding: 10px; font-family: 'Alegreya Sans SC', sans-serif">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <h2>Servicios:</h2>

                    <% Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
                        if (!servicios.isEmpty()) {
                    %>
                    <div id="accordionServicios">
                        <%
                            int contador = 0;
                            for (DTMinServicio servicio : servicios) {
                                contador++;
                        %>
                        <h3> Servicio <%= Integer.toString(contador)%> </h3>
                        <div>
                            <p>Proveedor: <%= servicio.getNicknameP()%></p>
                            <p>Nombre: <%= servicio.getIdServicio()%></p>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <%
                    } else { %>
                    <p> No hay servicios para esa búsqueda </p>
                    <%
                        }
                    %>

                    <h2>Promociones:</h2>

                    <% Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
                        if (!promociones.isEmpty()) {
                    %>
                    <div id="accordionPromociones">
                        <%
                            int contador = 0;
                            for (DTMinPromocion promocion : promociones) {
                                contador++;
                        %>
                        <h3> Promoción <%= Integer.toString(contador)%> </h3>
                        <div>
                            <p>Proveedor: <%= promocion.getNicknameP()%></p>
                            <p>Nombre: <%= promocion.getIdPromocion()%></p>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <%
                    } else {
                    %>
                    <p> No hay promociones para esa búsqueda </p>
                    <%
                        }
                    %>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
