package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaUsuario extends JFrame {
    public VentanaUsuario(String usuario) {
        setTitle("Área de Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Permite cerrar la ventana sin cerrar el programa
        setLocationRelativeTo(null);
        setLayout(null);

        // Mensaje de bienvenida
        JLabel mensajeBienvenida = new JLabel("¡Bienvenido, " + usuario + "!");
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        mensajeBienvenida.setBounds(250, 20, 300, 40);
        add(mensajeBienvenida);

        // Panel de opciones (puedes expandirlo con más funcionalidades)
        JPanel panelOpciones = new JPanel();
        panelOpciones.setBackground(new Color(30, 30, 30));
        panelOpciones.setBounds(50, 80, 700, 400);
        panelOpciones.setLayout(null);

        JLabel tituloOpciones = new JLabel("Opciones Disponibles");
        tituloOpciones.setForeground(Color.WHITE);
        tituloOpciones.setFont(new Font("Arial", Font.BOLD, 18));
        tituloOpciones.setBounds(50, 20, 200, 30);
        panelOpciones.add(tituloOpciones);

        // Botón de cerrar sesión (puedes agregar más funciones en el futuro)
        JButton botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setBounds(300, 350, 150, 40);
        botonCerrarSesion.addActionListener(e -> dispose()); // Cierra la ventana actual
        panelOpciones.add(botonCerrarSesion);

        add(panelOpciones);
        setVisible(true);
    }
}