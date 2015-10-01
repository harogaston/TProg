<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="tprog.logica.dt.DTReserva"%>

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

		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-pills nav-justified" role="tablist">
								<li role="presentation" class="active"><a href="#info" aria-controls="info" role="tab" data-toggle="tab">Información</a></li>
								<li role="presentation"><a href="#reservas" aria-controls="reservas" role="tab" data-toggle="tab">Reservas</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="info">
									<div class="row">
										<div class="col-md-3 text-center">
											<img src="${imagen}" width="100vh" height="100vh"/>
										</div>
										<div class="col-md-9">
											<div class="row">
												<div class="col-md-12">
													<h1 class="only-bottom-margin media-heading">${nick}</h1>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<span class="text-muted">Nombre: </span> ${nombre}<br>
													<span class="text-muted">Fecha de Nacimineto: </span>${fNac}<br>
													<span class="text-muted">Email: </span>${email}<br><br>
												</div>
											</div>
										</div>
									</div>
								</div>	
								<div role="tabpanel" class="tab-pane" id="reservas">
									<ul class="list-group">
									<%
										for (DTReserva dtR : (Set<DTReserva>) request.getAttribute("reservas")) {
											out.print("<li class='list-group-item'>" + 
													dtR.toString().replace("\n", "<br>") + "<br>" + 
													"</li>");
										}
									%>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</body>
	<!-- ACÁ includes de .js que se requieran en ESTA página  -->
	<%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>
