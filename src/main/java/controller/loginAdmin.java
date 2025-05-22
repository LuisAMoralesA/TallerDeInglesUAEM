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
import controller.BaseDatos;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Luis Morales
 */
@WebServlet(name = "loginAdmin", urlPatterns = {"/loginAdmin"})
public class loginAdmin extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Busca los parametros de los cuadros de texto de usuario y contraseña
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        //Declara al controlador de la base de datos
        BaseDatos base = new BaseDatos();
        HttpSession sesion; 
        //destroy();
            if(request.getParameter("submit")!=null){
                //Devuelve un numero segun lo indicado en el metodo de Inicio de Sesion
                int resultado = base.inicioSesion(user, pass, "ADMINISTRADOR");
                switch (resultado) {
                    case BaseDatos.ACCESO_CONCEDIDO:
                        //Establece una sesion al usuario
                        sesion = request.getSession(true); 
                        sesion.setAttribute("sesionIniciada", user);
                        response.sendRedirect("/tallerDeInglesUAEM/view/principal_admin.jsp");
                        break;
                    case BaseDatos.USUARIO_NO_ENCONTRADO:
                        //Impide el paso debido a que el usuario no fue encontrado
                        sesion = request.getSession(false);
                        sesion.setAttribute("errorMessage", "Usuario no encontrado");
                        response.sendRedirect("/tallerDeInglesUAEM/view/login_admin.jsp");
                        break;
                    case BaseDatos.DATO_INCORRECTO:
                        //Impide el paso debido a que la contraseña ingresada fue incorrecta
                        sesion = request.getSession(false);
                        sesion.setAttribute("errorMessage", "La contraseña ingresada es incorrecta");
                        response.sendRedirect("/tallerDeInglesUAEM/view/login_admin.jsp");
                        break;
                }
            }      
        //catch SQL Exception
    }
}
