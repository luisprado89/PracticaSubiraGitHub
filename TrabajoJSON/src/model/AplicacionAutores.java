package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import gui.VentanaBorrarAutor;
import gui.VentanaCambiarTitulo;
import gui.VentanaCrearAutor;
import gui.VentanaInicioSesion;
import gui.VentanaMenuAutor;
import gui.VentanaVerDatos;

public class AplicacionAutores {

    private final String RUTA_FICHERO = "autores.json";// Ruta del archivo JSON donde se almacenan los autores.
    // Declaración de ventanas de la GUI.
    private VentanaInicioSesion ventanaInicioSesion;
    private VentanaCrearAutor ventanaCrearAutor;
    private VentanaMenuAutor ventanaMenuAutor;
    private VentanaVerDatos ventanaVerDatos;
    private VentanaCambiarTitulo ventanaCambiarTitulo;
    private VentanaBorrarAutor ventanaBorrarAutor;

    private void crearFicheroJson()	{
        File archivo = new File(RUTA_FICHERO);// Crea un objeto File con la ruta del archivo.
        if (!archivo.exists()) { // Comprueba si el archivo no existe.
            try (FileWriter file = new FileWriter(RUTA_FICHERO)) { // Intenta crear y abrir el archivo para escritura.
                // Crear un archivo JSON vacío (un array de autores vacío)
                JSONArray autores = new JSONArray();
                file.write(autores.toString(4)); // Escribe el array vacío en el archivo con indentación de 4 espacios.
                file.flush();// Asegura que todos los datos se escriban en el archivo.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//final crearFicheroJson

    // Método privado para obtener el array de autores desde el archivo JSON.
    private void guardarFicheroJson(JSONArray autores) {
        // Método para guardar el array de autores en el archivo JSON
        try (FileWriter file = new FileWriter(RUTA_FICHERO)) {// Intenta abrir el archivo para escritura.
            file.write(autores.toString(4)); // Guardar con indentación de 4 espacios
            file.flush();// Asegura que todos los datos se escriban en el archivo.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método privado para obtener el array de autores desde el archivo JSON.
	private JSONArray obtenerAutoresJson() {
	  File archivo = new File(RUTA_FICHERO);// Crea un objeto File con la ruta del archivo.
            if (!archivo.exists()) { // Si el archivo no existe, se crea un array vacío
        return new JSONArray();// retorna un array vacío.
    }

        try (FileReader reader = new FileReader(archivo)) {// Intenta abrir el archivo para lectura.
        JSONTokener tokener = new JSONTokener(reader);// Crea un JSONTokener para analizar el contenido.
        return new JSONArray(tokener);// Devuelve el array JSON leído del archivo.
    } catch (IOException e) {
        e.printStackTrace();
        return new JSONArray();
        }
	}
//
//	private int obtenerPosicionAutor(String nombreAutor, JSONArray autores){
//		// TODO
//	}

// Método privado para obtener un autor por su nombre.
private JSONObject obtenerAutorPorNombre(String nombreAutor) {
    // Obtener el array de autores desde el archivo JSON
    JSONArray autoresArray = obtenerAutoresJson();

    // Buscar el autor en el array
    for (int i = 0; i < autoresArray.length(); i++) {
        JSONObject autorJson = autoresArray.getJSONObject(i);// Obtiene el objeto JSON del autor.
        String nombre = autorJson.getString("nombre");// Obtiene el nombre del autor.

        // Comparar si el nombre del autor coincide
        if (nombreAutor.equalsIgnoreCase(nombre)) {
            return autorJson; // Si coincide, devolver el objeto JSON del autor
        }
    }
    return null; // Si no se encuentra el autor, devolver null
}//Final obtenerAutoresJson


    // Método público para ejecutar la aplicación.
    public void ejecutar(){
                // Crear una instancia de la ventana de inicio de sesión
        ventanaInicioSesion = new VentanaInicioSesion(this);
        // Mostrar la ventana
        ventanaInicioSesion.setVisible(true); // Muestra la ventana de inicio de sesión.
    }

    // Método público para validar la sesión del autor.
    public void iniciarValidacion(String nombreAutor, String tituloLibroAutor){
        // Obtener la lista de autores del archivo JSON
        JSONArray autores = obtenerAutoresJson();

        // Buscar si el autor existe en el archivo JSON
        boolean autorEncontrado = false; // Inicializa el flag de autor encontrado.
        for (int i = 0; i < autores.length(); i++) { // Itera sobre el array de autores.
            JSONObject autor = autores.getJSONObject(i);// Obtiene el objeto JSON del autor.
            String nombre = autor.getString("nombre");// Obtiene el nombre del autor.
            String titulo = autor.getString("titulo"); // Obtiene el título del libro del autor.

            // Comparar si el nombre y el título coinciden
            if (nombre.equalsIgnoreCase(nombreAutor) && titulo.equalsIgnoreCase(tituloLibroAutor)) {
                autorEncontrado = true; // Marca que el autor ha sido encontrado.
                break; // Sale del bucle.
            }
        }

        // Si se encuentra el autor, mostrar el menú del autor
        if (autorEncontrado) {
            mostrarMenuAutor(nombreAutor); // Mostrar menú del autor
        } else {
            // Si no se encuentra el autor, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Autor o título incorrectos", "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cerrarSesion(){
        // TODO
    }

    // Método público para crear un nuevo autor.
    public void crearAutor(String nombre, String titulo, String paginas, String editorial){
        // Crear un nuevo objeto JSON para el autor
        JSONObject nuevoAutor = new JSONObject(); // Crea un nuevo objeto JSON.
        nuevoAutor.put("nombre", nombre); // Añade el nombre del autor.
        nuevoAutor.put("titulo", titulo); // Añade el título del libro.
        nuevoAutor.put("paginas", paginas); // Añade el número de páginas.
        nuevoAutor.put("editorial", editorial); // Añade la editorial.

        // Leer el archivo JSON existente
        JSONArray autores = obtenerAutoresJson();// Obtiene la lista actual de autores.

        // Añadir el nuevo autor al array
        autores.put(nuevoAutor); // Añade el nuevo autor al array de autores.

        // Guardar los cambios en el archivo JSON
        guardarFicheroJson(autores); // Guarda el array actualizado en el archivo JSON.
    }

    // Método público para cambiar el título de un libro de un autor.
    public void cambiarTituloLibro(String nombreAutor, String nuevoTitulo) {
        // Obtener la lista de autores del archivo JSON
        JSONArray autores = obtenerAutoresJson();

        // Buscar el autor y cambiar su título
        for (int i = 0; i < autores.length(); i++) { // Itera sobre el array de autores.
            JSONObject autor = autores.getJSONObject(i); // Obtiene el objeto JSON del autor.
            if (autor.getString("nombre").equalsIgnoreCase(nombreAutor)) { // Verifica si el nombre coincide.
                autor.put("titulo", nuevoTitulo); // Cambia el título del libro.
                break; // Sale del bucle.
            }
        }

        // Guardar los cambios en el archivo JSON
        guardarFicheroJson(autores); // Guarda el array actualizado en el archivo JSON.
    }

    // Método público para borrar un autor.
    public void borrarAutor(String nombreAutor){
        // Paso 1: Leer el archivo JSON
        JSONArray autores = obtenerAutoresJson(); // Obtiene la lista de autores.

        // Paso 2: Buscar el autor y eliminarlo
        for (int i = 0; i < autores.length(); i++) { // Itera sobre el array de autores.
            JSONObject autor = autores.getJSONObject(i); // Obtiene el objeto JSON del autor.
            if (autor.getString("nombre").equalsIgnoreCase(nombreAutor)) { // Verifica si el nombre coincide.
                // Autor encontrado, proceder a eliminarlo
                autores.remove(i); // Elimina el autor del array.
                break; // Sale del bucle.
            }
        }

        // Paso 3: Guardar los cambios en el archivo JSON
        guardarFicheroJson(autores); // Guarda el array actualizado en el archivo JSON.
    }//final borrarAutor

    // Método público para obtener los libros de un autor.
    public List<JSONObject> obtenerLibrosPorAutor(String nombreAutor) {
        List<JSONObject> librosDelAutor = new ArrayList<>(); // Crea una lista para almacenar los libros del autor.
        // Obtener el array de autores
        JSONArray autoresArray = obtenerAutoresJson(); // Obtiene la lista de autores.

        // Buscar libros del autor en el array
        for (int i = 0; i < autoresArray.length(); i++) { // Itera sobre el array de autores.
            JSONObject autorJson = autoresArray.getJSONObject(i); // Obtiene el objeto JSON del autor.
            String nombre = autorJson.getString("nombre"); // Obtiene el nombre del autor.

            // Comparar si el nombre del autor coincide
            if (nombreAutor.equalsIgnoreCase(nombre)) {
                // Si coincide, añadir a la lista de libros del autor
                librosDelAutor.add(autorJson);  // Añade el JSON del autor a la lista.
            }
        }
        return librosDelAutor; // Devolver la lista de libros del autor
    }

    // Método público para mostrar la ventana de crear autor.
    public void mostrarVentanaCrearAutor(){
        // Crear una instancia de la ventana VentanaCrearAutor, pasándole el objeto de la aplicación.
        VentanaCrearAutor ventanaCrearAutor = new VentanaCrearAutor(this);// Crea la ventana para crear un autor.
        ventanaCrearAutor.setVisible(true); // Muestra la ventana.
    }

    // Método público para mostrar la ventana de ver datos de un autor.
    public void mostrarVentanaVerDatos(String nombreAutor){
        // Obtener todos los libros del autor
        List<JSONObject> libros = obtenerLibrosPorAutor(nombreAutor); // Obtiene los libros del autor.

        if (!libros.isEmpty()) { // Comprueba si hay libros para mostrar.
            // Crear una instancia de VentanaVerDatos y pasarle la lista de libros
            VentanaVerDatos ventanaVerDatos = new VentanaVerDatos(this, nombreAutor, libros); // Crea la ventana para ver datos del autor.
            ventanaVerDatos.setVisible(true); // Muestra la ventana.
        } else {
            System.out.println("Autor no encontrado o sin libros."); // Mensaje si no se encuentra el autor.
            // Aquí podrías mostrar un mensaje de error si es necesario
        }
    }

    // Método público para mostrar la ventana de cambiar título de un libro.
    public void mostrarVentanaCambiarTitulo(String nombreAutor) {
        // Obtener el autor por su nombre para obtener el título actual
        JSONObject autorJson = obtenerAutorPorNombre(nombreAutor);

        if (autorJson != null) {
            String tituloActual = autorJson.getString("titulo"); // Obtiene el título actual del autor
            VentanaCambiarTitulo ventanaCambiarTitulo = new VentanaCambiarTitulo(this, nombreAutor, tituloActual); // Crea la ventana para cambiar el título.
            ventanaCambiarTitulo.setVisible(true); // Muestra la ventana.
        } else {
            JOptionPane.showMessageDialog(null, "Autor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Método público para mostrar la ventana de borrar autor.
    public void mostrarVentanaBorrarAutor(String nombreAutor){
        // Crear una instancia de la ventana VentanaBorrarAutor, pasándole el nombre del autor
        VentanaBorrarAutor ventanaBorrarAutor = new VentanaBorrarAutor(this, nombreAutor); // Crea la ventana para borrar un autor.

        // Mostrar la ventana
        ventanaBorrarAutor.setVisible(true); // Muestra la ventana.
    }

    // Método público para mostrar el menú del autor.
    public void mostrarMenuAutor(String nombreAutor){
        // TODO
        // Crear una instancia de la ventana VentanaMenuAutor, pasándole el nombre del autor
        VentanaMenuAutor ventanaMenuAutor = new VentanaMenuAutor(this, nombreAutor); // Crea el menú del autor.

        // Mostrar la ventana
        ventanaMenuAutor.setVisible(true); // Muestra la ventana.
    }

}
