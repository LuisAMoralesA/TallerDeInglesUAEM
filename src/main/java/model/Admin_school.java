/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Luis Morales
 */
public class Admin_school {
    private int id_admin;
    private int id_user_admin;
    private String apellido_paterno_admin;
    private String apellido_materno_admin;
    private String nombre_admin;
    private Object fecha_nacimiento_admin;

    public Admin_school(int id_admin, int id_user_admin, String apellido_paterno_admin, String apellido_materno_admin, 
            String nombre_admin, Object fecha_nacimiento_admin) {
        this.id_admin = id_admin;
        this.id_user_admin = id_user_admin;
        this.apellido_paterno_admin = apellido_paterno_admin;
        this.apellido_materno_admin = apellido_materno_admin;
        this.nombre_admin = nombre_admin;
        this.fecha_nacimiento_admin = fecha_nacimiento_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_user_admin() {
        return id_user_admin;
    }

    public void setId_user_admin(int id_user_admin) {
        this.id_user_admin = id_user_admin;
    }

    public String getApellido_paterno_admin() {
        return apellido_paterno_admin;
    }

    public void setApellido_paterno_admin(String apellido_paterno_admin) {
        this.apellido_paterno_admin = apellido_paterno_admin;
    }

    public String getApellido_materno_admin() {
        return apellido_materno_admin;
    }

    public void setApellido_materno_admin(String apellido_materno_admin) {
        this.apellido_materno_admin = apellido_materno_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public Object getFecha_nacimiento_admin() {
        return fecha_nacimiento_admin;
    }

    public void setFecha_nacimiento_admin(Date fecha_nacimiento_admin) {
        this.fecha_nacimiento_admin = fecha_nacimiento_admin;
    }
    
    
}
