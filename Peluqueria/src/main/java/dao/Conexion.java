/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author guill
 */
public class Conexion {
    private static Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static PreparedStatement ps = null;
    private static final String url = "jdbc:postgresql://localhost:5432/peluqueria1";
    private static final String usuario = "postgres";
    private static final String password = "root";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("conectando a la BD");
        } catch (SQLException ex) {
        } catch (Exception e) {

        }
        return con;
    }

    public static void cerrarConexiones() {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement" + e);
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la BD" + e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la BD" + e);
            }
        }
    }
}
