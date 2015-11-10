<%@page import="java.util.List"%>
<%@page import="webservice.DtLineaReserva"%>
<%@page import="webservice.DtReserva"%>
<%@page import="tprog.logica.interfaces.ICtrlReservas"%>
<%@page import="java.util.Set"%>

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
			<div class="panel panel-warning">
				<div class="panel-heading"><h2> <span class="glyphicon glyphicon-shopping-cart"></span>  Carrito de compras</h2></div>
				<%	DtReserva reservaTemporal = (DtReserva) session.getAttribute("reservaTemporal");
					float subtotal = 0;
					if (reservaTemporal != null) {
						List<DtLineaReserva> lineas = reservaTemporal.getLineasReserva();
				%>
				<!-- Tabla -->
				<table class="table">
					<thead>
						<tr>
							<th>Item</th>
							<th>Tipo</th>
							<th>Descripción</th>
							<th>Precio unitario</th>
							<th>Cantidad</th>
							<th>Subotal</th>
						</tr>
					</thead>
					<tbody>
						<%	int i = 0;
							for (DtLineaReserva linea : lineas) {
								i++;
								subtotal += (linea.getPrecio() * linea.getCantidad());
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
							<td>$<%=linea.getPrecio()%></td>
							<td><%=linea.getCantidad()%></td>
							<td>$<%=(linea.getPrecio() * linea.getCantidad())%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
				} else {
				%>
				<div class="col-md-12" style="margin-top: 10px">No ha agregado productos a su reserva</div>

				<%
					}
				%>
				<div class="panel-footer text-right" style="font-weight: bold">
					<div>Total $<%=subtotal%></div>
					<%
						//si el carrito no está vacío, habilito el botón de confirmación de reserva
						if (request.getSession().getAttribute("reservaTemporal") != null) {
					%>
					<!-- Trigger the modal with a button -->
					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
						<i class="glyphicon glyphicon-check"></i>
						<span style="font-weight: bold">Confirmar</span>
					</button>

					<!-- Modal -->
					<div class="modal fade" id="myModal" role="dialog" style="text-align: center">
						<div class="modal-dialog" style="vertical-align: middle;">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title text-center">Confirmar acción</h4>
								</div>
								<div class="modal-body">
									<form action="GenerarReserva" method="POST">
										<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
										<button type="submit" class="btn btn-success">Crear reserva</button>
									</form>
								</div>
							</div>

						</div>
					</div>
					<%
						}
					%>
				</div>
			</div><!-- panel -->
		</div><!-- container -->
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
<script>
	/**
	 * Vertically center Bootstrap 3 modals so they aren't always stuck at the top
	 */
	$(function () {
		function reposition() {
			var modal = $(this),
					dialog = modal.find('.modal-dialog');
			modal.css('display', 'block');

			// Dividing by two centers the modal exactly, but dividing by three
			// or four works better for larger screens.
			dialog.css("margin-top", Math.max(0, ($(window).height() - dialog.height()) / 2));
		}
		// Reposition when a modal is shown
		$('.modal').on('show.bs.modal', reposition);
		// Reposition when the window is resized
		$(window).on('resize', function () {
			$('.modal:visible').each(reposition);
		});

	});
</script>
