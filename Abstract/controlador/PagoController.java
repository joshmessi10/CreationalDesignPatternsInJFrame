package controlador;

import factory.CreadorPago;
import factory.CreadorEfectivo;
import factory.CreadorTarjeta;
import modelo.Pago;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controla todas las operaciones relacionadas con los pagos dentro del sistema
 */
public class PagoController {
    // Lista que almacena todos los pagos registrados en el sistema
    private final List<Pago> pagos;

    //Inicializa la lista donde se guardarán los pagos
    public PagoController() {
        this.pagos = new ArrayList<>();
    }

    //crear un nuevo pago
    public boolean crearPago(CreadorPago creador, int id, int monto) {
        // Verifica si ya existe un pago con el mismo ID
        if (obtenerPago(id).isPresent()) {
            return false; // No se puede crear si ya existe
        }
        // Crea el pago usando la fábrica concreta (Efectivo o Tarjeta)
        Pago p = creador.crearPago(id, monto);
        pagos.add(p); // Agrega el pago a la lista
        return true;
    }

    //actualizar los datos de un pago existente
    public boolean actualizarPago(int id, int nuevoMonto, String nuevoMetodo) {
        Optional<Pago> op = obtenerPago(id);
        if (op.isPresent()) {
            Pago p = op.get();
            p.setMonto(nuevoMonto);
            p.setMetodo(nuevoMetodo);
            return true;
        }
        return false; // No se encontró el pago
    }

    //eliminar un pago
    public boolean eliminarPago(int id) {
        return pagos.removeIf(p -> p.getId() == id);
    }

    //listar todos los pagos registrados
    public List<Pago> listarPagos() {
        return new ArrayList<>(pagos);
    }

    //Método para buscar un pago específico por su ID.
    public Optional<Pago> obtenerPago(int id) {
        return pagos.stream().filter(p -> p.getId() == id).findFirst();
    }
}
