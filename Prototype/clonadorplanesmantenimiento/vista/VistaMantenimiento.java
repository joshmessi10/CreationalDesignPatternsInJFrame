/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.vista;

import com.mycompany.clonadorplanesmantenimiento.controlador.Controlador;
import javax.swing.*;

/**
 * Vista principal (JFrame) para gestionar y clonar planes de mantenimiento
 * utilizando el patrón Prototype dentro del esquema MVC.
 * 
 * @author JL
 */
public class VistaMantenimiento extends JFrame {

    // === Componentes accesibles al controlador ===
    public JTextField txtId;
    public JComboBox<String> cmbTipoVehiculo;
    public JTextField txtPeriodicidad;
    public JTextArea txtChecklist;
    public JTextArea txtRepuestos;
    public JTextArea txtNotas;
    public JTextField txtNuevoKm;
    public JTextArea txtNotasClon;
    public JTextField txtDuracion;
    public JTextField txtCosto;

    // === Componentes para selección y control ===
    public JComboBox<String> cmbPlanBase;
    public JButton btnCargarPlan;
    public JButton btnClonarPlan;
    public JButton btnExportar;

    public VistaMantenimiento() {
        initComponents();
        setTitle("Gestor de Planes de Mantenimiento - Patrón Prototype");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Vincular controlador
        new Controlador(this);
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Gestor de Planes de Mantenimiento", SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));

        JLabel lblSeleccion = new JLabel("Seleccionar plan base:");
        JLabel lblId = new JLabel("ID del plan:");
        JLabel lblTipo = new JLabel("Tipo de vehículo:");
        JLabel lblPeriodicidad = new JLabel("Periodicidad (km):");
        JLabel lblChecklist = new JLabel("Checklist:");
        JLabel lblRepuestos = new JLabel("Repuestos:");
        JLabel lblNotas = new JLabel("Notas:");
        JLabel lblNuevoKm = new JLabel("Periodicidad del clon:");
        JLabel lblNotasClon = new JLabel("Notas del clon:");
        JLabel lblDuracion = new JLabel("Duración estimada (horas):");
        JLabel lblCosto = new JLabel("Costo estimado ($):");


        // Campos y áreas de texto
        txtId = new JTextField(8);
        cmbTipoVehiculo = new JComboBox<>(new String[]{"Bus", "Minivan", "Otro"});
        txtPeriodicidad = new JTextField(8);
        txtChecklist = new JTextArea(4, 20);
        txtRepuestos = new JTextArea(4, 20);
        txtNotas = new JTextArea(3, 20);
        txtNuevoKm = new JTextField(8);
        txtNotasClon = new JTextArea(3, 20);
        txtDuracion = new JTextField(8);
        txtCosto = new JTextField(8);

        // ComboBox y botones
        cmbPlanBase = new JComboBox<>();
        btnCargarPlan = new JButton("Cargar Plan Base");
        btnClonarPlan = new JButton("Clonar Plan");
        btnExportar = new JButton("Exportar Resultado");

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // === Estructura ===
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));

        // Selector de plan base
        panel.add(lblSeleccion);
        JPanel filaSeleccion = new JPanel();
        filaSeleccion.add(cmbPlanBase);
        filaSeleccion.add(btnCargarPlan);
        panel.add(filaSeleccion);

        panel.add(Box.createVerticalStrut(10));

        // Datos del plan
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblTipo);
        panel.add(cmbTipoVehiculo);
        panel.add(lblPeriodicidad);
        panel.add(txtPeriodicidad);
        panel.add(lblDuracion);
        panel.add(txtDuracion);
        panel.add(lblCosto);
        panel.add(txtCosto);

        panel.add(lblChecklist);
        panel.add(new JScrollPane(txtChecklist));

        panel.add(lblRepuestos);
        panel.add(new JScrollPane(txtRepuestos));

        panel.add(lblNotas);
        panel.add(new JScrollPane(txtNotas));

        // Sección del clon
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblNuevoKm);
        panel.add(txtNuevoKm);
        panel.add(lblNotasClon);
        panel.add(new JScrollPane(txtNotasClon));

        // Botones de acción
        panel.add(Box.createVerticalStrut(10));
        JPanel filaBotones = new JPanel();
        filaBotones.add(btnClonarPlan);
        filaBotones.add(btnExportar);
        panel.add(filaBotones);

        add(panel);
        pack();
    }

    // --- Método para mostrar mensajes desde el controlador ---
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
