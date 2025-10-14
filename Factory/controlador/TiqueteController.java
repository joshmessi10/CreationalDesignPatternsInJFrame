/*
 * Controlador encargado de manejar la creación de facturas
 * Usa el patrón Factory para generar diferentes tipos de tiquetes
 */

package controlador;

import modelo.*;
import java.util.Random;

//ontrola la creación de tiquetes
public class TiqueteController {
    // Atributo que almacena la fábrica usada para crear los tiquetes
    private TiqueteFactory factory;

    /**
     * Genera un identificador único para la factura
     */
    public String generarIdFactura() {
        Random random = new Random(); // Generador de números aleatorios
        int numero = 1000 + random.nextInt(9000); // Genera un número entre 1000 y 9999
        return "F" + numero; // Retorna el ID con prefijo "F"
    }

    // Crea una factura del tipo indicado
    public Tiquete crearFactura(String tipo, String idCliente, String nombre, String destino, double valor, int cantidad) {
        // Genera un nuevo ID de factura
        String idFactura = generarIdFactura();
        
        // Selecciona la fábrica según el tipo de tiquete
        if (tipo.equals("paquete")) {
            factory = new PaqueteFactory();
        } else if (tipo.equals("pasajero")) {
            factory = new PasajeroFactory();
        } else {
            return null; // Si el tipo no es válido, no se crea nada
        }

        // Usa la fábrica para crear el tiquete correspondiente
        Tiquete tiquete = factory.crearTiquete(idCliente, nombre, destino, valor, idFactura, cantidad);
        return tiquete; // Retorna el tiquete creado
    }
}
