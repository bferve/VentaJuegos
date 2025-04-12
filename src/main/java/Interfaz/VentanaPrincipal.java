package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Tienda de Juegos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear barra de tareas (JMenuBar)
        JMenuBar barraMenu = new JMenuBar();
        
        // Menú "Inicio"
        JMenu menuInicio = new JMenu("Inicio");
        JMenuItem opcionHome = new JMenuItem("Página Principal");
        menuInicio.add(opcionHome);
        
        // Menú "Categorías"
        JMenu menuCategorias = new JMenu("Categorías");
        JMenuItem opcionAccion = new JMenuItem("Acción");
        JMenuItem opcionAventura = new JMenuItem("Aventura");
        JMenuItem opcionDeportes = new JMenuItem("Deportes");
        menuCategorias.add(opcionAccion);
        menuCategorias.add(opcionAventura);
        menuCategorias.add(opcionDeportes);
        
        // Menú "Ayuda"
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem opcionContacto = new JMenuItem("Contacto");
        JMenuItem opcionFAQ = new JMenuItem("Preguntas Frecuentes");
        menuAyuda.add(opcionContacto);
        menuAyuda.add(opcionFAQ);
        
        // Agregar menús a la barra
        barraMenu.add(menuInicio);
        barraMenu.add(menuCategorias);
        barraMenu.add(menuAyuda);
        
        // Establecer la barra de tareas en la ventana
        setJMenuBar(barraMenu);

        // Panel base con fondo gris oscuro
        JPanel panelBase = new JPanel();
        panelBase.setBackground(new Color(50, 50, 50));
        panelBase.setLayout(null);

        // Título principal
        JLabel titulo = new JLabel("Bienvenido a la Tienda de Juegos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(200, 20, 400, 40);
        panelBase.add(titulo);

        // Botón de ejemplo
        JButton botonExplorar = new JButton("Explorar Juegos");
        botonExplorar.setBounds(300, 100, 200, 40);
        panelBase.add(botonExplorar);

        add(panelBase);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}