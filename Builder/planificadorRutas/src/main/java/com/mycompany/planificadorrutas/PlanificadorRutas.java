package com.mycompany.planificadorrutas;

import com.mycompany.planificadorrutas.vista.VistaPlanificadorRutas;

/**
 * Clase demo para ejecutar el Planificador de Rutas.
 * Crea y muestra la vista principal del sistema.
 */
public class PlanificadorRutas {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            VistaPlanificadorRutas vista = new VistaPlanificadorRutas();
            vista.setVisible(true);
        });
    }
}