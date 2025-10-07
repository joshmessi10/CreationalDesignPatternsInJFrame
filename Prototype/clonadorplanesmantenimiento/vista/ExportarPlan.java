/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.vista;

/**
 *
 * @author JL
 */
import com.mycompany.clonadorplanesmantenimiento.modelo.prototype.PlanMantenimiento;
import javax.swing.*;

/**
 * Ventana que muestra los resultados de clonación (plan original y clonado).
 */
public class ExportarPlan extends JFrame {

    public ExportarPlan(PlanMantenimiento original, PlanMantenimiento clon) {
        setTitle("Resultado del Clonador de Planes");
        setSize(1200, 700); // Tamaño más grande
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea txtOriginal = new JTextArea(original.toString());
        txtOriginal.setBorder(BorderFactory.createTitledBorder("Plan Original"));
        txtOriginal.setEditable(false);

        JTextArea txtClonado = new JTextArea(clon.toString());
        txtClonado.setBorder(BorderFactory.createTitledBorder("Plan Clonado"));
        txtClonado.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(1, 2, 10, 10));
        panel.add(new JScrollPane(txtOriginal));
        panel.add(new JScrollPane(txtClonado));

        add(panel);
    }
}
