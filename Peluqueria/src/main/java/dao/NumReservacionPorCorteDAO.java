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
import modelo.NumReservacionPorCorteDTO;
/**
 *
 * @author Luis
 */


public class NumReservacionPorCorteDAO {

    private Conexion conexion;
    private ArrayList<NumReservacionPorCorteDTO> listaNumReservaciones;

    private static final String SQL_CONSULTA = "SELECT co.tipocorte, COUNT(*) AS num_reservations "
            + "FROM public.reserva r "
            + "JOIN public.cortes co ON r.fk_cortes = co.idcortes "
            + "GROUP BY co.tipocorte";

    public NumReservacionPorCorteDAO() throws SQLException, ClassNotFoundException {
        this.conexion = new Conexion();
    }

    public ArrayList<NumReservacionPorCorteDTO> consultarNumReservacionesPorCorte() throws SQLException {
        this.listaNumReservaciones = new ArrayList<>();
        System.out.println("LLegando");
        try {
            Connection connection = conexion.getConexion();
            PreparedStatement ps = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = ps.executeQuery();
            NumReservacionPorCorteDTO obj;
            while (rs.next()) {
                obj = new NumReservacionPorCorteDTO();
                obj.setTipoCorte(rs.getString("tipocorte"));
                obj.setCantidadCorte(rs.getInt("num_reservations"));
                listaNumReservaciones.add(obj);
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaNumReservaciones;
    }
}
