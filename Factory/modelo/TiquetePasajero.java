/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class TiquetePasajero extends Tiquete {
    private int cantidadTiquetes;

    public TiquetePasajero(String idCliente, String nombre, String destino, double valor, String idFactura, int cantidadTiquetes) {
        super(idCliente, nombre, destino, valor, idFactura);
        this.cantidadTiquetes = cantidadTiquetes;
    }

    @Override
    public String mostrarDetalles() {
        return "Factura de Pasajero [" + idFactura + "] - Cliente: " + nombre + 
               ", Destino: " + destino + ", Valor: $" + valor + 
               ", Tiquetes: " + cantidadTiquetes;
    }
}
