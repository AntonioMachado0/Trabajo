/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Luis
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReservaDTO {
    private int idreserva;
    private String fecha;
    private String hora;
    private String nombre;
    private String Correo;
    private String tipoCorte;
    private Double precio;
    
    
      
    
}

