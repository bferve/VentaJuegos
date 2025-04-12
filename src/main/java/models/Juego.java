
package models;

import java.util.Date;


public class Juego {
    private String id;
    private String titulo;
    private double precio;
    private String genero;
    private String descripcion;
    private String imagenURL;
    private Date fechaLanzamiento;
    private String desarrollador;
    private double calificacion;
    //private Vendedor vendedor;
    
    
    public Juego(String id, String titulo, Double precio){
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }
    
    public Juego(String id, String titulo, String descripcion, Double precio,
            String genero, String imagenURL, Date fechaLanzamiento,
            String desarrollador) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.genero = genero;
        this.imagenURL = imagenURL;
        this.fechaLanzamiento = fechaLanzamiento;
        this.desarrollador = desarrollador;
        calificacion = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    @Override
    public String toString(){
        return titulo+"("+genero+")-$"+precio;
    }
    
    
}