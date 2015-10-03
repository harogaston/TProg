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
    </header>
    <body>
		<!-- MENSAJE SI SE GENERÓ UNA RESERVA-->
		<%if (request.getSession().getAttribute("reservaGenerada") != null && request.getSession().getAttribute("reservaGenerada").equals("OK")) {%>
		<script type="text/javascript">
			$(window).load(function () {
				$('#myModal').modal('show');
			});
		</script>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" style="text-align: center;">
			<div class="modal-dialog" style="vertical-align: middle;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-center">Reserva generada con éxito</h4>
					</div>
					<div class="modal-body">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
					</div>
				</div>

			</div>
		</div>
		<%
				request.getSession().setAttribute("reservaGenerada", null);
			}
		%>

		<!-- MENSAJE SI SE INTENTÓ ENTRAR A UNA CUENTA NO REGISTRADA -->
		<%if (request.getSession().getAttribute("inicioIncorrecto") != null) {%>
		<script type="text/javascript">
			$(window).load(function () {
				$('#myModal').modal('show');
			});
		</script>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" style="text-align: center;">
			<div class="modal-dialog" style="vertical-align: middle;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-center">Credenciales incorrectas</h4>
					</div>
					<div class="modal-body">
						<%=request.getSession().getAttribute("inicioIncorrecto")%>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
					</div>
				</div>

			</div>
		</div>
		<%
				request.getSession().setAttribute("inicioIncorrecto", null);
			}
		%>

        <div class="container">
			<div class="row">

                <!-- JSTREE -->
                <div class=" wrapper col-md-3">
                    <div class="row" style="padding-left: 20px; padding-right: 20px">
                        <!-- con el siguiente div se crea el arbol de categorias, con la data que se generó en el servlet -->
                        <div id="arbol_categorias"></div>
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
				
				<!--Espacio entre containers-->
				<div class="col-md-1" style="width: 50px">
				</div>

				<div class="wrapper col-md-8">
					<div class="row">
						<div class="col-md-12">
							<form action="Buscar" id="criterio_busqueda" role="form" method="POST">
								<div class="btn-group pull-right" data-toggle="buttons">
									<%if (request.getAttribute("tipo_orden") != null && ((String) request.getAttribute("tipo_orden")).equals("alfabetico")) {%>
									<label id="btn_alfabetico" class="btn btn-default active">
										<input type="radio" name="alfabetico" id="alfabetico" autocomplete="off" checked>A-Z
									</label>
									<label id="btn_precio" class="btn btn-default">
										<input type="radio" name="precio" id="precio" autocomplete="off">Precio
									</label>
									<%} else if (request.getAttribute("tipo_orden") != null && ((String) request.getAttribute("tipo_orden")).equals("precio")) {%>
									<label id="btn_alfabetico" class="btn btn-default">
										<input type="radio" name="alfabetico" id="alfabetico" autocomplete="off">A-Z
									</label>
									<label id="btn_precio" class="btn btn-default active">
										<input type="radio" name="precio" id="precio" autocomplete="off" checked>Precio
									</label>
									<%} else {%>
									<label id="btn_alfabetico" class="btn btn-default">
										<input type="radio" name="alfabetico" id="alfabetico" autocomplete="off">A-Z
									</label>
									<label id="btn_precio" class="btn btn-default">
										<input type="radio" name="precio" id="precio" autocomplete="off">Precio
									</label>
									<%}%>
								</div>
								<input name="busquedaPrevia" value="<%=(String) request.getAttribute("busquedaPrevia")%>" style="visibility: hidden">
								<input name="seleccionPrevia" value="<%=(String) request.getAttribute("categoriaPrevia")%>" style="visibility: hidden">
								<input id="tipo_orden" name="tipo_orden" style="visibility: hidden">
							</form>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<h2 class="text-center">Servicios:</h2>
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
											<h4 class="panel-title text-center">
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

							<h2 class="text-center">Promociones:</h2>

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
											<h4 class="panel-title text-center">
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
		arbol.jstree(true)._open_to('#<%=(String) request.getAttribute("categoriaPrevia")%>');
	});

	//cuando se clickea algún elemento del árbol, se muestran todos los servicios asociados (y ninguna promoción)
	$('#arbol_categorias').on('activate_node.jstree', function () {
		document.getElementById('categoriaSeleccionada').value = $('.jstree-clicked').text();
		document.getElementById('ver_servicios_form').submit(); //mando la form para actualizar la lista de servicios
	});

	$('#btn_alfabetico').on('click', function () {
		document.getElementById('tipo_orden').value = "alfabetico";
		document.getElementById('criterio_busqueda').submit();
	});
	$('#btn_precio').on('click', function () {
		document.getElementById('tipo_orden').value = "precio";
		document.getElementById('criterio_busqueda').submit();
	});

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