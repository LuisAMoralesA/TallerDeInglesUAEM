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

//NOTA: Agregar esto a GitHub
/**
* Esta clase contiene un conjunto de clases para visualizacion de Informacion especifica de una base de datos. 
* @author Luis Morales
**/

public class BaseDatosObtener {
    
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    /**
     * Este constructor funciona para hacer conexion con la base de datos,
     * usando un URL y un Driver de conexion (8.0)
     **/
    public BaseDatosObtener(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar los datos de un usuario especifico 
     * @param usuario: Un nombre de usuario para comparar en la base de datos 
     * @return ArrayList: Datos de un usuario especifico en la base de datos
     **/
    
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
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar los datos de un profesor especifico 
     * @param id_user: Id de usuario del profesor para comparar en la base de datos
     * @return ArrayList: Datos de un profesor especifico en la base de datos
     **/
    
    public ArrayList<Teachers> obtenerTeacher(int id_user){
        ArrayList<Teachers> listaTeachers = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM TEACHERS WHERE id_user_teacher = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_user);
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
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar los datos de un administrador especifico 
     * @param id_user: Id de usuario del administrador para comparar en la base de datos
     * @return ArrayList: Datos de un administrador especifico en la base de datos
     **/
     public ArrayList<Admin_school> obtenerAdministrador(int id_user){
        ArrayList<Admin_school> listaAdministrador = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM admin_school WHERE id_user_admin = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_user);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_admin = rs.getInt("id_admin");
                int id_user_admin = rs.getInt("id_user_admin");
                String apellido_paterno_admin = rs.getString("apellido_paterno_admin");
                String apellido_materno_admin = rs.getString("apellido_materno_admin");
                String nombre_admin = rs.getString("nombre_admin");
                Object fecha_nacimiento_admin = rs.getObject("fecha_nacimiento_admin");
                String telefono_admin = rs.getString("telefono_admin");
                String email_admin = rs.getString("email_admin");
   
                
                Admin_school administrator = new Admin_school(id_admin, id_user_admin, apellido_paterno_admin, apellido_materno_admin,
                                                nombre_admin, fecha_nacimiento_admin,telefono_admin, email_admin);
                listaAdministrador.add(administrator);
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
        return listaAdministrador;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar los datos de un alumno especifico 
     * @param id_user: Id de usuario del alumno para comparar en la base de datos
     * @return ArrayList: Datos de un  alumno especifico en la base de datos
     **/
     
    public ArrayList<Students> obtenerEstudiante(int id_user){
        ArrayList<Students> listaStudents = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
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
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar las calificaciones de un alumno especifico
     * @param id: Id de la lista de calificaciones a buscar
     * @return ArrayList: Lista de calificaciones de un alumno especifico
     **/
    public ArrayList<Report> obtenerCalificaciones(int id){
        ArrayList<Report> listaCalificaciones = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM report WHERE id_report = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_report = rs.getInt("id_report");
                double first_partial_report = rs.getDouble("first_partial_report");
                double second_partial_report = rs.getDouble("second_partial_report");
                double avg_report = rs.getDouble("avg_report");
                
                Report reporte = new Report(id_report, first_partial_report, second_partial_report, avg_report);
                listaCalificaciones.add(reporte);
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
        return listaCalificaciones;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar un estatus de pago especifico
     * @param id: Id de la descripcion de estatus en la base de datos
     * @return ArrayList: Estatus e identificador en la base de datos
     **/
    
    public ArrayList<Payment_status> obtenerEstatus(int id){
        ArrayList<Payment_status> listaEstatus = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM payment_status WHERE id_status = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_status = rs.getInt("id_status");
                String description_status = rs.getString("description_status");
                
                Payment_status status = new Payment_status(id_status, description_status);
                listaEstatus.add(status);
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
        return listaEstatus;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar el seguimiento de pago de un alumno especifico
     * @param id: Id de la lista de seguimiento buscado en la base de datos
     * @return ArrayList: Lista de seguimiento de un alumno especifico
     **/
    
    public ArrayList<Payment> obtenerSeguimiento(int id){
        ArrayList<Payment> listaSeguimiento = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM payment WHERE id_payment;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_payment = rs.getInt("id_status");
                boolean register_payment = rs.getBoolean("register_payment");
                boolean pay_1 = rs.getBoolean("pay_1");
                boolean pay_2 = rs.getBoolean("pay_2");
                boolean pay_3 = rs.getBoolean("pay_3");
                boolean pay_4 = rs.getBoolean("pay_4");
                boolean pay_5 = rs.getBoolean("pay_5");
                boolean pay_6 = rs.getBoolean("pay_6");
                boolean pay_7 = rs.getBoolean("pay_7");
                int payment_status = rs.getInt("payment_status");
                
                Payment pago = new Payment(id_payment, register_payment, pay_1, pay_2, pay_3, pay_4, pay_5, pay_6, pay_7, payment_status);
                listaSeguimiento.add(pago);
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
        return listaSeguimiento;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar la informacion de un mes especifico
     * @param id: Id del mes buscado en la base de datos
     * @return ArrayList: Informacion del mes solicitado
     **/
    
    public ArrayList<Pay_simbology> obtenerCalendario(int id){
        ArrayList<Pay_simbology> calendario = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM pay_simbology WHERE id_pay = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_pay = rs.getInt("id_pay");
                String month = rs.getString("month");
                String description_pay = rs.getString("description_pay");
                double cost_pay = rs.getDouble("cost_pay");
                String period_pay = rs.getString("period_pay");
                Object deadline_pay = rs.getObject("deadline_pay");
                Pay_simbology mes = new Pay_simbology(id_pay, month, description_pay, cost_pay, period_pay, deadline_pay);
                calendario.add(mes);
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
        return calendario;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar la informacion de un grupo especifico
     * @param id: Id del grupo  buscado en la base de datos
     * @return ArrayList: Informacion del grupo solicitado
     **/
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
    
    /**
     * Este metodo permite hacer una consulta SQL para regresar la informacion de un nivel especifico. 
     * <br>
     * NOTA: Actualmente solo se puede seleccionar entre Basico, Intermedio o Avanzado
     * @param id: Id del nivel buscado en la base de datos
     * @return ArrayList: Informacion del nivel solicitado
     **/
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
     
    /**
     * Este metodo permite hacer una consulta SQL para regresar la informacion de una categoria especifica. 
     * <br>
     * NOTA: Actualmente solo se puede seleccionar entre Children o Teens
     * @param id: Id de la categroia en la base de datos
     * @return ArrayList: Informacion de la categoria solicitada
     **/
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
    
    /**
     * Este metodo permite hacer una consulta SQL de varias tablas enfocada en un grupo y visualizar su informacion en la pagina web. 
     * <br>
     * 
     * @param id_grupo: Id del grupo a consultar
     * @return ArrayList: Informacion del grupo localizada en diferentes tablas.
     **/
    public ArrayList<ConsultaGrupos> obtenerDatosGrupo(int id_grupo){
        ArrayList <ConsultaGrupos> datosGrupo = new ArrayList<>();
         try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "SELECT grupos.id_group, grupos.id_grade, grade.description_grade ," +
                            "grupos.level_group,  grupos.id_category_group, category.description_category FROM " +
                            "(" +
                            "	(grupos INNER JOIN grade ON grupos.id_grade = grade.id_grade) " +
                            "	INNER JOIN category ON grupos.id_category_group = category.id_category" +
                            ")" +
                            "WHERE id_group = (?);";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_grupo);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                //0. Id del Grupo
                int idGrupo = rs.getInt(1);
                //1. Id del Grado
                int id_grade = rs.getInt(2);
                //2. Descripcion del Grado
                String grado = rs.getString(3);
                //3. Nivel del Grupo
                int nivel = rs.getInt(4);
                //4. Id de Categoria
                int idCategory = rs.getInt(5);
                //5. Descripcion de Categoria
                String categoria = rs.getString(6);
                
                ConsultaGrupos cons = new ConsultaGrupos(idGrupo, id_grade, grado, nivel, idCategory, categoria);
                datosGrupo.add(cons);
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
        return datosGrupo;
        
    }
    
    /**
     * Este metodo permite hacer una consulta SQL de varias tablas de todos los grupos de la
     * base de datos y visualizar toda la informacion en la pagina web. 
     * <br>
     * 
     * @return ArrayList: Informacion del todos los grupos localizada en diferentes tablas.
     **/
    public ArrayList<ConsultaGrupos> obtenerDatosTodosGrupos(){
        ArrayList <ConsultaGrupos> datosGrupo = new ArrayList<>();
         try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "SELECT grupos.id_group, grupos.id_grade, grade.description_grade ," +
                            "grupos.level_group,  grupos.id_category_group, category.description_category FROM " +
                            "(" +
                            "	(grupos INNER JOIN grade ON grupos.id_grade = grade.id_grade) " +
                            "	INNER JOIN category ON grupos.id_category_group = category.id_category" +
                            ");";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                //0. Id del Grupo
                int idGrupo = rs.getInt(1);
                //1. Id del Grado
                int id_grade = rs.getInt(2);
                //2. Descripcion del Grado
                String grado = rs.getString(3);
                //3. Nivel del Grupo
                int nivel = rs.getInt(4);
                //4. Id de Categoria
                int idCategory = rs.getInt(5);
                //5. Descripcion de Categoria
                String categoria = rs.getString(6);
                
                ConsultaGrupos cons = new ConsultaGrupos(idGrupo, id_grade, grado, nivel, idCategory, categoria);
                datosGrupo.add(cons);
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
        return datosGrupo;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL de conteo para saber la cantidad de grupos registrados en la Base de datos. 
     * <br>
     * @return int: Cantidad de grupos en la base de datos. 
     **/
    public int conteoAlumnos(){
        int conteo = 0;
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT COUNT(*) FROM STUDENTS;";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                conteo = rs.getInt(1);
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
        return conteo;
    }
    /**
     * Este metodo permite hacer una consulta SQL de varias tablas enfocada en un administrador y visualizar su informacion en la pagina web. 
     * <br>
     * 
     * @param usuario: Nombre de usuario a buscar en la base de datos
     * @return ArrayList: Informacion del administrador localizada en diferentes tablas.
     **/
    
    public ArrayList<String> obtenerDatosAdministrador(String usuario){
        //1. Obtiene los datos de ingreso del usuario
        ArrayList <String> listaDatos = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "SELECT admin_school.id_admin, admin_school.apellido_paterno_admin, admin_school.apellido_materno_admin, \n" +
                        "admin_school.nombre_admin, users.rango, users.id_user, users.nom_user, admin_school.telefono_admin, \n" + 
                        "admin_school.email_admin, admin_school.fecha_nacimiento_admin FROM admin_school \n" +
                        "INNER JOIN users ON users.id_user = admin_school.id_user_admin \n" +
                        "WHERE nom_user = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                //0. Id del Administrador
                String id_admin = rs.getString(1);
                listaDatos.add(id_admin);
                //1. Apellido Paterno
                String apellido_paterno = rs.getString(2);
                listaDatos.add(apellido_paterno);
                //2. Apellido Materno
                String apellido_materno = rs.getString(3);
                listaDatos.add(apellido_materno);
                //3. Nombre
                String nombre = rs.getString(4);
                listaDatos.add(nombre);
                //4. Fecha de nacimiento
                String fecha_nacimiento = rs.getString(10);
                listaDatos.add(fecha_nacimiento);
                //5. TelEfono
                String telefono = rs.getString(8);
                listaDatos.add(telefono);
                //6. Email
                String email = rs.getString(9);
                listaDatos.add(email);
                
                //7. Rango del Usuario
                String rango = rs.getString(5);
                listaDatos.add(rango);
                //8. Id de Usuario
                String user = rs.getString(6);
                listaDatos.add(user);
                //9. Nombre de Usuario
                String nom_user = rs.getString(7);
                listaDatos.add(nom_user);
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
        return listaDatos;
    }
    
    /**
     * Este metodo permite hacer una consulta SQL de varias tablas enfocada en un alumno y visualizar su informacion en la pagina web. 
     * <br>
     * 
     * @param usuario: Nombre de usuario a buscar en la base de datos
     * @return ArrayList: Informacion del alumno localizada en diferentes tablas.
     **/
    public ArrayList<String> obtenerDatosAlumno(String usuario){
        //1. Obtiene los datos de ingreso del usuario
        ArrayList <String> listaDatos = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "SELECT students.id_student, students.apellido_paterno_student, students.apellido_materno_student, \n" +
                            "students.nombre_student, users.nom_user, students.telefono1_student, students.telefono2_student, \n" +
                            "students.id_teacher_student, users.rango,\n" +
                            "students.id_user_student, students.id_payment_student, \n" +
                            "students.id_report_student, students.email_student, students.sale_solo, students.fecha_nacimiento_student \n"
                            + " FROM STUDENTS \n" +
                            "INNER JOIN users ON users.id_user = students.id_user_student \n" +
                            "WHERE nom_user = ? ;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                //0. Id del Alumno
                String id_student = rs.getString(1);
                listaDatos.add(id_student);
                //1. Apellido Paterno
                String apellido_paterno = rs.getString(2);
                listaDatos.add(apellido_paterno);
                
                //2. Apellido Materno
                String apellido_materno = rs.getString(3);
                listaDatos.add(apellido_materno);
                
                //3. Nombre
                String nombre = rs.getString(4);
                listaDatos.add(nombre);
                
                //4. Fecha de Nacimiento
                String fecha = rs.getString(15);
                listaDatos.add(fecha);
                
                //5. Numero de Telefono 1
                String tel1 = rs.getString(6);
                listaDatos.add(tel1);
                
                //6. Correo electronico
                String email = rs.getString(13);
                if(email != null){
                  listaDatos.add(email);  
                }
                else{
                   listaDatos.add("Ningun correo registrado");
                }
                
                //7. Numero de Telefono 2
                String tel2 = rs.getString(7);
                if(tel2 != null){
                  listaDatos.add(tel2);  
                }
                else{
                   listaDatos.add("Ningun número extra");
                }
                
                //8. ¿Sale Solo?
                String saleSolo = rs.getString(14);
                listaDatos.add(saleSolo);
                
                //9. Rango del Usuario
                String rango = rs.getString(9);
                listaDatos.add(rango);
                
                //10. Nombre de Usuario
                String nom_user = rs.getString(5);
                listaDatos.add(nom_user);
                
                //11. Id de Usuario
                String user = rs.getString(10);
                listaDatos.add(user);
                
                //12. Id del Profesor
                String id_teacher = rs.getString(8);
                if(id_teacher != null){
                  listaDatos.add(id_teacher);  
                }
                else{
                   listaDatos.add("0");
                }
                
                //13. Id de lista de pagos
                String pago = rs.getString(11);
                listaDatos.add(pago);
                
                //14. Id de lista de calificaciones
                String calificaciones = rs.getString(12);
                listaDatos.add(calificaciones);

                //15. Grupo Correspondiente
                if(id_teacher !=null){
                    ArrayList<String> profesor = obtenerDatosProfesor(id_teacher);
                    listaDatos.add(profesor.get(12));
                }
                else{
                    listaDatos.add("Ningun grupo registrado");
                }
                
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
        return listaDatos;
    }
    /**
     * Este metodo permite hacer una consulta SQL de varias tablas enfocada en un profesor y visualizar su informacion en la pagina web. 
     * <br>
     * 
     * @param usuario: Nombre de usuario a buscar en la base de datos
     * @return ArrayList: Informacion del profesor localizada en diferentes tablas.
     **/
    public ArrayList<String> obtenerDatosProfesor(String usuario){
        //1. Obtiene los datos de ingreso del usuario
        ArrayList <String> listaDatos = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "SELECT teachers.id_teacher, teachers.apellido_paterno_teacher, teachers.apellido_materno_teacher,\n" +
                            "teachers.nombre_teacher, teachers.fecha_nacimiento_teacher, teachers.telefono_teacher, \n" +
                            "teachers.email_teacher, teachers.id_group_teacher, teachers.status_teacher, users.rango, users.id_user, users.nom_user FROM TEACHERS \n" +
                            "INNER JOIN users ON users.id_user = teachers.id_user_teacher \n" +
                            "WHERE nom_user = (?) OR teachers.id_teacher = (?) ;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, usuario);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                //0. Id del Profesor
                String id_teacher = rs.getString(1);
                listaDatos.add(id_teacher);
                //1. Apellido Paterno
                String apellido_paterno = rs.getString(2);
                listaDatos.add(apellido_paterno);
                //2. Apellido Materno
                String apellido_materno = rs.getString(3);
                listaDatos.add(apellido_materno);
                //3. Nombre
                String nombre = rs.getString(4);
                listaDatos.add(nombre);
                //4. Fecha de Nacimiento
                String fecha = rs.getString(5);
                listaDatos.add(fecha);
                //5. Numero de Telefono 
                String tel1 = rs.getString(6);
                listaDatos.add(tel1);
                //6. Correo Electronico
                String email = rs.getString(7);
                if(email != null){
                  listaDatos.add(email);  
                }
                else{
                   listaDatos.add("Ningun correo registrado");
                }
                
                //7. Id del grupo
                String grupo = rs.getString(8);
                listaDatos.add(grupo);
                
                //8. Status
                String status = rs.getString(9);
                listaDatos.add(status);
                
                //9. Rango del Usuario
                String rango = rs.getString(10);
                listaDatos.add(rango);
                
                //10. Id del Usuario
                String user = rs.getString(11);
                listaDatos.add(user);
                
                //11. Nombre de Usuario
                String nom_user = rs.getString(12);
                listaDatos.add(nom_user);
                
                //12. Grupo Correspondiente
                ArrayList<ConsultaGrupos> datosGrupo = obtenerDatosGrupo(Integer.parseInt(grupo));
                Iterator <ConsultaGrupos> iter = datosGrupo.iterator();
                ConsultaGrupos per = null;
                String detallesGrupo = "";
                while(iter.hasNext()){
                    per = iter.next();
                    detallesGrupo = per.getDescription_grade() + " " + per.getLevel_group()+ ": " + per.getDescription_category();
                }
                if(detallesGrupo !=null){
                    listaDatos.add(detallesGrupo);
                }
                else{
                    listaDatos.add("Ningun grupo registrado");
                }
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
        return listaDatos;
    }
    /**
     * Este metodo permite hacer seleccion de que informacion se desea mostrar en la base de datos. 
     * <br>
     * @param usuario: Nombre de usuario a buscar en la base de datos
     * @param rango: Rango de usuario a buscar en la base de datos
     * @return ArrayList: Informacion del profesor localizada en diferentes tablas.
     **/
    
    public ArrayList<String> obtenerData (String usuario, String rango){
        ArrayList<String> datosModificar = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            switch(rango){
            case "ESTUDIANTE":
                datosModificar = obtenerDatosAlumno(usuario);
                break;
            case "ADMINISTRADOR":
                datosModificar = obtenerDatosAdministrador(usuario);
                break;
            case "PROFESOR":
                datosModificar = obtenerDatosProfesor(usuario);
                break;
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
        return datosModificar;
    }
}

