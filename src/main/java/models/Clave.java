
package models;

public class Clave {
    private String juego_id;
    private String clave;
    private boolean vendido;

    public String getJuego_id() {
        return juego_id;
    }

    public void setJuego_id(String juego_id) {
        this.juego_id = juego_id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendida) {
        this.vendido = vendida;
    }
    
    
}
