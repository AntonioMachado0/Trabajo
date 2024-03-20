/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelss;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Luis
 */
@Getter
@Setter

public class Reserva {
    private int idReserva;
    private Date fecha;
    private Date hora;
    private String estado;
    private Cortes corte;
    private Cliente cliente;
    private Usuarios usuarios;
    
    
    

}
