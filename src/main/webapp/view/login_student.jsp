<%-- 
    Document   : login_student
    Created on : 19 abr. 2025, 15:08:03
    Author     : Luis Morales
--%>

<%@page import="java.sql.*" %>
<%@page import="com.mysql.jdbc.Driver" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controller.BaseDatos"%>
<!doctype html>
<html lang = "es">
    <head>
        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width-device-width, initial-scale = 1.0">
        <title> Iniciar Sesion </title>
        <link rel = "stylesheet" href = "/tallerDeInglesUAEM/css/style_login.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href = "/tallerDeInglesUAEM/Images/uaem.png" rel = "icon"/>
    </head>

    <body>
        <header class = "header">
            <div class="menu container">
                <a href="https://cuecatepec.uaemex.mx/" class="logo-navbar">
                    <img src="/tallerDeInglesUAEM/Images/uaem.png" class = "logo-navbar" alt="" >
                </a>
    
                <input type = "checkbox" id = "menu" />
                <label for="menu"> 
                    <img src="/tallerDeInglesUAEM/Images/Menu.png" class = "menu-icono" alt="">
                </label>
    
                <nav class = "navbar">
                    <ul>
                        <li>
                            <a href="/tallerDeInglesUAEM/view/index.html"> Inicio </a>
                        </li>

                        <li>
                            <a href="/tallerDeInglesUAEM/view/login_student.jsp"> Alumnos </a>  
                        </li>
                        <li> 
                            <a href="/tallerDeInglesUAEM/view/login_teacher.jsp"> Profesores </a>  
                        </li>
                        <li> 
                            <a href="/tallerDeInglesUAEM/view/login_admin.jsp"> Administrativos </a>  
                        </li>
                    </ul>
                </nav>
            </div>
        </header>

        <main>
            <div class="contenedor_form">
                <div class="caja_trasera">
                    <div class="caja_trasera_login">
                        <h1> ¿Estas registrado en el sistema? </h1>
                        <p> Inicia sesion para ingresar </p>
                        <button id = "btn_ingresar" type="submit" name="submit"> Ingresar </button>
                    </div>
    
                    <div class="caja_trasera_register">
                        <h1> ¿Aún no tienes una cuenta? </h1>
                        <p> Crea una cuenta para iniciar sesión </p>
                        <button id = "btn_registro"> Registrarse </button>
                    </div>
                </div>
    
                <div class="contenedor_login_register">
                    
                    <%
                        // La palabra action debe tener el nombre de la clase del Servlet para funcionar
                        // ¿Como se llama a un archivo class desde un form jsp? 
                    %>
                    <form class = "form_login" method = "POST" action = "../loginStudent" >
                        <h2> Iniciar Sesión </h2>
                        <input type = "text" id="user" name="user" placeholder="Usuario" required = "required">
                        <input type = "password" id="pass" name="pass" placeholder="Contraseña" required = "required">
                        <button type="submit" name="submit"> Ingresar </button>
                    </form>
                    
                    <form action = "" class = "form_register" method = "POST">
                        <h2> Registrarse </h2>
                        <input type = "text" placeholder="Apellido Paterno">
                        <input type = "text" placeholder="Apellido Materno">
                        <input type = "text" placeholder="Nombre">
                        <p> Fecha de nacimiento:  </p> 
                        <input type = "date" placeholder="Fecha de nacimiento" class = "date">
                        <input type = "text" placeholder="Correo Electronico">
                        <input type = "password" placeholder="Contraseña">
                        <input type = "password" placeholder="Confirmar Contraseña">
                        <button type="submit" name="add" id = "add"> Concluir registro </button>
                    </form>
                </div> 
            </div>
        </main>
        <br><br> <br> <br> <br><br> <br> <br>
        <%
            String mensaje = (String) request.getAttribute("errorMessage");
            if (mensaje != null && !mensaje.isEmpty()){
        %>
        <div class = "alert alert-success" role ="alert">
            <%= mensaje %>
        </div>
        <%}%>
        <footer id="sp-footer" > 
            <div class="container-conocenos">
                <br>
                <h1> Contactanos </h1>
                <br>
    
                <table class = "tabla-conocenos">
                    <tr>
                        <td>
                            <p><i class="fas fa-map-marker-alt"></i>
                                Instituto Literario 100, Centro, <br>
                                Toluca, Estado de México, <br>
                                México, C.P. 50000 </p>
                        </td>
        
                        <td>
                            <p>
                                <span>
                                    UAEMéx
                                </span>&nbsp;
                                <a href="https://www.facebook.com/UAEMex" target="_blank" rel="noopener">
                                    <i class="fa-brands fa-facebook"></i>&nbsp;
                                </a>
    
                                <a href="https://twitter.com/UAEM_MX" target="_blank" rel="noopener">
                                    <i class="fa-solid fa-x"></i>&nbsp;
                                </a>
                                
                                <a href="https://www.youtube.com/channel/UCe8Se89aeErlTzKnwhFkOtQ" target="_blank" rel="noopener">
                                    <i class="fa-brands fa-youtube"></i>
                                </a>&nbsp;
                                
                                <a href="https://www.instagram.com/uaemex_oficial/" target="_blank" rel="noopener">
                                    <i class="fa-brands fa-square-instagram"></i>
                                </a>&nbsp;
                            </p> 
                        </td>
        
                        <td>
                            <p>
                                <span>
                                    <a href="https://www.uaemex.mx/comit%C3%A9-de-%C3%A9tica-de-la-investigaci%C3%B3n.html" target="_blank" rel="noopener">
                                        <i class="fas fa-external-link-alt" style="font-size: 20px;" aria-hidden="true"></i> 
                                        Comité de Ética de investigación
                                    </a>
                                </span>
                            </p>
                        </td>
    
                        <td>
                            <p>
                                <a href="http://web.uaemex.mx/contraloriasocial.html" target="_blank" rel="noopener">
                                    <img src="https://www.uaemex.mx/images/2020/contraloriasocial.png" alt="Contraloría Social" width="220" height="112" style="display: block; margin-left: auto; margin-right: auto;" />
                                </a>
                            </p>
                        </td>
                    </tr>
                </table>
                <br>
                <p class = "privacy">
                    <span style="color: #000000;">
                        <a href="https://www.uaemex.mx/avisos/Aviso_Privacidad.pdf" target="_blank" rel="noopener" style="color: #000000;">
                            <span>
                                Aviso. de Privacidad Universidad Autónoma del Estado de México&nbsp;© 2022 Todos los derechos reservados
                            </span>
                        </a>
                    </span>
                </p>
                
                <p>
                    <a href="https://tics.uaemex.mx" target="_blank" rel="noopener">
                        <img src="https://tics.uaemex.mx/images/logos/DTIC_1B.png" alt="identidad-DTIC-2019_02.png" width="213" height="73" style="display: block; margin-left: auto; margin-right: auto;" />
                    </a>
                </p>
        </footer>
        <script src = "/tallerDeInglesUAEM/js/prueba.js"></script>
    </body>
    
</html>
<%
        //ResultSet rs = null;
            //Clases Entidad: Conecta la aplicacion con la Base de Datos. (Modelo)
        /*Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            stm = con.createStatement();*/
        /*
            rs = stm.executeQuery("SELECT * FROM users WHERE nom_user ='" + user + "' AND rango ='ESTUDIANTE'" );
                    if(rs.next()){
                        if(user.equals(rs.getString(2)) && pass.equals(rs.getString(3))){
                            int id = rs.getInt(1);
                            ResultSet rsAdmin = stm.executeQuery("SELECT * FROM students WHERE id_user_student ='" + id + "';" );
                            rsAdmin.next();
                            String firstName = rsAdmin.getString(6) ;
                            String lastName = rsAdmin.getString(7);
                            String name = rsAdmin.getString(8);
                            
                            request.getRequestDispatcher("principal_students.jsp").forward(request, response);
                            //out.println("BIENVENIDO AL SISTEMA, ALUMNO "+ "<br>" + firstName + " " + lastName + " " + name);
                            
                            //Cookies ¿Como generar sesion de usuario en JSP?
                            //Pasar valores entre Paginas JSP
                            //End Sesion
                        }else{
                            out.println("Alguno de los datos son incorrectos");
                        }
                    }
                    else{
                        out.println("Usuario no identificado");
                    } 
        */%>
        
        <%
            /*
                if(request.getParameter("submit") != null){
                    String user = request.getParameter("user");
                    String pass = request.getParameter("pass");
                    BaseDatos base = new BaseDatos();
                    String accion = base.inicioSesion(user,pass,"ESTUDIANTE");
                    switch(accion){
                        case "1":
                            out.println("Alguno de los datos son incorrectos");
                            break;
                        
                        case "2":
                            out.println("Usuario no identificado");
                            break;
                        
                        default:
                            //
                            request.getRequestDispatcher("principal_students.jsp?u="+accion).forward(request, response);
                    }
                }
            */
        %>