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
        <div class="container">
			<div class="row">
				<!-- Parte izquierda imágenes, origen, destino, proveedor, etc -->
				<div class="col-md-4">
					<div id="myCarousel" class="carousel slide" style="margin-bottom: 30px">
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li class="" data-target="#myCarousel" data-slide-to="1"></li>
							<li class="" data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img src="imagenes/IMG1.jpg" alt="">
							</div>
							<div class="item">
								<img src="imagenes/IMG2.jpg" alt="">
							</div>
							<div class="item">
								<img src="imagenes/IMG3.jpg" alt="">
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
										<td>Moe</td>
									</tr>
									<tr>
										<td>Origen</td>
										<td>Montevideo, Uruguay.</td>
									</tr>
									<tr>
										<td>Destino</td>
										<td>Caracas, Venezuela.</td>
									</tr>
									<tr>
										<td>Precio</td>
										<td>123.50</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

				</div>


				<!-- Parte derecha nombre, descripcion, categorias, agregar al carro, etc -->
				<div class="col-md-8">
					<h1>Nombre del Servicio</h1>
					<p>Descripcion: Lorem Ipsum is simply dummy text of the printing 
						and typesetting industry. Lorem Ipsum has been the industry's 
						standard dummy text ever since the 1500s, when an unknown printer 
						took a galley of type and scrambled it to make a type specimen book.
					</p>
					<form action= "VerReservaActual" method="POST">
						<input type="number" name="quantity" min="1" max="99" style="width: 60px">
						<button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-shopping-cart"></i> Agregar al carrito</button>
					</form>
					<h3>Categorías</h3>
					<h5 style="display: inline-block"><span class="label label-info">Vuelos</span></h5>
					<h5 style="display: inline-block"><span class="label label-info">Iberia</span></h5>
					<h5 style="display: inline-block"><span class="label label-info">First Class</span></h5>
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
				</div>
			</div>
		</div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>