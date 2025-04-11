
package controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.sql.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ControladorTiendaTest {
    @Mock
    private Connection conexion;
    ControladorTienda instance;
    
    
    public ControladorTiendaTest() {
            instance = new ControladorTienda(conexion);
    }

    
    @Test
    public void testAgregarJuego() {
        System.out.println("AgregarJuego");
        int juegoId = 0;
        boolean expResult = false;
        boolean result = instance.AgregarJuego(juegoId);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    
}
