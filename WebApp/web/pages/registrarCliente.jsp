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
						<input type="text" name= "nombre" id="inputNombre" pattern="^[_A-z]{1,}$" class="form-control" placeholder="Oliver" required onKeyup="checkform()">
					</div>
					<div class="form-group">
						<label for="inputApellido" class="control-label">Apellido</label>
						<input type="text" name="apellido" class="form-control" pattern="^[_A-z]{1,}$" id="inputApellido" placeholder="Wood" required onKeyup="checkform()">
					</div>
					<div class="form-group">
						<label for="inputNickname" class="control-label">Nickname</label>
						<input type="text" name="nickname" id="nickname" pattern="^[_A-z0-9]{1,}$" class="form-control" id="inputNickname" placeholder="oWood" required onKeyup="checkform()">
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
							<input type="password" name="password" data-minlength="4" class="form-control" id="inputPassword" placeholder="Password" required onKeyup="checkform()">
							<span class="help-block">Mínimo de 4 carácteres</span>
						</div>
						<div class="form-group">
							<input type="password" name="password2" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Las claves no coinciden" placeholder="Confirmar" required onKeyup="checkform()">
							<div class="help-block with-errors"></div>
						</div>
					</div>
                                        <div class="form-group">
						<label for="datepicker" class="control-label">Fecha de Nacimiento</label>
						<input type="text" name="fNac" id="datepicker" pattern="[_0-9]{2}/[_0-9]{2}/[_0-9]{4}" class="form-control" style="width: 100px" onKeyup="checkform()" required>
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
$(document).ready(function () {
    $('#nickname').blur(function (event) {
        var name = $('#nickname').val();
        $.get('JqueryServlet', {
            nickname: name
        }, function (responseText) {
            var div = $('#ajaxResponse');
            if (responseText === 'OK') {
                div.text('').html('<div><h4><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Nickname disponible</h4></div>');
            } else {
                if (responseText === 'EN_USO') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> Nickname no disponible</h4></div>');
                } else  if (responseText === 'CORTO') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> Debe contener al menos 3 caracteres</h4></div>');
                }else if (responseText === 'SIN_ESPACIOS') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> No debe contener espacios</h4></div>');
                } else if (responseText === '') {
                    div.text('').html('<div><h4></h4></div>');
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
                div.text('').html('<div><h4><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Email disponible</h4></div>');
            } else {
                //document.getElementById("boton-enviar").disabled = true;
                if (responseText === 'EN_USO') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> Email no disponible</h4></div>');
                } else if (responseText === 'SIN_ESPACIOS') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> No debe contener espacios</h4></div>');
                } else if (responseText === 'FORMATO_INVALIDO') {
                    div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> Formato invalido</h4></div>');
                } else {
                    div.text('').html('<div><h4> </h4></div>');
                }
            };
        });
    });
});

function checkform(){
                var f = document.forms["theform"].elements;
                
                cansubmit = true;
                               
                for (var i = 0; i < 2; i++) {
                        if (f[i].value.length === 0) 
                            cansubmit = false;
                }
                for (var i = 2; i < 5; i++) {
                        if (f[i].value.length < 3)
                            cansubmit = false;
                }
                if (!f[3].value.toString().match(".*\.com"))
                        cansubmit = false;
                if (f[4].value !== f[5].value )
                        cansubmit = false;
                   
                document.getElementById('boton-enviar').disabled = !cansubmit;
                
        }
</script>