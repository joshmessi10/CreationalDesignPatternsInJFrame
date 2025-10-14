/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que implementa la fábrica para crear tiquetes de tipo "Pasajero"
 */

public class PasajeroFactory implements TiqueteFactory {
    @Override
    public Tiquete crearTiquete(String idCliente, String nombre, String destino, double valor, String idFactura, int cantidad) {
        // Retorna un nuevo tiquete de tipo Pasajero con los datos proporcionados
        return new TiquetePasajero(idCliente, nombre, destino, valor, idFactura, cantidad);
    }
}
