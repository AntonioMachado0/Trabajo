/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String clave; 

    private ArrayList<Reserva> list;
    
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public Cliente(int idCliente, String nombre, String apellido, String telefono, String correo, String clave) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public Cliente(String nombre, String apellido, String telefono, String correo, String clave, ArrayList<Reserva> list) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        this.list = list;
    }
    
    

    public Cliente(int idCliente, String nombre, String apellido, String telefono, String correo, String clave, ArrayList<Reserva> list) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        this.list = list;
    }

    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Reserva> getList() {
        return list;
    }

    public void setList(ArrayList<Reserva> list) {
        this.list = list;
    }

    
    
}
