<%-- 
    Document   : factura
    Created on : Nov 18, 2015, 10:25:01 PM
    Author     : User
--%>
<%@page import="webservice.DtPromocionF"%>
<%@page import="webservice.DtServicioF"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="webservice.DtFacturaF"%>;
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ el título de ESTA página
                        <title>El título</title>
        -->
        <!-- ACÁ .js que se requieran en ESTA página  -->
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
        <!-- ACÁ .css que se requieran en ESTA página -->
    </header>
    <body>

        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Detalles de la Factura</h3>
                </div>
                <div class="panel-body">
                    <%DtFacturaF dtf = (DtFacturaF) request.getAttribute("factura");
                    Set<DtServicioF> servicios = new HashSet(dtf.getServicios());
                    Set<DtPromocionF> promociones = new HashSet(dtf.getPromociones());%>
                    <span class="text-muted">Id de Reserva: </span> <%=Integer.toString(dtf.getIdReserva())%><br>
                    <span class="text-muted">Cliente: </span><%=(dtf.getNicknameCliente())%><br>
                    <span class="text-muted">Monto:  </span><%=Double.toString(dtf.getMonto())%><br>
                    <div class="panel panel-default">
                    <div class="panel-heading">Servicios</div>
                    <br>
                    <% if (!servicios.isEmpty()){ %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Proveedor</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <%	int j = 0;
                                for (DtServicioF servicio : servicios) {
                                    j++;
                                    
                            %>
                            <tr>
                                <th scope="row"><%=j%></th>
                                    
                               
                                <td><%=servicio.getNombre()%></td>
                               
                                <td><%=servicio.getCantidad()%></td>
                               
                                <td>$<%=servicio.getPrecio()%></td>
                                <td><%=servicio.getNicknameProveedor()%></td>
                                
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <%}%>
                    </div>
                    <div class="panel panel-default">    
                    <div class="panel-heading">Promociones</div>
                    <br>
                    <% if (!promociones.isEmpty()){ %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Proveedor</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <%	int i = 0;
                                for (DtPromocionF promocion : promociones) {
                                    i++;
                                    
                            %>
                            <tr>
                                <th scope="row"><%=i%></th>
                                    
                               
                                <td><%=promocion.getNombre()%></td>
                               
                                <td><%=promocion.getCantidad()%></td>
                               
                                <td>$<%=promocion.getPrecio()%></td>
                                <td><%=promocion.getNicknameProveedor()%></td>
                                
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <%}%>
                </div>
            </div>
        </div>

    </body>
    <%@include file="templates/footer.jspf" %>
</html>

