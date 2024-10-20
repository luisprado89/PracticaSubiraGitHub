package EjercicioRepaso103;
/*
Ejercicio Repaso 103

Realiza un programa en Java que gestione la compra de los productos de un supermercado.

El programa solicitará el nombre del producto y su precio en bucle.

Después de de introducir estos datos, preguntará si deseamos continuar introduciendo más productos. Las posibles respuestas serán SI para seguir en el bucle y NO para salir.

Al terminar, mostrará el importe total de la compra y cuántos productos hemos comprado.
 */

// Importamos las clases necesarias: ArrayList para manejar la lista de artículos y Scanner para la entrada de datos
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio103 {

    public static void main(String[] args) {

        // Creamos un objeto Scanner para leer la entrada de datos del usuario
        Scanner sc = new Scanner(System.in);

        // Inicializamos la variable 'opcion' con "SI" para que el bucle comience
        String opcion = "SI";

        // Creamos una lista de objetos de tipo Articulo donde almacenaremos los productos comprados
        ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

        // Mientras la opción introducida no sea "NO", seguimos solicitando productos
        while(!opcion.toUpperCase().equals("NO")) {

            // Solicitamos el nombre del artículo al usuario
            System.out.println("Introduzca el nombre del articulo");
            String nombre = sc.next();

            // Solicitamos el precio del artículo
            System.out.println("Introduzca el precio del articulo");
            double precio = sc.nextDouble();

            // Añadimos un nuevo objeto Articulo a la lista con el nombre y el precio introducidos
            listaArticulos.add(new Articulo(nombre, precio));

            // Pedimos al usuario si desea seguir introduciendo productos
            // Esto continuará pidiendo un valor hasta que el usuario escriba "SI" o "NO"
            do {
                System.out.println("Deseas seguir introduciendo valores? Posibles valores si/no");
                opcion = sc.next();
            } while(!opcion.toUpperCase().equals("SI") && !opcion.toUpperCase().equals("NO"));
        }

        // Al salir del bucle, mostramos el número total de productos comprados
        System.out.println("Total de productos: " + Integer.toString(listaArticulos.size()));

        // Inicializamos una variable 'suma' para almacenar el importe total de la compra
        double suma = 0.0;

        // Recorremos la lista de artículos y sumamos sus precios
        for(Articulo articulo : listaArticulos) {
            // Mostramos el nombre y el precio de cada artículo
            System.out.println(articulo.toString());
            // Sumamos el precio del artículo al total
            suma += articulo.getPrecio();
        }

        // Mostramos el importe total de la compra
        System.out.println("\nTotal: " + suma);
    }
}

