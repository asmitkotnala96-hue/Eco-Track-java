package ui;

import javax.swing.*;
import java.awt.*;

public class AdminLoginGUI extends JFrame {

    JTextField usernameField;

    JPasswordField passwordField;

    JButton loginButton;

    public AdminLoginGUI() {

        setTitle("Admin Login");

        setSize(350, 200);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        add(new JLabel("Username:"));

        usernameField =
                new JTextField(15);

        add(usernameField);

        add(new JLabel("Password:"));

        passwordField =
                new JPasswordField(15);

        add(passwordField);

        loginButton =
                new JButton("Login");

        add(loginButton);

        loginButton.addActionListener(e -> {

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            // SIMPLE LOGIN

            if (username.equals("admin")
                    &&
                password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful"
                );

                new AdminGUI();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Login"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new AdminLoginGUI();
    }
}