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
import modelo.HistorialReservaDTO;

/**
 *
 * @author Luis
 */

public class HistorialReservaDAO {

    private Conexion conexion;
    private ArrayList<HistorialReservaDTO> listaHistorialReservas;

    private static final String SQL_CONSULTA = "SELECT re.idreserva,re.fecha, re.hora, cl.nombre, cl.correo,co.tipocorte ,co.precio "
            + "FROM reserva re "
            + "INNER JOIN cliente cl ON re.fk_cliente = cl.idcliente "
            + "INNER JOIN cortes co ON co.idcortes = re.fk_cortes "
            + "WHERE co.idcortes = 1";

    public HistorialReservaDAO() throws SQLException, ClassNotFoundException {
        this.conexion = new Conexion();
    }

    public ArrayList<HistorialReservaDTO> consultarHistorialReservas() throws SQLException {
        this.listaHistorialReservas = new ArrayList<>();
        try {
            Connection connection = conexion.getConexion();
            PreparedStatement ps = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = ps.executeQuery();
            HistorialReservaDTO obj;
            while (rs.next()) {
                obj = new HistorialReservaDTO();
                obj.setIdreserva(rs.getInt("idreserva"));
                obj.setFecha(rs.getString("fecha"));
                obj.setHora(rs.getString("hora"));
                obj.setNombre(rs.getString("nombre"));
                obj.setCorreo(rs.getString("correo"));
                obj.setTipoCorte(rs.getString("tipocorte"));
                obj.setPrecio(rs.getDouble("precio"));
                listaHistorialReservas.add(obj);
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaHistorialReservas;
    }
}