<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ se puede especificar el título de ESTA jsp de la siguiente forma:
			<title>El título</title>
		-->
		<!-- ACÁ includes de .js que se requieran en ESTA página  -->
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
    <%@include file="templates/footer.jspf" %>
</html>
