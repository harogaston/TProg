<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="webservice.DtPromocion"%>
<%@page import="webservice.DtServicio"%>
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
					<li role="presentation"><a href="#servicios" aria-controls="servicios" role="tab" data-toggle="tab">Servicios</a></li>
					<li role="presentation"><a href="#promociones" aria-controls="promociones" role="tab" data-toggle="tab">Promociones</a></li>
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
								<img class="img-thumbnail" src="imagenes/clientes/sinimagen.jpeg" style="border-radius: 50%; height: 100px; width: 100px"/>
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
										<span class="text-muted">Empresa: </span>${empresa}<br><br>
										<span class="text-muted"><a href="<%=(String) request.getAttribute("webempresa")%>"></a>Web: </span>${webempresa}<br><br>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!--Servicios-->
					<div role="tabpanel" class="tab-pane" id="servicios">
						<% if (request.getAttribute("servicios") != null) {%>
						<div class="panel-group" id="accordionServicios">
							<%
								int i = 0;
								Map<DtServicio, String> servicios = (Map<DtServicio, String>) request.getAttribute("servicios");
								for (Entry<DtServicio, String> entry : servicios.entrySet()) {
									DtServicio servicio = entry.getKey();
									i++;
							%>
							<div class="accordion-group">
								<div class="panel">
									<div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionServicios" href="#s<%=i%>">
										<h4 class="panel-title">
											<%= servicio.getIdServicio()%>
										</h4>
									</div>
									<div id="s<%=i%>" class="panel-collapse collapse">
										<div class="panel-body">
											<%=entry.getValue().replace("\n", "<br>")%>
										</div>
										<form action="VerServicio" class="navbar-form">
											<div class="input-group">
												<input type="text" name="idServicio" value="<%=servicio.getIdServicio()%>" style="display: none">
												<input type="text" name="idProveedor" value="<%=servicio.getNicknameProveedor()%>" style="display: none">
												<button class="btn btn-info" type="submit">Ir a Servicio</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<%
								}
							%>
						</div>
						<% } else { %>
						<p> El proveedor no tiene servicios asociados </p>
						<%
							}
						%>
					</div>

					<!--Promociones-->
					<div role="tabpanel" class="tab-pane" id="promociones">
						<% if (request.getAttribute("promociones") != null) {%>
						<div class="panel-group" id="accordionPromociones">
							<%
								int i = 0;

								Map<DtPromocion, String> promociones = (Map<DtPromocion, String>) request.getAttribute("promociones");
								for (Entry<DtPromocion, String> entry : promociones.entrySet()) {
									DtPromocion promocion = entry.getKey();
									i++;
							%>
							<div class="accordion-group">
								<div class="panel">
									<div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionPromociones" href="#p<%=i%>">
										<h4 class="panel-title">
											<%= promocion.getIdPromocion()%>
										</h4>
									</div>
									<div id="p<%=i%>" class="panel-collapse collapse">
										<div class="panel-body">
											<%=entry.getValue().replace("\n", "<br>")%>
										</div>
										<form action="VerPromocion" class="navbar-form">
											<div class="input-group">
												<input type="text" name="idPromocion" value="<%=promocion.getIdPromocion()%>" style="display: none">
												<input type="text" name="idProveedor" value="<%=promocion.getNicknameProveedor()%>" style="display: none">
												<button class="btn btn-info" type="submit">Ir a Promoción</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<%
								}
							%>
						</div>
						<% } else { %>
						<p> El proveedor no tiene promociones asociadas </p>
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
