/*
Ejercicio Repaso 101

Realiza un programa en Java que usando una variable estática

String texto = “4;5;7;8;4”;
 */
public class EjercicioRepaso101 {

    // Declaramos una variable estática 'texto' que contiene una cadena de números separados por punto y coma
    static String texto = "4;5;7;8;4";

    public static void main(String[] args) {

        // Inicializamos una variable entera 'suma' que almacenará el resultado de la suma de los números
        int suma = 0;

        // Usamos el método split() para separar la cadena 'texto' por el carácter ';'
        // Esto devuelve un arreglo de Strings que contiene los números en formato de texto
        String[] separados = texto.split(";");

        // Usamos un bucle for-each para recorrer cada elemento del arreglo 'separados'
        for (String separado : separados) {
            // Convertimos cada cadena de texto a un número entero usando Integer.parseInt()
            // y lo sumamos a la variable 'suma'
            suma += Integer.parseInt(separado);
        }

        // Imprimimos el resultado total de la suma de los números
        System.out.println("El total es: " + suma);
    }
}
