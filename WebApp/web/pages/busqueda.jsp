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
        <title>Resultados de busqueda</title>
        <script src="js/vakata-jstree/dist/jstree.min.js"></script>
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
        <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css">
    </header>

    <body>
        <div id="body_holder" style="visibility: hidden">
            <div class="container-fluid" style="padding: 10px; font-family: 'Alegreya Sans SC', sans-serif">
                <div class="row">


                    <!-- JSTREE -->
                    <div class="col-lg-2"></div>
                    <div class="col-lg-2">
                        <div class="row">
                            <p >Seleccione una categoría para filtrar los resultados de la búsqueda</p>
                            <!--
                            con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet
                            -->
                            <div id="arbol_categorias" style="padding-top: 50px; overflow: scroll; max-height: 50vh"></div>
                        </div>
                        <div class="col-lg-3">

                        </div>
                    </div>
                    <!--
                    En la siguiente form oculta, se va a guardar el nombre de la categoria seleccionada,
                    para que siempre que cambie se recargue la página y se muestren los servicios asociados
                    a la categoría
                    -->
                    <form action= "Buscar" id="ver_servicios_form" class="form-inline" role="form" method="POST">
                        <input type="text" name="categoriaSeleccionada" id="categoriaSeleccionada" style="visibility: hidden">
                    </form>




                    <div class="col-lg-3">
                        <h2>Servicios:</h2>
                        <% if (request.getAttribute("noHayServicios") != null
                                    && !(boolean) request.getAttribute("noHayServicios")
                                    && request.getAttribute("servicios") != null) {
                                Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
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
                                <form action="VerServicio" class="navbar-form">
                                    <div class="input-group">
                                        <input type="text" name="idServicio" value="<%=dt.getIdServicio()%>" style="visibility: hidden">
                                        <input type="text" name="idProveedor" value="<%=dt.getNicknameP()%>" style="visibility: hidden">
                                        <button class="btn btn-info" type="submit">Ir a Servicio</button>
                                    </div>
                                </form>
                            </div>
                            <%
                                }
                            %>
                        </div>
                        <%
                            }
                        } else { %>
                        <p> No hay servicios para esa búsqueda </p>
                        <%
                            }
                        %>

                    </div>
                    <div class="col-lg-3">

                        <h2>Promociones:</h2>

                        <%if (request.getAttribute("mostrarPromociones") != null
                                    && (boolean) request.getAttribute("mostrarPromociones")) {
                                Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
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
                                <form action="VerPromocion" class="navbar-form">
                                    <div class="input-group">
                                        <input type="text" name="idServicio" value="<%=dt.getIdPromocion()%>" style="visibility: hidden">
                                        <input type="text" name="idProveedor" value="<%=dt.getNicknameP()%>" style="visibility: hidden">
                                        <button class="btn btn-info" type="submit">Ir a Promocion</button>
                                    </div>
                                </form>
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
        </div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>

<script>
    $(window).load(function () {
        //hago que la página interna (no header ni footer) se muestre cuando
        //este todo cargado, para evitar glitches random
        $("#body_holder").css("visibility", "visible");
    <%
        if (request.getAttribute("noHayServicios") != null
                && (boolean) request.getAttribute("noHayServicios")) {
            //quiere decir que se volvio a la pagina por no haber servicios para la categoria
    %>
        alert("No hay servicios para la categoria seleccionada; por favor seleccione otra");
    <%
        }
    %>
    });


    var arbol = <%=request.getAttribute("arbolJson")%>;
    //creo jstree y sorteo nodos
    $('#arbol_categorias').jstree({
        "plugins": ["sort"],
        'core': {
            'data': arbol
        }
    });

    $('#arbol_categorias').on('loaded.jstree', function () {
        //abro todo el arbol
        $('#arbol_categorias').jstree('open_all');
    });

    //cuando se clickea algún elemento del árbol, se muestran todos los servicios asociados (y ninguna promoción)
    $('#arbol_categorias').click(function () {
        document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
        document.getElementById('ver_servicios_form').submit(); //mando la form para actualizar la lista de servicios
    });

</script>