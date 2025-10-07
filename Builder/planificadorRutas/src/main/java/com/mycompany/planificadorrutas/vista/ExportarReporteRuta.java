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
 * Ventana secundaria que muestra el resultado del Reporte de Ruta
 * y permite exportarlo o imprimirlo.
 */
public class ExportarReporteRuta extends JFrame{
    public JButton btnExportarTxt;
    public JButton btnImprimir;
    public JButton btnCerrar;

    private JTable tblDatos;
    private JTable tblRestricciones;
    private JTextArea txtResumen;

    public ExportarReporteRuta(String contenido) {
        initComponents(contenido);
        setTitle("Reporte de Ruta - Detalles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents(String contenido) {
        JLabel lblTitulo = new JLabel("Reporte Gerencial - Resultados");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // === TABLA PRINCIPAL ===
        String[][] datosReporte = {
                {"Vehículo", extraer(contenido, "Vehículo:")},
                {"Conductor", extraer(contenido, "Conductor:")},
                {"Tipo de Servicio", extraer(contenido, "Tipo de servicio:")},
                {"Distancia Total", extraer(contenido, "Distancia total:")},
                {"Tiempo Estimado", extraer(contenido, "Tiempo estimado:")},
                {"Costo Estimado", extraer(contenido, "Costo estimado:")},
                {"Velocidad Promedio", extraer(contenido, "Velocidad promedio:")}
        };
        String[] columnas = {"Indicador", "Valor"};
        tblDatos = new JTable(new DefaultTableModel(datosReporte, columnas));

        // === TABLA DE RESTRICCIONES ===
        String[][] datosRestricciones = extraerTabla(contenido, "Restricciones:");
        String[] columnasRestricciones = {"#", "Tipo/Detalle"};
        tblRestricciones = new JTable(new DefaultTableModel(datosRestricciones, columnasRestricciones));

        // === RESUMEN ===
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
        JPanel tablas = new JPanel(new GridLayout(2, 1, 5, 5));
        tablas.add(new JScrollPane(tblDatos));
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
    
    // === Construir tabla del reporte ===
    private String[][] extraerTabla(String texto, String campo) {
        if (!texto.contains(campo)) return new String[0][0];
        if (campo.equals("Paradas:")) {
            // Buscar cantidad o nombres (si los incluyes más adelante)
            String valor = extraer(texto, campo);
            return new String[][]{{"1", "Total de paradas: " + valor}};
        }
        if (campo.equals("Restricciones:")) {
            String valor = extraer(texto, campo);
            if (valor.equals("Ninguna"))
                return new String[][]{{"1", "Sin restricciones"}};
            // Si hay varias separadas por coma:
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
        fc.setDialogTitle("Guardar Reporte de Ruta");
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (java.io.FileWriter fw = new java.io.FileWriter(fc.getSelectedFile() + ".txt")) {
                fw.write(contenido);
                JOptionPane.showMessageDialog(this, "Reporte exportado correctamente.");
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
