
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.ListaJuegos;

/**
 *
 * @author Katherine Gomez
 */
public class ListDao {
    Conexion conn;

    public ListDao(Conexion conn) {
        this.conn = conn;
    }
    
    public boolean insertar(ListaJuegos list){
        String sql = "insert into Juegos values(?,?,?,?,?,?)";
        try{
            PreparedStatement PS = conn.conectar().prepareStatement(sql);
            PS.setInt(1, list.getId());
            PS.setString(2, list.getNombre());
            PS.setString(3, list.getGenero());
            PS.setString(4, list.getClasificacion());
            PS.setString(5, list.getDescripcion());
            PS.setString(6, list.getDate());
            PS.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
    }
    
    public List<ListaJuegos> consultarTodo(){
     String  sql ="Select * from Juegos";
     try{
         PreparedStatement pst= conn.conectar().prepareStatement(sql);
         ResultSet rst = pst.executeQuery();
         ListaJuegos list;
         List<ListaJuegos> Lista = new LinkedList<>();
         
         while(rst.next()){
             list=new ListaJuegos(rst.getInt("id"));
             list.setNombre(rst.getString("nombre"));
             list.setGenero(rst.getString("genero"));
             list.setClasificacion(rst.getString("clasificacion"));
             list.setDescripcion(rst.getString("descripcion"));
             list.setDate(rst.getString("fechalanzamiento"));
             Lista.add(list);
         }
         return Lista;
         
     }catch(Exception e){
         return null;
         
     }
    }
    
}
