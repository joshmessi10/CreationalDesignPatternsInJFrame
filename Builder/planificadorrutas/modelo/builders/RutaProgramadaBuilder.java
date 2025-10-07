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
import com.mycompany.planificadorrutas.modelo.productos.RutaProgramada;
import java.util.List;

/**
 * Builder concreto que crea objetos del tipo RutaProgramada.
 * Este tipo de ruta se usa para operaciones diarias (detalle operativo).
 */
public class RutaProgramadaBuilder implements RutaBuilder {
    private RutaProgramada ruta;
    @Override
    public void reset() {
        ruta = new RutaProgramada();
    }
    @Override
    public void agregarParadas(List<Parada> paradas) {
        ruta.setParadas(paradas);
    }
    @Override
    public void asignarVehiculo(Vehiculo vehiculo) {
        ruta.setVehiculo(vehiculo);
    }
    @Override
    public void definirConductor(Conductor conductor) {
        ruta.setConductor(conductor);
    }
    @Override
    public void agregarRestricciones(List<Restriccion> restricciones) {
        ruta.setRestricciones(restricciones);
    }
    @Override
    public void configurarTarifas(List<Tarifa> tarifas) {
        ruta.setTarifas(tarifas);
    }

    @Override
    public void calcularDistancias() {
        // Simulación: cada parada representa 10 km adicionales
        if (ruta.getParadas() != null) {
            ruta.setDistanciaTotalKm(ruta.getParadas().size() * 10.0);
        }
    }

    @Override
    public void calcularTiempos() {
        // Simulación: 0.9 km/min de velocidad promedio
        ruta.setTiempoTotalMin(ruta.getDistanciaTotalKm() / 0.9);
    }

    @Override
    public RutaProgramada obtenerResultado() {
        return ruta;
    }
}