
package dao;


import java.sql.*;

public class Conexion {
    
    
    private static String url ="";
    private static String user="";
    private static String pass = "";
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
