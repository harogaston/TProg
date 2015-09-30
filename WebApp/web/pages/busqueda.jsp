<%@page import="tprog.logica.dt.DTPromocion"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
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
                <div class="col-lg-4">
                    <h2>Servicios:</h2>

                    <% Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
                        if (!servicios.isEmpty()) {
                    %>
                    <div id="accordionServicios">
                        <%
                            for (DTMinServicio dt : servicios) {
                                Fabrica f = Fabrica.getInstance();
                                ICtrlProductos ctrlProductos = f.getICtrlProductos();
                                ctrlProductos.seleccionarServicio(dt);
                                DTServicio servicio = ctrlProductos.infoServicio();
                        %>
                        <h3><%= servicio.getIdServicio()%> </h3>
                        <div>
                            <%=servicio.toString().replace("\n", "<br>")%>
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

                </div>
                <div class="col-lg-4">

                    <h2>Promociones:</h2>

                    <% Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
                        if (!promociones.isEmpty()) {
                    %>
                    <div id="accordionPromociones">
                        <%
                            for (DTMinPromocion dt : promociones) {
                                Fabrica f = Fabrica.getInstance();
                                ICtrlProductos ctrlProductos = f.getICtrlProductos();
                                ctrlProductos.seleccionarPromocion(dt);
                                DTPromocion promocion = ctrlProductos.infoPromocion();
                        %>
                        <h3> <%= promocion.getIdPromocion()%> </h3>
                        <div>
                            <%=promocion.toString().replace("\n", "<br>")%>
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

