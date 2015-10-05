<%-- 
    Document   : verProveedores
    Created on : 05-oct-2015, 1:54:25
    Author     : Martin
--%>

<%@page import="tprog.logica.dt.DTMinProveedor"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jspf" %>
       
        <title>JSP Page</title>
    </head>
    <header>
        <%@include file="templates/header.jsp" %>
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css">
        
    </header>
    <body>
       <div class="container">
           <div class="row" >
		<div class="col-md-3">
							<h2 class="text-center">Proveedores</h2>
							<%	Set<DTMinProveedor> proveedores = (Set<DTMinProveedor>) request.getAttribute("proveedores");
								if (!proveedores.isEmpty()) {
							%>
							<div class="panel-group" id="accordionProveedores">
								<%
									int i = 0;
									for (DTMinProveedor proveedor : proveedores) {
										i++;
								%>
								<div class="accordion-group">
                                                                    
									<div class="panel">
										<div class="panel-heading" style="background-color: rgb(91, 192, 222); color: white" data-toggle="collapse" data-parent="#accordionProveedores" href="#s<%=i%>">
                                                                                    <form action="VerInfoProveedor" id="myform<%=i%>" method="POST">
                                                                                        
											<h1 class="panel-title text-center">
                                                                                            <input name="idProveedor" value="<%=proveedor.getNickname()%>" style="display: none">
                                                                                            <a href="#" style="text-decoration: none" onclick="document.getElementById('myform<%=i%>').submit()"><span class="label label-info"><%=proveedor.getNickname()%></span></a>
												 
											</h1>
                                                                                        
                                                                                        
                                                                                    </form>    
                                                                                </div>
										
									</div>
								</div>
								<%
									}
								%>
							</div>
							<% } else { %>
							<p class="text-center"> No hay proveedores en el sistema.</p>
							<%
								}
							%>

						</div>
        </div>
    </body>
    <%@include file="templates/footer.jspf" %>
</html>
