package service;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Complaint;
import model.Status;

public class ComplaintService {

    public static int generateId(List<Complaint> list) {
        return list.size() + 1;
    }

    public static void viewStatus(List<Complaint> list, int id) {
        for (Complaint c : list) {
            if (c.getId() == id) {
                System.out.println("Status: " + c.getStatus());
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void updateStatus(List<Complaint> list, int id, Status s) {
        for (Complaint c : list) {
            if (c.getId() == id) {
                c.setStatus(s);
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void saveComplaintToDB(Complaint complaint) {

    try {

        Connection conn =
                DatabaseConnections.getConnection();

        String query =
                "INSERT INTO complaints(id, description, location, status) VALUES(?,?,?,?)";

        PreparedStatement ps =
                conn.prepareStatement(query);

        ps.setInt(1, complaint.getId());

        ps.setString(2,
                complaint.getDescription());

        ps.setString(3,
                complaint.getLocation());

        ps.setString(4,
                complaint.getStatus().toString());

        ps.executeUpdate();

        System.out.println(
                "Complaint Saved To Database");

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}
