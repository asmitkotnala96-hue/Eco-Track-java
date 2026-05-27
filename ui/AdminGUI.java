package ui;

import model.Complaint;
import model.Status;
import filehandler.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

public class AdminGUI extends JFrame {

    JTable table;

    DefaultTableModel model;

    JTextField idField;

    JComboBox<Status> statusBox;

    JButton updateButton;

    JButton sortButton;

    public AdminGUI() {

        setTitle("Admin Panel");

        setSize(700, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // TABLE

        String[] columns = {
                "ID",
                "Description",
                "Location",
                "Status"
        };

        model =
                new DefaultTableModel(columns, 0);

        table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // BOTTOM PANEL

        JPanel bottomPanel =
                new JPanel(new FlowLayout());

        bottomPanel.add(
                new JLabel("Complaint ID:")
        );

        idField =
                new JTextField(5);

        bottomPanel.add(idField);

        bottomPanel.add(
                new JLabel("New Status:")
        );

        statusBox =
                new JComboBox<>(Status.values());

        bottomPanel.add(statusBox);

        updateButton =
                new JButton("Update Status");

        sortButton = new JButton("Sort by ID");

        bottomPanel.add(updateButton);

        bottomPanel.add(sortButton);

        add(bottomPanel, BorderLayout.SOUTH);

        loadComplaints();

        // UPDATE BUTTON

        updateButton.addActionListener(e -> {

            try {

                int id =
                        Integer.parseInt(
                                idField.getText()
                        );

                Status newStatus =
                        (Status) statusBox
                                .getSelectedItem();

                List<Complaint> list =
                        FileManager.load();

                boolean found = false;

                // LINEAR SEARCH
                for (Complaint c : list) {

                    if (c.getId() == id) {

                        c.setStatus(newStatus);

                        found = true;

                        break;
                    }
                }

                if (found) {

                    FileManager.overwrite(list);

                    JOptionPane.showMessageDialog(
                            this,
                            "Status Updated!"
                    );

                    refreshTable();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Complaint Not Found"
                    );
                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Input"
                );
            }
        });

        sortButton.addActionListener(e -> {

    try {

        List<Complaint> list =
                FileManager.load();

        // BUBBLE SORT

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = 0;
                 j < list.size() - i - 1;
                 j++) {

                if (list.get(j).getId() >
                        list.get(j + 1).getId()) {

                    Complaint temp =
                            list.get(j);

                    list.set(
                            j,
                            list.get(j + 1)
                    );

                    list.set(
                            j + 1,
                            temp
                    );
                }
            }
        }

        // Refresh JTable

        model.setRowCount(0);

        for (Complaint c : list) {

            model.addRow(new Object[] {

                    c.getId(),

                    c.getDescription(),

                    c.getLocation(),

                    c.getStatus()
            });
        }

        JOptionPane.showMessageDialog(
                this,
                "Complaints Sorted By ID"
        );

    } catch (Exception ex) {

        ex.printStackTrace();
    }
    });

        setVisible(true);
    }

    // LOAD TABLE

    private void loadComplaints() {

        try {

            List<Complaint> list =
                    FileManager.load();

            for (Complaint c : list) {

                model.addRow(new Object[] {

                        c.getId(),

                        c.getDescription(),

                        c.getLocation(),

                        c.getStatus()
                });
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // REFRESH TABLE

    private void refreshTable() {

        model.setRowCount(0);

        loadComplaints();
    }

    public static void main(String[] args) {

        new AdminGUI();
    }
}