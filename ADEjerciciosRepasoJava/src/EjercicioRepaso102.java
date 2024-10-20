/*
Ejercicio Repaso 102

Realiza un programa en Java que pida por teclado el nombre y la edad de una persona mayor de edad (se debe validar el valor introducido) y responda indicando:

    Si no está jubilado (edad de jubilación = 65 años), cuántos años le quedan para jubilarse.
    Si ya está jubilada indicará cuántos años lleva jubilado.

 */

// Importamos la clase Scanner para poder leer la entrada del usuario desde la consola
import java.util.Scanner;

public class EjercicioRepaso102 {

    public static void main(String[] args) {

        // Creamos un objeto Scanner para leer la entrada de datos del usuario
        Scanner sc = new Scanner(System.in);

        // Solicitamos al usuario que introduzca su nombre
        System.out.println("Introduzca el nombre de la persona");
        // Leemos la entrada del usuario y la almacenamos en la variable 'nombre'
        String nombre = sc.nextLine();

        // Inicializamos la variable 'edad' con un valor de -1 para iniciar el ciclo de validación
        int edad = -1;

        // Bucle while que se ejecuta mientras la edad sea menor a 18 (para asegurar que el usuario sea mayor de edad)
        while(edad < 18) {
            // Solicitamos la edad de la persona
            System.out.println("Introduzca la edad");
            try {
                // Intentamos leer la edad como un número entero
                edad = sc.nextInt();

                // Validamos si la edad es menor a 18
                if (edad < 18)
                    // Si la edad es menor a 18, mostramos un mensaje diciendo que debe ser mayor de edad
                    System.out.println(nombre + " tiene que ser mayor de edad");

                    // Si la edad es mayor que 65, significa que la persona ya está jubilada
                else if(edad > 65)
                    // Calculamos cuántos años lleva jubilada la persona restando 65 a la edad actual
                    System.out.println(nombre + " lleva jubilada desde hace: " + Integer.toString(edad - 65) + " años");

                    // Si la edad es exactamente 65, significa que la persona se jubila este año
                else if(edad == 65)
                    System.out.println(nombre + " se jubila este año");

                    // Si la edad es menor a 65, calculamos cuántos años le quedan para jubilarse
                else
                    System.out.println(nombre + " se va a jubilar dentro de: " + Integer.toString(65 - edad) + " años");

            } catch (Exception e) {
                // Si ocurre un error al leer la edad (por ejemplo, si el usuario introduce un valor no numérico)
                // mostramos un mensaje de error
                System.out.println("Error en el valor introducido");
                // Limpiamos el buffer de entrada del scanner para evitar un bucle infinito
                sc.next(); // Esto limpia la entrada incorrecta
            }
        }
    }
}
