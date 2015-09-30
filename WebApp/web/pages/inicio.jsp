<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
    </header>
    <body>
		<!--El padding es para salvar el footer--> 
        <div style="padding-bottom: 50px">
            <%if (!(boolean) session.getAttribute("datos_cargados")) {
            %>
			<form action= 'CargarDatos' method='POST'>
				<button type="submit" class="btn btn-success">Cargar Datos</button>
			</form>
			<%
			}%>
		<!-- Los imports de JavaScript deben ir al final del 'body' para favorecer
		el tiempo de carga de la página -->
		<script src="js/jquery-2.1.4.js"></script>
		<script src="js/bootstrap.min.js"></script>
		</div>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
