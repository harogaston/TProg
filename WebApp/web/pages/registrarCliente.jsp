<!doctype html>
<html>
    <head>

        <%@include file="templates/head.jspf" %>
        <!-- ACÁ el título de ESTA página
			<title>El título</title>
		-->
		<script src="js/validator.min.js"></script>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<script src="js/bootstrap-datepicker.es.min.js"></script>
	</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACÁ .css que se requieran en ESTA página -->
		<link rel="stylesheet" href="css/bootstrap-datepicker3.css">
    </header>
    <body>
		<div class="container wrapper" style="padding: 50px; width: 50%">
			<div class="row">
				<form action="RegistrarCliente" id="alta" role="form" method="POST">
					<div class="form-group">
						<label for="inputNombre" class="control-label">Nombre</label>
						<input type="text" name= "nombre" id="inputNombre" class="form-control" placeholder="Oliver" required>
					</div>
					<div class="form-group">
						<label for="inputApellido" class="control-label">Apellido</label>
						<input type="text" name="apellido" class="form-control" id="inputApellido" placeholder="Wood" required>
					</div>
					<div class="form-group">
						<label for="inputNickname" class="control-label">Nickname</label>
						<input type="text" name="nickname" id="nickname" pattern="^[_A-z0-9]{1,}$" class="form-control" id="inputNickname" placeholder="oWood" required>
						<div class="form-group">
							<div  id="ajaxResponse"></div> 
                        </div> 
					</div>
					<div class="form-group">
						<label for="mail" class="control-label">Email</label>
						<input type="email" name="mail" class="form-control" id="mail" placeholder="email@domain" required>
						<div class="form-group">
							<div  id="ajaxResponse2"></div> 
                        </div> 
						<div class="help-block with-errors"></div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="control-label">Password</label>
						<div class="form-group">
							<input type="password" name="password" data-minlength="4" class="form-control" id="inputPassword" placeholder="Password" required>
							<span class="help-block">Mínimo de 4 carácteres</span>
						</div>
						<div class="form-group">
							<input type="password" name="password2" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Las claves no coinciden" placeholder="Confirmar" required>
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="datepicker" class="control-label">Fecha de Nacimiento</label>
						<input type="text" name="fNac" id="datepicker" class="form-control" style="width: 100px">
					</div>
					<div class="form-group text-right">
						<button type="submit" id="boton-enviar" class="btn btn-primary" disabled>Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>

<script>
	$('#datepicker').datepicker({
		format: "dd/mm/yyyy",
		language: "es",
		autoclose: true,
		startView: 2,
		endDate: "+Infinity"
	});
</script>

