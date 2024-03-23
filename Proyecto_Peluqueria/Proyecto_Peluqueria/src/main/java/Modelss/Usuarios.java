/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelss;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Luis
 */
@Getter
@Setter
public class Usuarios {
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String dui; //Cambiar en la base 
    private String telefono; //Cambiar en la base 
    private String correo;
    private String direccion;
    private String estado;
    private int fk_cargo;
    private String claveusuario;
    private Cargo cargo;
}
