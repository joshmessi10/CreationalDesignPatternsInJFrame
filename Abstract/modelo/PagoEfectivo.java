package modelo;

import modelo.Pago;

public class PagoEfectivo extends Pago {
    public PagoEfectivo(int id, int monto) {
    super(id, monto, "Efectivo");
    }
}
