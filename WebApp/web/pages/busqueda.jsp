<%@page import="tprog.logica.dt.DTPromocion"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page import="tprog.logica.dt.DTMinPromocion"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <title>Resultados de busqueda</title>
        <script src="js/vakata-jstree/dist/jstree.min.js"></script>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css">
    </header>

    <body>
		<div class="container">
			<div class="row">

				<!-- JSTREE -->
				<div class="col-md-4">
					<div class="row">
						<p >Seleccione una categoría para filtrar los resultados de la búsqueda</p>
						<!--
						con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet
						-->
						<div id="arbol_categorias" style="padding-top: 50px; overflow: scroll; max-height: 70vh"></div>
					</div>
				</div>
				<!--
				En la siguiente form oculta, se va a guardar el nombre de la categoria seleccionada,
				para que siempre que cambie se recargue la página y se muestren los servicios asociados
				a la categoría
				-->
				<form action= "Buscar" id="ver_servicios_form" class="form-inline" role="form" method="POST">
					<input type="text" name="categoriaSeleccionada" id="categoriaSeleccionada" style="visibility: hidden">
				</form>

				<div class="col-md-4">
					<h2>Servicios:</h2>
					<% if (request.getAttribute("noHayServicios") != null
								&& !(boolean) request.getAttribute("noHayServicios")
								&& request.getAttribute("servicios") != null) {
							Set<DTMinServicio> servicios = (Set<DTMinServicio>) request.getAttribute("servicios");
							if (!servicios.isEmpty()) {
					%>
					<div class="panel-group" id="accordionServicios">
						<%
							int i = 0;
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
								</div>
							</div>
						</div>
						<%
							}
						%>
					</div>
					<%
						}
					} else { %>
					<p> No hay servicios para esa búsqueda </p>
					<%
						}
					%>

				</div>
				<div class="col-md-4">

					<h2>Promociones:</h2>

					<%if (request.getAttribute("mostrarPromociones") != null
								&& (boolean) request.getAttribute("mostrarPromociones")) {
							Set<DTMinPromocion> promociones = (Set<DTMinPromocion>) request.getAttribute("promociones");
					%>
					<div class="panel-group" id="accordionPromociones">
						<%
							int j = 0;
							for (DTMinPromocion dt : promociones) {
								Fabrica f = Fabrica.getInstance();
								ICtrlProductos ctrlProductos = f.getICtrlProductos();
								ctrlProductos.seleccionarPromocion(dt);
								DTPromocion promocion = ctrlProductos.infoPromocion();
								j++;
						%>
						<div class="accordion-group">
							<div class="panel">
								<div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionPromociones" href="#p<%=j%>">
									<h4 class="panel-title">
										<%= promocion.getIdPromocion()%>
									</h4>
								</div>
								<div id="p<%=j%>" class="panel-collapse collapse">
									<div class="panel-body">
										<%=promocion.toString().replace("\n", "<br>")%>
									</div>
								</div>
							</div>
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
			</div>
		</div>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>

<script>
	var arbolJSON = <%=request.getAttribute("arbolJson")%>;

	//creo jstree y sorteo nodos
	$.jstree.defaults.core.themes.icons = false;
	var arbol = $('#arbol_categorias').jstree({
		"plugins": ["sort"],
		'core': {
			'data': arbolJSON
		}
	});
	
	arbol.on('loaded.jstree', function () {
		//debería abrir la última categoría seleccionada
		arbol.jstree("open_node", '#Categorias');

	});

	//cuando se clickea algún elemento del árbol, se muestran todos los servicios asociados (y ninguna promoción)
	$('#arbol_categorias').on('activate_node.jstree', function () {
		document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
		document.getElementById('ver_servicios_form').submit(); //mando la form para actualizar la lista de servicios
	});
</script>