<%-- 
    Document   : principal_students
    Created on : 22 abr. 2025, 21:05:47
    Author     : Luis Morales
--%>

<%@page import="java.sql.*" %>
<%@page import="com.mysql.jdbc.Driver" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href = "../css/style_principal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href = "../Images/uaem.png" rel = "icon"></link>
    <title>Bienvenido!!</title>
</head>
<body>
    <section class = "section-logo">
        <div class="img_taller"></div>
            <img src="../Images/Logo_Taller.png" alt="Imagen_Taller" class = "logo"/>
        </div>
    </section>

    <div class = "info-user">
        <div class="tabla-usuario">
            <table border = 1>
                <tr>
                    <th>
                        
                    </th>
                </tr>
                
                <tr>
                    <th colspan = "2">
                        <h1> Información del Usuario </h1>
                    </th>
                </tr>
                
                <tr>
                        <td colspan = "2"> 
                            <div class="img_user">
                                <img src="../Images/user3.png" alt="img_usuario" class = "user"></td>
                            </div>
                        </td>
                </tr>
    
                <tr class = "impar">
                    <td class = "dato">Apellido Paterno: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "par">
                    <td class = "dato">Apellido Materno: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "impar">
                    <td class = "dato">Nombre: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "par">
                    <td class = "dato">Nombre de Usuario: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "impar">
                    <td class = "dato">Fecha de Nacimiento: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "par">
                    <td class = "dato">Numero de Telefono: </td>
                    <td>??? </td>
                </tr>
    
                <tr class = "impar">
                    <td class = "dato">Grupo que Imparte: </td>
                    <td>??? </td>
                </tr>
                
                <tr class = "par">
                    <td class = "dato">Rango: </td>
                    <td>??? </td>
                </tr>
            </table>

            <div class="form-user">
                <form action = "" class = "form_options" method = "POST">
                    
                        <td><button>Modificar Datos</button></td>
                        <td><button>Imprimir Bitacoras</button></td>
                        <td><button>Asignar Calificaciones</button></td>
                        <td><button>Cerrar Sesión</button></td>
                </form>
            </div>
        </div>
        
    </div>
</body>
</html>
