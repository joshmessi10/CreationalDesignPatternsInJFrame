/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.modelo.prototype;

/**
 *
 * @author JL
 */
/**
 * Subclase concreta del Prototype.
 * Define el plan de mantenimiento específico para minivans.
 */
public class PlanMantenimientoMinivan extends PlanMantenimiento {

    private boolean revisionSuspensionLigera;

    public PlanMantenimientoMinivan(String id, String vehiculoTipo, Integer periodicidadKm) {
        super(id, vehiculoTipo, periodicidadKm);
    }

    /** Constructor copia */
    public PlanMantenimientoMinivan(PlanMantenimientoMinivan original) {
        super(original);
        this.revisionSuspensionLigera = original.revisionSuspensionLigera;
    }

    public void verificarSuspensionLigera() {
        this.revisionSuspensionLigera = true;
    }

    @Override
    public Prototype clone() {
        return new PlanMantenimientoMinivan(this);
    }
}

