<%@page import="java.io.File"%>
<%@page import="tprog.web.EstadoSesion"%>
<head>
    <!-- imports que todas las páginas necesitan -->
    <script src="js/jquery-2.1.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="js/jquery-ui-1.11.4.custom/jquery-ui.css">
    <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
    <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css" />
    <script src="js/vakata-jstree/dist/jstree.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-default nav-justified navbar-static-top">
        <div class="container">
            <div class="navbar-header navbar-left">
                <!--			<button aria-controls="navbar" aria-expanded="false" data-target="#colapsar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                                                <span class="sr-only">Toggle navigation</span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                        </button>-->
                <a href="index.html" class="navbar-brand">Help4Traveling</a>
            </div>

            <div class="navbar-nav">
                <form action="Buscar" role="search" class="navbar-form">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Buscar servicios" name="busqueda" size="40%">
                        <div class="input-group-btn">
                            <button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <%
                System.out.println("El estado de la sesión es: " + session.getAttribute("estado_sesion").toString());
                if (session.getAttribute("estado_sesion") == EstadoSesion.OK_LOGIN) {
            %>
            <div class="navbar-nav navbar-right">
                <form action= "VerCarrito" class="navbar-form" method="POST">
                    <button class="btn btn-warning" type="submit"><i class="glyphicon glyphicon-shopping-cart"></i></button>
                </form>
            </div>
            <div class="navbar-nav navbar-right">
                <form action= "CerrarSesion" class="navbar-form" method="POST">
                    <button class="btn btn-warning" type="submit">Cerrar Sesión</button>
                </form>
            </div>
            <%
            } else {
            %>
            <div class="navbar-nav navbar-right">
                <form action= "AltaCliente" class="navbar-form" method="POST">
                    <div class="form-group">
                        <button class="btn btn-default" type="submit">Registrarse</button>
                    </div>
                </form>
            </div>
            <div class="navbar-nav navbar-right">
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
            <%
                }
            %>
            <div class="col-md-1 pull-right"></div>
            <div class="row ">
                <div class="col-md-5"></div>
                <div class="dropdown col-md-1">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Registros<span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Registrar Cliente</a></li>
                        <li><a href="#">Agregar Servicio o Promoción a Reserva Actual</a></li>
                        <li><a href="#">Generar Reserva</a></li>
                        <li><a href="#">Actualizar estado de Reserva</a></li>
                    </ul>
                </div>
                <div class="dropdown col-md-1">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Consultas<span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Ver Información de Proveedor</a></li>
                        <li><a href="VerInfoServicio">Ver Información de Servicio</a></li>
                        <li><a href="#">Ver Información de Promoción</a></li>
                        <li><a href="#">Ver Información de Reserva</a></li>
                    </ul>
                </div>
                <div class="col-md-5"></div>
            </div>
            <div class="row" style="padding-bottom: 50px">
                <%if (!(boolean) session.getAttribute("datos_cargados")) {
                %>
                <form action= "CargarDatos" method="POST">
                    <button type="submit" class="btn btn-success">Cargar Datos</button>
                </form>
                <%
                    }%>
            </div>
            <div class="row">
                Dir : <%= (new File(".")).getCanonicalPath()%>
            </div>

            <!-- script para que funcione el dropdown siempre -->
            <script>
                $(document).ready(function () {
                    $(".dropdown-toggle").dropdown();
                });
            </script>
        </div><!-- /.container -->
    </nav><!-- /.navbar -->
</body>