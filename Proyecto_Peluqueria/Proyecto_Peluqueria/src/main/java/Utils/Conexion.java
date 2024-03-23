/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Machado
 */
public class Conexion {

	private Connection conexion = null;
//	private static final ResultSet rs = null;
//	private static Statement sentencia = null;
//	private static final PreparedStatement ps = null;

        private String jdbcDataBase = "peluqueria";//Peluqueria
        private String jdbcURL = "jdbc:postgresql://localhost:5432/"+jdbcDataBase+"?useSSL=false";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "admin"; //CAMBIAR root

	public Connection getConexion() {
		try {
                     // Class.forName("com.mysql.jdbc.Driver");para mysql
			Class.forName("org.postgresql.Driver");
			// Obtener la conexion
			this.conexion = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                        return this.conexion;
		} catch (Exception e) {
                    e.printStackTrace();
                    return null;
		}
               
	}

	public void cerrarConexiones() {
            try{
                this.conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
//		if (sentencia != null) {
//			try {
//				sentencia.close();
//			} catch (SQLException e) {
//				System.out.println("Error al cerrar el Statement" + e);
//			}
//		}
//		if (conexion != null) {
//			try {
//				conexion.close();
//			} catch (SQLException e) {
//				System.out.println("Error al cerrar la conexion a la bd" + e);
//			}
//		}
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				System.out.println("Error al cerrar la conexion a la bd" + e);
//			}
//		}
                
	}

//    public PreparedStatement prepareStatement(String select__from_Empleados_WHERE_DUI__) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
        
       
}

