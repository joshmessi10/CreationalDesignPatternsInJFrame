/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.productos;

/**
 *
 * @author JL
 */
import com.mycompany.planificadorrutas.modelo.componentes.*;
import java.util.List;

/**
 * Producto concreto construido por el RutaProgramadaBuilder.
 * Contiene toda la información detallada de la ruta.
 */
public class RutaProgramada {

    private Vehiculo vehiculo;
    private Conductor conductor;
    private List<Parada> paradas;
    private List<Restriccion> restricciones;
    private List<Tarifa> tarifas;
    private double distanciaTotalKm;
    private double tiempoTotalMin;

    // ===== SETTERS =====
    public void setVehiculo(Vehiculo v) { this.vehiculo = v; }
    public void setConductor(Conductor c) { this.conductor = c; }
    public void setParadas(List<Parada> p) { this.paradas = p; }
    public void setRestricciones(List<Restriccion> r) { this.restricciones = r; }
    public void setTarifas(List<Tarifa> t) { this.tarifas = t; }
    public void setDistanciaTotalKm(double d) { this.distanciaTotalKm = d; }
    public void setTiempoTotalMin(double t) { this.tiempoTotalMin = t; }

    // ===== GETTERS =====
    public Vehiculo getVehiculo() { return vehiculo; }
    public Conductor getConductor() { return conductor; }
    public List<Parada> getParadas() { return paradas; }
    public List<Restriccion> getRestricciones() { return restricciones; }
    public List<Tarifa> getTarifas() { return tarifas; }
    public double getDistanciaTotalKm() { return distanciaTotalKm; }
    public double getTiempoTotalMin() { return tiempoTotalMin; }

    /** 
     * Muestra un resumen por consola de la ruta construida.
     */
    public void mostrarResumen() {
        System.out.println("=== RUTA PROGRAMADA ===");
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Conductor: " + conductor);
        System.out.println("Paradas: " + (paradas != null ? paradas.size() : 0));
        System.out.println("Distancia total: " + distanciaTotalKm + " km");
        System.out.println("Tiempo estimado: " + tiempoTotalMin + " min");
    }
}