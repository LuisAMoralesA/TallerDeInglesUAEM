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

//GitHub

public class BaseDatos {
    //Implementa constantes de inicio de sesión
    public static final int DATO_INCORRECTO = 1;
    public static final int USUARIO_NO_ENCONTRADO = 2;
    public static final int ACCESO_CONCEDIDO = 3;
    
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    public BaseDatos(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
    
    public void insertarUsuario(Users user) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO users (nom_user, password, rango) VALUES (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getNom_user());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRango());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Users> obtenerUsuario(){
        ArrayList<Users> listaUsuarios = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM users;";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_user = rs.getInt("id_user");
                String nom_user = rs.getString("nom_user");
                String password = rs.getString("password");
                String rango = rs.getString("rango");
                
                Users user = new Users(id_user, nom_user, password, rango);
                listaUsuarios.add(user);
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
        return listaUsuarios;
    }
    
    public int inicioSesion(String user, String password, String rol){
        int pagina = 0;
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String SQL = "SELECT * FROM users WHERE rango = ? and nom_user = ? " ;
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, rol);
            pstm.setString(2, user);
            rs = pstm.executeQuery();
            //String SQL2;
            
            if(rs.next()){
                String contraBD = rs.getString("password");
                if(password.equals(contraBD)){
                    //3. Menu de inicio de cierto rol
                    pagina = ACCESO_CONCEDIDO;
                    
                }else{
                    //1 = Un dato es incorrecto
                    pagina  = DATO_INCORRECTO;
                }
            }
            else{
                pagina = USUARIO_NO_ENCONTRADO;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            //pagina = USUARIO_NO_ENCONTRADO;
            
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            }  
        }
        return pagina;
    }
    
    public void insertarTeacher(Teachers teacher) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO teachers (id_user_teacher, apellido_paterno_teacher, apellido_materno_teacher,"
                    + "nombre_teacher, telefono_teacher, email_teacher, fecha_nacimiento_teacher, status_teacher, "
                    + "id_group_teacher) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, teacher.getId_user_teacher());
            pstm.setString(2, teacher.getApellido_paterno_teacher());
            pstm.setString(3, teacher.getApellido_materno_teacher());
            pstm.setString(4, teacher.getNombre_teacher());
            pstm.setString(5, teacher.getTelefono_teacher());
            pstm.setString(6, teacher.getEmail_teacher());
            pstm.setObject(7, teacher.getFecha_nacimiento_teacher());
            pstm.setString(8, teacher.getStatus_teacher());
            pstm.setInt(9, teacher.getId_group_teacher());
            
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Teachers> obtenerTeacher(){
        ArrayList<Teachers> listaTeachers = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM teachers ORDER BY apellido_paterno_teacher;";
            pstm = con.prepareStatement(sql);
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
    
    public void insertarEstudiante(Students student) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO students (id_teacher_student, id_report_student, id_payment_student,"
                    + "id_user_student, apellido_paterno_student, apellido_materno_student, nombre_student, telefono1_student, "
                    + "telefono2_student, fecha_nacimiento_student, sale_solo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            if(student.getId_teacher_student() == 0){
                pstm.setNull(1, java.sql.Types.INTEGER);
            }
            else{
                pstm.setInt(1, student.getId_teacher_student());
            }
            
            pstm.setInt(2, student.getId_report_student());
            pstm.setInt(3, student.getId_payment_student());
            pstm.setInt(4, student.getId_user_student());
            pstm.setString(5, student.getApellido_paterno_student());
            pstm.setString(6, student.getApellido_materno_student());
            pstm.setString(7, student.getNombre_student());
            pstm.setString(8, student.getTelefono1_student());
            pstm.setString(9, student.getTelefono2_student());
            pstm.setObject(10, student.getFecha_nacimiento_student());
            pstm.setInt(11, (student.isSale_solo())?1:0);
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Students> obtenerEstudiante(){
        ArrayList<Students> listaStudents = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM students ORDER BY apellido_paterno_student;";
            pstm = con.prepareStatement(sql);
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
    
    public void insertarAdministrador(Admin_school admin){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO admin_school (id_user_admin, apellido_paterno_admin, apellido_materno_admin,"
                    + "nombre_admin, fecha_nacimiento_admin) VALUES (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, admin.getId_user_admin());
            pstm.setString(2, admin.getApellido_paterno_admin());
            pstm.setString(3, admin.getApellido_materno_admin());
            pstm.setString(4, admin.getNombre_admin());
            pstm.setObject(5, admin.getFecha_nacimiento_admin());
            
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Admin_school> obtenerAdministrador(){
        ArrayList<Admin_school> listaAdministrador = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM admin_school ORDER BY apellido_paterno_admin;";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                int id_admin = rs.getInt("id_admin");
                int id_user_admin = rs.getInt("id_user_admin");
                String apellido_paterno_admin = rs.getString("apellido_paterno_admin");
                String apellido_materno_admin = rs.getString("apellido_materno_admin");
                String nombre_admin = rs.getString("nombre_admin");
                Object fecha_nacimiento_admin = rs.getObject("fecha_nacimiento_admin");

   
                
                Admin_school administrator = new Admin_school(id_admin, id_user_admin, apellido_paterno_admin, apellido_materno_admin,
                                                nombre_admin, fecha_nacimiento_admin);
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
    
    public void insertarReporteCalificaciones(Report report) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO report (first_partial_report, second_partial_report, avg_report) VALUES (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setDouble(1, report.getFirst_partial_report());
            pstm.setDouble(2, report.getSecond_partial_report());
            pstm.setDouble(3, report.getAvg_report());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Report> obtenerCalificaciones(){
        ArrayList<Report> listaCalificaciones = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM report;";
            pstm = con.prepareStatement(sql);
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
    
    public void insertarEstatusDePago(Payment_status status) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO payment_status (description_status) VALUES (?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, status.getDescription_status());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Payment_status> obtenerEstatus(){
        ArrayList<Payment_status> listaEstatus = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM payment_status;";
            pstm = con.prepareStatement(sql);
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
    
    public void insertarSeguimientoDePago(Payment pay) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO payment(register_payment, pay_1, pay_2, pay_3, pay_4"
                    + ",pay_5, pay_6, pay_7, payment_status) VALUES (?,?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, (pay.isRegister_payment())? 1:0);
            pstm.setInt(2, pay.isPay_1()? 1:0);
            pstm.setInt(3, pay.isPay_2()? 1:0);
            pstm.setInt(4, pay.isPay_3()? 1:0);
            pstm.setInt(5, pay.isPay_4()? 1:0);
            pstm.setInt(6, pay.isPay_5()? 1:0);
            pstm.setInt(7, pay.isPay_6()? 1:0);
            pstm.setInt(8, pay.isPay_7()? 1:0);
            pstm.setInt(9, pay.getPayment_status());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Payment> obtenerSeguimiento(){
        ArrayList<Payment> listaSeguimiento = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM payment;";
            pstm = con.prepareStatement(sql);
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
    
    //Simbologia de Pagos
    public void insertarMes(Pay_simbology symbol) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO pay_simbology (month, description_pay, cost_pay, period_pay, deadline_pay) VALUES (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, symbol.getMonth());
            pstm.setString(2, symbol.getDescription_pay());
            pstm.setDouble(3, symbol.getCost_pay());
            pstm.setString(4, symbol.getPeriod_pay());
            pstm.setObject(5, symbol.getDeadline_pay());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Pay_simbology> obtenerCalendario(){
        ArrayList<Pay_simbology> calendario = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM pay_simbology;";
            pstm = con.prepareStatement(sql);
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
    
    public void insertarGrupos(Grupos group) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO grupos (id_grade, level_group, id_category_group, classroom_group) VALUES (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, group.getId_grade());
            pstm.setInt(2, group.getLevel_group());
            pstm.setInt(3, group.getId_category_group());
            pstm.setString(4, group.getClassroom_group());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Grupos> obtenerGrupos(){
        ArrayList<Grupos> listaGrupos = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM grupos;";
            pstm = con.prepareStatement(sql);
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
    
    //Seleccionar entre Basico, Intermedio o Avanzado
    public void insertarNivel(Grade grade) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO grade (description_grade) VALUES (?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, grade.getDescription_grade());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Grade> obtenerNivel(){
        ArrayList<Grade> listaNiveles = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM grade;";
            pstm = con.prepareStatement(sql);
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
    
    //Seleccionar entre Children o Teens
    public void insertarCategoria(Category category) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "INSERT INTO category (description_category) VALUES (?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, category.getDescription_category());
            pstm.executeUpdate();
            
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
    }
    
    public ArrayList<Category> obtenerCategorias(){
        ArrayList<Category> listaCategorias = new ArrayList<>();
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "SELECT * FROM category;";
            pstm = con.prepareStatement(sql);
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
}
