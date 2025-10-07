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
 * Define el plan de mantenimiento específico para buses.
 */
public class PlanMantenimientoBus extends PlanMantenimiento {

    private boolean revisionFrenosAire;
    private boolean revisionTacografo;

    public PlanMantenimientoBus(String id, String vehiculoTipo, Integer periodicidadKm) {
        super(id, vehiculoTipo, periodicidadKm);
    }

    /** Constructor copia */
    public PlanMantenimientoBus(PlanMantenimientoBus original) {
        super(original);
        this.revisionFrenosAire = original.revisionFrenosAire;
        this.revisionTacografo = original.revisionTacografo;
    }

    public void verificarFrenosAire() {
        this.revisionFrenosAire = true;
    }

    public void verificarTacografo() {
        this.revisionTacografo = true;
    }

    @Override
    public Prototype clone() {
        return new PlanMantenimientoBus(this);
    }
}

