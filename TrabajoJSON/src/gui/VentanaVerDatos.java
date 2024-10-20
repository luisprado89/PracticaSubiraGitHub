package gui;

import model.AplicacionAutores;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
// Constructor que recibe la instancia de la aplicación, el nombre del autor y la lista de libros.
public class VentanaVerDatos extends JFrame {
    // Componentes de la ventana
    private JPanel contentPane;
    private JLabel etiquetaDatosAutor;
    private JTextArea areaDatosAutor;
    private JButton btnVolver;
    private AplicacionAutores app;  // Referencia a la lógica de la aplicación

    public VentanaVerDatos(AplicacionAutores app, String nombreAutor, List<JSONObject> libros) {
        this.app = app;
        
        // Configuración de la ventana
        setTitle("Datos del Autor"); // Establece el título de la ventana.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Configura la operación por defecto al cerrar la ventana.
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();// Crea un nuevo panel.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);// Establece el panel como el contenido de la ventana.
        contentPane.setLayout(new BorderLayout()); // Configura el layout del panel como BorderLayout.
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);  // Evita que la ventana sea redimensionada
        // Crea y configura la etiqueta que muestra los datos del autor.
        etiquetaDatosAutor = new JLabel("Datos de " + nombreAutor);
        etiquetaDatosAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
        etiquetaDatosAutor.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente.
        contentPane.add(etiquetaDatosAutor, BorderLayout.NORTH);// Añade la etiqueta al panel en la parte norte.
        // Crea y configura el área de texto que mostrará los datos del autor.
        areaDatosAutor = new JTextArea();// Crea el área de texto.
        areaDatosAutor.setEditable(false);// Establece el área de texto como no editable.
        contentPane.add(new JScrollPane(areaDatosAutor), BorderLayout.CENTER);// Añade el área de texto al panel en el centro con un JScrollPane.
        // Crea y configura el botón "Volver".
        btnVolver = new JButton("Volver");// Crea el botón con el texto "Volver".
        btnVolver.addActionListener(e -> dispose());// Añade un listener de acción para cerrar la ventana al presionar el botón.
        contentPane.add(btnVolver, BorderLayout.SOUTH);// Añade el botón al panel en la parte sur.
        // Carga y muestra los datos del autor en el área de texto
        mostrarDatosAutor(libros);// Llama al método para mostrar los datos del autor.
    }
    // Método para cargar los datos del autor desde la aplicación
    private void mostrarDatosAutor(List<JSONObject> libros) {
        StringBuilder datos = new StringBuilder();
        // Itera sobre la lista de libros para construir la información del autor.
        for (JSONObject libro : libros) {
            datos.append("Título: ").append(libro.getString("titulo"))// Obtiene el título del libro.
                    .append("\nEditorial: ").append(libro.getString("editorial"))// Obtiene la editorial del libro.
                    .append("\nPáginas: ").append(libro.getString("paginas"))// Obtiene el número de páginas del libro.
                    .append("\n\n"); // Agregar separación entre libros
        }
        // Si no se encontraron libros, muestra un mensaje indicativo.
        if (datos.length() == 0) {
            datos.append("No se encontraron libros para este autor.");
        }
        // Establece el texto construido en el área de texto.
        areaDatosAutor.setText(datos.toString()); // Muestra los datos en el área de texto.
    }
}
