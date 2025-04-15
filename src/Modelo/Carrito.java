
package Modelo;


public class Carrito {
    private String usuario_id;
    private String juego_id;
    private int cantidad;

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getJuego_id() {
        return juego_id;
    }

    public void setJuego_id(String juego_id) {
        this.juego_id = juego_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
