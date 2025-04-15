/*
package controllers;


import org.junit.Test;
import org.mockito.*;
import java.sql.*;
import java.util.List;
import models.Juego;
import models.Usuario;
import static org.junit.Assert.assertEquals;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class ControladorTiendaTest {
    
    @Mock 
    private Connection mockConexion;
    
    @Mock
    private PreparedStatement mockPreparedStatement;
    
    @Mock
    private Statement mockStatement;
    
    @Mock 
    private ResultSet mockResultSet;
    
    
    private ControladorTienda controlador;
    private Usuario usuarioTest;
    
    void setUp() throws SQLException{
        MockitoAnnotations.openMocks(this);
        controlador = new ControladorTienda(mockConexion);
        usuarioTest = new Usuario();
        usuarioTest.setContrasena("123");
        usuarioTest.setCorreo("test@gmail.com");
        usuarioTest.setNombre("test");
        usuarioTest.setUsuario_id("1");
        controlador.setUsuarioActual(usuarioTest);
               
        when(mockConexion.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockConexion.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    }
    
    @Test
    public void testObtenerJuegosConClave() throws SQLException{
        when(mockResultSet.next()).thenReturn(true,true,false);
        when(mockResultSet.getString("id")).thenReturn("juego1","juego2");
        when(mockResultSet.getString("titulo")).thenReturn("Juego 1", "Juego 2");
        
        List<Juego> juegos = controlador.obtenerJuegosConClave();
        assertEquals(2, juegos.size());
        assertEquals("juego1", juegos.get(0).getId());
        assertEquals("Juego 1", juegos.get(0).getTitulo());
        
    }
}
*/