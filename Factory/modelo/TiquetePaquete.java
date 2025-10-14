/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class TiquetePaquete extends Tiquete {
    private final int cantidadItems;

    public TiquetePaquete(String idCliente, String nombre, String destino, double valor, String idFactura, int cantidadItems) {
        super(idCliente, nombre, destino, valor, idFactura);
        this.cantidadItems = cantidadItems;
    }

    @Override
    public String mostrarDetalles() {
        return "Factura de Paquete [" + idFactura + "] - Cliente: " + nombre + 
               ", Destino: " + destino + ", Valor: $" + valor + 
               ", Ítems: " + cantidadItems;
    }
}
