<%-- 
    Document   : factura
    Created on : Nov 18, 2015, 10:25:01 PM
    Author     : User
--%>
<%@page import="webservice.DtFacturaF"%>;
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <%DtFacturaF dtf = (DtFacturaF) request.getAttribute("factura");%>
                    <td>Factura </td>
                    <td><%=Integer.toString(dtf.getIdReserva())%></td>
                    <td>Cliente </td>
                    <td><%=(dtf.getNicknameCliente())%></td>
                </div>
            </div>
        </div>
         
    </body>
    <%@include file="templates/footer.jspf" %>
</html>

