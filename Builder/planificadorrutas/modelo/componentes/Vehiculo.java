/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.componentes;

/**
 *
 * @author JL
 */
public class Vehiculo {
    private String placa;
    private String tipo;
    private int capacidad;
    private boolean disponible;

    public Vehiculo(String placa, String tipo, int capacidad) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public String getPlaca() { return placa; }
    public String getTipo() { return tipo; }
    public int getCapacidad() { return capacidad; }
    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return tipo + " - " + placa;
    }
}