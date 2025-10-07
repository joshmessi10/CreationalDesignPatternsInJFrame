/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.modelo.prototype;

import com.mycompany.clonadorplanesmantenimiento.modelo.componentes.CheckItem;
import com.mycompany.clonadorplanesmantenimiento.modelo.componentes.Repuesto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase base del patrón Prototype.
 * Representa un plan genérico de mantenimiento de vehículos.
 * 
 * Incluye lógica para clonación profunda, manipulación de listas,
 * y atributos extendidos para un registro más completo del plan.
 * 
 * @author JL
 */
public class PlanMantenimiento implements Prototype {

    protected String id;
    protected String vehiculoTipo;
    protected Integer periodicidadKm;
    protected List<CheckItem> checklist;
    protected List<Repuesto> repuestos;
    protected String notasTecnicas;

    // === Nuevos atributos ===
    protected Integer kilometrajeMaximo;   // límite máximo sugerido de uso
    public Double costoPromedio;        // costo estimado del mantenimiento
    protected Integer duracionHoras;       // tiempo estimado de servicio
    protected LocalDate fechaCreacion;     // registro del plan

    // --- Constructor base ---
    public PlanMantenimiento(String id, String vehiculoTipo, Integer periodicidadKm) {
        this.id = id;
        this.vehiculoTipo = vehiculoTipo;
        this.periodicidadKm = periodicidadKm;
        this.checklist = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.kilometrajeMaximo = periodicidadKm * 2; // estimado
        this.costoPromedio = 0.0;
        this.duracionHoras = 0;
        this.fechaCreacion = LocalDate.now();
    }

    /** Constructor copia utilizado para clonar objetos */
    public PlanMantenimiento(PlanMantenimiento original) {
        this.id = original.id;
        this.vehiculoTipo = original.vehiculoTipo;
        this.periodicidadKm = original.periodicidadKm;
        this.checklist = new ArrayList<>(original.checklist);
        this.repuestos = new ArrayList<>(original.repuestos);
        this.notasTecnicas = original.notasTecnicas;

        // Copia profunda de los nuevos atributos
        this.kilometrajeMaximo = original.kilometrajeMaximo;
        this.costoPromedio = original.costoPromedio;
        this.duracionHoras = original.duracionHoras;
        this.fechaCreacion = original.fechaCreacion;
    }

    @Override
    public Prototype clone() {
        return new PlanMantenimiento(this);
    }

    // === Métodos funcionales ===
    public void ajustarPeriodicidad(Integer km) {
        this.periodicidadKm = km;
        this.kilometrajeMaximo = km * 2;
    }

    public void agregarCheckItem(CheckItem item) {
        checklist.add(item);
    }

    public void eliminarCheckItem(String nombre) {
        checklist.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    public void agregarRepuesto(Repuesto repuesto) {
        repuestos.add(repuesto);
    }

    public void eliminarRepuesto(String nombre) {
        repuestos.removeIf(r -> r.getNombre().equalsIgnoreCase(nombre));
    }

    public void actualizarNotas(String notas) {
        this.notasTecnicas = notas;
    }

    public void calcularCostoPromedio() {
        // Simulación de cálculo de costo con base en repuestos
        this.costoPromedio = repuestos.stream()
                .mapToDouble(r -> r.getCantidad() * 20000.0)
                .sum();
    }

    public void definirDuracionServicio(int horas) {
        this.duracionHoras = horas;
    }

    // === Getters ===
    public String getId() { return id; }
    public String getVehiculoTipo() { return vehiculoTipo; }
    public Integer getPeriodicidadKm() { return periodicidadKm; }
    public List<CheckItem> getChecklist() { return checklist; }
    public List<Repuesto> getRepuestos() { return repuestos; }
    public String getNotasTecnicas() { return notasTecnicas; }
    public Integer getKilometrajeMaximo() { return kilometrajeMaximo; }
    public Double getCostoPromedio() { return costoPromedio; }
    public Integer getDuracionHoras() { return duracionHoras; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }

    // === Resumen legible (para exportar o mostrar en interfaz) ===
    public String mostrarResumen() {
        return """
               === PLAN DE MANTENIMIENTO ===
               ID: %s
               Tipo Vehículo: %s
               Periodicidad: %d km
               Kilometraje Máximo: %d km
               Duración Estimada: %d horas
               Costo Promedio: $%.2f
               Checklist: %s
               Repuestos: %s
               Notas: %s
               Fecha de Creación: %s
               """.formatted(id, vehiculoTipo, periodicidadKm, kilometrajeMaximo,
                             duracionHoras, costoPromedio,
                             checklist, repuestos, notasTecnicas, fechaCreacion);
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
