package Interfaz;

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
    // HOLA
      // COMO ESTAS
        // RESPONDE
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}