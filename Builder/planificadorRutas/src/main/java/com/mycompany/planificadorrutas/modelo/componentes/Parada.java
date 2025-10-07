/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.componentes;

/**
 *
 * @author JL
 */

public class Parada {
    private String nombre;
    private double latitud;
    private double longitud;
    private double distanciaAnteriorKm;
    private double tiempoEstimadoMin;

    public Parada(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() { return nombre; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }
    public double getDistanciaAnteriorKm() { return distanciaAnteriorKm; }
    public double getTiempoEstimadoMin() { return tiempoEstimadoMin; }

    public void setDistanciaAnteriorKm(double d) { this.distanciaAnteriorKm = d; }
    public void setTiempoEstimadoMin(double t) { this.tiempoEstimadoMin = t; }

    @Override
    public String toString() {
        return nombre + " (" + distanciaAnteriorKm + " km)";
    }
}