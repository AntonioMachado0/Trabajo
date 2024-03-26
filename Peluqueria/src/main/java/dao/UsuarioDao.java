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
import java.util.List;
import modelo.Cargo;
import modelo.Usuarios;

/**
 *
 * @author Jonathan Flores
 */
public class UsuarioDao {
    
    Conexion conexion = null;
    private ArrayList<Usuarios> usuarioList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    private Usuarios usuario;
    
    private static final String SELECT_QUERY = 
        "SELECT u.nombreusuario, " +
        "       u.apellidousuario, " +
        "       u.dui, " +
        "       u.telefono, " +
        "       u.estado AS apellido_usuario, " +
        "       cargo.nombrecargo AS cargo " +
        "FROM usuarios AS u " +
        "JOIN cargo ON u.fk_cargo = cargo.idcargo";

    public UsuarioDao() {
         this.conexion = new Conexion();
    }
    
     public ArrayList<Usuarios> obtenerUsuariosConCargos() throws SQLException {
      this.usuarioList = new ArrayList<>();
        
        try{
            this.accesoDB = this.conexion.getConexion();
            this.ps = this.accesoDB.prepareStatement(SELECT_QUERY);
            this.rs = ps.executeQuery();
            
            while (this.rs.next()){
                Usuarios usuario = new Usuarios();
                Cargo cargo = new Cargo();
                usuario.setNombreusuario(rs.getString("nombreusuario"));
                usuario.setApellidousuario(rs.getString("apellidousuario"));
                usuario.setDui(rs.getString("dui"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEstado(rs.getString("apellido_usuario"));
                cargo.setNombrecargo(rs.getString("cargo"));
                usuario.setCargo(cargo);
                this.usuarioList.add(usuario);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.usuarioList;
    }
}
    

