<%--
    Document   : verinfoservicio
    Created on : Sep 28, 2015, 12:03:29 AM
    Author     : marccio
--%>

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
    <body style="font-family: 'Alegreya Sans SC', sans-serif">
        <div class="col-lg-3"></div>
        <div class="col-lg-3">
            <p >Por favor seleccione una categoría y haga click en "Ver Servicios"</p>
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
            <form action= "ListarServicios" class="form-inline" role="form" method="POST">
                <button type="submit" class="row btn btn-success" style="background-color: #23527c; border-color: #23527c">Ver Servicios</button>
            </form>
        </div>
        <div class="col-lg-3"></div>
    </body>
    <footer>
        <jsp:include page="templates/footer.jspf"/>
    </footer>
</html>
