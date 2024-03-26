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
public class Corte {
    private int idCorte;
    private String tipoCorte;
    private Double precio;
    private ArrayList<Corte> list;
    
    public Corte() {
    }

    public Corte(int idCorte, String tipoCorte, Double precio) {
        this.idCorte = idCorte;
        this.tipoCorte = tipoCorte;
        this.precio = precio;
    }

    public Corte(String tipoCorte, Double precio) {
        this.tipoCorte = tipoCorte;
        this.precio = precio;
    }

    public Corte(String tipoCorte, Double precio, ArrayList<Corte> list) {
        this.tipoCorte = tipoCorte;
        this.precio = precio;
        this.list = list;
    }

    public Corte(int idCorte, String tipoCorte, Double precio, ArrayList<Corte> list) {
        this.idCorte = idCorte;
        this.tipoCorte = tipoCorte;
        this.precio = precio;
        this.list = list;
    }
    

    public int getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(int idCorte) {
        this.idCorte = idCorte;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ArrayList<Corte> getList() {
        return list;
    }

    public void setList(ArrayList<Corte> list) {
        this.list = list;
    }
    
    
}
