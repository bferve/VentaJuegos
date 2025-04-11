
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Juego;
import models.Usuario;

public class ControladorTienda {
    private Connection conexion;
    private Usuario usuarioActual;
    
    public ControladorTienda(Connection conexion){
        this.conexion = conexion;
    }
    
    public void setUsuarioActual(Usuario usuario){
        this.usuarioActual = usuario;
    }
    
    public boolean agregarAlCarrito(String juegoId) throws SQLException{
        if(usuarioActual == null){
            throw new IllegalStateException("No hay usuario autenticado");
        }
        Juego juego = buscarJuegoId(juegoId);
        
        if(juego != null){
            
        }
        
        return false;
    }
    

    
    public Juego buscarJuegoId(String juegoId) throws SQLException{
        String query = "SELECT id, titulo, precio,... FROM Juego WHERE"
                + "id = ? ";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            bridge.setString(1, juegoId);
            ResultSet rs = bridge.executeQuery();
            if(rs.next()){
                return new Juego(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("precio")
                );
            }
        }
                
        return null;
    }
    
    public List<Juego> obtenerJuegosConClave() throws SQLException{
        List<Juego> juegosConDisponibilidad = new ArrayList<Juego>();
        String query = "SELECT j.* c.* " + 
                       "FROM Juego j, Clave c"+
                       "WHERE j.juegoId = c.juegoId"+
                       "and c.Vendida = FALSE";
        try(PreparedStatement bridge = conexion.prepareStatement(query)){
            
        }
    }
    
}
