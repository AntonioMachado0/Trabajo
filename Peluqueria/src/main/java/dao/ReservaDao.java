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
import modelo.Cliente;
import modelo.Corte;
import modelo.Reserva;

/**
 *
 * @author guill
 */
public class ReservaDao {

    Conexion conexion = null;
    private ArrayList<Reserva> reservaList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Reserva reserva;

    private static final String MOSTRAR_CONFIRMADOS = "SELECT cl.nombre, cl.correo, re.estado\n"
            + "FROM cliente Cl\n"
            + "INNER JOIN reserva re ON cl.idcliente = re.fk_cliente\n"
            + "WHERE re.estado = 'Confirmada';";
    
      private static final String SELECT_ALL = "SELECT r.idreserva, r.fecha, r.hora, r.estado, cliente.nombre AS nombre_cliente, cortes.tipocorte AS tipocorte FROM reserva r JOIN cliente ON r.fk_cliente = cliente.idcliente JOIN cortes ON r.fk_cortes = cortes.idcortes";

    public  ReservaDao () throws SQLException, ClassNotFoundException{
        this.conexion = new Conexion();
    }
    
    public ArrayList<Reserva> selectReserva () throws SQLException, ClassNotFoundException{
        this.reservaList = new ArrayList<>();
        
        try{
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(MOSTRAR_CONFIRMADOS);
            this.rs = ps.executeQuery();
            
            Reserva obj = null;
            Cliente ob = null;
            while (this.rs.next()){
                ob = new Cliente();
                ob.setNombre(rs.getString("nombre"));
                ob.setCorreo(rs.getString("correo"));
                obj = new Reserva();
                obj.setCliente(ob);
                obj.setEstado(rs.getString("estado"));
                
                this.reservaList.add(obj);
            }
            this.conexion.cerrarConexiones();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.reservaList;
    }
    
    public ArrayList<Reserva> obtenerReservasConDetalles() {
       this.reservaList = new ArrayList<>();

        try {            
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(SELECT_ALL);
            this.rs = ps.executeQuery();
                
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idreserva"));
                reserva.setFecha(rs.getDate("fecha"));
                reserva.setHora(rs.getTime("hora"));
                reserva.setEstado(rs.getString("estado"));

                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre_cliente"));

                Corte corte = new Corte();
                corte.setTipoCorte(rs.getString("tipocorte"));

                reserva.setCliente(cliente);
                reserva.setCorte(corte);

                this.reservaList.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.reservaList;
    }

}
