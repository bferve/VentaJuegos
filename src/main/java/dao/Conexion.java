
package dao;


import java.sql.*;

public class Conexion {
    
    private static String url ="jdbc:postgresql://db.bcngexdxtuvkgnndqsac.supabase.co:5432/postgres";
    private static String user="postgres";
    private static String pass = "Mundolibre.123";
    private static Connection con = null;
    
    public static Connection conectar(){
        
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion Exitosa");
            
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        return con;
        //hola//com
         //Ccc
          ///asd
    }
    
    
}
