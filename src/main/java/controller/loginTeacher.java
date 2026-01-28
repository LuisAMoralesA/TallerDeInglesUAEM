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
import controller.BaseDatosInsertar;
import encriptacion.SHA256;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet que se activa cuando se inicia sesion como Profesor en el sitio web. 
 * @author Luis Morales
 */
@WebServlet(name = "loginTeacher", urlPatterns = {"/loginTeacher"})
public class loginTeacher extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Busca los parametros de los cuadros de texto de usuario y contraseña
        String user = request.getParameter("user");
        SHA256 hash = new SHA256();
        String pass = hash.contraseñaNueva(request.getParameter("pass"));
        //Hashear la contraseña para compararla con la de la base de datos
        //String pass = String.valueOf(request.getParameter("pass").hashCode());
        //Declara al controlador de la base de datos
        BaseDatosInsertar base = new BaseDatosInsertar();
        HttpSession sesion; 
        //destroy();
            if(request.getParameter("submit")!=null){
                //Devuelve un numero segun lo indicado en el metodo de Inicio de Sesion
                int resultado = base.inicioSesion(user, pass, "PROFESOR");
                switch (resultado) {
                    case BaseDatosInsertar.ACCESO_CONCEDIDO:
                        //Establece una sesion al usuario
                        sesion = request.getSession(true); 
                        sesion.setAttribute("sesionIniciada", user);
                        response.sendRedirect("/tallerDeInglesUAEM/view/principal_teacher.jsp");
                        break;
                    case BaseDatosInsertar.USUARIO_NO_ENCONTRADO:
                        //Impide el paso debido a que el usuario no fue encontrado
                        sesion = request.getSession(false);
                        sesion.setAttribute("errorMessage", "Usuario no encontrado");
                        response.sendRedirect("/tallerDeInglesUAEM/view/login_teacher.jsp");
                        break;
                    case BaseDatosInsertar.DATO_INCORRECTO:
                        //Impide el paso debido a que la contraseña ingresada fue incorrecta
                        sesion = request.getSession(false);
                        sesion.setAttribute("errorMessage", "La contraseña ingresada es incorrecta");
                        response.sendRedirect("/tallerDeInglesUAEM/view/login_teacher.jsp");
                        break;
                }
            }      
        //catch SQL Exception
    }
}
