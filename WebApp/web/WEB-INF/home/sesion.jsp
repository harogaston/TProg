<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/WEB-INF/templates/head.jspf"/>
    </head>
    <header>
        <jsp:include page="/WEB-INF/templates/headerSesionActiva.jspf"/>
    </header>
    <body
		
		<!-- Los imports de JavaScript deben ir al final del 'body' para favorecer 
		el tiempo de carga de la p�gina -->
        <script src="../js/jquery-2.1.4.js"></script>
		<script src="../js/bootstrap.min.js"></script>
    </body>
    <jsp:include page="/WEB-INF/templates/footer.jspf"/>
</html>