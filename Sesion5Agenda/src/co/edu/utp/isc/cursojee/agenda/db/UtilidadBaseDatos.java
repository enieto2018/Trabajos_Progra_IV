/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiazOspina
 */
public class UtilidadBaseDatos {

    public static boolean registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilidadBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Connection obtenerConexion() throws Exception {
        String url = "jdbc:h2:~/agenda";
        String usuario = "root";
        String clave = "123";
        
        return DriverManager.getConnection(url, usuario, clave);
    }
}
