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
@WebServlet(name = "principalStudent", urlPatterns = {"/principalStudent"})
public class principalStudent extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(); 
        if(sesion != null && sesion.getAttribute("sesionIniciada")!=null){
            String usuario = (String) sesion.getAttribute("sesionIniciada");
            request.setAttribute("nombreUsuario", usuario);
            request.getRequestDispatcher("/view/principal_students.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("/view/login_student.jsp");
        }
        
        
    }
}
