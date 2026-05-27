package ui;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    JButton userButton;

    JButton statusButton;

    JButton exitButton;

    public MainGUI() {

        setTitle("Complaint Management System");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel titleLabel =
                new JLabel(
                        "Complaint Management System"
                );

        titleLabel.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18)
        );

        userButton =
                new JButton("File Complaint");

        statusButton =
                new JButton("Check Complaint Status");

        exitButton =
                new JButton("Exit");

        add(titleLabel);

        add(userButton);

        add(statusButton);

        add(exitButton);

        // Open UserGUI
        userButton.addActionListener(e -> {

            new UserGUI();
        });

        // Open StatusGUI
        statusButton.addActionListener(e -> {

            new StatusGUI();
        });

        // Exit App
        exitButton.addActionListener(e -> {

            System.exit(0);
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new MainGUI();
    }
}