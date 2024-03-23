/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Dao;

import Modelss.Cargo;
import Modelss.Usuarios;
import Utils.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author javier
 */
public class daoUsuario {
    private final String todoUsuario = "select * from usuarios inner join cargo on fk_cargo = idcargo;";
    private final String usuarioPorCorreo = "select * from usuarios where correo = ?;";
    private final String insertarUsuario = "insert into usuarios (nombreusuario, apellidousuario, dui, telefono, correo, direccion, estado, fk_cargo,claveusuario) values (?,?,?,?,?,?,?,?,?);";
    private final String updateUsuario = "update usuarios set nombreusuario = ?, apellidousuario = ?, dui = ?, telefono = ?, correo = ?, direccion = ?, estado = ?, fk_cargo = ?, claveusuario=? where idusuario  = ?;";
    
    
    public Usuarios getUsuarioPorCorreo(String correo){
        Usuarios usu = null;
        try{
            usu = new Usuarios();
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConexion().prepareStatement(usuarioPorCorreo);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cargo tc = new Cargo();
                tc.setIdcargo(rs.getInt("idcargo"));
                tc.setNombrecargo(rs.getString("nombrecargo"));
                
                usu.setIdUsuario(rs.getInt("idusuario"));
                usu.setNombreUsuario(rs.getString("nombreusuario"));
                usu.setApellidoUsuario(rs.getString("apellidousuario"));
                usu.setDui(rs.getString("dui"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setCorreo(rs.getString("correo"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setEstado(rs.getString("estado"));
                usu.setClaveusuario(rs.getString("claveusuario"));
                usu.setCargo(tc);
                
            }
            con.cerrarConexiones();
            return usu;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Usuarios> getTodoUsuario(){
        ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
        try{
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConexion().prepareStatement(todoUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Cargo tc = new Cargo();
                tc.setIdcargo(rs.getInt("idcargo"));
                tc.setNombrecargo(rs.getString("nombrecargo"));
                
                Usuarios usu = new Usuarios();
                usu.setIdUsuario(rs.getInt("idusuario"));
                usu.setNombreUsuario(rs.getString("nombreusuario"));
                usu.setApellidoUsuario(rs.getString("apellidousuario"));
                usu.setDui(rs.getString("dui"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setCorreo(rs.getString("correo"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setEstado(rs.getString("estado"));
                usu.setClaveusuario(rs.getString("claveusuario"));
                usu.setCargo(tc);
                lista.add(usu);
            }
            con.cerrarConexiones();
            return lista;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean insertarUsuario(Usuarios u){
        try{
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConexion().prepareStatement(insertarUsuario);
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getApellidoUsuario());
            ps.setString(3, u.getDui());
            ps.setString(4, u.getTelefono());
            ps.setString(5, u.getCorreo());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getEstado());
            ps.setInt(8, u.getCargo().getIdcargo());
            ps.setString(9, u.getClaveusuario());
            ps.executeUpdate();
            con.cerrarConexiones();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarUsuario(Usuarios u){
        try{
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConexion().prepareStatement(updateUsuario);
            
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getApellidoUsuario());
            ps.setString(3, u.getDui());
            ps.setString(4, u.getTelefono());
            ps.setString(5, u.getCorreo());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getEstado());
            ps.setInt(8, u.getCargo().getIdcargo());
            ps.setString(9, u.getClaveusuario());
            ps.setInt(10, u.getIdUsuario());
            
            ps.executeUpdate();
            con.cerrarConexiones();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
