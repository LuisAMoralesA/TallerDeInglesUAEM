<%-- 
    Document   : pruebaStudents
    Created on : 5 may. 2025, 15:09:11
    Author     : Luis Morales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.BaseDatos"%>
<%@page import ="model.Students"%>
<%@page import ="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Links de Hojas de estilo para la tabla-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.3/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.3.0/css/dataTables.bootstrap5.css"/>
        <title>Lista de Alumnos</title>
    </head>
    <body>
        <!--Tabla obtenida de Bootstrap-->
        <table id="example" class="table table-striped">
        <thead>
            <tr>
                <th>Id de Estudiante</th>
                <th>Id del Profesor</th>
                <th>Lista de calificaciones</th>
                <th>Lista de seguimiento($)</th>
                <th>Id de Usuario</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Nombres</th>
                <th>Telefono 1</th>
                <th>Telefono 2</th>
                <th>Fecha de Nacimiento</th>
                <th>Correo Electronico</th>
                <th>¿Sale solo?</th>
            </tr>
        </thead>
        <%
            BaseDatos base = new BaseDatos();
            ArrayList <Students> lista = base.obtenerEstudiante();
            Iterator<Students> iter = lista.iterator();
            Students per = null;
            
            while(iter.hasNext()){
                per = iter.next();
            
        %>
        <tbody>
            <tr>
                <td><%=per.getId_student()%></td>
                <td><%=per.getId_teacher_student()%></td>
                <td><%=per.getId_report_student()%></td>
                <td><%=per.getId_payment_student()%></td>
                <td><%=per.getId_user_student()%></td>
                <td><%=per.getApellido_paterno_student()%></td>
                <td><%=per.getApellido_materno_student()%></td>
                <td><%=per.getNombre_student()%></td>
                <td><%=per.getTelefono1_student()%></td>
                <td><%=per.getTelefono2_student()%></td>
                <td><%=per.getFecha_nacimiento_student()%></td>
                <td><%=per.getEmail_student()%></td>
                <td><%=per.isSale_solo()%></td>
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
