<%--
    Document   : verinfoservicio
    Created on : Sep 28, 2015, 12:03:29 AM
    Author     : marccio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="templates/head.jspf"/>
        <script src="js/jquery-2.1.4.js"></script>
        <link rel="stylesheet" href="js/vakata-jstree/dist/themes/default/style.min.css" />
        <script src="js/vakata-jstree/dist/jstree.min.js"></script>
    </head>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
    <body>
        <h1>Hello World!</h1>
        <div id="jstree_demo_div">
            <!--
            <script>
                var dataArbol = '${arbolJson}'.toString(); // creo que no hay que parsearlo
                $(function () {
                    $('#jstree_demo_div').jstree(dataArbol);
                });
//            $('#using_json_2').jstree(dataArbol);
            </script>
            -->
            <script>
                <!--
                $(function () {
                    $('#jstree_demo_div').jstree({'core': {
                            'data': [
                                {"id": "ajson1", "parent": "#", "text": "Simple root node"},
                                {"id": "ajson2", "parent": "#", "text": "Root node 2"},
                                {"id": "ajson3", "parent": "ajson2", "text": "Child 1"},
                                {"id": "ajson4", "parent": "ajson2", "text": "Child 2"},
                            ]
                        }});
                });
            </script>
        </div>
    </body>
    <footer>
        <jsp:include page="templates/footer.jspf"/>
    </footer>
</html>
