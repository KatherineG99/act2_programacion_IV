
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Katherine Gomez
 */
public class Conexion {
    
    static String bd="libreriajuegos";
    static String user="root";
    static String password="root";
    static String urlbd="jdbc:mysql://localhost:3306/"+bd;
    Connection conn = null;
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar()throws Exception{
        conn.close();
    }
   

    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(urlbd,user,password);
            if(conn!=null){
                System.out.println("Conexion establecida con exito");
            }
            
        }catch(Exception e){
            System.out.println("Fallo en la conexion error : "+e);
            
        }
    }
    
   /* public static void main(String[] args) {
        //prueba de conexion
        Conexion conn = new Conexion();
        conn.conectar();
    }*/
   
}
