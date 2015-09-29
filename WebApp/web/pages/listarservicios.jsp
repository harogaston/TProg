<%--
    Document   : listarservicios
    Created on : Sep 29, 2015, 1:37:11 PM
    Author     : marccio
--%>

<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page import="tprog.logica.dt.DTMinPromocion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <title>Listado de Servicios</title>
        <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
        <link href='https://fonts.googleapis.com/css?family=Alegreya+Sans+SC:400,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <script src="js/jquery-2.1.4.js"></script>
        <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#accordionServicios").accordion();
            });
        </script>
    </head>
    <header>
        <%@page  import="tprog.web.EstadoSesion"%>
        <%@include file="templates/header.jsp" %>
    </header>


    <body style="font-family: 'Alegreya Sans SC', sans-serif">

        <div class="container-fluid" style="padding: 10px; font-family: 'Alegreya Sans SC', sans-serif">
            <div class="row" style="text-align: center">
                Seleccione algún servicio del sistema para ver su información
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <select class="input-large form-control">
                        <%                    Set<String> servicios = (Set<String>) request.getAttribute("servicios");
                            for (String servicio : servicios) {
                        %>
                        <option value=<%=servicio%>><%=servicio%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-lg-3"></div>
            </div>
        </div>
    </body>
    <footer>
        <%@include file="templates/footer.jspf" %>
    </footer>
</html>
