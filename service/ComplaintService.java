package service;
import java.util.*;

class ComplaintService {

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
}
