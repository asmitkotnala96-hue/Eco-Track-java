package ui;

import model.Complaint;
import model.Status;
import service.ComplaintService;
import filehandler.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserGUI extends JFrame {

    JTextArea descriptionArea;
    JTextField locationField;
    JButton submitButton;

    public UserGUI() {

        setTitle("Complaint Management System");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel descLabel =
                new JLabel("Description:");

        descriptionArea =
                new JTextArea(5, 25);

        JLabel locLabel =
                new JLabel("Location:");

        locationField =
                new JTextField(20);

        submitButton =
                new JButton("Submit Complaint");

        add(descLabel);

        add(descriptionArea);

        add(locLabel);

        add(locationField);

        add(submitButton);

        submitButton.addActionListener(e -> {

            try {

                List<Complaint> list =
                        FileManager.load();

                int id =
                        ComplaintService.generateId(list);

                String desc =
                        descriptionArea.getText();

                String loc =
                        locationField.getText();

                Complaint c =
                        new Complaint(
                                id,
                                desc,
                                loc,
                                Status.PENDING
                        );

                FileManager.save(c);

                FileManager.saveAsSeparateFile(c);

                ComplaintService.saveComplaintToDB(c);

                JOptionPane.showMessageDialog(
                        this,
                        "Complaint Submitted!\nComplaint ID: " + id
                );

                descriptionArea.setText("");

                locationField.setText("");

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Error Saving Complaint"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new UserGUI();
    }
}
