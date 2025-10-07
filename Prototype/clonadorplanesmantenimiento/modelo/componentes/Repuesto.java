/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.modelo.componentes;

/**
 * Representa un repuesto requerido en el plan de mantenimiento.
 */
public class Repuesto {
    private String nombre;
    private int cantidad;

    public Repuesto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " x" + cantidad;
    }
}