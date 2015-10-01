<%@page import="tprog.logica.dt.DTPromocion"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page import="tprog.logica.dt.DTMinPromocion"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <%@include file="templates/head.jspf" %>
        <title>Resultados de busqueda</title>
		<script>
			$(function () {
				$("#accordionServicios").accordion();
				$("#accordionPromociones").accordion();
			});
		</script>
		<script src="js/vakata-jstree/dist/jstree.min.js"></script>
		<script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
	</head>
	<header>
		<%@include file="templates/header.jsp" %>
		<link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
		<link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css">
	</header>

	<body>
		<div id="body_holder" style="visibility: hidden">
			<div class="container-fluid" style="padding: 10px; font-family: 'Alegreya Sans SC', sans-serif">
				<div class="row">
					<div class="col-lg-2"></div>
					<div class="col-lg-4">
						<h2>Servicios:</h2>

						<% Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
							if (!servicios.isEmpty()) {
						%>
						<div id="accordionServicios">
							<%
								for (DTMinServicio dt : servicios) {
									Fabrica f = Fabrica.getInstance();
									ICtrlProductos ctrlProductos = f.getICtrlProductos();
									ctrlProductos.seleccionarServicio(dt);
									DTServicio servicio = ctrlProductos.infoServicio();
							%>
							<h3><%= servicio.getIdServicio()%> </h3>
							<div>
								<%=servicio.toString().replace("\n", "<br>")%>
							</div>
							<%
								}
							%>
						</div>
						<%
						} else { %>
						<p> No hay servicios para esa búsqueda </p>
						<%
							}
						%>

					</div>
					<div class="col-lg-4">

						<h2>Promociones:</h2>

						<% Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
							if (!promociones.isEmpty()) {
						%>
						<div id="accordionPromociones">
							<%
								for (DTMinPromocion dt : promociones) {
									Fabrica f = Fabrica.getInstance();
									ICtrlProductos ctrlProductos = f.getICtrlProductos();
									ctrlProductos.seleccionarPromocion(dt);
									DTPromocion promocion = ctrlProductos.infoPromocion();
							%>
							<h3> <%= promocion.getIdPromocion()%> </h3>
							<div>
								<%=promocion.toString().replace("\n", "<br>")%>
							</div>
							<%
								}
							%>
						</div>
						<%
						} else {
						%>
						<p> No hay promociones para esa búsqueda </p>
						<%
							}
						%>
					</div>
					<div class="col-lg-2"></div>
				</div>
			</div>
		</div>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
<script>
			$(window).load(function () {
				//hago que la página interna (no header ni footer) se muestre cuando
				//este todo cargado, para evitar glitches random
				$("#body_holder").css("visibility", "visible");
			});
</script>