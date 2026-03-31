import java.util.*;
import java.io.*;

public class MainUI {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EcoTrack =====");
            System.out.println("1. File Complaint");
            System.out.println("2. Check Status");
            System.out.println("3. Update Status (Admin)");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            List<Complaint> list = FileManager.loadComplaints();

            switch (choice) {

                case 1:
                    int id = ComplaintService.generateId(list);

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String loc = sc.nextLine();

                    Complaint c = new Complaint(id, desc, loc, Status.PENDING);
                    FileManager.saveComplaint(c);

                    System.out.println("Complaint filed with ID: " + id);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int checkId = sc.nextInt();

                    ComplaintService.viewStatus(list, checkId);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Status (PENDING/IN_PROGRESS/RESOLVED/REJECTED): ");
                    String statusInput = sc.nextLine();

                    try {
                        Status newStatus = Status.valueOf(statusInput.toUpperCase());
                        ComplaintService.updateStatus(list, updateId, newStatus);
                        FileManager.overwriteFile(list);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status!");
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
