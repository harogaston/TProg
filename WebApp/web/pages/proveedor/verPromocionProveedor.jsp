<%@page import="java.net.URL"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@page import="webservice.DtPromocion"%>
<%@page import="webservice.DtMinServicio"%>
<%@page import="webservice.DtServicio"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
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
			DtPromocion infoPromocion = (DtPromocion) request.getAttribute("infoPromocion");
			String idProveedor = (String) request.getAttribute("idProveedor");
			Map<DtMinServicio, Integer> servicios = (Map<DtMinServicio, Integer>) request.getAttribute("servicios");
        %>
        <div class="container wrapper">
            <div class="row">
                <!-- Parte izquierda imágenes, origen, destino, proveedor, etc -->
                <div class="col-md-4">
                    <div id="myCarousel" class="carousel slide" style="margin-bottom: 30px">
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="imagenes/sinimagen.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev"><</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">></a>
                    </div>

                    <!-- Panel para la información detallada -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Detalle</h3>
                        </div>
                        <div class="panel-body">
                            <div class="panel-body">

								<span class="text-muted">Proveedor </span> <%=idProveedor%><br><br>

								<span class="text-muted">Descuento </span>
								<%=Float.toString(infoPromocion.getDescuento())%><br><br>


								<span class="text-muted">Precio Total </span>
								$<%=Float.toString(infoPromocion.getTotal())%>
								<br>
							</div>

                        </div>
                    </div>

                </div>


                <!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
                <div class="col-md-8">
                    <h4><%=infoPromocion.getIdPromocion()%></h4>
					<!--Solo se muestra agregar al carrito si estoy logueado como cliente-->
					<h6>Servicios:</h6>
                    <div class="panel-group" id="accordionServicios">
                        <%
							int i = 0;

							for (Map.Entry<DtMinServicio, Integer> nodo : servicios.entrySet()) {
//                                System.out.println(nodo.getKey() + "/" + nodo.getValue());
								Properties properties = new Properties();
								String ruta = System.getProperty("user.home") + "/.Help4Travel/config.properties";
								FileInputStream file = new FileInputStream(ruta);
								properties.load(file);
								file.close();
								URL wsdlLocation = new URL(properties.getProperty("publicador") + "?wsdl");
								webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
								webservice.Publicador proxy = service.getPublicadorPort();
								DtServicio servicio = proxy.seleccionarInfoServicio(nodo.getKey());
								i++;
                        %>
                        <div class="accordion-group">
                            <div class="panel">
                                <div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionServicios" href="#s<%=i%>">
                                    <h7 class="panel-title">
                                        <%= servicio.getIdServicio()%>
                                    </h7>
                                </div>
                                <div id="s<%=i%>" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <p>Cantidad: <%=nodo.getValue()%></p>
                                        <p><%=proxy.toString(servicio).replace("\n", "<br>")%></p>
                                    </div>
                                    <form action="VerServicio" class="navbar-form">
                                        <div class="input-group">
                                            <input type="text" name="idServicio" value="<%=servicio.getIdServicio()%>" style="display: none">
                                            <input type="text" name="idProveedor" value="<%=nodo.getKey().getNicknameP()%>" style="display: none">
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
