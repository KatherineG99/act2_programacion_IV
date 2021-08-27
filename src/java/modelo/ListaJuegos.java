
package modelo;

import java.util.List;

/**
 *
 * @author Katherine Gomez
 */
public class ListaJuegos {
    private int id;
    private String nombre;
    private String genero;
    private String clasificacion;
    private String descripcion;
    private String date;
    
    public ListaJuegos(int id){
        this.id=id;
    }
    
    public ListaJuegos(List<ListaJuegos> Lista){
         throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
