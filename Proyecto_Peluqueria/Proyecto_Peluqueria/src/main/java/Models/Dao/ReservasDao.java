/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Dao;

import Modelss.Cliente;
import Modelss.Cortes;
import Modelss.Reserva;
import Utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Machado
 */
public class ReservasDao {
    
    Conexion conexion = null;
    private ArrayList<Reserva> reservaList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Cliente cliente;

    private static final String MOSTRAR_CORTES = "select cl.nombre ||' '|| cl.apellido as nombre_Cliente, re.fecha,co.tipocorte\n" +
"from cliente cl\n" +
"inner join reserva re ON re.fk_cliente = cl.idcliente\n" +
"inner join cortes co ON co.idcortes = re.fk_cortes";
    
    public  ReservasDao() throws SQLException, ClassNotFoundException{
        this.conexion = new Conexion();
    }
    
    public ArrayList<Reserva> selectCortes () throws SQLException, ClassNotFoundException{
        this.reservaList = new ArrayList<>();
        
        try{
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(MOSTRAR_CORTES);
            this.rs = ps.executeQuery();
            
            Reserva res = null;
            Cliente cli = null;
            Cortes cor = null;
            while (this.rs.next()){       
               res = new Reserva();
               cli = new Cliente();
               cor = new Cortes();
                cli.setNombre(rs.getString("nombre_Cliente"));
                res.setCliente(cli);
                res.setFecha(rs.getDate("fecha"));    
                cor.setTipoCorte(rs.getString("tipocorte"));
                res.setCorte(cor);
                
                this.reservaList.add(res);
            }
            this.conexion.cerrarConexiones();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.reservaList;
    }
}
