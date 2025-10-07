package com.mycompany.clonadorplanesmantenimiento;

import com.mycompany.clonadorplanesmantenimiento.vista.VistaMantenimiento;

/**
 * Demo principal del sistema de clonación de planes de mantenimiento
 * basado en el patrón Prototype bajo arquitectura MVC.
 * 
 * @author JL
 */
public class ClonadorPlanesMantenimiento {

    public static void main(String[] args) {
        // Configura la apariencia visual
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("No se pudo aplicar el estilo del sistema.");
        }

        // Inicializa la vista principal
        java.awt.EventQueue.invokeLater(() -> {
            VistaMantenimiento vista = new VistaMantenimiento();
            vista.setVisible(true);
        });
    }
}