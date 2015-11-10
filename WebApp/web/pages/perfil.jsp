<%@page import="webservice.DtLineaReserva"%>
<%@page import="webservice.DtReserva"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>

<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- Acá se puede especificar el título de ESTA jsp de la siguiente forma:
			<title>El título</title>
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
			<div class="row">
				<!-- Nav tabs -->
				<ul class="nav nav-pills" role="tablist" style="margin-bottom: 50px">
					<li role="presentation" class="active"><a href="#info" aria-controls="info" role="tab" data-toggle="tab">Información</a></li>
						<% if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) { %>
					<li role="presentation"><a href="#reservas" aria-controls="reservas" role="tab" data-toggle="tab">Reservas</a></li>
						<% } %>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<!--Información de perfil-->
					<div role="tabpanel" class="tab-pane active" id="info">
						<div class="row">
							<div class="col-md-3 text-center">
								<%if (request.getAttribute("imagen") != null) {%>
								<img class="img-thumbnail" src="${imagen}" style="border-radius: 50%; height: 100px; width: 100px"/>
								<%} else {%>
								<img class="img-thumbnail" src="imagenes/clientes/sinimagen.jpg" style="border-radius: 50%; height: 100px; width: 100px"/>
								<%}%>
							</div>
							<div class="col-md-9">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3 class="panel-title">${nick}</h3>
									</div>
									<div class="panel-body">
										<span class="text-muted">Nombre: </span> ${nombre}<br>
										<span class="text-muted">Fecha de Nacimiento: </span>${fNac}<br>
										<span class="text-muted">Email: </span>${email}<br>
										<% if (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR) { %>
										<span class="text-muted">Empresa: </span> ${nombreEmpresa}<br>
										<span class="text-muted">Link Empresa: </span>${linkEmpresa}<br>
										<% } %>
										<br>
									</div>
								</div>
							</div>
						</div>
					</div>
					<% if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) { %>
					<!--Reservas-->
					<div role="tabpanel" class="tab-pane" id="reservas">
						<% if (request.getAttribute("reservas") != null) {%>
						<div class="panel-group" id="accordionServicios">
							<%	int i = 0;
								for (DtReserva dtR : (Set<DtReserva>) request.getAttribute("reservas")) {
									i++;
							%>
							<div class="accordion-group">
								<div class="panel panel-warning">
									<div class="panel-heading" data-toggle="collapse" data-parent="#accordionServicios" href="#s<%=i%>">
										<h4 class="panel-title">
											Reserva #<%=dtR.getIdReserva()%>

										</h4>
									</div>
									<div id="s<%=i%>" class="panel-collapse collapse">
										<div class="panel-body">
											<span class="text-muted">Estado: </span> <%=dtR.getEstado().value()%><br>
											<%
												String fCreacion = Integer.toString(dtR.getFCreacion().getDay()) + "-"
														+ Integer.toString(dtR.getFCreacion().getMonth() + 1) + "-"
														+ Integer.toString(dtR.getFCreacion().getYear()) + "\n";
											%>
											<span class="text-muted">Fecha de Creación: </span><%=fCreacion%><br>
											<div class="panel panel-default">
												<div class="panel-heading">Detalle de la reserva</div>
												<%	float subtotal = 0;
													Set<DtLineaReserva> lineas = new HashSet(dtR.getLineasReserva());
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
															<th>Subtotal</th>
														</tr>
													</thead>
													<tbody>
														<%	int j = 0;
															for (DtLineaReserva linea : lineas) {
																j++;
																subtotal += linea.getPrecio() * linea.getCantidad();
														%>
														<tr>
															<th scope="row"><%=j%></th>
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
												<div class="panel-footer text-right" style="font-weight: bold">
													<div>Total $<%=subtotal%></div>

													<%if (dtR.getEstado().value().equals("Registrada")) {%>
													<!-- Trigger the modal with a button -->
													<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal<%=String.valueOf(i)%>">
														<i class="glyphicon glyphicon-remove"></i>
														<span style="font-weight: bold">Cancelar</span>
													</button>

													<!-- Modal -->
													<div class="modal fade" id="myModal<%=String.valueOf(i)%>" role="dialog" style="text-align: center">
														<div class="modal-dialog" style="vertical-align: middle;">
															<!-- Modal content-->
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal">&times;</button>
																	<h4 class="modal-title text-center">Confirmar acción</h4>
																</div>
																<div class="modal-body">
																	<form action="CancelarReserva" method="GET">
																		<button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
																		<button type="submit" class="btn btn-danger">Sí, cancelar</button>
																		<input type="text" name="idReserva" value="<%=dtR.getIdReserva()%>" style="display: none">
																	</form>
																</div>
															</div>

														</div>
													</div>
													<%}%>
												</div>
											</div><!-- panel -->
										</div>
									</div>
								</div>
							</div>
							<%
								}// cierra for
							%>
						</div>
						<% } else { %>
						<p> Usted no posee reservas </p>
						<%
							}
						%>
					</div>
					<% } else {

						}%>
				</div>
			</div>
		</div>
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