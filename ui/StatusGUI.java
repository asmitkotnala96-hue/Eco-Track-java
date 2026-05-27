package ui;

import model.Complaint;
import service.ComplaintService;
import filehandler.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatusGUI extends JFrame {

    JTextField idField;

    JButton checkButton;

    JLabel resultLabel;

    public StatusGUI() {

        setTitle("Complaint Status Checker");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel idLabel =
                new JLabel("Enter Complaint ID:");

        idField =
                new JTextField(15);

        checkButton =
                new JButton("Check Status");

        resultLabel =
                new JLabel("");

        add(idLabel);

        add(idField);

        add(checkButton);

        add(resultLabel);

        checkButton.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                idField.getText()
                        );

                List<Complaint> list =
                        FileManager.load();

                boolean found = false;

                // LINEAR SEARCH ALGORITHM
                for (Complaint c : list) {

                    if (c.getId() == id) {

                        resultLabel.setText(
                                "Status: " +
                                c.getStatus()
                        );

                        found = true;

                        break;
                    }
                }

                if (!found) {

                    resultLabel.setText(
                            "Complaint Not Found"
                    );
                }

            } catch (Exception ex) {

                ex.printStackTrace();

                resultLabel.setText(
                        "Invalid Input"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new StatusGUI();
    }
}