package modelo;

import java.util.Objects;

public class Pago {
    private int id;
    private int monto;
    private String metodo;

    public Pago(int id, int monto, String metodo) {
        this.id = id;
        this.monto = monto;
        this.metodo = metodo;
    }

    public int getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Pago{id=" + id + ", monto=" + monto + ", metodo=" + metodo + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pago pago = (Pago) o;
        return id == pago.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
