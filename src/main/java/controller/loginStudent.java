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
@WebServlet(name = "loginStudent", urlPatterns = {"/loginStudent"})
public class loginStudent extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Busca los parametros de los cuadros de texto de usuario y contraseña
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        //Declara al controlador de la base de datos
        BaseDatos base = new BaseDatos();
        //destroy();
            //Devuelve un numero segun lo indicado en el metodo de Inicio de Sesion
            int resultado = base.inicioSesion(user, pass, "ESTUDIANTE");
            switch (resultado) {
                case BaseDatos.ACCESO_CONCEDIDO:
                    //Estableces una sesion al usuario
                    HttpSession sesion = request.getSession(true); 
                    sesion.setAttribute("sesionIniciada", user);
                    response.sendRedirect(request.getContextPath()+"/principalStudent");
                    break;
                case BaseDatos.USUARIO_NO_ENCONTRADO:
                    request.setAttribute("errorMessage", "Usuario no encontrado");
                    request.getRequestDispatcher("/view/login_student.jsp").forward(request, response);
                    break;
                case BaseDatos.DATO_INCORRECTO:
                    //BaseDatos.DATO_INCORRECTO;
                    request.setAttribute("errorMessage", "Alguno de los datos esta incorrecto");
                    request.getRequestDispatcher("/view/login_student.jsp").forward(request, response);
                    //request.setAttribute("incorrectInformation", user);
                    break;
            }
        //catch SQL Exception
    }
}
