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
public class cortesDao {
    
     Conexion conexion = null;
    private ArrayList<Cliente> clienteList;
    private ResultSet rs = null;
    private PreparedStatement ps;
    private Connection accesoDB;
    
    
}
