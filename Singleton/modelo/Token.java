package modelo;
// Representa un token de autenticación generado para un usuario
public class Token {
    private String usuario; // usuario al que pertenece el token
    private String valor; // cadena única del token generado

    // Crea un token sin asignarle aún un valor específico
    public Token(String usuario) {
        this.usuario = usuario;
    }

    public Token(String usuario, String valor) { // Crea un token asignando tanto el usuario como el valor
        this.usuario = usuario;
        this.valor = valor;
    }

    public String getUsuario() { // Devuelve el nombre del usuario asociado a este token
        return usuario;
    }

    public String getValor() { // Devuelve el valor actual del token
        return valor;
    }

    public void setValor(String valor) { // Permite modificar o asignar un nuevo valor al token
        this.valor = valor;
    }
}
