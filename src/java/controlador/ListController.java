package controlador;

import conexion.Conexion;
import dao.ListDao;
import java.util.List;
import java.util.Scanner;
import modelo.ListaJuegos;

/**
 *
 * @author Katherine Gomez
 */
public class ListController {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        ListaJuegos list = new ListaJuegos(0);
        ListDao listado = new ListDao(con);
        Scanner scan = new Scanner(System.in);
        int deci;
        do {
            System.out.println("Que desea hacer el dia de hoy? "
                    + "\n 1 - Introducir un nuevo Juego "
                    + "\n 2 - Mostrar todos los registros"
                    + "\n 0 - salir ");
            deci = scan.nextInt();

            switch (deci) {
                case 1:
                    System.out.println("Ingrese el nombre del Videojuego");
                    list.setNombre(scan.next());
                    System.out.println("Ingrese el genero del Videojuego");
                    list.setGenero(scan.next());
                    System.out.println("Ingrese la clasificacion del Videojuego "
                            + "\n Digite EC si es Juego de primera Infancia "
                            + "\n Digite E si el Juego es apto para todo publico"
                            + "\n Digite T si el Juego es dedicado a adolescentes"
                            + "\n Digite M si el juego es para edad madura +17"
                            + "\n Digite AO si el Juego es solo para adultos +18");
                    list.setClasificacion(scan.next().toUpperCase());
                    System.out.println("Ingrese una descripcion corta del Juego");
                    list.setDescripcion(scan.next());
                    System.out.println("Ingrese la fecha de lanzamiento del juego en formato yyyy-mm-dd");
                    list.setDate(scan.next());

                    boolean respuesta = listado.insertar(list);
                    if (respuesta) {
                        System.out.println("registro guaradado");
                    } else {
                        System.out.println("error al guardar");
                    }
                    break;
                case 2:
                    
                    List<ListaJuegos> lis = listado.consultarTodo();
                    for (ListaJuegos listar: lis) {
                        System.out.println("Juego con Id : " + listar.getId());
                        System.out.println("Juego con Nombre : " + listar.getNombre());
                        System.out.println("De genero : " + listar.getGenero());
                        System.out.println("Con clasificacion : " + listar.getClasificacion());
                        System.out.println("Descripcion del Juego : " + listar.getDescripcion());
                        System.out.println("Lanzado en la fecha de : " + listar.getDate()+"\n");

                    }
                    break;
                default:
                    break;
            }
        } while (deci != 0);

    }
}
