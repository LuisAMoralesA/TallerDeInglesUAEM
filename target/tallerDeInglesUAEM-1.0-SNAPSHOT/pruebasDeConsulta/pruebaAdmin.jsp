<%-- 
    Document   : pruebaStudents
    Created on : 5 may. 2025, 15:09:11
    Author     : Luis Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.BaseDatos"%>
<%@page import ="model.Admin_school"%>
<%@page import ="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Links de Hojas de estilo para la tabla-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.3/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.3.0/css/dataTables.bootstrap5.css"/>
        <title>Lista de Administrador</title>
    </head>
    <body>
        <!--Tabla obtenida de Bootstrap-->
        <table id="example" class="table table-striped">
        <thead>
            <tr>
                <th>Id de Administrador</th>
                <th>Id de Usuario</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Nombres</th>
                <th>Fecha de Nacimiento</th>

            </tr>
        </thead>
        <%
            BaseDatos base = new BaseDatos();
            ArrayList<Admin_school> lista = base.obtenerAdministrador();
            Iterator<Admin_school> iter = lista.iterator();
            Admin_school per = null;
            
            while(iter.hasNext()){
                per = iter.next();
            
        %>
        <tbody>
            <tr>
                <td><%=per.getId_admin()%></td>
                <td><%=per.getId_user_admin()%></td>
                <td><%=per.getApellido_paterno_admin()%></td>
                <td><%=per.getApellido_materno_admin()%></td>
                <td><%=per.getNombre_admin()%></td>>
                <td><%=per.getFecha_nacimiento_admin()%></td>
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
