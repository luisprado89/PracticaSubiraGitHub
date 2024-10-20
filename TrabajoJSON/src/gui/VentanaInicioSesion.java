package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import model.AplicacionAutores;

public class VentanaInicioSesion extends JFrame implements ActionListener {
    // Componentes de la ventana
    private JPanel contentPane;
    private JTextField textoAutor;
    private JTextField textoTitulo;
    private JButton btnValidar;
    private JButton btnCrearNuevoAutorLibro;
    private AplicacionAutores app;  // Referencia a la lógica de la aplicación

    // Constructor que recibe la instancia de la aplicación
    public VentanaInicioSesion(AplicacionAutores app) {
        this.app = app;
        // Configuración de la ventana
        setTitle("Aplicación autores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 507, 376);
        contentPane = new JPanel(); // Crea un nuevo panel.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane); // Establece el panel como el contenido de la ventana.
        contentPane.setLayout(null); // Configura el layout del panel como nulo para posicionar componentes manualmente.
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // Evita que la ventana sea redimensionada

        // Crea y configura la etiqueta para el título "Validación".
        JLabel etiquetaInicioSesion = new JLabel("Validación");
        etiquetaInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
        etiquetaInicioSesion.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto horizontalmente.
        etiquetaInicioSesion.setBounds(97, 26, 270, 44);
        contentPane.add(etiquetaInicioSesion); // Añade la etiqueta al panel.

        // Etiqueta para el nombre del autor
        JLabel etiquetaAutor = new JLabel("Nombre autor:");
        etiquetaAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaAutor.setBounds(160, 90, 80, 14);
        contentPane.add(etiquetaAutor); // Añade la etiqueta al panel.

        // Campo de texto para el nombre del autor
        textoAutor = new JTextField(); // Crea el campo de texto.
        textoAutor.setBounds(160, 115, 149, 20);
        ((PlainDocument) textoAutor.getDocument()).setDocumentFilter(new AuthorFilter()); // Aplicar filtro para solo texto
        contentPane.add(textoAutor); // Añade el campo de texto al panel.
        textoAutor.setColumns(10); // Establece el número de columnas del campo de texto.

        // Crea y configura la etiqueta para el título del libro.
        JLabel etiquetaContraseña = new JLabel("Título del libro:");
        etiquetaContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaContraseña.setBounds(160, 146, 149, 14);
        contentPane.add(etiquetaContraseña); // Añade la etiqueta al panel.

        // Crea el campo de texto para el título del libro.
        textoTitulo = new JTextField(); // Crea el campo de texto.
        textoTitulo.setColumns(10); // Establece el número de columnas del campo de texto.
        textoTitulo.setBounds(160, 171, 149, 20);
        ((PlainDocument) textoTitulo.getDocument()).setDocumentFilter(new TitleFilter()); // Aplicar filtro para título
        contentPane.add(textoTitulo); // Añade el campo de texto al panel.

        // Crea el botón para validar la información ingresada.
        btnValidar = new JButton("Validar"); // Crea el botón con el texto "Validar".
        btnValidar.setBounds(176, 215, 118, 23);
        btnValidar.addActionListener(this); // Añade el listener de acción al botón.
        contentPane.add(btnValidar); // Añade el botón al panel.

        // Crea el botón para crear un nuevo autor.
        btnCrearNuevoAutorLibro = new JButton("Crear nuevo autor"); // Crea el botón con el texto "Crear nuevo autor".
        btnCrearNuevoAutorLibro.setBounds(10, 303, 149, 23);
        btnCrearNuevoAutorLibro.addActionListener(this); // Añade el listener de acción al botón.
        contentPane.add(btnCrearNuevoAutorLibro); // Añade el botón al panel.
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnValidar) { // Comprueba si el botón "Validar" fue presionado.
            // Obtener los valores introducidos por el usuario
            String nombreAutor = textoAutor.getText(); // Obtiene el texto del campo de autor.
            String tituloLibro = textoTitulo.getText(); // Obtiene el texto del campo de título.

            // Validar el campo nombre autor para verificar que no contiene números
            if (nombreAutor.isEmpty() || !nombreAutor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "Error: El nombre del autor solo puede contener letras.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                return; // Detener el proceso si hay un error.
            }

            // Llamar al método para iniciar la validación en la clase AplicacionAutores
            app.iniciarValidacion(nombreAutor, tituloLibro); // Llama a la función de validación.
        } else if (e.getSource() == btnCrearNuevoAutorLibro) {
            // Llamar al método para mostrar la ventana de crear autor
            app.mostrarVentanaCrearAutor(); // Abre la ventana para crear un nuevo autor.
        }
    }

    // Filtro para permitir solo letras en el campo de texto del autor
    private class AuthorFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null) {
                if (string.matches(".*[0-9].*")) {
                    JOptionPane.showMessageDialog(VentanaInicioSesion.this, "Error: El nombre del autor solo puede contener letras.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    super.insertString(fb, offset, string, attr);
                }
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null) {
                if (text.matches(".*[0-9].*")) {
                    JOptionPane.showMessageDialog(VentanaInicioSesion.this, "Error: El nombre del autor solo puede contener letras.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }

    // Filtro para el título que permite letras y números, asegurándose de que comienza con una letra
    private class TitleFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null) {
                // Verificar si es el primer carácter
                if (offset == 0 && !string.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ].*")) {
                    JOptionPane.showMessageDialog(VentanaInicioSesion.this, "Error: El título debe comenzar con una letra.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    super.insertString(fb, offset, string, attr);
                }
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null) {
                // Verificar si es el primer carácter
                if (offset == 0 && !text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ].*")) {
                    JOptionPane.showMessageDialog(VentanaInicioSesion.this, "Error: El título debe comenzar con una letra.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }
}
