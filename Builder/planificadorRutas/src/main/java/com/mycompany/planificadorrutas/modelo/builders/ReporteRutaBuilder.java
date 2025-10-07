/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.builders;

/**
 *
 * @author JL
 */
import com.mycompany.planificadorrutas.modelo.componentes.*;
import com.mycompany.planificadorrutas.modelo.productos.ReporteRuta;
import java.util.List;

/**
 * Builder concreto que crea objetos del tipo ReporteRuta.
 * Este tipo de reporte es usado por la gerencia para análisis
 * y estadísticas de desempeño.
 */
public class ReporteRutaBuilder implements RutaBuilder {
    private ReporteRuta reporte;
    @Override
    public void reset() {
        reporte = new ReporteRuta();
    }
    @Override
    public void agregarParadas(List<Parada> paradas) {
        reporte.setParadas(paradas);
    }
    @Override
    public void asignarVehiculo(Vehiculo vehiculo) {
        reporte.setVehiculo(vehiculo);
    }
    @Override
    public void definirConductor(Conductor conductor) {
        reporte.setConductor(conductor);
    }
    @Override
    public void agregarRestricciones(List<Restriccion> restricciones) {
        reporte.setRestricciones(restricciones);
    }
    @Override
    public void configurarTarifas(List<Tarifa> tarifas) {
        reporte.setTarifas(tarifas);
    }
    @Override
    public void calcularDistancias() {
        if (reporte.getParadas() != null) {
            reporte.setDistanciaTotalKm(reporte.getParadas().size() * 10.0);
        }
    }
    @Override
    public void calcularTiempos() {
        // Velocidad de referencia: 1 km/min
        reporte.setTiempoTotalMin(reporte.getDistanciaTotalKm() / 1.0);
    }
    @Override
    public ReporteRuta obtenerResultado() {
        // Cálculos adicionales del reporte
        reporte.calcularCostoEstimado();
        reporte.calcularPromedioVelocidad();
        return reporte;
    }
}