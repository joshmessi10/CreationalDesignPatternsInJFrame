/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.vista;

import com.mycompany.planificadorrutas.controlador.Controlador;
import javax.swing.*;

/**
 * Ventana principal del Planificador de Rutas (Patrón Builder).
 * Contiene todos los campos, checkboxes y botones del formulario principal.
 */
public class VistaPlanificadorRutas extends JFrame {
    // === COMPONENTES PÚBLICOS ACCESIBLES POR EL CONTROLADOR ===
    public JTextField txtPlaca;
    public JTextField txtTipoVehiculo;
    public JTextField txtCapacidad;
    public JTextField txtConductor;
    public JTextField txtOrigen;
    public JTextField txtDestino;
    public JTextField txtTarifaBase;
    public JTextField txtCostoKm;
    public JCheckBox chkEvitarTráfico;
    public JCheckBox chkEvitarZonasEscolares;
    public JComboBox<String> cmbTipoServicio;
    public JButton btnAgregarParada;
    public JButton btnGenerarRuta;
    public JButton btnGenerarReporte;
    public JTextArea txtParadas;

    public VistaPlanificadorRutas() {
        initComponents();
        setTitle("Planificador de Rutas - Patrón Builder");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vincular controlador
        new Controlador(this);
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Planificador de Rutas");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));

        JLabel lblPlaca = new JLabel("Placa:");
        JLabel lblTipoVehiculo = new JLabel("Tipo:");
        JLabel lblCapacidad = new JLabel("Capacidad:");
        JLabel lblConductor = new JLabel("Conductor:");
        JLabel lblOrigen = new JLabel("Origen:");
        JLabel lblDestino = new JLabel("Destino:");
        JLabel lblParadas = new JLabel("Paradas intermedias:");
        JLabel lblTarifa = new JLabel("Tarifa base:");
        JLabel lblCostoKm = new JLabel("Costo/km:");
        JLabel lblServicio = new JLabel("Tipo de servicio:");

        txtPlaca = new JTextField(10);
        txtTipoVehiculo = new JTextField(10);
        txtCapacidad = new JTextField(5);
        txtConductor = new JTextField(15);
        txtOrigen = new JTextField(10);
        txtDestino = new JTextField(10);
        txtTarifaBase = new JTextField(8);
        txtCostoKm = new JTextField(8);

        cmbTipoServicio = new JComboBox<>(new String[]{
            "Transporte Urbano", "Intermunicipal", "Interdepartamental"
        });

        chkEvitarTráfico = new JCheckBox("Evitar tráfico pesado");
        chkEvitarZonasEscolares = new JCheckBox("Evitar zonas escolares");

        txtParadas = new JTextArea(5, 20);
        txtParadas.setBorder(BorderFactory.createTitledBorder("Ingrese una parada por línea"));
        btnAgregarParada = new JButton("Agregar Paradas");

        btnGenerarRuta = new JButton("Generar Ruta Programada");
        btnGenerarReporte = new JButton("Generar Reporte Gerencial");

        // === PANEL PRINCIPAL ===
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(lblTitulo)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPlaca)
                    .addComponent(lblTipoVehiculo)
                    .addComponent(lblCapacidad)
                    .addComponent(lblConductor)
                    .addComponent(lblOrigen)
                    .addComponent(lblDestino)
                    .addComponent(lblTarifa)
                    .addComponent(lblCostoKm)
                    .addComponent(lblServicio))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlaca)
                    .addComponent(txtTipoVehiculo)
                    .addComponent(txtCapacidad)
                    .addComponent(txtConductor)
                    .addComponent(txtOrigen)
                    .addComponent(txtDestino)
                    .addComponent(txtTarifaBase)
                    .addComponent(txtCostoKm)
                    .addComponent(cmbTipoServicio)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(chkEvitarTráfico)
                .addComponent(chkEvitarZonasEscolares))
            .addComponent(lblParadas)
            .addComponent(txtParadas)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnGenerarRuta)
                .addComponent(btnGenerarReporte))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(lblTitulo)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblPlaca).addComponent(txtPlaca))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTipoVehiculo).addComponent(txtTipoVehiculo))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCapacidad).addComponent(txtCapacidad))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblConductor).addComponent(txtConductor))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblOrigen).addComponent(txtOrigen))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDestino).addComponent(txtDestino))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTarifa).addComponent(txtTarifaBase))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCostoKm).addComponent(txtCostoKm))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblServicio).addComponent(cmbTipoServicio))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(chkEvitarTráfico)
                .addComponent(chkEvitarZonasEscolares))
            .addComponent(lblParadas)
            .addComponent(txtParadas)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnGenerarRuta)
                .addComponent(btnGenerarReporte))
        );

        add(panel);
        pack();
    }
}
