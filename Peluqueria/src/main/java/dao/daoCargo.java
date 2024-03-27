/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cargo;

/**
 *
 * @author javier
 */
public class daoCargo {
    private String todoCargo = "select * from cargo;";
    
    public ArrayList<Cargo> getTodoCargo(){
        ArrayList<Cargo> lista = new ArrayList<Cargo>();
        
        try{
            Conexion con = new Conexion();
            PreparedStatement ps = con.getConexion().prepareStatement(todoCargo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cargo tmp = new Cargo();
                tmp.setIdcargo(rs.getInt("idcargo"));
                tmp.setNombrecargo(rs.getString("nombrecargo"));
                lista.add(tmp);
            }
            con.cerrarConexiones();
            return lista;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
