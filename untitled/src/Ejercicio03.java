/*
Ejercicio 3
Escribe un programa que muestre por pantalla 10 palabras en inglés junto a su
correspondiente traducción al castellano. Las palabras deben estar distribuidas en
dos columnas y alineadas a la izquierda.
Ejemplo:
Computer        ordenador
Student         alumno/a
Cat             gato
Penguin         pingüino.
Machine         máquina
Nature          naturaleza
Light           luz
Greee           verde
Book            libro
Pyramid         pirámide.
*/
public class Ejercicio03 {
    public static void main(String[] args) {
        System.out.println("Computer        ordenador");
        System.out.println("Student         alumno/a");
        System.out.println("Cat             gato");
        System.out.println("Penguin         pingüino.");
        System.out.println("Machine         máquina");
        System.out.println("Nature          naturaleza");
        System.out.println("Light           luz");
        System.out.println("Greee           verde");
        System.out.println("Book            libro");
        System.out.println("Pyramid         pirámide.");
        System.out.print("Diferencia entre usar");
        System.out.print("O usar \n");
        System.out.printf("%-10s %30s\n", "computer", "ordenador");
        System.out.printf("%-10s %s\n", "student", "alumno\\a");
        System.out.printf("%-10s %s\n", "cat", "gato");
        System.out.printf("%-10s %s\n", "penguin", "pingüino");
        System.out.printf("%-10s %s\n", "machine", "máquina");
        System.out.printf("%-10s %s\n", "nature", "naturaleza");
        System.out.printf("%-10s %s\n", "light", "luz");
        System.out.printf("%-10s %s\n", "green", "verde");
        System.out.printf("%-10s %s\n", "book", "libro");
        System.out.printf("%-10s %s\n", "pyramid", "pirámide");
        System.out.printf("Greee           verde\n");
        System.out.printf("Book\n            libro\n");
        System.out.printf("Pyramid         pirámide.");
    }
}
