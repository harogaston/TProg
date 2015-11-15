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
						<h2 class="text-center">Promociones</h2>

						<%								Map<DtPromocion, String> promociones = (Map<DtPromocion, String>) request.getAttribute("promociones");
							if (!promociones.isEmpty()) {
						%>
						<div class="panel-group" id="accordionPromociones">
							<%
								int j = 0;
								for (Entry<DtPromocion, String> entry : promociones.entrySet()) {
									DtPromocion promocion = entry.getKey();
									j++;
							%>
							<div class="accordion-group">
								<div class="panel">
									<div class="panel-heading promocion" data-toggle="collapse" data-parent="#accordionPromociones" href="#p<%=j%>">
										<h4 class="panel-title text-center">
											<span><%= promocion.getIdPromocion()%></span> <span class="badge"><%=Math.round(promocion.getDescuento())%>%</span>
										</h4>
									</div>
									<div id="p<%=j%>" class="panel-collapse collapse">
										<div class="panel-body">
											<%=entry.getValue().replace("\n", "<br>")%>
										</div>
										<form action="VerPromocion" class="navbar-form">
											<div class="input-group">
												<input type="text" name="idPromocion" value="<%=promocion.getIdPromocion()%>" style="display: none">
												<input type="text" name="idProveedor" value="<%=promocion.getNicknameProveedor()%>" style="display: none">
												<button class="btn promocion" type="submit"><span style="color: white">Ir a Promocion</span></button>
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
						<p class="text-center"> No hay promociones aún</p>
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