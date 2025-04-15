package Controlador;

public class ControladorLogin {
    // Usuarios y contraseñas predefinidos
    private String[][] usuarios = {
        {"fidel", "1234"}, // Usuario: fidel, Contraseña: 1234
        {"admin", "admin123"}, // Usuario: admin, Contraseña: admin123
        {"invitado", "invitado"}
    };

    // Método para validar el usuario y contraseña
    public boolean validarCredenciales(String usuario, String contraseña) {
        for (String[] datosUsuario : usuarios) {
            if (datosUsuario[0].equals(usuario) && datosUsuario[1].equals(contraseña)) {
                return true; // Credenciales correctas
            }
        }
        return false; // Credenciales incorrectas
    }
}