<%@page import="java.net.URL"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>
<%@page import="webservice.DtServicio"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Set"%>

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
        <%			//obtengo el atributo de info servicio para usar en toda la página
			DtServicio infoServicio = (DtServicio) request.getAttribute("infoServicio");
			String idProveedor = (String) request.getAttribute("idProveedor");
			List< String> imagenes = (List<String>) request.getAttribute("imagenes");
        %>
        <div class="container wrapper">
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
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev"><</a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">></a>
                        </div>
                        <%} else {%>
                        <ol class="carousel-indicators">
                            <li class="" data-target="#myCarousel" data-slide-to="<%=0%>"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="imagenes/sinimagen.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev"><</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">></a>
                    </div>
                    <%}%>

                    <!-- Panel para la información detallada -->
                    <div class="panel panel-default" style="margin-bottom: 0px">
                        <div class="panel-heading">
                            <h3 class="panel-title">Detalle</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover" style="margin-bottom: 0px">
                                <tbody>
                                    <tr>
                                        <td>Proveedor</td>
										<td>
											<form action="VerInfoProveedor" method="POST">
												<button type="submit" class="btn btn-link"><%=idProveedor%></button>
												<input name="idProveedor" value="<%=idProveedor%>" style="display: none">
											</form>
										</td>
									</tr>
									<tr>
										<td>Precio</td>
										<td>$<%=Float.toString(infoServicio.getPrecio())%></td>
									</tr>
									<tr>
										<td>Origen</td>
										<%
											Properties properties = new Properties();
											String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
											FileInputStream file = new FileInputStream(ruta);
											properties.load(file);
											file.close();
											URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
											webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
											webservice.Publicador proxy = service.getPublicadorPort();
										%>
										<td><%=proxy.toString(infoServicio.getOrigen())%>
											<%String origenSafe = URLEncoder.encode(infoServicio.getOrigen().getCiudad(), "UTF-8");%>
											<img src="http://maps.googleapis.com/maps/api/staticmap?center=<%=origenSafe%>
												 &zoom=2&scale=1&size=100x100&maptype=terrain&format=png&visual_refresh=true&markers=size:small%7Ccolor:0xff0000%7Clabel:0%7C
												 <%=origenSafe%>" alt="Google Map of caracas" style="padding-top: 10px;">
										</td>
									</tr>
									<%if (infoServicio.getDestino() != null) {%>
									<tr>
										<td>Destino</td>
										<td><%=proxy.toString(infoServicio.getDestino())%>
											<%String destinoSafe = URLEncoder.encode(infoServicio.getDestino().getCiudad(), "UTF-8");%>
											<img src="http://maps.googleapis.com/maps/api/staticmap?center=<%=destinoSafe%>
												 &zoom=2&scale=1&size=100x100&maptype=terrain&format=png&visual_refresh=true&markers=size:small%7Ccolor:0xff0000%7Clabel:0%7C
												 <%=destinoSafe%>" alt="Google Map of caracas"  style="padding-top: 10px;">
										</td>
									</tr>
									<%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>


                <!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
                <div class="col-md-8">
                    <h1><%=infoServicio.getIdServicio()%></h1>
                    <p><h3>Descripción</h3> <%=infoServicio.getDescripcion()%></p>

                    <!--Solo se muestra agregar al carrito si estoy logueado como cliente-->
                    <%
						if (session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN
								&& session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
                    %>
                    <form action= "Carrito" method="POST">
                        <input type="number" name="cantidad" value="1" min="1" max="99" style="width: 60px">
						<button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</button>
						<input type="text" name="idServicio" value="<%=infoServicio.getIdServicio()%>" style="display: none">
						<input type="text" name="idProveedor" value="<%=idProveedor%>" style="display: none">

                        <!-- SECCION DE FECHAS -->
						<p style="padding-top: 20px">Fechas</p>
						<div class="input-daterange input-group input-sm" id="datepicker" style="width: 10%">
							<input type="text" class="input-sm form-control" name="inicio" value="07/10/2015" style="width: 100px"/>
							<span class="input-group-addon">hasta</span>
							<input type="text" class="input-sm form-control" name="fin" value="07/10/2015" style="width: 100px"/>
						</div>
					</form>

                    <%}%>

					<h3>Categorías</h3>
                    <%Set<String> categorias = (Set<String>) request.getAttribute("categorias");
						int i = 0;
						for (String categoria : categorias) {
							i++;
                    %>
					<form action="Buscar" id="myform<%=i%>" method="POST" style="display: inline-block">
						<h4><a href="#" style="text-decoration: none" onclick="document.getElementById('myform<%=i%>').submit()"><span class="label label-warning"><%=categoria%></span></a></h4>
						<input name="categoriaSeleccionada" value="<%=categoria%>" style="display: none">
					</form>
					<%}%>
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
