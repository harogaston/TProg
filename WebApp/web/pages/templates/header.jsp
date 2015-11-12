<%@page import="tprog.web.TipoUsuario"%>
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
                <%
				if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			%> 
				<a href="index.html" class="navbar-brand">Help4Traveling</a>
                <%
                }
			%> 
			</div>
                <%
				if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
			%> 
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
			<% }
				if ((session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) && (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE)) {
			%>
			<div class="navbar-nav navbar-right">
				<form action= "CerrarSesion" class="navbar-form" method="POST">
					<button class="btn btn-warning" type="submit">
						<i class="glyphicon glyphicon-off"></i> Cerrar Sesión
					</button>
				</form>
			</div>
			<div class="navbar-nav navbar-right">
				<form action= "Carrito" class="navbar-form">
					<button class="btn btn-warning" type="submit">
						<span class="badge"><%if ((Integer) session.getAttribute("cant_items") > 0) {%>${cant_items}<%}%></span> <i class="glyphicon glyphicon-shopping-cart"></i> Carrito
					</button>
				</form>
			</div>
			<div class="navbar-nav navbar-right">
				<form action= "VerPerfil" class="navbar-form" method="GET">
					<button class="btn btn-warning" type="submit">
						<i class="glyphicon glyphicon-user"></i>
						<%=" " + session.getAttribute("usuario_logueado")%>
					</button>
				</form>
			</div>               
			<%
			} else if((session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) && (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR)){
			%>
            <%--           
			<div class="navbar-nav navbar-right">
				<form action= "CerrarSesion" class="navbar-form" method="POST">
					<button class="btn btn-warning" type="submit">
						<i class="glyphicon glyphicon-off"></i> Cerrar Sesión
					</button>
				</form>
			</div>
			
			<div class="navbar-nav navbar-right">
				<form action= "VerPerfil" class="navbar-form" method="GET">
					<button class="btn btn-warning" type="submit">
						<i class="glyphicon glyphicon-user"></i>
						<%=" " + session.getAttribute("usuario_logueado")%>
                                                
                                                </button>
                                                
                        
					
				</form>
                                              
			</div> 
                        <%--                       <div class="navbar-nav navbar-right">
                                                    <div class="dropdown">
                                                        <button type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            <i class="glyphicon glyphicon-align-justify"></i>
                                                        </button>
                                                        
                                                        <u1 class="dropdown-menu" >
                                                             <li><a href="ServiciosProveedor">Ver Servicios</a></li>
                                                            <li><a href="ReservasProveedor">Ver Reservas</a></li>
                                                            <li><a href="PromocionesProveedor">Ver Promociones</a></li>
                                
                                                        </u1>
                                                </div>  
                                                </div>                        
                        --%>
         
            
            <div class="row row-centered">
                <div role="tabpanel" class="tab-pane">
                    <div class="panel-group" id="accordionMenu">
                        <div class="accordion-group">
                            <div class="panel panel-default">
                                <div class="panel-heading" data-toggle="collapse" data-parent="#accordionMenu" href="#w1">
                                    <h4 class="panel-title text-center" >
                                        <span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
                                        Bienvenido  <%=session.getAttribute("usuario_logueado")%>
                                    </h4>
                                </div>

                                <div id="w1" class="panel-collapse collapse">
                                    
                                        <ul class="nav nav-pills nav-stacked">


                                            
                                            
                                            <li role="presentation"><a href="VerPerfil">Perfil</a></li>
                                            <li role="presentation"><a href="ServiciosProveedor">Servicios</a></li>
                                            <li role="presentation"><a href="ReservasProveedor">Reservas</a></li>
                                            <li role="presentation"><a href="PromocionesProveedor">Promociones</a></li>
                                            <li role="presentation"><a href="CerrarSesion">Cerrar sesion</a></li>
                                            </ul>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                       
                                                
        <%
			}else if((session.getAttribute("estado_sesion") == EstadoSesion.NO_LOGIN) && (session.getAttribute("tipo_usuario") == TipoUsuario.PROVEEDOR)){
        %>
                        <div class="navbar-nav navbar-right" style="display: inline-block">
				<form action= "CambiarUsuario" class="navbar-form" method="POST">
					<button class="btn btn-success" type="submit">
						<i class="glyphicon glyphicon-arrow-right"></i> Loguear con Cliente
					</button>
				</form>
			</div>
                        
			<div class="navbar-nav navbar-right" style="display: inline-block">

				<form action= "NuevoCliente" class="navbar-form" >

					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-edit"></i> Registrarse
					</button>
				</form>
			</div>
        <%
			}else {
        %>
                        <div class="navbar-nav navbar-right" style="display: inline-block">
				<form action= "CambiarUsuario" class="navbar-form" method="POST">
					<button class="btn btn-success" type="submit">
						<i class="glyphicon glyphicon-arrow-right"></i> Loguear con Proveedor
					</button>
				</form>
			</div>
                        <div class="navbar-nav navbar-right" style="display: inline-block">
				<form action= "IniciarSesion" class="navbar-form" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nickname" name="nickname" autofocus required>
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Password" name="password" required>
					</div>
					<button class="btn btn-success" type="submit">
						<i class="glyphicon glyphicon-log-in"></i> Ingresar
					</button>
				</form>
			</div>
                        
			<div class="navbar-nav navbar-right" style="display: inline-block">

				<form action= "NuevoCliente" class="navbar-form" >

					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-edit"></i> Registrarse
					</button>
				</form>
			</div>
        <%
			}
        %>                
        </div>
        <!-- script para que funcione el dropdown siempre -->
        <script>
			$(document).ready(function () {
				$(".dropdown-toggle").dropdown();
			});
        </script>
    </div><!-- /.container -->
</nav><!-- /.navbar -->
