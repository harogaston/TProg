<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collection"%>
<%@page import="webservice.DtPromocion"%>
<%@page import="webservice.DtServicio"%>
<%@page import="java.util.Set"%>

<!doctype html>
<html>
    <head>
        <%@include file="/pages/templates/head.jspf" %>
        <title>Tus servicios</title>
        <script src="js/vakata-jstree/dist/jstree.min.js"></script>
    </head>
    <header>
        <%@include file="/pages/templates/header.jsp" %>
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css">
    </header>
    <body>


        <div class="container">
			<div class="row">

				<!--Espacio entre containers-->
				<div class="col-md-1">
				</div>

				<div class="wrapper col-md-12">
					<div class="row">
						<h2 class="text-center">Servicios</h2>
						<%								Map<DtServicio, String> servicios = (Map<DtServicio, String>) request.getAttribute("servicios");
							int i = 0;
							if (!servicios.isEmpty()) {
						%>
						<div class="panel-group" id="accordionServicios">
							<%
								for (Entry<DtServicio, String> entry : servicios.entrySet()) {
									DtServicio servicio = entry.getKey();
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
						<p class="text-center"> No hay servicios aún</p>
						<%
							}
						%>
					</div>
                </div>
            </div>
        </div>
    </body>
    <%@include file="/pages/templates/footer.jspf" %>
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