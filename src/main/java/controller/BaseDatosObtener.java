/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import model.*;
/**
 *
 * @author Luis Morales
 */

public class BaseDatosObtener {
    //Implementa constantes de inicio de sesión
    public static final int DATO_INCORRECTO = 1;
    public static final int USUARIO_NO_ENCONTRADO = 2;
    public static final int ACCESO_CONCEDIDO = 3;
    
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    public BaseDatosObtener(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    public ArrayList<Users> obtenerUsuario(String usuario){
        ArrayList<Users> listaUsuario = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM users WHERE nom_user = ?;";
            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_user = rs.getInt("id_user");
                String nom_user = rs.getString("nom_user");
                String password = rs.getString("password");
                String rango = rs.getString("rango");
                
                Users user = new Users(id_user, nom_user, password, rango);
                listaUsuario.add(user);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaUsuario;
    }
    
    
    public ArrayList<Teachers> obtenerTeacher(int id){
        ArrayList<Teachers> listaTeachers = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM TEACHERS WHERE id_teacher = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_teacher = rs.getInt("id_teacher");
                int id_user_teacher = rs.getInt("id_user_teacher");
                String apellido_paterno_teacher = rs.getString("apellido_paterno_teacher");
                String apellido_materno_teacher = rs.getString("apellido_materno_teacher");
                String nombre_teacher = rs.getString("nombre_teacher");
                String telefono_teacher = rs.getString("telefono_teacher");
                String email_teacher = rs.getString("email_teacher");
                Object fecha_nacimiento_teacher = rs.getObject("fecha_nacimiento_teacher");
                String status_teacher = rs.getString("status_teacher");
                int id_group_teacher = rs.getInt("id_group_teacher");
                
                Teachers teacher = new Teachers(id_teacher, id_user_teacher, apellido_paterno_teacher, apellido_materno_teacher,
                                                nombre_teacher, telefono_teacher, email_teacher, fecha_nacimiento_teacher, 
                                                status_teacher, id_group_teacher);
                listaTeachers.add(teacher);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaTeachers;
    }
    
    public ArrayList<Students> obtenerEstudiante(int id_user){
        ArrayList<Students> listaStudents = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM STUDENTS WHERE id_user_student = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_user);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_student = rs.getInt("id_student");
                int id_teacher_student = rs.getInt("id_teacher_student");
                int id_report_student = rs.getInt("id_report_student");
                int id_payment_student = rs.getInt("id_payment_student");
                int id_user_student = rs.getInt("id_user_student");
                String apellido_paterno_student = rs.getString("apellido_paterno_student");
                String apellido_materno_student = rs.getString("apellido_materno_student");
                String nombre_student = rs.getString("nombre_student");
                String telefono1_student = rs.getString("telefono1_student");
                String telefono2_student = rs.getString("telefono2_student");
                Object fecha_nacimiento_student = rs.getObject("fecha_nacimiento_student");
                String email_student = rs.getString("email_student");
                boolean sale_solo = rs.getBoolean("sale_solo");
   
                
                Students student = new Students(id_student, id_teacher_student, id_report_student, id_payment_student, 
                                                id_user_student, apellido_paterno_student, apellido_materno_student,
                                                nombre_student, telefono1_student, telefono2_student, fecha_nacimiento_student,
                                                email_student, sale_solo);
                listaStudents.add(student);
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaStudents;
    }
    
    public ArrayList<Grupos> obtenerGrupos(int id){
        ArrayList<Grupos> listaGrupos = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM GRUPOS WHERE id_group = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_group = rs.getInt("id_group");
                int id_grade = rs.getInt("id_grade");
                int level_group = rs.getInt("level_group");
                int id_category_group = rs.getInt("id_category_group");
                String classroom_group = rs.getString("classroom_group");
                
                Grupos grupo = new Grupos(id_group, id_grade, level_group, id_category_group, classroom_group);
                listaGrupos.add(grupo);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaGrupos;
    }
    
     public ArrayList<Grade> obtenerNivel(int id){
        ArrayList<Grade> listaNiveles = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM grade WHERE id_grade = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_grade = rs.getInt("id_grade");
                String description_grade = rs.getString("description_grade");
                
                Grade nivel = new Grade(id_grade, description_grade);
                listaNiveles.add(nivel);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaNiveles;
    }
     
    public ArrayList<Category> obtenerCategorias(int id){
        ArrayList<Category> listaCategorias = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM category WHERE id_category = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_category = rs.getInt("id_category");
                String description_category = rs.getString("description_category");
                
                Category cat = new Category(id_category, description_category);
                listaCategorias.add(cat);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }
        }
        return listaCategorias;
    }
    
    public ArrayList<String> obtenerDatosGrupo(int id_teacher){
        ArrayList <String> datosGrupo = new ArrayList<>();
        ArrayList <Teachers> listaTeacher = obtenerTeacher(id_teacher);
        Iterator <Teachers> iteradorTeacher = listaTeacher.iterator();
        //Busca datos del maestro
        Teachers per = null;
        while(iteradorTeacher.hasNext()){
            per = iteradorTeacher.next();
            int id_group_teacher = per.getId_group_teacher();
            ArrayList <Grupos> grupo = obtenerGrupos(id_group_teacher);
            Iterator <Grupos> iteradorGrupo = grupo.iterator();
            //Busca al grupo correspondiente
            Grupos per1 = null;
            while(iteradorGrupo.hasNext()){
                per1 = iteradorGrupo.next();
                int id_grade = per1.getId_grade();
                int level_group = per1.getLevel_group();
                int id_category_group = per1.getId_category_group();
                ArrayList <Grade> grade = obtenerNivel(id_grade);
                ArrayList <Category> category = obtenerCategorias(id_category_group);
                Iterator <Grade> iteradorNivel = grade.iterator();
                Iterator <Category> iteradorCategory = category.iterator();
                Grade per2 = null;
                Category per3 = null;
                while(iteradorNivel.hasNext()){
                    per2 = iteradorNivel.next();
                    datosGrupo.add(per2.getDescription_grade());
                    datosGrupo.add(String.valueOf(level_group));
                    while(iteradorCategory.hasNext()){
                        per3 = iteradorCategory.next();
                        datosGrupo.add(per3.getDescription_category());
                    }
                }
            }
        }
        return datosGrupo;
    }
    public ArrayList<String> obtenerDatosAlumno(String usuario){
        /*    0. Apellido Paterno
              1. Apellido Materno
              2. Nombre
              3. Nombre de Usuario
              4. Fecha de Nacimiento
              5. Numeros de Telefono
              6. Id del Profesor
              7. Grupo Asignado
              8. Rango
              9. Nombre de usuario
              10. Seguimiento de Pago
              11. Lista de Calificaciones*/
              
        ArrayList <String> listaDatos = new ArrayList<>();
        ArrayList <Users> lista = obtenerUsuario(usuario);
        Iterator  <Users> iter = lista.iterator();
        Users per = null;
        while(iter.hasNext()){
            per = iter.next();
            int idUsuario = per.getId_user();
            String nombreUsuario = per.getNom_user(); 
            //Accede a la lista de alumnos y busca al que concuerda con el usuario
            ArrayList <Students> datos = obtenerEstudiante(idUsuario);
            Iterator  <Students> iter1 = datos.iterator();  
            Students perStudents = null;
            while(iter1.hasNext()){
                perStudents = iter1.next();
                listaDatos.add(perStudents.getApellido_paterno_student());
                listaDatos.add(perStudents.getApellido_materno_student());
                listaDatos.add(perStudents.getNombre_student());
                listaDatos.add(nombreUsuario);
                listaDatos.add(String.valueOf(perStudents.getFecha_nacimiento_student()));
                listaDatos.add(perStudents.getTelefono1_student() + "<br>" +
                               perStudents.getTelefono1_student());
                listaDatos.add(String.valueOf(perStudents.getId_teacher_student()));
                if(perStudents.getId_teacher_student()==0){
                    listaDatos.add("NINGUNO");
                }
                else{
                   ArrayList<String> grupo = obtenerDatosGrupo(perStudents.getId_teacher_student());
                   String datosGrupos = grupo.get(0) + " "; 
                   datosGrupos += grupo.get(1) + ": ";
                   datosGrupos +=grupo.get(2);
                   listaDatos.add(datosGrupos); 
                }
                listaDatos.add(per.getRango());
                listaDatos.add(String.valueOf(idUsuario));
                listaDatos.add(String.valueOf(perStudents.getId_payment_student()));
                listaDatos.add(String.valueOf(perStudents.getId_report_student()));
            }
        }
        return listaDatos;
    }
}
