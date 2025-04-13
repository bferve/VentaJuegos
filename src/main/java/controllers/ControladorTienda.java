
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Juego;
import models.Usuario;

public class ControladorTienda {
    
    private Connection conexion;
    private Usuario usuarioActual;
    private Juego juegoAcomprar;
    
    public ControladorTienda(Connection conexion){
        this.conexion = conexion;
    }
    
    public void setUsuarioActual(Usuario usuario){
        this.usuarioActual = usuario;
    }
    
    public List<Juego> obtenerJuegosConClave() throws SQLException{
        List<Juego> juegosConDisponibilidad = new ArrayList<Juego>();
        String query = "SELECT DISTINCT j.*, c.* FROM Juego j, Clave c WHERE j.id = c.juego_id and c.vendido = FALSE";
        
        try(Statement bridge = conexion.createStatement();
            ResultSet rs = bridge.executeQuery(query)){
            
            while(rs.next()){
                juegosConDisponibilidad.add(
                new Juego(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getDouble("precio"),
                        rs.getString("genero"),
                        rs.getString("descripcion"),
                        rs.getString("imagenurl"),
                        rs.getDate("fechalanzamiento"),
                        rs.getString("desarrollador"),
                        rs.getDouble("calificacion")
                ));
            }
        }
        return juegosConDisponibilidad;
    }
    
    public String comprarJuego(String juegoID) throws SQLException{
        if(usuarioActual == null){
            throw new IllegalStateException("Usuario no identificado");
        }
        
        String clave = null;
        if(!agregarAlCarrito(juegoID)){
            clave = obtenerClaveDisponible(juegoID);
            if(clave == null) return null;
        }
        registrarVenta(juegoID, clave);
        return clave;
    }
    
    private String obtenerClaveDisponible(String juegoID) throws SQLException{
        String query = "SELECT * FROM Clave "
                + "WHERE juego_id = ? AND vendido=FALSE"
                + "LIMIT 1";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, juegoID);
            ResultSet rs = bridge.executeQuery();
            if(rs.next()){
                String clave = rs.getString("clave");
                return clave;
            }
            
        }
        return null;
    }
    
    private void registrarVenta(String juegoID, String clave)throws SQLException{
        String query = "INSERT INTO Venta (juego_id, usuario_id, clave, fecha) VALUES (?,?,?,NOW())";
        
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, juegoID);
            bridge.setString(2, usuarioActual.getUsuario_id());
            bridge.setString(3, clave);
            bridge.executeUpdate();
        }
    }
    
    public boolean agregarAlCarrito(String juegoId) throws SQLException{
        List<Juego> lista;
        
        if(!tieneClaveDisponible(juegoId)){
            return false;
        }
        
        if(juegoYaEnCarrito(juegoId)){
            return incrementarCantidad(juegoId);
        }
        
        String query = "INSERT INTO carrito (usuario_id, juego_id, cantidad) VALUES (?,?,1)";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, usuarioActual.getUsuario_id());
            bridge.setString(2, juegoId);
            return bridge.executeUpdate() > 0;
        }
    }
    
    //Retorna si existe al menos un juego con clave disponible
    private boolean tieneClaveDisponible(String juegoId) throws SQLException{
        String query = "SELECT * FROM Clave WHERE juego_id = ? and vendido=FALSE";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, juegoId);
            ResultSet rs = bridge.executeQuery();
            return rs.next();
        }
    }
    
    //Si existe el juego ya en el carrito
    private boolean juegoYaEnCarrito(String juegoId) throws SQLException{
        String query = "SELECT * FROM Carrito WHERE usuario_id = ? and juego_id = ? ";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, usuarioActual.getUsuario_id());
            bridge.setString(2, juegoId);
            ResultSet rs = bridge.executeQuery();
            return rs.next();
        }
    }
    
    private boolean incrementarCantidad(String juegoId) throws SQLException{
        String query = "UPDATE carrito SET cantidad = cantidad +1 WHERE usuario_id=? AND juego_id=?";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, usuarioActual.getUsuario_id());
            bridge.setString(2, juegoId);
            return bridge.executeUpdate()>0;
        }
    }
    
    public Juego buscarJuegoId(String juegoId) throws SQLException{
        String query = "SELECT * FROM Juego WHERE id=?";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, juegoId);
            ResultSet rs = bridge.executeQuery();
            if(rs.next()){
                return new Juego(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getDouble("precio"),
                        rs.getString("genero"),
                        rs.getString("descripcion"),
                        rs.getString("imagenurl"),
                        rs.getDate("fechalanzamiento"),
                        rs.getString("desarrollador"),
                        rs.getDouble("calificacion")
                );
            }
        }        
        return null;
    }
    
    public Usuario getUser(){
        return usuarioActual;
    }
}
