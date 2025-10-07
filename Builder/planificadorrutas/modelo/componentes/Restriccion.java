/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.componentes;

/**
 *
 * @author JL
 */
public class Restriccion {
    private String tipo;
    private String descripcion;

    public Restriccion(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return tipo + ": " + descripcion;
    }
}