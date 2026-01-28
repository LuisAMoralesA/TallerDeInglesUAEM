<%@page import ="java.sql.*" %>
<%@page import ="com.mysql.jdbc.Driver" %>
<%@page import ="controller.BaseDatosObtener"%>
<%@page import ="model.*"%>
<%@page import ="java.util.*"%>
<%@page import = "jakarta.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Taller de Ingles para Niños y Adolescentes </title>
    
    <link rel="stylesheet" href="../css/style_menuprincipal.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href = "../Images/uaem.png" rel = "icon"/>
    <!--Librerias para alertas emergentes-->
        <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.19.1/dist/sweetalert2.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.19.1/dist/sweetalert2.all.min.js"></script>
        <!--Link para visualizar alertas
            https://sweetalert2.github.io/-->
</head>

<body>
    <%
        int id_user = 0; 
        String username = "";
        String password = "";  
        String rango = "";
        
        //Obtiene la sesion al usuario
        HttpSession sesion = request.getSession();
        String usuario = (String) sesion.getAttribute("sesionIniciada");
        //Accede a la base de datos y accede a los datos del usuario
        BaseDatosObtener base = new BaseDatosObtener();
        ArrayList <Users> lista = base.obtenerUsuario(usuario);
        Iterator<Users> iter = lista.iterator();
        Users per = null;
        
        if(iter.hasNext()){
            per = iter.next();
            id_user = per.getId_user();
            username = per.getNom_user();
            password = per.getPassword();
            rango = String.valueOf(sesion.getAttribute("rango"));
        }
    %>
    <aside id = "menu_lateral">
        <ul id="menu_opciones">
            <li>
                <img src="../Images/Logo_Taller2.png" alt=""> 
            </li>
            
            <%if (rango.equals("ESTUDIANTE")){%>
            <li>
                <a href="../view/principal_students.jsp">
                    <i class="fa-solid fa-circle-user"></i> <br>
                        Cuenta
                </a>
            </li>

            <li>
                <a href="">
                    <i class="fa-solid fa-dollar-sign"></i> <br>
                    Seguimiento
                </a>
            </li>

            <li>
                <a href="">
                    <i class="fa-solid fa-school"></i> <br>
                    Calificaciones
                </a>
            </li>

            <li>
                <a href="../view/login_student.jsp">
                    <i class="fa-solid fa-right-from-bracket"></i> <br>
                    Cerrar Sesión
                </a>
            </li>
            <%}
            else if (rango.equals("PROFESOR")){%>
            <li>
                <a href="../view/principal_teacher.jsp">
                    <i class="fa-solid fa-circle-user"></i> <br>
                        Cuenta
                </a>
            </li>

            <li>
                <a href="">
                   <i class="fa-solid fa-print"></i><br>
                    Bitacoras
                </a>
            </li>

            <li>
                <a href="">
                    <i class="fa-solid fa-school"></i> <br>
                    Asignar Calificaciones
                </a>
            </li>

            <li>
                <a href="../view/login_teacher.jsp">
                    <i class="fa-solid fa-right-from-bracket"></i> <br>
                    Cerrar Sesión
                </a>
            </li>
            <%}
            else {%>
            <li>
                <a href="../view/principal_admin.jsp"">
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
                <a href="">
                    <i class="fa-solid fa-right-from-bracket"></i> <br>
                    Cerrar Sesión
                </a>
            </li>
            <%}%>
        </ul>
    </aside>
    <article>
        <%
                String mensaje = (String) sesion.getAttribute("contraseñaIncorrecta");
                if (mensaje != null && !mensaje.isEmpty()){
            %>
                <script>
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "<%= mensaje %>",
                        confirmButtonColor: "#9C8412"
                      });
                </script>
                <%}
                sesion.setAttribute("contraseñaIncorrecta", null);%>
        <div id = "perfil_usuario">
            <div class="form-container">
                <form action="../updateUser" method="post">
                <h1> 
                    <i class="fa-solid fa-arrows-rotate"></i><br> 
                    Actualizar Datos de Inicio de Sesión 
                </h1>

                <input type = "hidden" name = "iduser" id="iduser" value = "<%=id_user%>">
                <label for="username">
                    Nombre de Usuario: 
                </label>
                <input type="text" name="username" id="username" required value = "<%=username%>">

                <label for="password1">
                    Contraseña: 
                </label>
                <input type="password" name="password1" id="password1" required value = "">

                <label for="password2">
                    Confirmar Contraseña: 
                </label>
                <input type="password" name="password2" id="password2" required value = "">
                <input type = "hidden" name = "rango" id="rango" value = "<%=rango%>">
                
                <button name = "update" id ="update">
                    <i class="fa-solid fa-pen"></i><br>
                    Actualizar Datos
                </button>
            </form>
            </div>
        </div>
    </article>
</body>

</html>