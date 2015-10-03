<%@page import="tprog.web.EstadoSesion"%>

<!--TYPEAHEAD-->
<script type="text/javascript">
	$(document).ready(function () {
		$('#typeaheadSearch').typeahead({
			name: 'accounts',
			local: <%=session.getAttribute("terminos")%>
		});
	});
</script>

<nav class="navbar navbar-default nav-justified navbar-static-top">
    <div class="container">
		<div class="row">
			<div class="navbar-header navbar-left">
				<!--<button aria-controls="navbar" aria-expanded="false" data-target="#colapsar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>
				-->
				<a href="index.html" class="navbar-brand">Help4Traveling</a>
			</div>

			<div class="navbar-nav">
				<form action="Buscar" role="search" class="navbar-form">
					<div class="input-group">
						<input id="typeaheadSearch" type="text" class="form-control typehead tt-query" placeholder="Buscar servicios" name="busqueda" size="40">
						<div class="input-group-btn">
							<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
			<%
				if (session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) {
			%>
			<div class="navbar-nav navbar-right">
				<form action= "CerrarSesion" class="navbar-form" method="POST">
					<button class="btn btn-warning" type="submit">Cerrar Sesión</button>
				</form>
			</div>
			<div class="navbar-nav navbar-right">
				<form action= "Carrito" class="navbar-form">
					<button class="btn btn-warning" type="submit">
						<i class="glyphicon glyphicon-shopping-cart"></i>Ver reserva actual (${cant_items})
					</button>
				</form>
			</div>
			<div class="navbar-nav navbar-right">
				<form action= "VerPerfil" class="navbar-form" method="GET">

					<button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-user"></i>
						<%//Para mostrar el nickname del usuario
							out.print(session.getAttribute("usuario_logueado"));
						%>
					</button>
				</form>
			</div>
			<%
			} else {
			%>
			<div class="navbar-nav navbar-right" style="display: inline-block">
				<form action= "IniciarSesion" class="navbar-form" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nickname" name="nickname" autofocus required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Password" name="password" required>
					</div>
					<button class="btn btn-success" type="submit">Ingresar</button>
				</form>
			</div>
			<div class="navbar-nav navbar-right" style="display: inline-block">
				<form action= "AltaCliente" class="navbar-form" method="POST">
					<button class="btn btn-default" type="submit">Registrarse</button>
				</form>
			</div>
		</div>
        <%
			}
        %>

        <!-- script para que funcione el dropdown siempre -->
        <script>
			$(document).ready(function () {
				$(".dropdown-toggle").dropdown();
			});
        </script>
    </div><!-- /.container -->
</nav><!-- /.navbar -->
