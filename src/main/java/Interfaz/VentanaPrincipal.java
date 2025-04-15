package Interfaz;

import Controlador.ControladorLogin;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Tienda de Juegos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Imagen de fondo
        JLabel fondo = new JLabel(new ImageIcon("C:/Users/Asus tuf a16/Documents/F/sis2/SIS 2/LOGO DEL SISTEMA/Logo.jpg"));
        fondo.setBounds(0, 0, 800, 600);
        add(fondo);

        // Panel transparente para los elementos principales
        JPanel panelBase = new JPanel();
        panelBase.setOpaque(false);
        panelBase.setLayout(null);
        panelBase.setBounds(0, 0, 800, 600);

        // Panel lateral de categorias
        JPanel panelCategorias = new JPanel();
        panelCategorias.setBackground(new Color(30, 30, 30));
        panelCategorias.setLayout(null);
        panelCategorias.setBounds(0, 0, 200, 600);

        JLabel tituloCategorias = new JLabel("Categorías");
        tituloCategorias.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCategorias.setForeground(Color.WHITE);
        tituloCategorias.setBounds(50, 20, 100, 30);
        panelCategorias.add(tituloCategorias);

        String[] categorias = {"Acción", "Aventura", "Deportes", "Simulación", "Estrategia"};
        int yPosition = 70;
        for (String categoria : categorias) {
            JButton botonCategoria = new JButton(categoria);
            botonCategoria.setBounds(20, yPosition, 160, 30);
            panelCategorias.add(botonCategoria);
            yPosition += 40;
        }
        panelBase.add(panelCategorias);

        // Botón de "Iniciar Sesión"
        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setBounds(250, 500, 150, 40);
        botonIniciarSesion.addActionListener(e -> abrirVentanaLogin()); // Acción para abrir la ventana de login
        panelBase.add(botonIniciarSesion);

        // Título principal
        JLabel titulo = new JLabel("Bienvenido a la Tienda de Juegos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(250, 20, 400, 40);
        panelBase.add(titulo);

        fondo.setLayout(null);
        fondo.add(panelBase);

        setVisible(true);
    }
    // Método para abrir la ventana de inicio de sesión

    
    // para abrir ventana de login
    private void abrirVentanaLogin() {
    JFrame loginFrame = new JFrame("Iniciar Sesión");
    loginFrame.setSize(400, 300);
    loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setLayout(null);

    JLabel usuarioLabel = new JLabel("Usuario:");
    usuarioLabel.setBounds(50, 50, 100, 30);
    JTextField usuarioField = new JTextField();
    usuarioField.setBounds(150, 50, 200, 30);

    JLabel contraseñaLabel = new JLabel("Contraseña:");
    contraseñaLabel.setBounds(50, 100, 100, 30);
    JPasswordField contraseñaField = new JPasswordField();
    contraseñaField.setBounds(150, 100, 200, 30);

    JButton botonLogin = new JButton("Confirmar");
    botonLogin.setBounds(150, 170, 100, 30);

    // Acción al presionar el botón
    botonLogin.addActionListener(e -> {
        String usuario = usuarioField.getText();
        String contraseña = new String(contraseñaField.getPassword());

        ControladorLogin controlador = new ControladorLogin();
        if (controlador.validarCredenciales(usuario, contraseña)) {
            loginFrame.dispose(); // Cierra la ventana de login
            new VentanaUsuario(usuario); // Abre la ventana de usuario registrado
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

    loginFrame.add(usuarioLabel);
    loginFrame.add(usuarioField);
    loginFrame.add(contraseñaLabel);
    loginFrame.add(contraseñaField);
    loginFrame.add(botonLogin);

    loginFrame.setVisible(true);
}
    //hola
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}