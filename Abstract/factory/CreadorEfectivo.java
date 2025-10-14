package factory;

import modelo.PagoEfectivo;
import modelo.Pago;

public class CreadorEfectivo extends CreadorPago {
    @Override
    public Pago crearPago(int id, int monto) {
        return new PagoEfectivo(id, monto);
    }
}
