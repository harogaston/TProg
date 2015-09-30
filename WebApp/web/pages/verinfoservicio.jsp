<%--
    Document   : verinfoservicio
    Created on : Sep 28, 2015, 12:03:29 AM
    Author     : marccio
--%>

<%@page import="java.awt.Toolkit"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="java.util.Map"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="templates/head.jspf"/>
    </head>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
    <body>
        <div id="body_holder" style="visibility: hidden">
            <div class="col-lg-3"></div>
            <div class="col-lg-3">
                <p >Por favor seleccione una categoría y haga click en "Ver Servicios"</p>
                <!--
                con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet
                -->
                <div id="arbol_categorias" style="padding-top: 50px; overflow: scroll; max-height: 50vh"></div>
            </div>
            <div class="col-lg-3">
                <!--
                En la siguiente form oculta, se va a guardar el nombre de la categoria seleccionada,
                para que siempre que cambie se recargue la página y se muestren los servicios asociados
                a la categoría
                -->
                <form action= "VerInfoServicio" id="ver_servicios_form" class="form-inline" role="form" method="POST">
                    <input type="text" name="categoriaSeleccionada" id="categoriaSeleccionada" style="visibility: hidden">
                </form>


                <div id="lista_servicios">
                    <%
                        if (request.getAttribute("mapaServicios") != null) {
                            Map<String, DTMinServicio> servicios = (Map<String, DTMinServicio>) request.getAttribute("mapaServicios");
                            for (DTMinServicio servicio : servicios.values()) {
                                //dejo siempre cargada la información del servicio
                                Fabrica f = Fabrica.getInstance();
                                ICtrlProductos ctrlProductos = f.getICtrlProductos();
                                ctrlProductos.seleccionarServicio(servicio);
                                DTServicio infoServicio = ctrlProductos.infoServicio();
                    %>
                    <h3>Servicio : <%=servicio.getIdServicio()%></h3>
                    <div>
                        <%=infoServicio.toString().replace("\n", "<br>")%>
                    </div>
                    <%
                            }
                        }%>
                </div>


            </div>
            <div class="col-lg-3"></div>
        </div>
    </body>
    <footer>
        <jsp:include page="templates/footer.jspf"/>
    </footer>
</html>

<script>

    $(window).load(function () {
        //hago que la página interna (no header ni footer) se muestre cuando
        //este todo cargado, para evitar glitches random
        $("#body_holder").css("visibility", "visible");
    <%
        if ((boolean) request.getAttribute(
                "noHayServicios")) {
            //quiere decir que se volvio a la pagina por no haber servicios para la categoria
    %>
        alert("No hay servicios para la categoria seleccionada; por favor seleccione otra");
    <%
    } else {
    %>
        $("#lista_servicios").accordion();
        $("#lista_servicios").accordion("option", "heightStyle", "content");
        $("#lista_servicios").accordion("option", "active", false);
    <%}%>

    });

    //cuando se clickea algún elemento del árbol, se muestran todos los servicios asociados
    $('#arbol_categorias').click(function () {
        document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
        document.getElementById('ver_servicios_form').submit(); //mando la form para actualizar la lista de servicios
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
        //queda seleccionado el nodo seleccionado anteriormente
        if (<%= request.getAttribute("categoriaSeleccionada") != null%>) {
            $('#arbol_categorias').jstree(true).select_node(<%= request.getAttribute("categoriaSeleccionada")%>);
        }
        //abro todo el arbol
        $('#arbol_categorias').jstree('open_all');
    });

</script>