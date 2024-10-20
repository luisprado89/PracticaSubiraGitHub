package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar mensajes de alerta
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument; // Importa la clase AbstractDocument para manipular documentos de texto.import javax.swing.text.AttributeSet;
import javax.swing.text.AttributeSet; // Importa la clase AttributeSet para definir atributos de texto.
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter; // Importa la clase DocumentFilter para filtrar la entrada en campos de texto.

import model.AplicacionAutores;

public class VentanaCrearAutor extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel etiquetaCrearAutor;
    private JLabel etiquetaAutor;
    private JLabel etiquetaTituloLibro;
    private JLabel etiquetaPaginas;
    private JLabel etiquetaEditorial;
    private JTextField textoNombreAutor;
    private JTextField textoTituloLibro;
    private JTextField textoPaginas;
    private JTextField textoEditorial;
    private JButton btnCrear;
    private JButton btnCancelar;
    private AplicacionAutores app;
    // Constructor de la clase VentanaCrearAutor que recibe una instancia de AplicacionAutores.
    public VentanaCrearAutor(AplicacionAutores app) {
        this.app = app;
        setTitle("Aplicación autores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 322, 385);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane); // Establece el panel como el contenido de la ventana.
        contentPane.setLayout(null); // Configura el layout del panel como nulo para posicionar componentes manualmente.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        setResizable(false); // Impide que la ventana sea redimensionable.
        // Crea y configura la etiqueta para el nombre del autor.
        etiquetaAutor = new JLabel("Nombre autor:");
        etiquetaAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaAutor.setBounds(65, 56, 120, 14);
        contentPane.add(etiquetaAutor); // Añade la etiqueta al panel.
        // Crea y configura la etiqueta para el título "CREAR AUTOR".
        etiquetaCrearAutor = new JLabel("CREAR AUTOR");
        etiquetaCrearAutor.setBounds(83, 11, 154, 20);
        etiquetaCrearAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(etiquetaCrearAutor); // Añade la etiqueta al panel.
        // Crea el campo de texto para el nombre del autor.
        textoNombreAutor = new JTextField();
        textoNombreAutor.setBounds(65, 81, 214, 20);
        ((AbstractDocument) textoNombreAutor.getDocument()).setDocumentFilter(new TextOnlyDocumentFilter());  // Aplica el filtro para permitir solo letras y espacios.
        contentPane.add(textoNombreAutor);
        textoNombreAutor.setColumns(10);
        // Crea y configura la etiqueta para el título del libro.
        etiquetaTituloLibro = new JLabel("Título libro:");
        etiquetaTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaTituloLibro.setBounds(65, 112, 68, 14);
        contentPane.add(etiquetaTituloLibro);
        // Crea el campo de texto para el título del libro.
        textoTituloLibro = new JTextField();
        textoTituloLibro.setColumns(10);
        textoTituloLibro.setBounds(65, 137, 214, 20);
        ((AbstractDocument) textoTituloLibro.getDocument()).setDocumentFilter(new TitleDocumentFilter());
        contentPane.add(textoTituloLibro); // Añade la etiqueta al panel.
        // Crea el campo de texto para el número de páginas.
        etiquetaPaginas = new JLabel("Número de páginas:");
        etiquetaPaginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaPaginas.setBounds(65, 168, 120, 14);
        contentPane.add(etiquetaPaginas);// Añade el campo de texto al panel.

        textoPaginas = new JTextField();
        textoPaginas.setColumns(10);
        textoPaginas.setBounds(65, 193, 214, 20);
        ((AbstractDocument) textoPaginas.getDocument()).setDocumentFilter(new PositiveNumberDocumentFilter());  // Aplica el filtro para permitir solo números.
        contentPane.add(textoPaginas); // Añade el campo de texto al panel.

        // Crea y configura la etiqueta para la editorial.
        etiquetaEditorial = new JLabel("Editorial:");
        etiquetaEditorial.setFont(new Font("Tahoma", Font.PLAIN, 12));
        etiquetaEditorial.setBounds(65, 224, 214, 14);
        contentPane.add(etiquetaEditorial); // Añade la etiqueta al panel.
        // Crea el campo de texto para la editorial.
        textoEditorial = new JTextField();
        textoEditorial.setColumns(10);
        textoEditorial.setBounds(65, 249, 214, 20);
        contentPane.add(textoEditorial); // Añade el campo de texto al panel.
        // Crea el botón para crear un autor.
        btnCrear = new JButton("Crear");
        btnCrear.setBounds(172, 299, 89, 23);
        btnCrear.addActionListener(this);
        contentPane.add(btnCrear); // Añade el botón al panel.
        // Crea el botón para cancelar la creación del autor.
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(39, 299, 89, 23);
        btnCancelar.addActionListener(this);
        contentPane.add(btnCancelar); // Añade el botón al panel.
    }
    // Método que maneja los eventos de acción de los botones.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el botón "Crear" fue presionado.
        if (e.getSource() == btnCrear) {
            // Recoge los datos del formulario
            String nombre = textoNombreAutor.getText().trim(); // Obtiene el texto del campo de nombre del autor. trim() elimina espacios en blanco al principio y al final de los textos de los campos.
            String titulo = textoTituloLibro.getText().trim(); // Obtiene el texto del campo de título del libro.
            String paginas = textoPaginas.getText().trim(); // Obtiene el texto del campo de páginas.
            String editorial = textoEditorial.getText().trim(); // Obtiene el texto del campo de la editorial.
            // Validar que ninguno de los campos esté vacío
            if (nombre.isEmpty() || titulo.isEmpty() || paginas.isEmpty() || editorial.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error
            }
            // Llama al método de la aplicación para crear el autor.
            app.crearAutor(nombre, titulo, paginas, editorial);
            // Muestra un mensaje de éxito (opcional)
            JOptionPane.showMessageDialog(this, "Autor creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Cierra la ventana después de crear el autor.
            dispose(); // Libera la ventana de recursos.
            // Comprueba si el botón "Cancelar" fue presionado.
        } else if (e.getSource() == btnCancelar) {
            // Cerrar la ventana sin hacer nada
            dispose(); // Libera la ventana de recursos.
        }
    }

    // Clase interna para filtrar la entrada y permitir solo números
    private static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            // Permite solo dígitos al insertar texto
            if (string != null && string.matches("\\d*")) { // Comprueba si el texto es numérico.
                super.insertString(fb, offset, string, attr); // Llama al método padre para insertar.
            } else {
                // Muestra un mensaje de error si se intenta insertar un valor no válido
                JOptionPane.showMessageDialog(null, "Solo se permiten números enteros positivos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            // Permite solo dígitos al reemplazar texto
            if (text != null && text.matches("\\d*")) { // Comprueba si el texto es numérico.
                super.replace(fb, offset, length, text, attrs); // Llama al método padre para reemplazar.
            }else {
                // Muestra un mensaje de error si se intenta reemplazar con un valor no válido
                JOptionPane.showMessageDialog(null, "Solo se permiten números enteros positivos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length); // Llama al método padre para eliminar texto.
        }
    }

    // Clase interna para filtrar la entrada y permitir solo letras
    private static class TextOnlyDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) { // Permite solo letras y espacios.
                // Verifica que el primer carácter no sea un espacio si el offset es 0
                if (offset == 0 && string.startsWith(" ")) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con un espacio en blanco.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Sale del método sin insertar
                }
                super.insertString(fb, offset, string, attr);
            } else {
                // Muestra un mensaje de error si se intenta insertar un valor no válido
                JOptionPane.showMessageDialog(null, "Solo se permite introducir texto (letras y espacios).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) { // Permite solo letras y espacios.
                // Verifica que el primer carácter no sea un espacio si el offset es 0
                if (offset == 0 && text.startsWith(" ")) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con un espacio en blanco.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Sale del método sin reemplazar
                }
                super.replace(fb, offset, length, text, attrs);
            } else {
                // Muestra un mensaje de error si se intenta reemplazar con un valor no válido
                JOptionPane.showMessageDialog(null, "Solo se permite introducir texto (letras y espacios).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length); // Llama al método padre para eliminar texto.
        }
    }

    // Clase interna para filtrar el título del libro
    private static class TitleDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null) {
                // Permitir letras, espacios y caracteres especiales (como acentos)
                if (string.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9\\s]+")) {
                    if (offset == 0 && (string.startsWith(" ") || Character.isDigit(string.charAt(0)))) {
                        JOptionPane.showMessageDialog(null, "El título no puede comenzar con un espacio ni con un número.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir sin insertar
                    }
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Solo se permite introducir texto (letras, números y espacios).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null) {
                // Permitir letras, espacios y caracteres especiales (como acentos)
                if (text.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9\\s]+")) {
                    if (offset == 0 && (text.startsWith(" ") || Character.isDigit(text.charAt(0)))) {
                        JOptionPane.showMessageDialog(null, "El título no puede comenzar con un espacio ni con un número.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir sin reemplazar
                    }
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Solo se permite introducir texto (letras, números y espacios).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }

    // Clase interna para filtrar el número de páginas
    private static class PositiveNumberDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null) {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + string + currentText.substring(offset);

                if (newText.matches("\\d+") && !newText.startsWith("0") && Integer.parseInt(newText) > 0) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "El número de páginas debe ser mayor que 0 y no puede empezar con 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null) {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

                if (newText.matches("\\d+") && !newText.startsWith("0") && Integer.parseInt(newText) > 0) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "El número de páginas debe ser mayor que 0 y no puede empezar con 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }

}//final de la clase VentanaCrearAutor
