<%-- 
    Document   : proveedor
    Created on : 08-nov-2015, 20:28:56
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="templates/head.jspf" %>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
    </header>
    <body>
        <div class="wrapper container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        
                            <div class="row">
                                <div align="center">
                                    <a><h3>Iniciar Sesion</h3></a>
                                </div>

                            </div>
                            <hr>
                        
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="IniciarSesion" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="text" name="nickname" id="username" tabindex="1" class="form-control" placeholder="Email / Nickname" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                        </div>
                                        <div class="form-group text-center">
                                            <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                            <label for="remember"> Recordarme</label>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-primary" value="Login">
                                                </div>
                                            </div>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
