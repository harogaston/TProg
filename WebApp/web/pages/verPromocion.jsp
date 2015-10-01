<%@page import="java.util.Map.Entry"%>
<%@page import="tprog.logica.interfaces.Fabrica"%>
<%@page import="tprog.logica.interfaces.ICtrlProductos"%>
<%@page import="java.util.Map"%>
<%@page import="tprog.logica.dt.DTMinServicio"%>
<%@page import="tprog.logica.dt.DTPromocion"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTServicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ se puede especificar el título de ESTA jsp de la siguiente forma:
                        <title>El título</title>
        -->
        <!-- ACÁ includes de .js que se requieran en ESTA página  -->
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
        <!-- ACA .css que se requieran en esta jsp
                (sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
        -->
    </header>
    <body>
        <%
            //obtengo el atributo de info servicio para usar en toda la página
            DTPromocion infoPromocion = (DTPromocion) request.getAttribute("infoPromocion");
            String idProveedor = (String) request.getAttribute("idProveedor");
            Map<DTMinServicio, Integer> servicios = (Map<DTMinServicio, Integer>) request.getAttribute("servicios");
        %>
        <div class="container">
            <div class="row">
                <!-- Parte izquierda imágenes, origen, destino, proveedor, etc -->
                <div class="col-md-4">
                    <div id="myCarousel" class="carousel slide" style="margin-bottom: 30px">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="imagenes/sinimagen.jpeg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                    </div>

                    <!-- Panel para la información detallada -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Detalle</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <tbody>
                                    <tr>
                                        <td>Proveedor</td>
                                        <td><%=idProveedor%></td>
                                    </tr>
                                    <tr>
                                        <td>Descuento</td>
                                        <td><%=Float.toString(infoPromocion.getDescuento())%>%</td>
                                    </tr>
                                    <tr>
                                        <td>Precio Total</td>
                                        <td>$<%=Float.toString(infoPromocion.getTotal())%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>


                <!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
                <div class="col-md-8">
                    <h1><%=infoPromocion.getIdPromocion()%></h1>
                    <form action= "VerReservaActual" method="POST">
                        <input type="number" name="quantity" min="1" max="99" style="width: 60px">
                        <button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</button>
                    </form>


                    <h3>Servicios:</h3>
                    <div class="panel-group" id="accordionServicios">
                        <%
                            int i = 0;

                            for (Map.Entry<DTMinServicio, Integer> nodo : servicios.entrySet()) {
//                                System.out.println(nodo.getKey() + "/" + nodo.getValue());
                                Fabrica f = Fabrica.getInstance();
                                ICtrlProductos ctrlProductos = f.getICtrlProductos();
                                ctrlProductos.seleccionarServicio(nodo.getKey());
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
                                        <p>Cantidad: <%=nodo.getValue()%></p>
                                        <p><%=servicio.toString().replace("\n", "<br>")%></p>
                                    </div>
                                    <form action="VerServicio" class="navbar-form">
                                        <div class="input-group">
                                            <input type="text" name="idServicio" value="<%=servicio.getIdServicio()%>" style="visibility: hidden">
                                            <input type="text" name="idProveedor" value="<%=nodo.getKey().getNicknameP()%>" style="visibility: hidden">
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


                    <!--
                    <div class="accordion" id="accordion2">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                    Collapsible Group Item #1
                                </a>
                            </div>
                            <div id="collapseOne" class="accordion-body collapse in">
                                <div class="accordion-inner">
                                    Anim pariatur cliche...
                                </div>
                            </div>
                        </div>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                                    Collapsible Group Item #2
                                </a>
                            </div>
                            <div id="collapseTwo" class="accordion-body collapse">
                                <div class="accordion-inner">
                                    Anim pariatur cliche...
                                </div>
                            </div>
                        </div>
                    </div>
                    -->
                </div>
            </div>
        </div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>