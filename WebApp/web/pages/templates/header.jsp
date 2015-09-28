<%--
    Document   : header
    Created on : Sep 27, 2015, 6:26:11 PM
    Author     : marccio
--%>

<%@page import="tprog.web.EstadoSesion"%>
<!-- agrego estilo para texto -->
<link href='https://fonts.googleapis.com/css?family=Alegreya+Sans+SC:400,400italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<nav class="navbar navbar-default">
    <div class="container-fluid" style="padding: 10px; font-family: 'Alegreya Sans SC', sans-serif">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-3">
                <a class="navbar-brand navbar-header" href="index.html">H4T</a>
            </div>
            <div class="col-lg-4" style="display: inline">
                <form action="Buscar" class="form-inline" role="search" method="POST">
                    <div class="form-group">
                        <input type="text" name ="busqueda" class="form-control" placeholder="Buscar servicios" />
                    </div>
                    <button type="submit" class="btn btn-info" style="background-color: #23527c; border-color: #23527c">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </form>
            </div>

            <%
                System.out.println("El estado de la sesión es: " + session.getAttribute("estado_sesion").toString());
                if (session.getAttribute("estado_sesion") != EstadoSesion.LOGIN_CORRECTO) {
            %>
            <div class="col-lg-4" style="display: inline">
                <form action= "IniciarSesion" class="form-inline" role="form" method="POST">
                    <div class="form-group">
                        <label class="sr-only" for="Email">Email</label>
                        <input type="email" name="nickname" class="input-sm" id="Email" placeholder="Nickname" autofocus required />
                    </div>
                    <div class="form-group" style="size: 10px">
                        <label class="sr-only " for="Password">Password</label>
                        <input type="password" name="password" class="input-sm" id="Password" placeholder="Password" required/>
                    </div>
                    <button type="submit" class="btn btn-success" style="background-color: #23527c; border-color: #23527c">Ingresar</button>
                </form>
            </div>
            <%
            } else {
            %>
            <div class="col-lg-3" style="display: inline; text-align: right">
                <form action= "CerrarSesion" class="form-inline" role="form" method="POST">
                    <div class="form-group">
                        <label class="sr-only" for="Usuario"><Pepito</label>
                    </div>
                    <button type="submit" class="btn btn-success" style="background-color: #23527c; border-color: #23527c">Cerrar Sesion</button>
                </form>
            </div>
            <%
                }
            %>
        </div>
        <div class="row navbar-text col-lg-12">
            Ofertas en hoteles, paquetes de viajes y más!
        </div>
        <div class="row ">
            <div class="col-lg-5"></div>
            <div class="dropdown col-md-1">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: #23527c; border-color: #23527c">Registros
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#">Registrar Cliente</a></li>
                    <li><a href="#">Agregar Servicio o Promoción a Reserva Actual</a></li>
                    <li><a href="#">Generar Reserva</a></li>
                    <li><a href="#">Actualizar estado de Reserva</a></li>
                </ul>
            </div>
            <div class="dropdown col-md-1">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: #23527c; border-color: #23527c"> Consultas
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#">Ver Información de Proveedor</a></li>
                    <li><a href="VerInfoServicio">Ver Información de Servicio</a></li>
                    <li><a href="#">Ver Información de Promoción</a></li>
                    <li><a href="#">Ver Información de Reserva</a></li>
                </ul>
            </div>
            <div class="col-lg-5"></div>
        </div>
        <!-- script para que funcione el dropdown siempre -->
        <script>
            $(document).ready(function () {
                $(".dropdown-toggle").dropdown();
            });
        </script>

    </div>
</nav><!-- /.navbar -->