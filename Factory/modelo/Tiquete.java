/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public abstract class Tiquete {
    public String idCliente;
    protected String nombre;
    protected String destino;
    public double valor;
    public String idFactura;

    public Tiquete(String idCliente, String nombre, String destino, double valor, String idFactura) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.destino = destino;
        this.valor = valor;
        this.idFactura = idFactura;
    }

    public abstract String mostrarDetalles();
}
