<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTLineaReserva"%>
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
			<div class="panel panel-default">
				<div class="panel-heading"><h2> <i class="glyphicon glyphicon-shopping-cart"></i>  Carrito de compras</h2></div>
				<%	DTReserva reservaTemporal = (DTReserva) session.getAttribute("reservaTemporal");
					float subtotal = 0;
					if (reservaTemporal != null) {
						Set<DTLineaReserva> lineas = reservaTemporal.getLineasReserva();
						float precioTotal = reservaTemporal.getPrecioTotal();
				%>
				<!-- Tabla -->
				<table class="table">
					<thead>
						<tr>
							<th>Item</th>
							<th>Tipo</th>
							<th>Descripción</th>
							<th>Cantidad</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<%	int i = 0;
							for (DTLineaReserva linea : lineas) {
								i++;
								subtotal += linea.getPrecio()*linea.getCantidad();
						%>
						<tr>
							<th scope="row"><%=i%></th>
								<% if (linea.getServicio() != null) {%>
							<td>Servicio</td>
							<td><%=linea.getServicio()%></td>
							<%} else {%>
							<td>Promoción</td>
							<td><%=linea.getPromocion()%></td>
							<%}%>
							<td><%=linea.getCantidad()%></td>
							<td><%=(linea.getPrecio()*linea.getCantidad())%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
				} else {
				%>
				<div class="col-md-12">No hay ninguna linea de reserva actualmente</div>

				<%
					}
				%>
				<div class="panel-footer text-right" style="font-weight: bold">Subtotal: $<%=subtotal%></div>
			</div><!-- panel -->
		</div><!-- container -->
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
