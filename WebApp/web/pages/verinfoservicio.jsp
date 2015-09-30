<%--
    Document   : verinfoservicio
    Created on : Sep 28, 2015, 12:03:29 AM
    Author     : marccio
--%>

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
        <script src="js/jquery-2.1.4.js"></script>
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css" />
        <script src="js/vakata-jstree/dist/jstree.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
        <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
    </head>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
    <div class="col-lg-3"></div>
    <div class="col-lg-3">
        <p >Por favor seleccione una categoría y haga click en "Ver Servicios"</p>
        <!--
        con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet
        -->
        <div id="arbol_categorias" style="padding-top: 50px">
            <script>
                var arbol = <%=request.getAttribute("arbolJson")%>;
                $('#arbol_categorias').jstree({
                    'core': {
                        'data': arbol
                    }
                });
                $('#arbol_categorias').on('loaded.jstree', function () {
//                    queda seleccionado el nodo seleccionado anteriormente
//NO FUNCIONA TODAVÍA
                    if (<%= request.getAttribute("categoriaSeleccionada") != null%>) {
                        $('#arbol_categorias').jstree(true).select_node(<%= request.getAttribute("categoriaSeleccionada")%>);
                    }
                    //abro primer nivel
                    $('#arbol_categorias').jstree(true).toggle_node('Categorias');
                });

                //ordeno los nodos del arbol
                $(function () {
                    $("#arbol_categorias").jstree({
                        "plugins": ["sort"]
                    });
                });

            </script>
        </div>
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
</body>
<footer>
    <jsp:include page="templates/footer.jspf"/>
</footer>
</html>

<script>

    $(window).load(function () {
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

    //transformo la lista de servicios en un accordion
    //seteo el accordion para que ningún servicio esté seleccionado de una
    $(function () {

    });

    //si un servicio es seleccionado, se muestra su info servicio
    $('#lista_servicios').on("accordionactivate", function (event, ui) {
    <%
//        Fabrica f = Fabrica.getInstance();
//        ICtrlProductos ctrlProductos = f.getICtrlProductos();
//        ctrlProductos.seleccionarServicio(dtS);


    %>
    });


</script>