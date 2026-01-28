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
* Esta clase contiene un conjunto de clases para actualizacion de Informacion especifica de una base de datos. 
* @author Luis Morales
**/

public class BaseDatosActualizar {
    
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    /**
     * Este constructor funciona para hacer conexion con la base de datos,
     * usando un URL y un Driver de conexion (8.0)
     **/
    public BaseDatosActualizar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
    /**
     * Este metodo permite hacer una consulta SQL para actualizar los datos de un usuario especifico 
     * @param user: Un objeto de tipo User con todos sus datos 
     **/
    public void actualizarUsuario(Users user){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE users SET nom_user = ?, password = ?, rango = ? WHERE id_user = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getNom_user());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRango());
            pstm.setInt(4, user.getId_user());
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
    
    /**
     * Este metodo permite hacer una consulta SQL para actualizar los datos de un usuario especifico 
     * @param teacher: Un objeto de tipo Teacher con todos sus datos 
     **/
    public void actualizarTeacher(Teachers teacher){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE teachers SET apellido_paterno_teacher = ?, apellido_materno_teacher = ?, "
                    + "nombre_teacher = ?, telefono_teacher = ?, email_teacher = ?, fecha_nacimiento_teacher = ?,"
                    + "status_teacher = ?, id_group_teacher = ? WHERE id_user_teacher = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, teacher.getApellido_paterno_teacher());
            pstm.setString(2, teacher.getApellido_materno_teacher());
            pstm.setString(3, teacher.getNombre_teacher());
            pstm.setString(4, teacher.getTelefono_teacher());
            pstm.setString(5, teacher.getEmail_teacher());
            pstm.setObject(6, teacher.getFecha_nacimiento_teacher());
            pstm.setString(7, teacher.getStatus_teacher());
            pstm.setInt(8, teacher.getId_group_teacher());
            pstm.setInt(9, teacher.getId_user_teacher());
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
    /**
     * Este metodo permite hacer una consulta SQL para actualizar los datos de un administrador especifico 
     * @param admin: Un objeto de tipo Admin_school con todos sus datos 
     **/
     public void actualizarAdministrador(Admin_school admin){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE admin_school SET apellido_paterno_admin = ?, apellido_materno_admin = ?, "
                    + "nombre_admin =?, fecha_nacimiento_admin = ?, telefono_admin = ?, email_admin = ? WHERE id_user_admin = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, admin.getApellido_paterno_admin());
            pstm.setString(2, admin.getApellido_materno_admin());
            pstm.setString(3, admin.getNombre_admin());
            pstm.setObject(4, admin.getFecha_nacimiento_admin());
            pstm.setString(5, admin.getTelefono_admin());
            pstm.setString(6, admin.getEmail_admin());
            pstm.setInt(7, admin.getId_user_admin());
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
     
    /**
     * Este metodo permite hacer una consulta SQL para actualizar los datos de un estudiante especifico 
     * @param student: Un objeto de tipo Student con todos sus datos 
     **/ 
    public void actualizarEstudiante(Students student){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            //Lo busca con respecto al id de usuario de su respectiva tabla
            String sql = "UPDATE students SET id_teacher_student = ?,"
                    + "apellido_paterno_student = ?, apellido_materno_student = ?, nombre_student = ?, telefono1_student = ?, "
                    + "telefono2_student = ?, fecha_nacimiento_student = ?, email_student= ?, sale_solo = ? WHERE id_user_student = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, student.getId_teacher_student());
            pstm.setString(2, student.getApellido_paterno_student());
            pstm.setString(3, student.getApellido_materno_student());
            pstm.setString(4, student.getNombre_student());
            pstm.setString(5, student.getTelefono1_student());
            pstm.setString(6, student.getTelefono2_student());
            pstm.setObject(7, student.getFecha_nacimiento_student());
            pstm.setString(8, student.getEmail_student());
            pstm.setInt(9, (student.isSale_solo())?1:0);
            pstm.setInt(10, student.getId_user_student());
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
    
    /**
     * Este metodo permite hacer una consulta SQL para actualizar las calificaciones de un alumno especifico 
     * @param report: Un objeto de tipo Report con todos sus datos 
     **/
    public void actualizarReporteCalificaciones(Report report) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE report SET first_partial_report = ?, second_partial_report = ?, avg_report = ? WHERE id_report = ?";
            pstm = con.prepareStatement(sql);
            pstm.setDouble(1, report.getFirst_partial_report());
            pstm.setDouble(2, report.getSecond_partial_report());
            pstm.setDouble(3, report.getAvg_report());
            pstm.setInt(4, report.getId_report());
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
    /**
     * Este metodo permite hacer una consulta SQL para actualizar la descripcion de un estatus de pago especifico 
     * @param status: Un objeto de tipo Payment_status con todos sus datos 
     **/
    public void actualizarEstatusDePago(Payment_status status) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE payment_status SET description_status = ? WHERE id_ststus = (?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, status.getDescription_status());
            pstm.setInt(2, status.getId_status());
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
    /**
     * Este metodo permite hacer una consulta SQL para actualizar el registro de pago de un alumno especifico. 
     * @param pay: Un objeto de tipo Payment con todos sus datos 
     **/
    public void actualizarSeguimientoDePago(Payment pay) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE payment SET register_payment = ?, pay_1 = ?, pay_2 = ?, pay_3 = ?, pay_4 = ?"
                    + ",pay_5 = ?, pay_6 = ?, pay_7 = ?, payment_status = ? WHERE id_payment = ?";
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
            pstm.setInt(10, pay.getId_payment());
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
    /**
     * Este metodo permite hacer una consulta SQL para actualizar la descripcion e informacion de un mes especifico
     * @param symbol: Un objeto de tipo Pay_simbology con todos sus datos 
     **/
    //Simbologia de Pagos
    public void actualizarCalendario(Pay_simbology symbol) {
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE pay_simbology SET month = ?, description_pay = ?, cost_pay = ?, period_pay = ?, "
                    + "deadline_pay = ? WHERE id_pay = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, symbol.getMonth());
            pstm.setString(2, symbol.getDescription_pay());
            pstm.setDouble(3, symbol.getCost_pay());
            pstm.setString(4, symbol.getPeriod_pay());
            pstm.setObject(5, symbol.getDeadline_pay());
            pstm.setInt(7, symbol.getId_pay());
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
    
    /**
     * Este metodo permite hacer una consulta SQL para actualizar la informacion de un grupo especifico
     * @param group: Un objeto de tipo Grupos con todos sus datos 
     **/
    public void actualizarGrupos(Grupos group){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE grupos SET id_grade =?, level_group = ?, id_category_group = ?, classroom_group = ? WHERE id_group = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, group.getId_grade());
            pstm.setInt(2, group.getLevel_group());
            pstm.setInt(3, group.getId_category_group());
            pstm.setString(4, group.getClassroom_group());
            pstm.setInt(5, group.getId_group());
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
    /**
     * Este metodo permite hacer una consulta SQL para actualizar la descripcion de un nivel especifico 
     * @param grade: Un objeto de tipo Grade con todos sus datos 
     **/
     public void actualizarNivel(Grade grade){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE grade SET description_grade = ? WHERE id_grade = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, grade.getDescription_grade());
            pstm.setInt(2, grade.getId_grade());
            rs = pstm.executeQuery();
            
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
     
    /**
     * Este metodo permite hacer una consulta SQL para actualizar la descripcion de una categoria especifica
     * @param category: Un objeto de tipo Category con todos sus datos 
     **/ 
    public void actualizarCategorias(Category category){
        try{
            String urlDB = "jdbc:mysql://localhost:3306/tallerdeingles?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(urlDB, "nbUser", "123456");
            String sql = "UPDATE category SET description_category = ? WHERE id_category = ?;";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, category.getDescription_category());
            pstm.setInt(2, category.getId_category());
            rs = pstm.executeQuery();

            
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
}

