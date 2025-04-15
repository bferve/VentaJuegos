
package dao;


import java.sql.*;

public class Conexion {
    
    //conexion local
    private static String url ="jdbc:postgresql://localhost:5432/postgres";
    private static String user="postgres";
    private static String pass = "admin";
    private static Connection con = null;
    
    public static Connection conectar(){
        
        try{
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion Exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }  
    
    
}
