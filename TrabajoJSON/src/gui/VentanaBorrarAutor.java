package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AplicacionAutores;

public class VentanaBorrarAutor extends JFrame implements ActionListener {
    // Componentes de la ventana
    private JPanel contentPane;
    private JLabel etiquetaBorrarAutor;
    private JButton btnBorrar;
    private JButton btnCancelar;
    private AplicacionAutores app;  // Referencia a la lógica de la aplicación
    private String nombreAutor;  // Nombre del autor que se quiere borrar

    // Constructor que recibe la instancia de la aplicación y el nombre del autor
    public VentanaBorrarAutor(AplicacionAutores app, String nombreAutor) {
        this.app = app;
        this.nombreAutor = nombreAutor;
        // Configuración de la ventana
        setTitle("Aplicación autores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 316, 147);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);  // Evita que la ventana sea redimensionada
        // Etiqueta que pregunta si se quiere borrar al autor
        etiquetaBorrarAutor = new JLabel("¿Está seguro de que quiere borrar este autor?");
        etiquetaBorrarAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
        etiquetaBorrarAutor.setBounds(10, 11, 296, 34);
        contentPane.add(etiquetaBorrarAutor);
        // Botón para confirmar el borrado
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(170, 56, 89, 23);
        btnBorrar.addActionListener(this);
        contentPane.add(btnBorrar);
        // Botón para cancelar y cerrar la ventana
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(35, 56, 89, 23);
        btnCancelar.addActionListener(this);
        contentPane.add(btnCancelar);
    }
    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
        if (e.getSource() == btnBorrar) {
            // Llama al método para borrar el autor en AplicacionAutores
            app.borrarAutor(nombreAutor);
            // Cierra la ventana de confirmación
            dispose(); // Cierra la ventana
        } else if (e.getSource() == btnCancelar) {
            // Si se presiona cancelar, simplemente cierra la ventana
            dispose(); // Cierra la ventana
        }
    }

}
