<%-- 
    Document   : registrarCliente
    Created on : Oct 2, 2015, 10:24:52 PM
    Author     : ignacio.prandi
--%>

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

		<div class="container wrapper" style="padding: 30px">
			<form action= "RegistrarCliente" class="navbar-form" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nickname" name="nickname" autofocus required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Mail" name="mail" required>
					</div>
					<button class="btn btn-success" type="submit">Ingresar</button>
				</form>
		</div>
	</body>
	<!-- AC� includes de .js que se requieran en ESTA p�gina  -->
	<%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>

