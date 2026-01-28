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
        //Obtiene la sesion al usuario
        HttpSession sesion = request.getSession();
        String usuario = String.valueOf(sesion.getAttribute("sesionIniciada"));
        String rango = String.valueOf(sesion.getAttribute("rango"));
        String id_user = String.valueOf(sesion.getAttribute("userId"));
        
        //Accede a la base de datos y accede a los datos del usuario
        BaseDatosObtener base = new BaseDatosObtener();
        ArrayList <String> lista = base.obtenerData(usuario, rango);
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
        <div id = "perfil_usuario">
            <div class="form-container1">
                <form action="../updateInfo" method="post">
                <div class ="titulo-form">
                    <h1> 
                    <i class="fa-solid fa-arrows-rotate"></i><br> 
                    Actualizar Datos Personales 
                    </h1>
                </div>
                <%
                    String id = lista.get(0);
                    String apaterno = lista.get(1);
                    String amaterno = lista.get(2);
                    String nombre = lista.get(3);
                    String birthdate = lista.get(4);
                    String phone1 = lista.get(5);
                    String email = lista.get(6);
                %>
                
                <input type = "hidden" name = "iduser" id="iduser" value = "<%=id_user%>">
                <input type = "hidden" name = "rango" id="rango" value = "<%=rango%>">
                
                <div>
                    <input type = "hidden" name = "idprincipal" id="idprincipal" value = "<%=id%>">
                <label for="apaterno">
                    Apellido Paterno: 
                </label>
                <input type="text" name="apaterno" id="apaterno" required value ="<%=apaterno%>">

                <label for="amaterno">
                    Apellido Materno: 
                </label>
                <input type="text" name="amaterno" id="amaterno" required value ="<%=amaterno%>">

               <label for="nombre">
                    Nombre(s): 
                </label>
                <input type="text" name="nombre" id="nombre" required value ="<%=nombre%>">

                <label for="birthdate">
                    Fecha de Nacimiento: 
                </label>
                <input type="date" name="birthdate" id="birthdate" required value ="<%=birthdate%>">

                <label for="phone1">
                    Telefono: 
                </label>
                <input type="text" name="phone1" id="phone1" value ="<%=phone1%>" maxlength = 10>

                <label for="email">
                    Correo Electronico: 
                </label>
                </div>  
                
                <div>
                  <input type="email" name="email" id="email" value ="<%=email%>">
                <%
                    if (rango.equals("ESTUDIANTE")){
                        String phone2 = lista.get(7);
                        String sale_solo = lista.get(8) ;
                        String idprofesor = lista.get(12);
                        String grupo = lista.get(15);
                %>
                <label for="phone2">
                    Telefono extra: 
                </label>
                <input type="text" name="phone2" id="phone2" value ="<%=phone2%>" maxlength = 10>
                <label for="sale_solo">
                    ¿Sale solo?: 
                </label>
                <input type="checkbox" name="sale_solo" id="sale_solo" value =1 />
                <input type = "hidden" name = "idprofesor" id="idprofesor" value = "<%=idprofesor%>">
                <%}
                
                    else if(rango.equals("PROFESOR")){
                        String idgrupo = lista.get(7);
                        String status = lista.get(8);
                %>
                </label>
                <input type="hidden" name="status" id="status" value ="<%=status%>" >
                <input type="hidden" name="grupo" id="grupo" value ="<%=idgrupo%>" >
                <%}%>
                </div>
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