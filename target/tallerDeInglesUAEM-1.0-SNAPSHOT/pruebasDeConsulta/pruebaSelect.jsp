<%-- 
    Document   : pruebaStudents
    Created on : 5 may. 2025, 15:09:11
    Author     : Luis Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.*"%>
<%@page import ="model.ConsultaGrupos"%>
<%@page import ="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Links de Hojas de estilo para la tabla-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.3/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.3.0/css/dataTables.bootstrap5.css"/>
        <title>Lista de Teachers</title>
    </head>
    <body>
        <!--Tabla obtenida de Bootstrap-->
        <table id="example" class="table table-striped">
        <thead>
            <tr>
                <th>Id del grupo</th>
                <th>Id del Grado</th>
                <th>Descripción del grado</th>
                <th>Nivel</th>
                <th>Id de Categoria</th>
                <th>Descripcion de Categoria</th>

            </tr>
        </thead>
        <%
            BaseDatosObtener base = new BaseDatosObtener();
            ArrayList <ConsultaGrupos> opciones = base.obtenerDatosGrupo(1);
            Iterator <ConsultaGrupos> iter = opciones.iterator();
            ConsultaGrupos per = null;
            while(iter.hasNext()){
                per = iter.next();
        %>
        <tbody>
            <tr>
                <td><%=per.getId_group()%></td> 
                <td><%=per.getId_grade()%></td> 
                <td><%=per.getDescription_grade()%></td> 
                <td><%=per.getLevel_group()%></td> 
                <td><%=per.getId_category_group()%></td> 
                <td><%=per.getDescription_category()%></td> 
            </tr>
            <%}%>
        </tbody>
        
    </table>
    </body>
    <!--Scrpts de JavaScript para la tabla de Datos-->
    <script src ="https://code.jquery.com/jquery-3.7.1.js"> </script>
    <script src ="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.3/js/bootstrap.bundle.min.js"> </script>
    <script src ="https://cdn.datatables.net/2.3.0/js/dataTables.js"> </script>
    <script src ="https://cdn.datatables.net/2.3.0/js/dataTables.bootstrap5.js"> </script>
    <script> 
        new DataTable('#example');
    </script>
</html>

