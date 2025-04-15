package Interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaUsuario extends JFrame {
    private ArrayList<String> carrito; // Lista de juegos en el carrito
    private ArrayList<Integer> precios; // Lista de precios asociados a los juegos
    private JLabel precioTotalLabel; // Etiqueta para mostrar el precio total

    public VentanaUsuario(String usuario) {
        carrito = new ArrayList<>();
        precios = new ArrayList<>();

        setTitle("Área de Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Mensaje de bienvenida
        JLabel mensajeBienvenida = new JLabel("¡Bienvenido, " + usuario + "!");
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        mensajeBienvenida.setBounds(250, 20, 300, 40);
        add(mensajeBienvenida);

        // Panel para la lista de juegos
        JPanel panelJuegos = new JPanel();
        panelJuegos.setBackground(new Color(30, 30, 30));
        panelJuegos.setBounds(50, 80, 350, 400);
        panelJuegos.setLayout(null);

        JLabel tituloJuegos = new JLabel("Juegos Disponibles");
        tituloJuegos.setForeground(Color.WHITE);
        tituloJuegos.setFont(new Font("Arial", Font.BOLD, 18));
        tituloJuegos.setBounds(20, 10, 200, 30);
        panelJuegos.add(tituloJuegos);

        // Tabla para mostrar los juegos
        String[] columnas = {"Juego", "Precio", "Acción"};
        String[][] datos = {
            {"Juego 1", "10", "Agregar al Carrito"},
            {"Juego 2", "15", "Agregar al Carrito"},
            {"Juego 3", "20", "Agregar al Carrito"}
        };

        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
        JTable tablaJuegos = new JTable(modeloTabla) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // Solo la columna "Acción" es editable
            }
        };

        tablaJuegos.setBounds(20, 50, 310, 300);
        JScrollPane scrollPane = new JScrollPane(tablaJuegos);
        scrollPane.setBounds(20, 50, 310, 300);

        panelJuegos.add(scrollPane);
        add(panelJuegos);

        // Panel para mostrar el carrito de compras
        JPanel panelCarrito = new JPanel();
        panelCarrito.setBackground(new Color(40, 40, 40));
        panelCarrito.setBounds(420, 80, 300, 400);
        panelCarrito.setLayout(null);

        JLabel tituloCarrito = new JLabel("Carrito de Compras");
        tituloCarrito.setForeground(Color.WHITE);
        tituloCarrito.setFont(new Font("Arial", Font.BOLD, 18));
        tituloCarrito.setBounds(20, 10, 200, 30);
        panelCarrito.add(tituloCarrito);

        // Lista para mostrar los elementos del carrito
        DefaultListModel<String> modeloCarrito = new DefaultListModel<>();
        JList<String> listaCarrito = new JList<>(modeloCarrito);
        JScrollPane scrollCarrito = new JScrollPane(listaCarrito);
        scrollCarrito.setBounds(20, 50, 260, 300);
        panelCarrito.add(scrollCarrito);

        // Etiqueta para mostrar el precio total
        precioTotalLabel = new JLabel("Total: $0");
        precioTotalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        precioTotalLabel.setForeground(Color.WHITE);
        precioTotalLabel.setBounds(20, 360, 200, 30);
        panelCarrito.add(precioTotalLabel);

        // Botón para confirmar la compra
        JButton botonConfirmarCompra = new JButton("Confirmar Compra");
        botonConfirmarCompra.setBounds(140, 360, 150, 30); //aqui puedes mover los botonces su posicionamiento
        botonConfirmarCompra.addActionListener(e -> {
            if (carrito.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El carrito está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Has comprado: " + String.join(", ", carrito) + "\nTotal: $" + calcularPrecioTotal(), "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
                carrito.clear();
                precios.clear();
                modeloCarrito.clear(); // Limpia el carrito después de confirmar
                actualizarPrecioTotal();
            }
        });
        panelCarrito.add(botonConfirmarCompra);
        add(panelCarrito);

        // Acción para agregar juegos al carrito
        JButton botonAgregar = new JButton("Agregar al Carrito");
        botonAgregar.setBounds(100, 360, 150, 30);
        botonAgregar.addActionListener(e -> {
            int filaSeleccionada = tablaJuegos.getSelectedRow();
            if (filaSeleccionada != -1) {
                String juegoSeleccionado = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
                int precioJuego = Integer.parseInt((String) modeloTabla.getValueAt(filaSeleccionada, 1));
                if (!carrito.contains(juegoSeleccionado)) { // Evitar duplicados
                    carrito.add(juegoSeleccionado);
                    precios.add(precioJuego);
                    modeloCarrito.addElement(juegoSeleccionado);
                    actualizarPrecioTotal();
                    JOptionPane.showMessageDialog(this, juegoSeleccionado + " agregado al carrito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El juego ya está en el carrito.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un juego para agregar al carrito.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelJuegos.add(botonAgregar);

        setVisible(true);
    }

    // Método para calcular el precio total
    private int calcularPrecioTotal() {
        int total = 0;
        for (int precio : precios) {
            total += precio;
        }
        return total;
    }

    // Método para actualizar la etiqueta del precio total
    private void actualizarPrecioTotal() {
        precioTotalLabel.setText("Total: $" + calcularPrecioTotal());
    }
}