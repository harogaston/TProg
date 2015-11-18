<%@page import="java.util.List"%>
<%@page import="webservice.DtServicio"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Set"%>

<!doctype html>
<html>
    <head>
        <%@include file="/pages/templates/head.jspf" %>
        <!-- ACÁ se puede especificar el título de ESTA jsp de la siguiente forma:
                        <title>El título</title>
        -->
        <!-- ACÁ includes de .js que se requieran en ESTA página  -->
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/bootstrap-datepicker.es.min.js"></script>
    </head>
    <header>
        <%@include file="/pages/templates/header.jsp" %>
        <!-- ACA .css que se requieran en esta jsp -->
		<link rel="stylesheet" href="css/bootstrap-datepicker3.css">
    </header>
    <body>
        <%			//obtengo el atributo de info servicio para usar en toda la página
			DtServicio infoServicio = (DtServicio) request.getAttribute("infoServicio");
			String idProveedor = (String) request.getAttribute("idProveedor");
			List< String> imagenes = infoServicio.getImagenes();
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
                            <div class="panel-body">
                                <span class="text-muted">Proveedor </span> <%=idProveedor%><br><br>
								<span class="text-muted">Precio unitario: </span> $<%=Float.toString(infoServicio.getPrecio())%>		
                            </div>	
									
										
                            <div class="panel-body">	
									<span class="text-muted">Origen </span> 
										
										<%
											webservice.PublicadorService service = new webservice.PublicadorService();
											webservice.Publicador proxy = service.getPublicadorPort();
										%>
										<%=proxy.toString(infoServicio.getOrigen())%>
                                        <%String origenSafe = URLEncoder.encode(infoServicio.getOrigen().getCiudad(), "UTF-8");%><br>
											<img src="http://maps.googleapis.com/maps/api/staticmap?center=<%=origenSafe%>
												 &zoom=2&scale=1&size=100x100&maptype=terrain&format=png&visual_refresh=true&markers=size:small%7Ccolor:0xff0000%7Clabel:0%7C
												 <%=origenSafe%>" alt="Google Map of caracas" style="padding-top: 10px;">
										
                            </div>
                                                 
									<%if (infoServicio.getDestino() != null) {%>
                                    <div class="pane-body">
									
										<span class="text-muted">Destino </span> 
										<%=proxy.toString(infoServicio.getDestino())%>
                                        <%String destinoSafe = URLEncoder.encode(infoServicio.getDestino().getCiudad(), "UTF-8");%><br>
											<img src="http://maps.googleapis.com/maps/api/staticmap?center=<%=destinoSafe%>
												 &zoom=2&scale=1&size=100x100&maptype=terrain&format=png&visual_refresh=true&markers=size:small%7Ccolor:0xff0000%7Clabel:0%7C
												 <%=destinoSafe%>" alt="Google Map of caracas"  style="padding-top: 10px;">
										
                                    </div>
									<%}%>
                                
                            
                        </div>
                    </div>

                </div>


                <!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
                <div class="col-md-8">
                    <h4><%=infoServicio.getIdServicio()%></h4>
                    <p><h5>Descripción</h5> <%=infoServicio.getDescripcion()%></p>

                    

					<h5>Categorías</h5>
                    <%Set<String> categorias = (Set<String>) request.getAttribute("categorias");
						int i = 0;
						for (String categoria : categorias) {
							i++;
                    %>
					
						<h6><a style="text-decoration: none" onclick="document.getElementById('myform<%=i%>').submit()"><span class="label label-warning"><%=categoria%></span></a></h6>
						<input name="categoriaSeleccionada" value="<%=categoria%>" style="display: none">
					
					<%}%>
                </div>
            </div>
        </div>
    </body>
    <%@include file="/pages/templates/footer.jspf" %>
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
