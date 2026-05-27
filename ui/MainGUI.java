package ui;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    JButton userButton;

    JButton statusButton;

    JButton exitButton;

    JButton adminButton;

    public MainGUI() {

        setTitle("Complaint Management System");

        setSize(800, 600);

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

         adminButton =new JButton("Admin Pannel");

        exitButton =
                new JButton("Exit");


        add(titleLabel);

        add(userButton);

        add(statusButton);

        add(adminButton);

        add(exitButton);


        // Open UserGUI
        userButton.addActionListener(e -> {

            new UserLoginGUI();
        });

        // Open StatusGUI
        statusButton.addActionListener(e -> {

            new StatusGUI();
        });
        adminButton.addActionListener(e -> {

        new AdminLoginGUI();
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