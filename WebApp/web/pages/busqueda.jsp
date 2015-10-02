<%@page import="tprog.logica.dt.DTPromocion"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page import="tprog.logica.dt.DTMinPromocion"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>

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

		<link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
		<script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
		<script>
			$(function () {
				$("#dialog-message").dialog({
					modal: true,
					buttons: {
						Ok: function () {
							$(this).dialog("close");
						}
					}
				});
			});
		</script>

    </header>

    <body>
        <div class="container wrapper">

			<!-- MENSAJE SI SE GENERÓ UNA RESERVA-->

			<%			if (request.getSession().getAttribute("reservaGenerada") != null) {
			%>
			<div id="dialog-message" title="Reserva realizada">
				<p><%=(String) request.getSession().getAttribute("reservaGenerada")%></p>
			</div>
			<%
					request.getSession().setAttribute("reservaGenerada", null);
				}
			%>








            <div class="row">

                <!-- JSTREE -->
                <div class="col-md-4">
                    <div class="row">
                        <!--
                        con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet
                        -->
                        <div id="arbol_categorias" style="padding-top: 50px; overflow: scroll; min-height: 30vh; max-height: 70vh"></div>
                    </div>
                </div>
                <!--
                En la siguiente form oculta, se va a guardar el nombre de la categoria seleccionada,
                para que siempre que cambie se recargue la página y se muestren los servicios asociados
                a la categoría
                -->
                <form action= "Buscar" id="ver_servicios_form" class="form-inline" role="form" method="POST">
                    <input type="text" name="categoriaSeleccionada" id="categoriaSeleccionada" style="display: none">
                </form>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12">
							<form action="Buscar" id="criterio_busqueda" role="form" method="POST">
								<div class="btn-group pull-right" data-toggle="buttons">
									<!-- Determino qué botón dejar apretado, de acuerdo a si se ordenó por precio o A-Z -->
									<%if (request.getAttribute("precio") != null && ((String) request.getAttribute("precio")).equals("1")) {%>
									<label class="btn btn-default">
										<input   type = "radio" name = "ordenamiento" value = "alfabetico" autocomplete = "off" > A - Z
									</label>
									<label class="btn btn-default active">
										<input type="radio" name="ordenamiento" value="precio" autocomplete="off" checked>Precio
									</label>
									<%		} else {%>
									<label class="btn btn-default active">
										<input   type = "radio" name = "ordenamiento" value = "alfabetico" autocomplete = "off" checked> A - Z
									</label>
									<label class="btn btn-default">
										<input type="radio" name="ordenamiento" value="precio" autocomplete="off">Precio
									</label>
									<%}%>
								</div>
								<input name="busqueda" value="<%=(String) request.getAttribute("busquedaPrevia")%>" style="visibility: hidden">
								<input id="tipo_orden" name="tipo_orden" style="visibility: hidden">
							</form>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h2>Servicios:</h2>
							<%	Set<DTServicio> servicios = (Set<DTServicio>) request.getAttribute("servicios");
								if (!servicios.isEmpty()) {
							%>
							<div class="panel-group" id="accordionServicios">
								<%
									int i = 0;
									for (DTServicio servicio : servicios) {
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
												<form action="VerInfoProveedor" method="POST">
													<button type="submit" class="btn btn-link">Proveedor: <%=servicio.getNicknameProveedor()%></button>
													<input name="idProveedor" value="<%=servicio.getNicknameProveedor()%>" style="visibility: hidden">
												</form>
											</div>
											<form action="VerServicio" class="navbar-form">
												<div class="input-group">
													<input type="text" name="idServicio" value="<%=servicio.getIdServicio()%>" style="visibility: hidden">
													<input type="text" name="idProveedor" value="<%=servicio.getNicknameProveedor()%>" style="visibility: hidden">
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
							<p> No hay servicios para esa búsqueda </p>
							<%
								}
							%>

						</div>
						<div class="col-md-6">

							<h2>Promociones:</h2>

							<%	Set<DTPromocion> promociones = (Set<DTPromocion>) request.getAttribute("promociones");
								if (!promociones.isEmpty()) {
							%>
							<div class="panel-group" id="accordionPromociones">
								<%
									int j = 0;
									for (DTPromocion promocion : promociones) {
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
												<form action="VerInfoProveedor" method="POST">
													<button type="submit" class="btn btn-link">Proveedor: <%=promocion.getNicknameProveedor()%></button>
													<input name="idProveedor" value="<%=promocion.getNicknameProveedor()%>" style="visibility: hidden">
												</form>
											</div>
											<form action="VerPromocion" class="navbar-form">
												<div class="input-group">
													<input type="text" name="idPromocion" value="<%=promocion.getIdPromocion()%>" style="visibility: hidden">
													<input type="text" name="idProveedor" value="<%=promocion.getNicknameProveedor()%>" style="visibility: hidden">
													<button class="btn btn-info" type="submit">Ir a Promocion</button>
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
							<p> No hay promociones para esa búsqueda </p>
							<%
								}
							%>
						</div>
					</div>
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
		arbol.jstree(true)._open_to('#<%=(String) request.getAttribute("seleccionPrevia")%>');
	});

	//cuando se clickea algún elemento del árbol, se muestran todos los servicios asociados (y ninguna promoción)
	$('#arbol_categorias').on('activate_node.jstree', function () {
		document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
		document.getElementById('ver_servicios_form').submit(); //mando la form para actualizar la lista de servicios
	});

	$('#criterio_busqueda').change(function () {
		var radios = document.getElementsByName('ordenamiento');
		for (var i = 0, length = radios.length; i < length; i++) {
			if (radios[i].checked) {
				var inputOrdenamiento = document.getElementById('tipo_orden');
				inputOrdenamiento.value = radios[i].value;
				this.submit();
				break;
			}
		}

	});

</script>