<!doctype html>
<html>
    <head>

        <%@include file="templates/head.jspf" %>
        <!-- ACÁ el título de ESTA página
			<title>El título</title>
		-->
		<script src="js/validator.min.js"></script>
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
				<form name="theform" action="RegistrarCliente" id="alta" role="form" method="POST" >
					<div class="form-group">
						<label for="inputNombre" class="control-label">Nombre</label>
						<input type="text" name= "nombre" id="inputNombre" pattern="^[_A-z]{1,}$" class="form-control" placeholder="Nombre" required onKeyup="checknombre()">
					</div>
					<div class="form-group">
						<label for="inputApellido" class="control-label">Apellido</label>
						<input type="text" name="apellido" class="form-control" pattern="^[_A-z]{1,}$" id="inputApellido" placeholder="Apellido" required onKeyup="checkapellido()">
					</div>
					<div class="form-group">
						<label for="inputNickname" class="control-label">Nickname</label>
						<input type="text" name="nickname" id="nickname" pattern="^[_A-z0-9]{1,}$" class="form-control" id="inputNickname" placeholder="usuario" required onKeyup="checkform()">
						<div class="form-group">
							<div  id="ajaxResponse"></div> 
                        </div> 

					</div>
					<div class="form-group">
						<label for="mail" class="control-label">Email</label>
						<input type="email" name="mail" class="form-control" id="mail" placeholder="email@domain" required onKeyup="checkform()">
						<div class="form-group">
							<div  id="ajaxResponse2"></div> 
                        </div> 
						<div class="help-block with-errors"></div>
					</div>


					<div class="form-group">
						<label for="inputPassword" class="control-label">Password</label>
						<div class="form-group">
							<input type="password" name="password" data-minlength="3" class="form-control" id="inputPassword" placeholder="Password" required onKeyup="checkpass()">
							<span class="help-block">Mínimo de 3 carácteres</span>
						</div>
						<div class="form-group">
							<input type="password" name="password2" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Las claves no coinciden" placeholder="Confirmar" required onKeyup="checkpass()">
							<span id="mensaje-pass"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="datepicker" class="control-label">Fecha de Nacimiento</label>
						<input type="text" name="fNac" id="datepicker" pattern="[_0-9]{2}/[_0-9]{2}/[_0-9]{4}" class="form-control" style="width: 100px" required>
					</div>
					<div class="form-group text-right">

						<button type="submit" id="boton-enviar" class="btn btn-primary" disabled="disabled" value="Submit">Enviar</button>
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

<script>
	var nick = false;
	var mail = false;
	var nombre = false;
	var apellido = false;
	var pass = false;
	var fecha = false;

	$(document).ready(function () {
		$('#nickname').blur(function (event) {
			var name = $('#nickname').val();
			$.get('JqueryServlet', {
				nickname: name
			}, function (responseText) {
				var div = $('#ajaxResponse');
				if (responseText === 'OK') {
					div.text('').html('<div><h5><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Nickname disponible</h5></div>');
					nick = true;
				} else {
					if (responseText === 'EN_USO') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> Nickname no disponible</h5></div>');
						nick = false;
					} else if (responseText === 'CORTO') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> Debe contener al menos 3 caracteres</h5></div>');
						nick = false;
					} else if (responseText === 'SIN_ESPACIOS') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> No debe contener espacios</h5></div>');
						nick = false;
					} else if (responseText === '') {
						div.text('').html('<div><h5></h5></div>');
						nick = false;
					}
				}
			});
		});
	});

	$(document).ready(function () {
		$('#mail').blur(function (event) {
			var name = $('#mail').val();
			$.get('AjaxMail', {
				mail: name
			}, function (responseText) {
				var div = $('#ajaxResponse2');
				if (responseText === 'OK') {
					div.text('').html('<div><h5><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Email disponible</h5></div>');
					mail = true;
				} else {
					if (responseText === 'EN_USO') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> Email no disponible</h5></div>');
						mail = false;
					} else if (responseText === 'SIN_ESPACIOS') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> No debe contener espacios</h5></div>');
						mail = false;
					} else if (responseText === 'FORMATO_INVALIDO') {
						div.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> Formato invalido</h5></div>');
						mail = false;
					} else {
						div.text('').html('<div><h5></h5></div>');
						mail = false;
					}
				}
				;
			});
		});
	});

	function checkform() {
		if (nick && mail && nombre && apellido && pass) {
			document.getElementById('boton-enviar').disabled = false;
		} else {
			document.getElementById('boton-enviar').disabled = true;
		}
	}

	function checkpass() {
		var f = document.forms["theform"].elements;
		var span = $('#mensaje-pass');
		if (f[4].value.length < 3 || f[5].value.length < 3) {
			pass = false;
			span.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> La clave ingresada es muy corta</h5></div>');
		} else if(f[4].value !== f[5].value) {
			pass = false;
			span.text('').html('<div><h5><i class="glyphicon glyphicon-remove"></i> <a style="color:#FF0000"> La claves no coinciden</h5></div>');
		} else {
			span.text('').html('<div><h5><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Ok</h5></div>');
			pass = true;
		}
		checkform();
	}
	function checkapellido() {
		var f = document.forms["theform"].elements;
		if (f[1].value.length === 0) {
			apellido = false;
		} else {
			apellido = true;
		}
		checkform();
	}
	function checknombre() {
		var f = document.forms["theform"].elements;
		if (f[0].value.length === 0) {
			nombre = false;
		} else {
			nombre = true;
		}
		checkform();
	}
</script>