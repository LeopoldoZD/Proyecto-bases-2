/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rapid
 */
public class ProbarConexion {
    public static void main(String[] args) {
        try {
            Conexion.conectarse("system","system");
            System.out.println("Autenticado, bienvenido!!");
          } catch (Exception ex) {
            System.out.println("Lo siento datos incorrectos");
        }
    }
}
