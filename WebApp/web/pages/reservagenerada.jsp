<%@page import="tprog.logica.interfaces.ICtrlReservas"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTLineaReserva"%>
<%@page import="tprog.logica.dt.DTReserva"%>
<% response.setHeader("Refresh", "1;url=/WebApp/Home");%>
<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- AC� se puede especificar el t�tulo de ESTA jsp de la siguiente forma:
			<title>El t�tulo</title>
		-->
		<!-- AC� includes de .js que se requieran en ESTA p�gina  -->
	</head>
    <header>
        <%@include file="templates/header.jsp" %>
		<!-- ACA .css que se requieran en esta jsp
			(sin incluir bootstrap.css ni bootstrap-theme.css que ya estan en head.jsp)
		-->
    </header>
    <body>
		<h3>Ta todo bien querido</h3>
	</body>
	<%@include file="templates/footer.jspf" %>
</html>
