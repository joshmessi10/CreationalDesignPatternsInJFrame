/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.builders;

/**
 *
 * @author JL
 */
import java.util.List;
import com.mycompany.planificadorrutas.modelo.componentes.*;

public interface RutaBuilder {
    void reset();
    void agregarParadas(List<Parada> paradas);
    void asignarVehiculo(Vehiculo vehiculo);
    void definirConductor(Conductor conductor);
    void agregarRestricciones(List<Restriccion> restricciones);
    void configurarTarifas(List<Tarifa> tarifas);
    void calcularDistancias();
    void calcularTiempos();
    Object obtenerResultado();
}