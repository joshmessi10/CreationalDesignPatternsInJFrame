/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.modelo.director;

/**
 *
 * @author JL
 */
import com.mycompany.planificadorrutas.modelo.builders.RutaBuilder;

/**
 * La clase Director define el orden en que deben ejecutarse
 * los pasos de construcción del producto.
 * 
 * No conoce los detalles internos de cada builder,
 * solo invoca los métodos en una secuencia lógica.
 */
public class DirectorRuta {

    /** Construye una RutaProgramada paso a paso */
    public void construirRutaProgramada(RutaBuilder builder) {
        builder.calcularDistancias();
        builder.calcularTiempos();
    }

    /** Construye un ReporteRuta paso a paso */
    public void construirReporteRuta(RutaBuilder builder) {
        builder.calcularDistancias();
        builder.calcularTiempos();
    }
}