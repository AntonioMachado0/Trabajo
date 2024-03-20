/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelss;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Luis
 */

@Getter
@Setter
public class Cliente {
 private int idCliente;
 private   String nombre;
 private   String apellido;
 private   String telefono;//Cambiar en la base a Tipo String
 private   String correo;
 private   String clave;

}
