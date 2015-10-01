<%@page import="tprog.logica.dt.DTReserva"%>

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
		<div class="container wrapper" style="border: #000; border-radius: 4px;">
            <div class="row">
				<%
					DTReserva reservaTemporal = (DTReserva) session.getAttribute("reservaTemporal");
					if (reservaTemporal != null) {
				%>

				<div class="col-md-12"><%=reservaTemporal.toString().replace("\n", "<br>")%></div>
				<%
				} else {
				%>
				<div class="col-md-12">No hay ninguna linea de reserva actualmente</div>

				<%
					}
				%>
			</div>
		</div>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
