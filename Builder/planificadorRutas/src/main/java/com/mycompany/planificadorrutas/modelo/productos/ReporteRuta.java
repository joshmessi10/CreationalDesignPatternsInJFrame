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
 * Producto concreto construido por el ReporteRutaBuilder.
 * Contiene información resumida y cálculos adicionales
 * para análisis y supervisión de desempeño.
 */
public class ReporteRuta {

    private Vehiculo vehiculo;
    private Conductor conductor;
    private List<Parada> paradas;
    private List<Restriccion> restricciones;
    private List<Tarifa> tarifas;
    private double distanciaTotalKm;
    private double tiempoTotalMin;
    private double costoEstimado;
    private double promedioVelocidad;

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
    public double getCostoEstimado() { return costoEstimado; }
    public double getPromedioVelocidad() { return promedioVelocidad; }

    // ===== MÉTODOS DE CÁLCULO =====
    public void calcularCostoEstimado() {
        if (tarifas != null && !tarifas.isEmpty()) {
            costoEstimado = tarifas.get(0).calcularTotal(distanciaTotalKm);
        }
    }

    public void calcularPromedioVelocidad() {
        promedioVelocidad = tiempoTotalMin > 0 ? distanciaTotalKm / (tiempoTotalMin / 60) : 0;
    }

    /** Muestra por consola el resumen general del reporte */
    public void mostrarResumen() {
        System.out.println("=== REPORTE DE RUTA ===");
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Conductor: " + conductor);
        System.out.println("Paradas: " + (paradas != null ? paradas.size() : 0));
        System.out.println("Distancia total: " + distanciaTotalKm + " km");
        System.out.println("Tiempo estimado: " + tiempoTotalMin + " min");
        System.out.println("Costo estimado: $" + costoEstimado);
        System.out.println("Velocidad promedio: " + promedioVelocidad + " km/h");
    }
}