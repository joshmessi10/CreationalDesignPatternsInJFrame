/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.componentes;

/**
 *
 * @author JL
 */
public class Tarifa {
    private String tipoServicio;
    private double costoBase;
    private double costoPorKm;

    public Tarifa(String tipoServicio, double costoBase, double costoPorKm) {
        this.tipoServicio = tipoServicio;
        this.costoBase = costoBase;
        this.costoPorKm = costoPorKm;
    }

    public double calcularTotal(double distancia) {
        return costoBase + (costoPorKm * distancia);
    }

    @Override
    public String toString() {
        return tipoServicio + " ($" + costoBase + " + $" + costoPorKm + "/km)";
    }
}