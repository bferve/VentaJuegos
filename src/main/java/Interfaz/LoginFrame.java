package Interfaz;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel usuarioLabel = new JLabel("Usuario:");
        JLabel contraseñaLabel = new JLabel("Contraseña:");
        JTextField usuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        JButton confirmarButton = new JButton("Confirmar");

        // Posicionamiento de los elementos
        usuarioLabel.setBounds(20, 20, 80, 25);
        usuarioField.setBounds(100, 20, 150, 25);
        contraseñaLabel.setBounds(20, 60, 80, 25);
        contraseñaField.setBounds(100, 60, 150, 25);
        confirmarButton.setBounds(100, 100, 100, 30);

        // Agregar componentes
        add(usuarioLabel);
        add(usuarioField);
        add(contraseñaLabel);
        add(contraseñaField);
        add(confirmarButton);

        setVisible(true);
    }
}