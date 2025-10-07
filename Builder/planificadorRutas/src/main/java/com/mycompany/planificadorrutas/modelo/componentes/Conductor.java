/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.componentes;

/**
 *
 * @author JL
 */
public class Conductor {
    private String id;
    private String nombre;
    private String licencia;
    private boolean certificado;

    public Conductor(String id, String nombre, String licencia, boolean certificado) {
        this.id = id;
        this.nombre = nombre;
        this.licencia = licencia;
        this.certificado = certificado;
    }

    public String getNombre() { return nombre; }
    public boolean isCertificado() { return certificado; }

    @Override
    public String toString() {
        return nombre + " (" + licencia + ")";
    }
}