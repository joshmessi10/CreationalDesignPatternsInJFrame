/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.planificadorrutas.controlador;

/**
 *
 * @author JL
 */
import com.mycompany.planificadorrutas.modelo.builders.*;
import com.mycompany.planificadorrutas.modelo.director.DirectorRuta;
import com.mycompany.planificadorrutas.modelo.componentes.*;
import com.mycompany.planificadorrutas.modelo.productos.*;
import com.mycompany.planificadorrutas.vista.ExportarReporteRuta;
import com.mycompany.planificadorrutas.vista.ExportarRutaProgramada;
import com.mycompany.planificadorrutas.vista.VistaPlanificadorRutas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Controlador principal del proceso de planificación de rutas.
 * 
 * Se encarga de:
 * - Escuchar los eventos de la vista (botones)
 * - Tomar los datos del formulario
 * - Construir el tipo de producto (RutaProgramada o ReporteRuta)
 * - Mostrar el resultado en la interfaz
 */
public class Controlador implements ActionListener {

    private VistaPlanificadorRutas vista;
    private DirectorRuta director;

    public Controlador(VistaPlanificadorRutas vista) {
        this.vista = vista;
        this.director = new DirectorRuta();

        vista.btnGenerarRuta.addActionListener(this);
        vista.btnGenerarReporte.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGenerarRuta) {
            generarRutaProgramada();
        } else if (e.getSource() == vista.btnGenerarReporte) {
            generarReporteRuta();
        }
    }

    private boolean validarCampos() {
        if (vista.txtPlaca.getText().isEmpty() || vista.txtTipoVehiculo.getText().isEmpty()
                || vista.txtCapacidad.getText().isEmpty() || vista.txtConductor.getText().isEmpty()
                || vista.txtOrigen.getText().isEmpty() || vista.txtDestino.getText().isEmpty()
                || vista.txtTarifaBase.getText().isEmpty() || vista.txtCostoKm.getText().isEmpty()) {
            mostrarError("Por favor, complete todos los campos obligatorios.");
            return false;
        }

        try {
            Integer.parseInt(vista.txtCapacidad.getText());
            Double.parseDouble(vista.txtTarifaBase.getText());
            Double.parseDouble(vista.txtCostoKm.getText());
        } catch (NumberFormatException ex) {
            mostrarError("Capacidad, Tarifa Base y Costo/km deben ser valores numéricos.");
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(vista, mensaje, "Error de validación", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    private List<Parada> obtenerParadas() {
        String[] lineas = vista.txtParadas.getText().split("\n");
        List<Parada> paradas = new ArrayList<>();
        for (String linea : lineas) {
            if (!linea.trim().isEmpty()) {
                paradas.add(new Parada(linea.trim(), 0, 0)); // Coordenadas omitidas
            }
        }
        return paradas;
    }

    private List<Restriccion> obtenerRestricciones() {
        List<Restriccion> restricciones = new ArrayList<>();
        if (vista.chkEvitarTráfico.isSelected()) {
            restricciones.add(new Restriccion("Tráfico", "Evitar tráfico pesado"));
        }
        if (vista.chkEvitarZonasEscolares.isSelected()) {
            restricciones.add(new Restriccion("Zona", "Evitar zonas escolares"));
        }
        return restricciones;
    }

    private Tarifa obtenerTarifa() {
        double base = Double.parseDouble(vista.txtTarifaBase.getText());
        double porKm = Double.parseDouble(vista.txtCostoKm.getText());
        String tipo = vista.cmbTipoServicio.getSelectedItem().toString();
        return new Tarifa(tipo, base, porKm);
    }

    private void generarRutaProgramada() {
        if (!validarCampos()) return;

        Vehiculo vehiculo = new Vehiculo(vista.txtPlaca.getText(), vista.txtTipoVehiculo.getText(),
                Integer.parseInt(vista.txtCapacidad.getText()));
        Conductor conductor = new Conductor("C001", vista.txtConductor.getText(), "Licencia B2", true);
        List<Parada> paradas = obtenerParadas();
        List<Restriccion> restricciones = obtenerRestricciones();
        List<Tarifa> tarifas = Collections.singletonList(obtenerTarifa());
        //Llama los métodos del builder para la ruta programada
        RutaProgramadaBuilder builder = new RutaProgramadaBuilder();
        builder.reset();
        builder.agregarParadas(paradas);
        builder.asignarVehiculo(vehiculo);
        builder.definirConductor(conductor);
        builder.agregarRestricciones(restricciones);
        builder.configurarTarifas(tarifas);
        director.construirRutaProgramada(builder);
        RutaProgramada ruta = builder.obtenerResultado();
        // Genera el string con los datos recogidos
        StringBuilder sb = new StringBuilder();
        sb.append("=== RUTA PROGRAMADA ===\n");
        sb.append("Vehículo: ").append(vehiculo).append("\n");
        sb.append("Conductor: ").append(conductor).append("\n");
        sb.append("Origen: ").append(vista.txtOrigen.getText()).append("\n");
        sb.append("Destino: ").append(vista.txtDestino.getText()).append("\n");
        sb.append("Paradas: ").append(paradas.size()).append("\n");
        sb.append("Distancia total: ").append(ruta.getDistanciaTotalKm()).append(" km\n");
        sb.append("Tiempo estimado: ").append(String.format("%.2f", ruta.getTiempoTotalMin())).append(" min\n");
        sb.append("Restricciones: ").append(restricciones.isEmpty() ? "Ninguna" : restricciones).append("\n");
        new ExportarRutaProgramada(sb.toString()).setVisible(true);
    }

    private void generarReporteRuta() {
        if (!validarCampos()) return;

        Vehiculo vehiculo = new Vehiculo(vista.txtPlaca.getText(), vista.txtTipoVehiculo.getText(),
                Integer.parseInt(vista.txtCapacidad.getText()));
        Conductor conductor = new Conductor("C001", vista.txtConductor.getText(), "Licencia B2", true);
        List<Parada> paradas = obtenerParadas();
        List<Restriccion> restricciones = obtenerRestricciones();
        List<Tarifa> tarifas = Collections.singletonList(obtenerTarifa());
        //Llama los métodos del builder para el reporte de ruta
        ReporteRutaBuilder builder = new ReporteRutaBuilder();
        builder.reset();
        builder.agregarParadas(paradas);
        builder.asignarVehiculo(vehiculo);
        builder.definirConductor(conductor);
        builder.agregarRestricciones(restricciones);
        builder.configurarTarifas(tarifas);
        director.construirReporteRuta(builder);
        ReporteRuta reporte = builder.obtenerResultado();
        // Genera el string con los datos ingresados
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE GERENCIAL ===\n");
        sb.append("Vehículo: ").append(vehiculo).append("\n");
        sb.append("Conductor: ").append(conductor).append("\n");
        sb.append("Tipo de servicio: ").append(vista.cmbTipoServicio.getSelectedItem()).append("\n");
        sb.append("Distancia total: ").append(reporte.getDistanciaTotalKm()).append(" km\n");
        sb.append("Tiempo estimado: ").append(String.format("%.2f", reporte.getTiempoTotalMin())).append(" min\n");
        sb.append("Costo estimado: $").append(String.format("%.2f", reporte.getCostoEstimado())).append("\n");
        sb.append("Velocidad promedio: ").append(String.format("%.2f", reporte.getPromedioVelocidad())).append(" km/h\n");
        sb.append("Restricciones: ").append(restricciones.isEmpty() ? "Ninguna" : restricciones).append("\n");
        new ExportarReporteRuta(sb.toString()).setVisible(true);
    }
}