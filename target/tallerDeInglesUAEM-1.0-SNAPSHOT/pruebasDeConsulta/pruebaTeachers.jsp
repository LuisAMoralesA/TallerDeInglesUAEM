<%-- 
    Document   : pruebaStudents
    Created on : 5 may. 2025, 15:09:11
    Author     : Luis Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.BaseDatos"%>
<%@page import ="model.Teachers"%>
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
                <th>Id de Profesor</th>
                <th>Id de Usuario</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Nombres</th>
                <th>Telefono</th>
                <th>Fecha de Nacimiento</th>
                <th>Email</th>
                <th>Estatus</th>
                <th>Grupo</th>
            </tr>
        </thead>
        <%
            BaseDatos base = new BaseDatos();
            ArrayList<Teachers> lista = base.obtenerTeacher();
            Iterator<Teachers> iter = lista.iterator();
            Teachers per = null;
            
            while(iter.hasNext()){
                per = iter.next();
            
        %>
        <tbody>
            <tr>
                <td><%=per.getId_teacher()%></td>
                <td><%=per.getId_user_teacher()%></td>
                <td><%=per.getApellido_paterno_teacher()%></td>
                <td><%=per.getApellido_materno_teacher()%></td>
                <td><%=per.getNombre_teacher()%></td>
                <td><%=per.getTelefono_teacher()%></td>
                <td><%=per.getFecha_nacimiento_teacher()%></td>
                <td><%=per.getEmail_teacher()%></td>
                <td><%=per.getStatus_teacher()%></td>
                <td><%=per.getId_group_teacher()%></td>
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
