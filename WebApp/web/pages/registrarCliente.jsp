<%-- 
    Document   : registrarCliente
    Created on : Oct 2, 2015, 10:24:52 PM
    Author     : ignacio.prandi
--%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Set"%>
<!doctype html>
<html>
    <head>
    
        <%@include file="templates/head.jspf" %>
        <!-- Acá se puede especificar el título de ESTA jsp de la siguiente forma:
			<title>El título</title>
		-->
                
        <!-- ACÁ includes de .js que se requieran en ESTA página  -->
		<script src="js/bootstrap-datepicker.js"></script>
                <script src="js/bootstrap-datepicker.es.min.js"></script>
                <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
                <script type="text/javascript" src="ajax.js"></script>
	</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACA .css que se requieran en esta jsp
		(sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
		-->
    </header>
	<body>
            
		<div class="container wrapper" style="padding: 30px">
			<form action="RegistrarCliente" class="navbar-form" method="POST">
				
                            <div class="container wrapper" style="padding: 30px">
					<div class="form-group">
						REGÍSTRATE
					</div>
                            </div> 
                            <div class="container wrapper" style="padding: 30px">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nickname" name= "userName" id="userName" required>
                                               <div class="form-group">
                                                   <%--glyphicon glyphicon-alert si falla, glyphicon glyphicon-ok si ok --%>
                                                   <div  id="ajaxResponse"></div> 
                                               </div>  
					</div>
                            </br>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Mail" name="mail" id="mail" required>
                                                <div class="form-group">
                                                    <div  id="ajaxResponse2"></div> 
                                                </div>   
					</div>
                                        
                            </div> 
                            <!-- NICKNAME Y MAIL SE DEBEN VERIFICAR EN EL MOMENTO CON AJAX? -->
                            
                            <div class="container wrapper" style="padding: 30px">
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Password" name="password" required>
					</div>
                            
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Confirmación de Password" name="password2" required>
					</div>
                            </div> 
                            <div class="container wrapper" style="padding: 30px">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nombre" name="nombre" autofocus required>
					</div>
                            
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Apellido" name="apellido" required>
					</div>
                            </div> 
                            <!-- IMAGEN Y FECHA PROVISORIOS -->
                            
                            <!-- FALTA AGREGAR LA IMAGEN DE PERFIL -->
                            <div class="container wrapper" style="padding: 30px">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Imágen" name="imagen" >
					</div>
                            </div> 
                            
                            <!-- MUY INCÓMODA LA FECHA -CAMBIAR -->
                            <div class="container wrapper" style="padding: 30px">
				<div class="form-group">
                                    <p style="padding-top: 10px">Fecha de Nacimiento</p>
						<div class="input-daterange input-group input-sm" id="datepicker" style="width: 10%">
							<input type="text" class="input-sm form-control" name="fNac" value="01/01/1980" style="width: 100px" required>
                                                </div>
                                </div>  
                            </div>   
                            <div class="container wrapper" style="padding: 30px">
                                
					<button class="btn btn-success" type="submit">Ingresar</button>
                            </div>
			</form>
                            
		</div>
	</body>
	<!-- ACÁ includes de .js que se requieran en ESTA página  -->
	<%@include file="templates/footer.jspf" %> <!-- El footer ya incluye bootstrap.min.js y jquery-2.1.4.js -->
</html>

<!--Para las fechas-->
<script>    
	$('#datepicker').datepicker({
		format: "dd/mm/yyyy",
		language: "es",
		orientation: "top auto",
		autoclose: true
	});
</script>