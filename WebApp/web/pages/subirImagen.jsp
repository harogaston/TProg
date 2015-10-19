<%-- 
    Document   : subirImagen
    Created on : Oct 19, 2015, 2:32:31 AM
    Author     : ignacio.prandi
--%>

<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ el título de ESTA página
			<title>El título</title>
		-->
		<!-- ACÁ .js que se requieran en ESTA página  -->
</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACÁ .css que se requieran en ESTA página -->
    </header>
    <body>
        <div class="container wrapper" style="padding: 50px; padding-top: 20px; width: 50%">
            <div class="row">                            
                <div class="form-group">
                    <form action="upload" method="POST" enctype="multipart/form-data">
                        <! -- El usuario ya está registrado, se da la opción de subir un foto de perfil
                            en caso de que no se seleccione ninguna simplemente se asigna la imágen por defecto -->
							<h4>Seleccione una imágen de perfil:</h4>                                        
							<input type="file"  name="file">
                        <div class="form-group text-center">
                            <button class="btn btn-info" type="submit">
                            <i class="glyphicon glyphicon-upload"></i> Subir Imagen</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
         
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
