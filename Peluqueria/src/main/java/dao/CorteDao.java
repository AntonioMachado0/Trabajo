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
import modelo.Corte;

/**
 *
 * @author guill
 */
public class CorteDao {

    Conexion conexion = null;
    private ArrayList<Corte> cortesList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Corte corte;

    private static final String MOSTRAR_CORTES = "SELECT co.idcortes, co.tipocorte, co.precio\n"
            + "FROM cortes co\n"
            + "WHERE co.precio < 15.00;";
    
    public  CorteDao () throws SQLException, ClassNotFoundException{
        this.conexion = new Conexion();
    }
    
    public ArrayList<Corte> selectCortes () throws SQLException, ClassNotFoundException{
        this.cortesList = new ArrayList<>();
        
        try{
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(MOSTRAR_CORTES);
            this.rs = ps.executeQuery();
            
            Corte obj = null;
            while (this.rs.next()){
                obj = new Corte();
                obj.setIdCorte(rs.getInt("idcortes"));
                obj.setTipoCorte(rs.getString("tipocorte"));
                obj.setPrecio(rs.getDouble("precio"));
                
                this.cortesList.add(obj);
            }
            this.conexion.cerrarConexiones();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.cortesList;
    }
}
