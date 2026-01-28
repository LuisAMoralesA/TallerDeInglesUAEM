<%-- 
    Document   : principal_students
    Created on : 22 abr. 2025, 21:05:47
    Author     : Luis Morales
--%>

<%@page import="java.sql.*" %>
<%@page import="com.mysql.jdbc.Driver" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.BaseDatosObtener"%>
<%@page import ="model.*"%>
<%@page import ="java.util.*"%>
<%@page import = "jakarta.servlet.http.HttpSession"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href = "../css/style_menuprincipal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href = "../Images/uaem.png" rel = "icon"></link>
    <link href = "../Images/uaem.png" rel = "icon"/>
    <!--Librerias para alertas emergentes-->
        <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.19.1/dist/sweetalert2.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.19.1/dist/sweetalert2.all.min.js"></script>
    <!--Link para visualizar alertas
            https://sweetalert2.github.io/-->
    <title>Bienvenido!!</title>
</head>
<body>
    <%
        //Obtiene la sesion al usuario
        HttpSession sesion = request.getSession();
        String usuario = (String) sesion.getAttribute("sesionIniciada");
        //Accede a la base de datos y accede a los datos del usuario
        BaseDatosObtener base = new BaseDatosObtener();
        ArrayList <String> lista = base.obtenerDatosAdministrador(usuario);
    %>
    <aside id = "menu_lateral">
        <ul id="menu_opciones">
            <li>
                <img src="../Images/Logo_Taller2.png" alt=""> 
            </li>

            <li>
                <a href="../view/principal_admin.jsp">
                    <i class="fa-solid fa-circle-user"></i> <br>
                        Cuenta
                </a>
            </li>

            <li>
                <a href="">
                   <i class="fa-solid fa-users-line"></i><br>
                    Alumnos
                </a>
            </li>

            <li>
                <a href="">
                    <i class="fa-solid fa-chalkboard-user"></i>  <br>
                    Maestros
                </a>
            </li>

            <li>
                <a href="">
                   <i class="fa-solid fa-school"></i><br>
                    Grupos
                </a>
            </li>

            <li>
                <a href="">
                    <i class="fa-solid fa-print"></i><br>
                    Documentos
                </a>
            </li>

            <li>
                <a href="../view/login_admin.jsp">
                    <i class="fa-solid fa-right-from-bracket"></i> <br>
                    Cerrar Sesión
                </a>
            </li>
        </ul>
    </aside>

    <article >
        <div id = "perfil_usuario">
            <%
                String mensaje = (String) sesion.getAttribute("actualizacionCompleta");
                if (mensaje != null && !mensaje.isEmpty()){
            %>
                <script>
                    Swal.fire({
                        icon: "success",
                        title: "<%= mensaje %>",
                        draggable: true
                      });
                </script>
                <%}
                sesion.setAttribute("actualizacionCompleta", null);
            %>
            <h1> Perfil de Adminsitrador </h1>
            <div id = "imagen_perfil">
                <img src="../Images/user3.png" alt="">
            </div>
            
            <div id = "datos_personales">
                <h2> Datos Personales </h2>
                <p> <b>Nombre completo: </b> <%=lista.get(1)+ " " + lista.get(2)+ " " + lista.get(3)%></p>
                <p> <b>Nombre de Usuario: </b> <%=lista.get(9)%></p>
                <h2> Datos Academicos </h2>
                <p> <b>Rango: </b> <%=lista.get(7)%></p>
                <% 
                    //Obtiene el atributo del Rango para el resto de la sesion
                    sesion.setAttribute("rango", lista.get(7));
                %>
            </div>

            <div id = "button">
            <ul id = "modificar">
                <li>
                <% 
                    //Obtiene el atributo del Id_User para el resto de la sesion
                    sesion.setAttribute("userId", lista.get(8));
                %>
                    <a <a href="../view/updateInfo.jsp">
                        <i class="fa-solid fa-pen"></i> <br>
                        Modificar Datos
                    </a>
                </li>

                <li>
                    <a href="../view/updateUser.jsp">
                        <i class="fa-solid fa-key"></i> <br>
                        Cambiar Contraseña
                    </a>
                </li>
            </ul>
        </div>
        </div>
    </article>
</body>
</html>
