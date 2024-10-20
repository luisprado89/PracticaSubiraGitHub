package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import model.AplicacionAutores;

public class VentanaMenuAutor extends JFrame implements ActionListener {
    // Componentes de la ventana
    private JPanel contentPane;
    private JLabel etiquetaMenuAutor;
    private JTextPane textoNombreAutor;
    private JButton btnVerDatos;
    private JButton btnCambiarTituloLibro;
    private JButton btnBorrarAutor;
    private JButton btnCerrarValidacion;
    private AplicacionAutores app;  // Referencia a la lógica de la aplicación
    private String nombreAutor;  // Nombre del autor
    // Constructor que recibe la instancia de la aplicación y el nombre del autor
    public VentanaMenuAutor(AplicacionAutores app, String nombreAutor) {
        this.app = app;
        this.nombreAutor = nombreAutor;
        // Configuración de la ventana
        setTitle("Aplicación autores");// Establece el título de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura la operación por defecto al cerrar la ventana.
        setBounds(100, 100, 325, 300);
        contentPane = new JPanel();// Crea un nuevo panel.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);// Establece el panel como el contenido de la ventana.
        contentPane.setLayout(null); // Configura el layout del panel como nulo para posicionar componentes manualmente.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setResizable(false);  // Evita que la ventana sea redimensionada
        // Crea y configura la etiqueta para el título "Menú del autor".
        etiquetaMenuAutor = new JLabel("Menú del autor:");
        etiquetaMenuAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
        etiquetaMenuAutor.setBounds(10, 24, 147, 14);
        contentPane.add(etiquetaMenuAutor); // Añade la etiqueta al panel.
        // Botón para ver los datos del autor
        btnVerDatos = new JButton("Ver datos");
        btnVerDatos.setBounds(71, 64, 163, 23);
        btnVerDatos.addActionListener(this); // Mantenemos solo esta línea
        contentPane.add(btnVerDatos);// Añade el botón al panel.
        // Botón para cambiar el título del libro
        btnCambiarTituloLibro = new JButton("Cambiar título del libro");
        btnCambiarTituloLibro.setBounds(71, 98, 163, 23);
        btnCambiarTituloLibro.addActionListener(this);
        contentPane.add(btnCambiarTituloLibro);
        // Botón para borrar al autor
        btnBorrarAutor = new JButton("Borrar autor");
        btnBorrarAutor.setBounds(71, 132, 163, 23);
        btnBorrarAutor.addActionListener(this);// Añade el listener de acción al botón.
        contentPane.add(btnBorrarAutor);// Añade el botón al panel.
        // Crea el botón para cerrar la validación.
        btnCerrarValidacion = new JButton("Cerrar validación");
        btnCerrarValidacion.setBounds(150, 227, 145, 23);
        btnCerrarValidacion.addActionListener(this);// Añade el listener de acción al botón.
        contentPane.add(btnCerrarValidacion);// Añade el botón al panel.
        // Crea el JTextPane para mostrar el nombre del autor.
        textoNombreAutor = new JTextPane(); // Asegúrate de que esta línea exista
        textoNombreAutor.setEditable(false); // Configura el JTextPane para que no sea editable.
        textoNombreAutor.setBounds(167, 24, 132, 20);
        textoNombreAutor.setText(nombreAutor);// Establece el texto del JTextPane al nombre del autor.
        contentPane.add(textoNombreAutor);// Añade el JTextPane al panel.
    }
    // Método que maneja los eventos de los botones.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el botón "Ver datos" fue presionado.
        if (e.getSource() == btnVerDatos) {
            app.mostrarVentanaVerDatos(nombreAutor);// Llama al método para mostrar los datos del autor.
        } else if (e.getSource() == btnCambiarTituloLibro) {// Comprueba si el botón "Cambiar título del libro" fue presionado.
            app.mostrarVentanaCambiarTitulo(nombreAutor);// Llama al método para cambiar el título del libro.
        } else if (e.getSource() == btnBorrarAutor) {// Comprueba si el botón "Borrar autor" fue presionado.
            app.mostrarVentanaBorrarAutor(nombreAutor);// Llama al método para mostrar la ventana de borrar autor.
        } else if (e.getSource() == btnCerrarValidacion) {// Comprueba si el botón "Cerrar validación" fue presionado.
            app.cerrarSesion();// Llama al método para cerrar la sesión.
            dispose(); // Cierra la ventana de menú
        }
    }
}
