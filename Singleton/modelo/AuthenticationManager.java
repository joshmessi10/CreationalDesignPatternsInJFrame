package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * proceso de autenticación del sistema
 * Implementa el patrón Singleton, por lo que solo puede existir una instancia activa.
 */
public class AuthenticationManager {
    private static AuthenticationManager instance; // Instancia única de la clase

    // almacenar información de sesiones y usuarios
    private Map<String, Session> almacenTokens;          // Tokens activos
    private RegistroAuditoria registroAuditoria;         // Registro de auditoría
    private Map<String, String> usuariosRegistrados;     // Base de datos de usuarios (simulada)

    /**
     * Constructor privado (propio del patrón Singleton).
     * Inicializa las estructuras de datos y crea usuarios de prueba.
     */
    private AuthenticationManager() {
        almacenTokens = new HashMap<>();         // Almacén de sesiones activas
        registroAuditoria = new RegistroAuditoria();  // Registro de eventos del sistema
        usuariosRegistrados = new HashMap<>();   // Usuarios y contraseñas registrados

        // Usuarios de prueba
        usuariosRegistrados.put("usuario1", "abc123");
        usuariosRegistrados.put("usuario2", "abc456");
    }

    /**
     * devuelve instancia y si no existe, la crea
     */
    public static synchronized AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    //Valida usuario y contraseña
    public boolean validarCredenciales(String usuario, String clave) {
        if (usuariosRegistrados.containsKey(usuario) && usuariosRegistrados.get(usuario).equals(clave)) {
            registroAuditoria.registrarEvento("Validación exitosa de credenciales: " + usuario);
            return true;
        } else {
            registroAuditoria.registrarEvento("Intento fallido de validación: " + usuario);
            return false;
        }
    }

    //Genera un token aleatorio de 5 cifras
    public Token generarToken(String usuario) {
        int numeroAleatorio = 10000 + new Random().nextInt(90000);
        Token token = new Token(usuario, String.valueOf(numeroAleatorio)) ; // Crea un nuevo objeto Token con el número generado
        almacenTokens.put(token.getValor(), new Session(usuario, token)); // Guarda la sesión activa en el almacén
        registroAuditoria.registrarEvento("Token generado para: " + usuario + " -> " + token.getValor()); // Registra el evento en la auditoría
        return token;
    }

    // valida si un token ingresado existe
    public boolean validarToken(String valorToken) {
        boolean valido = almacenTokens.containsKey(valorToken);
        registroAuditoria.registrarEvento("Validación de token (" + valorToken + "): " + valido);
        return valido;
    }

    // cierra una sesión específica eliminando su token del sistema
    public void cerrarSesion(String valorToken) {
        almacenTokens.remove(valorToken);
        registroAuditoria.registrarEvento("Sesión cerrada con token: " + valorToken);
    }

    //Revoca todas las sesiones de un usuario específico
    public void revocarTodasSesiones(String idUsuario) {
        almacenTokens.entrySet().removeIf(entry -> entry.getValue().getUsuario().equals(idUsuario));
        registroAuditoria.registrarEvento("Sesiones revocadas para usuario: " + idUsuario);
    }
}
