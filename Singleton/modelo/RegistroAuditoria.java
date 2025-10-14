package modelo;

/**
 * registrar los eventos importantes del sistema,
 * como validaciones, generación de tokens, cierres de sesión.
 */

public class RegistroAuditoria {

    public void registrarEvento(String mensaje) {
        System.out.println("[AUDITORÍA] " + mensaje);
    }
}