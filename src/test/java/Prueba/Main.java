/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;
import encriptacion.SHA256;
        
/**
 *
 * @author Luis Morales
 */
public class Main {
    public static void main(String [] args){
        SHA256 sha = new SHA256();
        sha.contraseñaNueva("ACCSAN0011");
        System.out.println(sha.contraseñaNueva("ACCSAN0011"));
    }
}
