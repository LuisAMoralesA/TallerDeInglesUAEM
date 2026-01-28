/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import model.*;
import controller.BaseDatosActualizar;
import encriptacion.SHA256;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.util.Iterator;

/**
 * Servlet que se activa cuando se intenta actualizar la informacion de inicio de sesion de un usuario en el sitio web. 
 * @author Luis Morales
 */
@WebServlet(name = "updateUser", urlPatterns = {"/updateUser"})
public class updateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Busca los parametros de los cuadros de texto del usuario para actualización
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String rango = request.getParameter("rango");
        String url = "/tallerDeInglesUAEM/view/updateUser.jsp"; 
        
        //No poner atributos disabled en HTML por que no son detectados
        if(request.getParameter("update")!=null){
            HttpSession sesion = request.getSession();
            int uid = Integer.parseInt(request.getParameter("iduser"));
            if(password1.equals(password2)){
                //Crea las conexiones a la base de datos
                BaseDatosActualizar base = new BaseDatosActualizar();
                //Hashear la contraseña a la hora de ingresarla a la base de datos
                SHA256 hash = new SHA256();
                password1 = hash.contraseñaNueva(password1);
                
                //Compara si hay un usuario con nombre igual en la base de datos si gusta hacer el cambio
                BaseDatosObtener obtener = new BaseDatosObtener();
                ArrayList <Users> datosUsuario = obtener.obtenerUsuario(username);
                Iterator <Users> it = datosUsuario.iterator();
                Users per = null;
                String nombreUsuarioComparar = "";
                if(it.hasNext()){
                    per = it.next();
                    nombreUsuarioComparar = per.getNom_user();
                }
                
                if(!nombreUsuarioComparar.equals(username)){
                    //Actualizar los valores 
                    Users user = new Users(uid, username, password1, rango);
                    base.actualizarUsuario(user);

                    sesion.setAttribute("actualizacionCompleta","Usuario Actualizado correctamente");

                    switch(rango){
                        case "ESTUDIANTE": url = "/tallerDeInglesUAEM/view/principal_students.jsp"; break;
                        case "ADMINISTRADOR" : url = "/tallerDeInglesUAEM/view/principal_admin.jsp"; break;
                        case "PROFESOR": url = "/tallerDeInglesUAEM/view/principal_teacher.jsp"; break;
                    }
                    sesion.setAttribute("sesionIniciada", username);
                    response.sendRedirect(url);
                }
                
                else{
                    sesion.setAttribute("contraseñaIncorrecta","El usuario ya existe en la Base de Datos");
                    response.sendRedirect(url);
                }
            }
            else{
                sesion.setAttribute("contraseñaIncorrecta","El dato ingresado no es valido");
                response.sendRedirect(url);
            }
        }
    }
}
