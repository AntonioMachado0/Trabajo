/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author guill
 */
public class Conexion {
    private Connection conexion = null;
    //private ResultSet rs = null;
    //private Statement sentencia = null;
    //private PreparedStatement ps = null;
    private String database = "peluqueria";
    private String port = "5432";
    private String parcialUrl = "localhost";
    private String url = "jdbc:postgresql://"+parcialUrl+":"+port+"/"+database;
    private String usuario = "postgres";
    private String password = "admin";

    public Connection getConexion() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            this.conexion = DriverManager.getConnection(url, usuario, password);
            //System.out.println("conectando a la BD");
        } catch (Exception e) {

        }
        return this.conexion;
    }

    public void cerrarConexiones() {
        try{
            this.conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //sigo creyendo que esto es esta desordenado asi que lo comente y recontrui el codigo
//        if (sentencia != null) {
//            try {
//                sentencia.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar el Statement" + e);
//            }
//        }
//        if (conexion != null) {
//            try {
//                conexion.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexion a la BD" + e);
//            }
//        }
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexion a la BD" + e);
//            }
//        }
    }
}
