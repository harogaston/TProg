<%@page import="tprog.logica.dt.DTReserva"%>

<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- AC� se puede especificar el t�tulo de ESTA jsp de la siguiente forma:
			<title>El t�tulo</title>
		-->
		<!-- AC� includes de .js que se requieran en ESTA p�gina  -->
	</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACA .css que se requieran en esta jsp
			(sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
		-->
    </header>
    <body>
        <!-- La PAGINA propiamente dicha  -->
		<div class="col-lg-4"></div>
		<%
			DTReserva reservaTemporal = (DTReserva) session.getAttribute("reservaTemporal");
			if (reservaTemporal != null) {
		%>

		<div class="col-lg-4"><%=reservaTemporal.toString().replace("\n", "<br>")%></div>
		<%
		} else {
		%>
		<div class="col-lg-4">No hay ninguna linea de reserva actualmente</div>

		<%
			}
		%>
		<div class="col-lg-4"></div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
