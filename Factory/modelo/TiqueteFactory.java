/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public interface TiqueteFactory {
    Tiquete crearTiquete(String idCliente, String nombre, String destino, double valor, String idFactura, int cantidad);
}
