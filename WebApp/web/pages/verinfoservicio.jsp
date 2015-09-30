<%--
    Document   : verinfoservicio
    Created on : Sep 28, 2015, 12:03:29 AM
    Author     : marccio
--%>

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
    </head>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
        <div class="col-lg-3"></div>
        <div class="col-lg-3">
            <p >Por favor seleccione una categoría y haga click en "Ver Servicios"</p>
            <!-- con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet -->
            <div id="arbol_categorias" style="padding-top: 50px">
                <script>
                    var arbol = <%=request.getAttribute("arbolJson")%>;
                    $('#arbol_categorias').jstree({
                        'core': {
                            'data': arbol
                        }
                    });
                    $('#arbol_categorias').on('loaded.jstree', function () {
                        //queda seleccionado el nodo padre
                        $('#arbol_categorias').jstree(true).select_node('Categorias');
                        //abro primer nivel
                        $('#arbol_categorias').jstree(true).toggle_node('Categorias');
                    })
                </script>
            </div>
        </div>
        <div class="col-lg-3">
            <form action= "ListarServicios" id="ver_servicios_form" class="form-inline" role="form" method="POST">
                <input type="text" name="categoriaSeleccionada" id="categoriaSeleccionada" style="visibility: hidden">
                <button type="submit" id="ver_servicios" class="row btn btn-success" style="background-color: #23527c; border-color: #23527c">Ver Servicios</button>
            </form>
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
        if ((boolean) request.getAttribute("noHayServicios")) {
            //quiere decir que se volvio a la pagina por no haber servicios para la categoria
    %>
        alert("No hay servicios para la categoria seleccionada; por favor seleccione otra");
    <%
        }
    %>
    });


    $('#arbol_categorias').click(function () {
        document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
    });

//    $('#ver_servicios').click(function (eventObj) {
//        var textoNodoSeleccionado = $('.jstree-clicked').text();
//        document.getElementById('categoriaSeleccionada').value = textoNodoSeleccionado;
//        alert(textoNodoSeleccionado);
//    });

</script>

<!--
<script>
    $('#ver_servicios').click(function () {
        alert("Faggot");
    });
</script>
-->