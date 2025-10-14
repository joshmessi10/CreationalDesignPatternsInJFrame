package modelo;


import modelo.Pago;


public class PagoTarjeta extends Pago {
    public PagoTarjeta(int id, int monto) {
        super(id, monto, "Tarjeta");
    }
}