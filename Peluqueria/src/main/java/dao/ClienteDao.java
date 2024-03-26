/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author Jonathan Flores
 */
public class ClienteDao {
     Conexion conexion = null;
    private ArrayList<Cliente> clienteList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Cliente cliente;
    
     public static final String INSERTAR_CLIENTE = "INSERT INTO public.cliente(\n" +
"	idcliente, nombre, apellido, telefono, correo, clave)\n" +
"	VALUES (?, ?, ?, ?, ?, ?);";
      public static final String sql = "SELECT COUNT(*) AS total_clientes FROM cliente";
    public ClienteDao() {
        
        this.conexion = new Conexion();
    }
      public ClienteDao(Cliente cliente) {
        this.cliente = cliente;
    }
      
  
 public void insertar(Cliente cliente) throws SQLException {
    try {
        this.accesoDB = this.conexion.getConexion();       
        this.ps = accesoDB.prepareStatement(INSERTAR_CLIENTE);
        this.ps.setInt(1, cliente.getIdCliente());
        this.ps.setString(2, cliente.getNombre());
        this.ps.setString(3, cliente.getApellido());
        this.ps.setString(4, cliente.getTelefono());
        this.ps.setString(5, cliente.getCorreo());
        this.ps.setString(6, cliente.getClave());
        System.out.println(this.ps);
        this.ps.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

        public int obtenerTotalClientes() throws SQLException {
        int totalClientes = 0;
        
         try{
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(sql);
            this.rs = ps.executeQuery();
            
            // Verificar si hay resultados y obtener el total de clientes
            if (rs.next()) {
                totalClientes = rs.getInt("total_clientes");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return totalClientes;
    }
    
    
    
}
