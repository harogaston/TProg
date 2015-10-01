<%@page import="java.lang.String"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTServicio"%>

<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ se puede especificar el título de ESTA jsp de la siguiente forma:
                        <title>El título</title>
        -->
        <!-- ACÁ includes de .js que se requieran en ESTA página  -->
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/bootstrap-datepicker.es.min.js"></script>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
        <!-- ACA .css que se requieran en esta jsp -->
		<link rel="stylesheet" href="css/bootstrap-datepicker3.css">
    </header>
    <body>
        <%
			//obtengo el atributo de info servicio para usar en toda la página
			DTServicio infoServicio = (DTServicio) request.getAttribute("infoServicio");
			String idProveedor = (String) request.getAttribute("idProveedor");
			Set< String> imagenes = infoServicio.getImagenes();
        %>
        <div class="container">
            <div class="row">
                <!-- Parte izquierda imágenes, origen, destino, proveedor, etc -->
                <div class="col-md-4">
                    <div id="myCarousel" class="carousel slide" style="margin-bottom: 30px">
                        <%if (!imagenes.isEmpty()) {%>
                        <ol class="carousel-indicators">
                            <%
								int i = 0;
								for (String imagen : imagenes) {%>
                            <li class="" data-target="#myCarousel" data-slide-to="<%=i%>"></li>
                                <%
										i++;
									}%>
                        </ol>
                        <div class="carousel-inner">
                            <%
								int contador = 1;
								for (String imagen : imagenes) {
									if (contador == 1) {%>
                            <div class="item active">
                                <%} else {%>
                                <div class="item">
                                    <%}%>
                                    <img src="<%=imagen%>" alt="">
                                </div>
                                <%
										contador++;
									}%>
                            </div>
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">?</a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">?</a>
                        </div>
                        <%} else {%>
                        <ol class="carousel-indicators">
                            <li class="" data-target="#myCarousel" data-slide-to="<%=0%>"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="imagenes/sinimagen.jpeg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">?</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">?</a>
                    </div>
                    <%}%>

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
                                        <td>Origen</td>
                                        <td><%=infoServicio.getOrigen().toString()%></td>
                                    </tr>
                                    <%if (infoServicio.getDestino() != null) {%>
                                    <tr>
                                        <td>Destino</td>
                                        <td><%=infoServicio.getDestino().toString()%></td>
                                    </tr>
                                    <%}%>
                                    <tr>
                                        <td>Precio</td>
                                        <td>$<%=Float.toString(infoServicio.getPrecio())%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>


                <!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
                <div class="col-md-8">
                    <h1><%=infoServicio.getIdServicio()%></h1>
                    <p><h3>Descripción</h3> <%=infoServicio.getDescripcion()%></p>
				
                    <!--Solo se muestra agregar al carrito si estoy logueado-->
                    <%
						if (session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) {
                    %>
                    <form action= "Carrito" method="POST">
                        <input type="number" name="cantidad" value="1" min="1" max="99" style="width: 60px">
						<button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</button>
						<input type="text" name="idServicio" value="<%=infoServicio.getIdServicio()%>" style="visibility: hidden">
						<input type="text" name="idProveedor" value="<%=idProveedor%>" style="visibility: hidden">
                        
						<p style="padding-top: 20px">Fechas</p>
						<div class="input-daterange input-group input-sm" id="datepicker" style="width: 10%">
							<input type="text" class="input-sm form-control" name="inicio" style="width: 100px"/>
							<span class="input-group-addon">hasta</span>
							<input type="text" class="input-sm form-control" name="fin" style="width: 100px"/>
						</div>
					</form>

                    <%}%>

					<h3>Categorías</h3>
                    <%Set<String> categorias = (Set<String>) request.getAttribute("categorias");
						for (String categoria : categorias) {

                    %>
                    <h5 style="display: inline-block"><span class="label label-info"><%=categoria%></span></h5>
                        <%}%>
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

<!--Para las fechas-->
<script>
	$('#datepicker').datepicker({
		format: "dd/mm/yyyy",
		language: "es",
		orientation: "top auto",
		autoclose: true
	});
</script>
