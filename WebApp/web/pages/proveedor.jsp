
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
        <!-- MENSAJE SI SE INTENTÓ ENTRAR A UNA CUENTA NO REGISTRADA -->
		<%if (request.getSession().getAttribute("inicioIncorrecto") != null) {%>
		<script type="text/javascript">
			$(window).load(function () {
				$('#myModal').modal('show');
			});
		</script>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" style="text-align: center;">
			<div class="modal-dialog" style="vertical-align: middle;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-center">Credenciales incorrectas</h4>
					</div>
					<div class="modal-body">
						<%=request.getSession().getAttribute("inicioIncorrecto")%>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
					</div>
				</div>

			</div>
		</div>
		<%
				request.getSession().setAttribute("inicioIncorrecto", null);
			}
		%>
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
                                            <input type="text" name="nickname" id="username" tabindex="1" class="form-control" placeholder="Email / Nickname" value="" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required>
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
