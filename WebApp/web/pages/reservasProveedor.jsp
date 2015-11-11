<%@page import="java.util.List"%>
<%@page import="webservice.WrapperVerPerfilCliente"%>
<%@page import="webservice.DtLineaReserva"%>
<%@page import="webservice.DtReserva"%>
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


            <!--Reservas-->
            <div role="tabpanel" class="tab-pane" id="reservas">
                <% if (request.getAttribute("reservas") != null) {%>
                <div class="panel-group" id="accordionReservas">
                    <%	int i = 0;
                        
                        for (WrapperVerPerfilCliente wrapper : (Set<WrapperVerPerfilCliente>) request.getAttribute("reservas")) {

                            for (DtReserva dtR : wrapper.getReservas()) {
                                i++;


                    %>
                    <div class="accordion-group">
                        <div class="panel panel-warning">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordionReservas" href="#s<%=i%>">
                                <h4 class="panel-title">
                                    Reserva #<%=dtR.getIdReserva()%>

                                </h4>
                            </div>
                            <div id="s<%=i%>" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <span class="text-muted">Estado: </span> <%=dtR.getEstado().value()%><br>
                                    <span class="text-muted">Cliente: </span> <%=wrapper.getCliente().getNickname()%><br>
                                    <%
                                        String fCreacion = Integer.toString(dtR.getFCreacion().getDay()) + "-"
                                                + Integer.toString(dtR.getFCreacion().getMonth() + 1) + "-"
                                                + Integer.toString(dtR.getFCreacion().getYear()) + "\n";
                                    %>
                                    <span class="text-muted">Fecha de Creación: </span><%=fCreacion%><br>
                                    <span class="text-muted">Precio Total: </span><%=dtR.getPrecioTotal()%><br>

                                    <div class="panel-heading">Detalle de la reserva</div>
                                    <%	float subtotal = 0;
                                        List<DtLineaReserva> lineas = dtR.getLineasReserva();
                                    %>
                                    <!-- Tabla -->
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Item</th>
                                                <th>Tipo</th>
                                                <th>Descripción</th>
                                                <th>Precio unitario</th>
                                                <th>Cantidad</th>
                                                <th>Subtotal</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%	int j = 0;
                                                for (DtLineaReserva linea : lineas) {
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
                                                <td>$<%=linea.getPrecio()%></td>
                                                <td><%=linea.getCantidad()%></td>
                                                <td>$<%=(linea.getPrecio() * linea.getCantidad())%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                    <div class="panel-footer text-right" style="font-weight: bold">
                                        <div>Total $<%=subtotal%></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                                }
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

    </body><%@include file="templates/footer.jspf" %>
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