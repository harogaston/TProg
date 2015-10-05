<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page import="tprog.logica.dt.DTProveedor"%>
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
					<li role="presentation"><a href="#servicios" aria-controls="servicios" role="tab" data-toggle="tab">Servicios</a></li>
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
								<img class="img-thumbnail" src="imagenes/clientes/sinimagen.jpeg" style="border-radius: 50%"/>
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
								Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
								for (DTMinServicio dt : servicios) {
									Fabrica f = Fabrica.getInstance();
									ICtrlProductos ctrlProductos = f.getICtrlProductos();
									ctrlProductos.seleccionarServicio(dt);
									DTServicio servicio = ctrlProductos.infoServicio();
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
											<%=servicio.toString().replace("\n", "<br>")%>
										</div>
										<form action="VerServicio" class="navbar-form">
											<div class="input-group">
												<input type="text" name="idServicio" value="<%=dt.getIdServicio()%>" style="display: none">
												<input type="text" name="idProveedor" value="<%=dt.getNicknameP()%>" style="display: none">
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
				</div>
			</div>
		</div>
	</body>
	<!-- ACÁ includes de .js que se requieran en ESTA página  -->
	<%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>
