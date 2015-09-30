<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- Ac� se puede especificar el t�tulo de ESTA jsp de la siguiente forma:
			<title>El t�tulo</title>
		-->
</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACA .css que se requieran en esta jsp 
		(sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
		-->
    </header>
    <body>
        <!-- La PAGINA propiamente dicha  -->
    </body>
    <!-- AC� includes de .js que se requieran en ESTA p�gina  -->
    <%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>
