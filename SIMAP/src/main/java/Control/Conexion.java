/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.*;

/**
 *
 * @author M3R-00
 */
public class Conexion {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://yw3blbopseve.us-east-1.psdb.cloud/simap";
    private static final String USUARIO = "9qlsw3zv1qf1";
    private static final String CLAVE = "pscale_pw_w1MXJA3BBKZnOtFfAApP1muX05a4bS4F0A8X2qES79c";

    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection getConexion() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
            System.out.println(URL);
            System.out.println(USUARIO);
            System.out.println(CLAVE);
            

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            System.out.println(e.getMessage());
        }
        
        return conexion;
    }
}
