<%-- 
    Document   : subirImagen
    Created on : Oct 19, 2015, 2:32:31 AM
    Author     : ignacio.prandi
--%>

<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- AC� el t�tulo de ESTA p�gina
			<title>El t�tulo</title>
		-->
		<!-- AC� .js que se requieran en ESTA p�gina  -->
</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- AC� .css que se requieran en ESTA p�gina -->
    </header>
    <body>
        <div class="container wrapper" style="padding: 50px; padding-top: 20px; width: 50%">
            <div class="row">                            
                <div class="form-group">
                    <form action="upload" method="POST" enctype="multipart/form-data">
                        <! -- El usuario ya est� registrado, se da la opci�n de subir un foto de perfil
                            en caso de que no se seleccione ninguna simplemente se asigna la im�gen por defecto -->
							<h4>Seleccione una im�gen de perfil:</h4>                                        
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
