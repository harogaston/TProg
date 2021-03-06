<%@page import="webservice.WrapperReserva"%>
<%@page import="java.util.List"%>
<%@page import="webservice.WrapperVerPerfilCliente"%>
<%@page import="webservice.DtLineaReserva"%>
<%@page import="webservice.DtReserva"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>

<!doctype html>
<html>
    <head>
        <%@include file="/pages/templates/head.jspf" %>
        <!-- Ac� se puede especificar el t�tulo de ESTA jsp de la siguiente forma:
                        <title>El t�tulo</title>
        -->
    </head>
    <header>
        <%@include file="/pages/templates/header.jsp" %>
        <!-- ACA .css que se requieran en esta jsp
        (sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
        -->
    </header>
    <body>
        <div class="container wrapper" style="padding: 30px">


            <!--Reservas-->
            <div role="tabpanel" class="tab-pane" id="reservas">
                <% if (request.getAttribute("reservas") != null) {%>
                <div class="panel-group" id="accordionReservas">
                    <%	int i = 0;

						for (WrapperReserva wrapper : (List<WrapperReserva>) request.getAttribute("reservas")) {
							i++;
							DtReserva dtR = wrapper.getReserva();


                    %>
                    <div class="accordion-group">
                        <div class="panel panel-success">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordionReservas" id="acoRes" href="#s<%=i%>">
                                <h4 class="panel-title">
                                    Reserva #<%=dtR.getIdReserva()%>

                                </h4>
                            </div>
                            <div id="s<%=i%>" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <span class="text-muted">Estado: </span> <%=dtR.getEstado().value()%><br>
                                    <span class="text-muted">Cliente: </span> <%=wrapper.getNickCliente()%><br>
                                    <%
										String fCreacion = Integer.toString(dtR.getFCreacion().getDay()) + "-"
												+ Integer.toString(dtR.getFCreacion().getMonth() + 1) + "-"
												+ Integer.toString(dtR.getFCreacion().getYear()) + "\n";
                                    %>
                                    <span class="text-muted">Fecha de Creaci�n: </span><%=fCreacion%><br>
                                    <!--<span class="text-muted">Precio Total: </span><%=dtR.getPrecioTotal()%><br>-->
                                    <div class="panel-group" id=accordionLineas">
                                        <div class="accordion-group">
                                            <div class="panel panel-warning">
                                                <%	int w = 0;
													float subtotal = 0;
													List<DtLineaReserva> lineas = dtR.getLineasReserva();
													int j = 0;
													for (DtLineaReserva linea : lineas) {
														j++;
														subtotal += linea.getPrecio() * linea.getCantidad();
														w++;

                                                %>
                                                <div class="panel-heading" data-toggle="collapse" data-parent="#accordionLineas" href="#h<%=i%><%=j%>">
                                                    <h4 class="panel-title">
                                                        Item #<%=j%>
                                                    </h4>
                                                </div>
                                                <div id="h<%=i%><%=j%>" class="panel-collapse collapse">
                                                    <div class="panel-body">
                                                        <span class="text-muted">Tipo: </span> <% if (linea.getServicio() != null) {%> Servicio <%} else {%> Promoci�n <%} %><br>
                                                        <span class="text-muted">Descripcion: </span> <% if (linea.getServicio() != null) {%> <%=linea.getServicio()%> <%} else {%> <%=linea.getPromocion()%> <%}%> <br>
                                                        <span class="text-muted">Precio unitario: </span> $<%=linea.getPrecio()%><br>
                                                        <span class="text-muted">Cantidad: </span> <%=linea.getCantidad()%><br>
                                                        <span class="text-muted">Subtotal: </span> $<%=(linea.getPrecio() * linea.getCantidad())%><br>
                                                    </div>
                                                </div>
                                                <%
													}
                                                %>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer text-right" style="font-weight: bold">
                                    <div>Total $<%=subtotal%></div>
                                    <%if (dtR.getEstado().value().equals("Pagada")) {%>
                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal<%=String.valueOf(i)%>">
                                        <i class="glyphicon glyphicon-check"></i>
                                        <span style="font-weight: bold">Facturar</span>
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal<%=String.valueOf(i)%>" role="dialog" style="text-align: center">
                                        <div class="modal-dialog" style="vertical-align: middle;">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title text-center">Confirmar acci�n</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="FacturarReserva" method="GET">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
                                                        <button type="submit" class="btn btn-danger">S�, facturar</button>
                                                        <input type="number" name="idReserva" value="<%=dtR.getIdReserva()%>" style="display: none">
                                                        <input type="text" name="nickCliente" value="<%=wrapper.getNickCliente()%>" style="display: none">
                                                        <input type="text" name="emailCliente" value="<%=wrapper.getEmailCliente()%>" style="display: none">
                                                    </form>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
						}// cierra for
                    %>
                </div>
                <%  } else { %>
                <p> Usted no posee reservas </p>
                <%
					}
                %>
            </div>

        </div>

    </body><%@include file="/pages/templates/footer.jspf" %>
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