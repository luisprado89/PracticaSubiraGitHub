package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.AplicacionAutores;

public class VentanaCambiarTitulo extends JFrame implements ActionListener {
    // Componentes de la ventana
    private JPanel contentPane;
    private JLabel etiquetaNuevoTitulo;
    private JTextField textoNuevoTitulo;
    private JButton btnCambiarTitulo;
    private JButton btnCancelar;
    private AplicacionAutores app;  // Referencia a la lógica de la aplicación
    private String nombreAutor;  // Nombre del autor que quiere cambiar el título
    private String tituloActual; // Título actual del libro

    // Constructor que recibe la instancia de la aplicación, el nombre del autor y el título actual
    public VentanaCambiarTitulo(AplicacionAutores app, String nombreAutor, String tituloActual) {
        this.app = app;
        this.nombreAutor = nombreAutor;
        this.tituloActual = tituloActual; // Inicializa el título actual

        // Configuración de la ventana
        setTitle("Aplicación autores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 265, 188);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crea y configura la etiqueta que pide al usuario el nuevo título.
        etiquetaNuevoTitulo = new JLabel("Escribe el nuevo título del libro:");
        etiquetaNuevoTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
        etiquetaNuevoTitulo.setBounds(21, 22, 207, 14);
        contentPane.add(etiquetaNuevoTitulo);

        // Campo de texto para introducir el nuevo título
        textoNuevoTitulo = new JTextField();
        textoNuevoTitulo.setBounds(21, 58, 194, 20);
        contentPane.add(textoNuevoTitulo);
        textoNuevoTitulo.setColumns(10);

        // Botón para confirmar el cambio de título
        btnCambiarTitulo = new JButton("Cambiar");
        btnCambiarTitulo.setBounds(134, 111, 89, 23);
        btnCambiarTitulo.addActionListener(this);
        contentPane.add(btnCambiarTitulo);

        // Botón para cancelar la operación y cerrar la ventana
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(21, 111, 89, 23);
        btnCancelar.addActionListener(this);
        contentPane.add(btnCancelar);
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCambiarTitulo) { // Comprueba si el botón "Cambiar" fue presionado.
            // Obtener el nuevo título del texto introducido
            String nuevoTitulo = textoNuevoTitulo.getText().trim(); // .trim() elimina espacios en blanco

            if (!nuevoTitulo.isEmpty()) { // Validar que el nuevo título no esté vacío
                if (nuevoTitulo.equalsIgnoreCase(tituloActual)) { // Comparar el nuevo título con el título actual
                    JOptionPane.showMessageDialog(this, "El nuevo título no puede ser el mismo que el actual.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Llama al método para cambiar el título en AplicacionAutores
                    app.cambiarTituloLibro(nombreAutor, nuevoTitulo);
                    // Muestra un mensaje de éxito y cierra la ventana
                    JOptionPane.showMessageDialog(this, "Título cambiado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Cierra la ventana
                }
            } else {
                // Mostrar un mensaje de error si el título está vacío
                JOptionPane.showMessageDialog(this, "Por favor, introduce un título válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancelar) {
            // Si se presiona cancelar, simplemente cierra la ventana
            dispose(); // Cierra la ventana
        }
    }
}
