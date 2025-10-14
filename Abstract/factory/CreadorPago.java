package factory;

import modelo.Pago;

public abstract class CreadorPago {
    public abstract Pago crearPago(int id, int monto);
}


