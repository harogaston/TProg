<%--
    Document   : listarservicios
    Created on : Sep 29, 2015, 1:37:11 PM
    Author     : marccio
--%>

<%@page import="tprog.logica.dt.DTServicio"%>
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
        <script src="js/jquery-2.1.4.js"></script>
        <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
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
                    <select id="combobox" class="input-large form-control" onchange="seleccionarServicio(this);">
                        <%                    Set<String> listaServicios = (Set<String>) request.getAttribute("listaServicios");
                            for (String servicio : listaServicios) {
                        %>
                        <option value=<%=servicio%>><%=servicio%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="row">
                <%
                    DTServicio infoServicio = (DTServicio) request.getAttribute("infoServicio");
                    if (infoServicio != null) {
                %>
                <div id="dialog" title="Información del servicio">
                    <p><%= infoServicio.toString()%></p>
                </div>
                <%
                    }
                %>
            </div>

            <!--
            estructura para enviar el servicio seleccionado
            -->

            <form action= "DetalleServicio" id="detalle_servicio_form" class="form-inline" role="form" method="POST">
                <input name="idServicio" id="idServicio" type="text" style="visibility: hidden">
            </form>

        </div>
    </body>
    <footer>
        <%@include file="templates/footer.jspf" %>
    </footer>
</html>

<script>

    function seleccionarServicio(selectObj) {
        var selectIndex = selectObj.selectedIndex;
        var selectValue = selectObj.options[selectIndex].text;
        var inputIdServicio = document.getElementById("idServicio");
        inputIdServicio = selectValue;
        var form = document.getElementById("detalle_servicio_form").submit();
        form.submit();
    }

    /*
     //seteo la selección del combobox como nula
     window.document.onload(function () {
     var div_contents = document.getElementById("combobox_div");
     var elements = div_contents.getElementsByTagName("option");
     for (i = 0; i < elements.length; i++) {
     elements[i].selectedIndex = -1;
     }
     });
     */
</script>
