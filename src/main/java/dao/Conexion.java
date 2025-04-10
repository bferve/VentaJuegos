
package dao;


import java.sql.*;

public class Conexion {
    
    private static String url ="jdbc:mysql://localhost:3306/listaimpotancia";
    private static String user="root";
    private static String pass = "admin";
    private static Connection con = null;
    
    public static Connection conectar(){
        
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion Exitosa");
            
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        return con;
    }
    
    
}
