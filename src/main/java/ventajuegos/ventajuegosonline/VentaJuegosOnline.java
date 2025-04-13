
package ventajuegos.ventajuegosonline;

import controllers.ControladorTienda;
import java.sql.SQLException;
import java.util.List;
import models.Juego;
import models.Usuario;

public class VentaJuegosOnline {

    public static void main(String[] args) throws SQLException {
        //System.out.println("Hello World!");
        //dao.Conexion.conectar();
        
        Usuario user = new Usuario();
        ControladorTienda control = new ControladorTienda(dao.Conexion.conectar());
        
        Juego j  = control.buscarJuegoId("1");
        Usuario us = new Usuario();
     
        us.setUsuario_id("1");
        us.setNombre("Mario");
        us.setCorreo("mario@gmail.com");
        us.setContrasena("mario");
        control.setUsuarioActual(us);
        
        System.out.println(j.getPrecio());
        
        List<Juego> lista = control.obtenerJuegosConClave();
        for(Juego a:lista){
            System.out.println(a.getId());    
            System.out.println(a.getTitulo());
            System.out.println(a.getPrecio());
        }
        System.out.println(control.getUser().getNombre());
        
        String compra = control.comprarJuego("1");
        
        
    }
}