<%@page import="tprog.logica.dt.DTLineaReserva"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="tprog.logica.dt.DTReserva"%>

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
					<li role="presentation"><a href="#reservas" aria-controls="reservas" role="tab" data-toggle="tab">Reservas</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<!--Información de perfil-->
					<div role="tabpanel" class="tab-pane active" id="info">
						<div class="row">
							<div class="col-md-3 text-center">
								<%if (request.getAttribute("imagen") != null) {%>
								<img class="img-thumbnail" src="${imagen}" style="border-radius: 50%"/>
								<%} else {%>
								<img class="img-thumbnail" src="imagenes/sinimagen.jpeg" style="border-radius: 50%"/>
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
										<span class="text-muted">Email: </span>${email}<br><br>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!--Reservas-->
					<div role="tabpanel" class="tab-pane" id="reservas">
						<% if (request.getAttribute("reservas") != null) {%>
						<div class="panel-group" id="accordionServicios">
							<%	int i = 0;
								for (DTReserva dtR : (Set<DTReserva>) request.getAttribute("reservas")) {
									i++;
							%>
							<div class="accordion-group">
								<div class="panel">
									<div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionServicios" href="#s<%=i%>">
										<h4 class="panel-title">
											Reserva #<%=dtR.getIdReserva()%>

										</h4>
									</div>
									<div id="s<%=i%>" class="panel-collapse collapse">
										<div class="panel-body">
											<span class="text-muted">Estado: </span> <%=dtR.getEstadoReserva().toString()%><br>
											<%
												String fCreacion = Integer.toString(dtR.getFCreacion().getDate()) + "-"
														+ Integer.toString(dtR.getFCreacion().getMonth() + 1) + "-"
														+ Integer.toString(dtR.getFCreacion().getYear()) + "\n";
											%>
											<span class="text-muted">Fecha de Creación: </span><%=fCreacion%><br>
											<div class="panel panel-default">
												<div class="panel-heading">Detalle de la reserva</div>
												<%	float subtotal = 0;
													if (dtR != null) {
														Set<DTLineaReserva> lineas = dtR.getLineasReserva();
														float precioTotal = dtR.getPrecioTotal();
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
														<%	int j = 0;
															for (DTLineaReserva linea : lineas) {
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
															<td><%=linea.getCantidad()%></td>
															<td><%=(linea.getPrecio() * linea.getCantidad())%></td>
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
												<div class="panel-footer text-right" style="font-weight: bold">
													<p>Subtotal: $<%=subtotal%></p>

													<%if (dtR.getEstadoReserva().toString().equals("Registrada")) {%>
													<form action="CancelarReserva" method="GET" class="navbar-form">
														<input type="text" name="idReserva" value="<%=dtR.getIdReserva()%>" style="visibility: hidden">
														<button class="btn btn-danger" type="submit"><i class="glyphicon glyphicon-remove"></i></button>
													</form>
													<%} else {%>
													<button class="btn btn-danger" disabled="disabled" type="submit"><i class="glyphicon glyphicon-remove"></i></button>
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
				</div>
			</div>
		</div>
	</body>
	<!-- ACÁ includes de .js que se requieran en ESTA página  -->
	<%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>
