package ui;

import javax.swing.*;
import java.awt.*;

public class UserLoginGUI extends JFrame {

    JTextField usernameField;

    JPasswordField passwordField;

    JButton loginButton;

    public UserLoginGUI() {

        setTitle("User Login");

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

            // SIMPLE USER LOGIN

            if (username.equals("user")
                    &&
                password.equals("user123")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful"
                );

                new UserGUI();

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

        new UserLoginGUI();
    }
}