/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clonadorplanesmantenimiento.controlador;

/**
 *
 * @author JL
 */


import com.mycompany.clonadorplanesmantenimiento.modelo.prototype.*;
import com.mycompany.clonadorplanesmantenimiento.modelo.componentes.*;
import com.mycompany.clonadorplanesmantenimiento.vista.VistaMantenimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 * Controlador del módulo Prototype para la clonación de planes de mantenimiento.
 * Maneja la interacción entre la vista y el modelo.
 * 
 * @author JL
 */
public class Controlador implements ActionListener {

    private final VistaMantenimiento vista;
    private PlanMantenimiento planBase;
    private PlanMantenimiento planClonado;
    private final Map<String, PlanMantenimiento> prototipos = new HashMap<>();

    public Controlador(VistaMantenimiento vista) {
        this.vista = vista;
        inicializarPrototipos();

        // Llenar combo con los prototipos disponibles
        for (String nombre : prototipos.keySet()) {
            vista.cmbPlanBase.addItem(nombre);
        }

        // Asignar eventos
        vista.btnCargarPlan.addActionListener(this);
        vista.btnClonarPlan.addActionListener(this);
        vista.btnExportar.addActionListener(this);
    }

    // --- Inicializa planes base para clonación ---
    private void inicializarPrototipos() {
        // === PLAN DE MANTENIMIENTO BUS ESTÁNDAR ===
        PlanMantenimientoBus bus = new PlanMantenimientoBus("BUS001", "Bus", 10000);
        bus.agregarCheckItem(new CheckItem("Cambio de aceite", "Cada 10.000 km"));
        bus.agregarCheckItem(new CheckItem("Revisión de frenos", "Verificar aire"));
        bus.agregarRepuesto(new Repuesto("Filtro de aire", 1));
        bus.agregarRepuesto(new Repuesto("Aceite sintético", 5));
        bus.actualizarNotas("Plan estándar para buses urbanos.");
        bus.verificarFrenosAire();
        bus.verificarTacografo();
        bus.definirDuracionServicio(0);    
        bus.costoPromedio = 0.0;            

        // === PLAN DE MANTENIMIENTO MINIVAN ESTÁNDAR ===
        PlanMantenimientoMinivan mini = new PlanMantenimientoMinivan("MINI001", "Minivan", 8000);
        mini.agregarCheckItem(new CheckItem("Cambio de bujías", "Cada 8.000 km"));
        mini.agregarRepuesto(new Repuesto("Filtro de combustible", 1));
        mini.actualizarNotas("Plan estándar para minivans familiares.");
        mini.verificarSuspensionLigera();
        mini.definirDuracionServicio(0);   
        mini.costoPromedio = 0.0;           

        // Cargar al mapa de prototipos
        prototipos.put("Bus estándar", bus);
        prototipos.put("Minivan estándar", mini);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == vista.btnCargarPlan) {
            cargarPlanSeleccionado();
        } else if (src == vista.btnClonarPlan) {
            clonarPlan();
        } else if (src == vista.btnExportar) {
            exportarResultado();
        }
    }

    // --- Cargar datos del plan base seleccionado ---
    private void cargarPlanSeleccionado() {
        String seleccionado = (String) vista.cmbPlanBase.getSelectedItem();
        planBase = prototipos.get(seleccionado);
        if (planBase == null) {
            vista.mostrarMensaje("❌ No se encontró el plan seleccionado.");
            return;
        }
        cargarDatosEnVista(planBase);
        vista.mostrarMensaje("✅ Plan cargado: " + seleccionado);
    }

    private void cargarDatosEnVista(PlanMantenimiento plan) {
        vista.txtId.setText(plan.getId());
        vista.cmbTipoVehiculo.setSelectedItem(plan.getVehiculoTipo());
        vista.txtPeriodicidad.setText(String.valueOf(plan.getPeriodicidadKm()));
        vista.txtChecklist.setText(String.join("\n", 
            plan.getChecklist().stream().map(CheckItem::toString).toList()));
        vista.txtRepuestos.setText(String.join("\n", 
            plan.getRepuestos().stream().map(Repuesto::toString).toList()));
        vista.txtNotas.setText(plan.getNotasTecnicas());

        // 🕐 Mostrar duración y costo iniciales
        vista.txtDuracion.setText(String.valueOf(plan.getDuracionHoras()));
        vista.txtCosto.setText(String.format("%.2f", plan.getCostoPromedio()));
    }


    // --- Clonar plan cargado ---
private void clonarPlan() {
    if (planBase == null) {
        vista.mostrarMensaje("⚠️ Cargue un plan base antes de clonar.");
        return;
    }

    // Crear una copia profunda del plan base
    planClonado = (PlanMantenimiento) planBase.clone();

    // Aplicar datos del formulario
    String kmTexto = vista.txtPeriodicidad.getText().trim();
    if (!kmTexto.isEmpty()) {
        try {
            int nuevoKm = Integer.parseInt(kmTexto);
            planClonado.ajustarPeriodicidad(nuevoKm);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("⚠️ Valor de km inválido.");
        }
    }

    // Duración
    String duracionTexto = vista.txtDuracion.getText().trim();
    if (!duracionTexto.isEmpty()) {
        try {
            int horas = Integer.parseInt(duracionTexto);
            planClonado.definirDuracionServicio(horas);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("⚠️ Duración inválida, se mantiene igual.");
        }
    }

    // Costo
    String costoTexto = vista.txtCosto.getText().trim();
    if (!costoTexto.isEmpty()) {
        try {
            double costo = Double.parseDouble(costoTexto);
            planClonado.costoPromedio = costo;
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("⚠️ Costo inválido, se mantiene igual.");
        }
    } else {
        planClonado.calcularCostoPromedio();
    }

    // Checklist y repuestos (igual que antes)
    String checklistTexto = vista.txtChecklist.getText().trim();
    planClonado.getChecklist().clear();
    if (!checklistTexto.isEmpty()) {
        for (String linea : checklistTexto.split("\n")) {
            if (!linea.isBlank()) planClonado.agregarCheckItem(new CheckItem(linea, ""));
        }
    }

    String repuestosTexto = vista.txtRepuestos.getText().trim();
    planClonado.getRepuestos().clear();
    if (!repuestosTexto.isEmpty()) {
        for (String linea : repuestosTexto.split("\n")) {
            if (!linea.isBlank()) planClonado.agregarRepuesto(new Repuesto(linea, 1));
        }
    }

    // Notas
    String notasBase = planBase.getNotasTecnicas() != null ? planBase.getNotasTecnicas() + "\n" : "";
    String notasClon = vista.txtNotasClon.getText().trim();
    if (!notasClon.isEmpty()) {
        planClonado.actualizarNotas(notasBase + notasClon + "\n(Clonado desde " + planBase.getId() + ")");
    } else {
        planClonado.actualizarNotas(notasBase + "(Clonado desde " + planBase.getId() + ")");
    }

    vista.mostrarMensaje("✅ Plan clonado con todos los datos del formulario aplicados.");
}




    // --- Exportar solo el plan clonado en tabla visual ---
   private void exportarResultado() {
        if (planClonado == null) {
            vista.mostrarMensaje("Primero debe clonar un plan antes de exportar.");
            return;
        }

        // --- Construir datos de la tabla ---
        List<String[]> rows = new ArrayList<>();

        // Información general
        rows.add(new String[]{"ID", planClonado.getId()});
        rows.add(new String[]{"Tipo de Vehículo", planClonado.getVehiculoTipo()});
        rows.add(new String[]{"Periodicidad", planClonado.getPeriodicidadKm() + " km"});
        rows.add(new String[]{"Duración", planClonado.getDuracionHoras() + " h"});
        rows.add(new String[]{"Costo Promedio", "$" + String.format("%.2f", planClonado.getCostoPromedio())});
        rows.add(new String[]{"Notas Técnicas", planClonado.getNotasTecnicas()});
        rows.add(new String[]{"Notas del Clon", vista.txtNotasClon.getText().isEmpty() ? "(Sin notas)" : vista.txtNotasClon.getText()});

        // Checklist
        rows.add(new String[]{"--- CHECKLIST ---", ""});
        for (int i = 0; i < planClonado.getChecklist().size(); i++) {
            CheckItem item = planClonado.getChecklist().get(i);
            rows.add(new String[]{String.valueOf(i + 1), item.getNombre()});
        }

        // Repuestos
        rows.add(new String[]{"--- REPUESTOS ---", ""});
        for (int i = 0; i < planClonado.getRepuestos().size(); i++) {
            Repuesto rep = planClonado.getRepuestos().get(i);
            rows.add(new String[]{String.valueOf(i + 1), rep.getNombre() + " x" + rep.getCantidad()});
        }

        // Convertir a array para JTable
        String[][] data = new String[rows.size()][2];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }
        String[] columnNames = {"Campo", "Valor"};

        // --- Crear JTable con estilo ---
        JTable table = new JTable(data, columnNames);
        table.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 14));
        table.setRowHeight(25);

        table.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        table.getTableHeader().setBackground(new java.awt.Color(60, 120, 180));
        table.getTableHeader().setForeground(java.awt.Color.WHITE);

        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new java.awt.Color(230, 240, 250) : java.awt.Color.WHITE);
                }
                return c;
            }
        });

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        // --- Mostrar en ventana amplia ---
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new java.awt.Dimension(1150, 650));
        JOptionPane.showMessageDialog(null, scrollPane,
                "Resultado del Plan Clonado", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * Sincroniza los valores del formulario con el objeto del modelo.
     */
    private void actualizarPlanDesdeVista(PlanMantenimiento plan) {
        plan.actualizarNotas(vista.txtNotas.getText());
        try {
            plan.ajustarPeriodicidad(Integer.parseInt(vista.txtPeriodicidad.getText()));
        } catch (NumberFormatException e) {
            // Ignorar si no es válido
        }
    }
}
