/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.vista;

/**
 *
 * @author JL
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * Ventana de detalle de la Ruta Programada.
 * Muestra la información en tablas (vehículo, conductor, paradas, restricciones).
 */
public class ExportarRutaProgramada extends JFrame{
    public JButton btnExportarTxt;
    public JButton btnImprimir;
    public JButton btnCerrar;

    private JTable tblVehiculo;
    private JTable tblParadas;
    private JTable tblRestricciones;
    private JTextArea txtResumen;

    public ExportarRutaProgramada(String contenido) {
        initComponents(contenido);
        setTitle("Ruta Programada - Detalles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents(String contenido) {
        JLabel lblTitulo = new JLabel("Ruta Programada - Detalles");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // === TABLA VEHÍCULO / CONDUCTOR ===
        String[][] datosVehiculo = {
                {"Vehículo", extraer(contenido, "Vehículo:")},
                {"Conductor", extraer(contenido, "Conductor:")},
                {"Origen", extraer(contenido, "Origen:")},
                {"Destino", extraer(contenido, "Destino:")},
                {"Distancia Total", extraer(contenido, "Distancia total:")},
                {"Tiempo Estimado", extraer(contenido, "Tiempo estimado:")}
        };
        String[] columnasVehiculo = {"Campo", "Valor"};
        tblVehiculo = new JTable(new DefaultTableModel(datosVehiculo, columnasVehiculo));

        // === TABLA DE PARADAS ===
        String[][] datosParadas = extraerTabla(contenido, "Paradas:");
        String[] columnasParadas = {"#", "Descripción"};
        tblParadas = new JTable(new DefaultTableModel(datosParadas, columnasParadas));

        // === TABLA DE RESTRICCIONES ===
        String[][] datosRestricciones = extraerTabla(contenido, "Restricciones:");
        String[] columnasRestricciones = {"#", "Tipo/Detalle"};
        tblRestricciones = new JTable(new DefaultTableModel(datosRestricciones, columnasRestricciones));

        // === RESUMEN DE TEXTO (opcional) ===
        txtResumen = new JTextArea(5, 40);
        txtResumen.setText(contenido);
        txtResumen.setEditable(false);
        txtResumen.setBorder(BorderFactory.createTitledBorder("Resumen"));

        // === BOTONES ===
        btnExportarTxt = new JButton("Exportar a TXT");
        btnImprimir = new JButton("Imprimir");
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnExportarTxt.addActionListener(e -> exportarComoTxt(contenido));
        btnImprimir.addActionListener(e -> imprimir());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnExportarTxt);
        panelBotones.add(btnImprimir);
        panelBotones.add(btnCerrar);

        // === ORGANIZACIÓN GENERAL ===
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel tablas = new JPanel(new GridLayout(3, 1, 5, 5));
        tablas.add(new JScrollPane(tblVehiculo));
        tablas.add(new JScrollPane(tblParadas));
        tablas.add(new JScrollPane(tblRestricciones));

        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(tablas, BorderLayout.CENTER);
        panel.add(txtResumen, BorderLayout.SOUTH);
        panel.add(panelBotones, BorderLayout.PAGE_END);

        add(panel);
        pack();
    }

    private String extraer(String texto, String campo) {
        int idx = texto.indexOf(campo);
        if (idx == -1) return "";
        int end = texto.indexOf("\n", idx);
        if (end == -1) end = texto.length();
        return texto.substring(idx + campo.length()).split("\n")[0].trim();
    }
    
    private String[][] extraerTabla(String texto, String campo) {
        if (!texto.contains(campo)) return new String[0][0];

        if (campo.equals("Paradas:")) {
            String valor = extraer(texto, campo);
            return new String[][]{{"1", "Total de paradas: " + valor}};
        }

        if (campo.equals("Restricciones:")) {
            String valor = extraer(texto, campo);
            if (valor.equals("Ninguna"))
                return new String[][]{{"1", "Sin restricciones"}};
            String[] items = valor.replace("[", "").replace("]", "").split(",");
            String[][] data = new String[items.length][2];
            for (int i = 0; i < items.length; i++) {
                data[i][0] = String.valueOf(i + 1);
                data[i][1] = items[i].trim();
            }
            return data;
        }

        return new String[0][0];
    }

    private void exportarComoTxt(String contenido) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar Ruta Programada");
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (java.io.FileWriter fw = new java.io.FileWriter(fc.getSelectedFile() + ".txt")) {
                fw.write(contenido);
                JOptionPane.showMessageDialog(this, "Ruta exportada correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al exportar: " + ex.getMessage());
            }
        }
    }

    private void imprimir() {
        try {
            txtResumen.print();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al imprimir: " + ex.getMessage());
        }
    }
}
