package factory;

import modelo.PagoTarjeta;
import modelo.Pago;

public class CreadorTarjeta extends CreadorPago {
    @Override
    public Pago crearPago(int id, int monto) {
        return new PagoTarjeta(id, monto);
    }
}
