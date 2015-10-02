<%@page import="tprog.logica.interfaces.ICtrlReservas"%>
<%@page import="java.util.Set"%>
<%@page import="tprog.logica.dt.DTLineaReserva"%>
<%@page import="tprog.logica.dt.DTReserva"%>
<% response.setHeader("Refresh", "1;url=/WebApp/Home");%>
<!doctype html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
        <!-- ACÁ se puede especificar el título de ESTA jsp de la siguiente forma:
			<title>El título</title>
		-->
		<!-- ACÁ includes de .js que se requieran en ESTA página  -->
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
