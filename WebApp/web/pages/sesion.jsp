<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="templates/head.jspf"/>
    </head>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
    <body

        <!-- Los imports de JavaScript deben ir al final del 'body' para favorecer
        el tiempo de carga de la página -->
    <script src="js/jquery-2.1.4.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
    <jsp:include page="templates/footer.jspf"/>
</html>
