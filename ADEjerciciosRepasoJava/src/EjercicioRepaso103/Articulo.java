package EjercicioRepaso103;

public class Articulo {

    // Declaramos dos variables privadas: 'nombre' y 'precio' para almacenar el nombre y el precio del artículo
    private String nombre;
    private double precio;

    // Constructor que inicializa los atributos 'nombre' y 'precio' al crear un nuevo objeto Articulo
    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Sobrescribimos el método toString() para devolver una representación en cadena del artículo (nombre y precio)
    @Override
    public String toString() {
        return nombre + "\t" + precio;
    }

    // Método getter que devuelve el precio del artículo
    public double getPrecio() {
        return precio;
    }
}