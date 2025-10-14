package modelo;

public class Session { // almacenar y gestionar los usuarios
    private String usuario; // nombre de usuario
    private Token token; // token generado

    public Session(String usuario, Token token) { // Inicializa una nueva sesión para el usuario validado
        this.usuario = usuario; 
        this.token = token;
    }

    public String getUsuario() { // Devuelve el nombre del usuario asociado a la sesión
        return usuario;
    }

    public Token getToken() { // Devuelve el token asociado a esta sesión
        return token;
    }
}