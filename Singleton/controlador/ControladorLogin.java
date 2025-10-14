package controlador;

// Importa las clases necesarias del modelo y la vista
import modelo.AuthenticationManager;
import modelo.Token;
import vista.LogIn;

/**
 * maneja la lógica de autenticación del sistema
 * conectando la vista con el modelo
 */
public class ControladorLogin {
    private LogIn vista;                       // Referencia a la vista
    private AuthenticationManager authManager; // Referencia al modelo Singleton de autenticación
    private String usuarioValidado = null;     // Guarda temporalmente el usuario validado
    private Token tokenGenerado = null;        // Guarda el token generado para el usuario

    // conecta los eventos de la vista con este controlador
    public ControladorLogin(LogIn vista) {
        this.vista = vista;
        this.authManager = AuthenticationManager.getInstance(); // Obtiene la instancia única del modelo
        this.vista.agregarListeners(this); // Conecta los botones de la vista con los métodos de este controlador
    }

    // botón "Validar".
    // Verifica si las credenciales (usuario y contraseña) son correctas.
    // Si lo son, genera un token asociado al usuario y lo muestra
    public void validarUsuario(String usuario, String clave) {
        // Llama al modelo para validar el usuario y la contraseña
        boolean valido = authManager.validarCredenciales(usuario, clave);

        if (valido) { // Si las credenciales son correctas
            usuarioValidado = usuario; // Guarda el usuario validado
            tokenGenerado = authManager.generarToken(usuario); // Genera un token nuevo y lo asocia al usuario
            vista.mostrarMensaje("Usuario válido");
            vista.mostrarToken(tokenGenerado.getValor());
        }
        else { // Si las credenciales son incorrectas
            vista.mostrarMensaje("Usuario o contraseña incorrectos.");
            usuarioValidado = null; // Reinicia el usuario validado
        }
    }

    //Verifica que el token ingresado en la vista sea válido
    //Si el token es válido, se permite el acceso al sistema
    public void validarAcceso(String valorToken) {
        if (authManager.validarToken(valorToken)) { // Valida el token
            vista.mostrarMensaje("Acceso permitido. Bienvenido " + usuarioValidado);
        } 
        else {
            vista.mostrarMensaje("Token inválido. Intenta validar de nuevo.");
        }
    }
}
