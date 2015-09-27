<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
    </head>
    <header>
        <%@page  import="tprog.web.EstadoSesion"%>
        <%@include file="templates/header.jsp" %>
    </header>
    <body>

        <p>
            <%
                if (!(boolean) session.getAttribute("datos_cargados")) {
                    out.println("<form action= 'CargarDatos' method='POST'>"
                            + "<button type='submit' class='btn btn-success'>Cargar Datos</button>"
                            + "</form>");
                }%>
        </p>


        <!-- Los imports de JavaScript deben ir al final del 'body' para favorecer
        el tiempo de carga de la página -->
        <script src="js/jquery-2.1.4.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
