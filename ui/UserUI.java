package ui;

import java.util.*;
import model.*;
import service.ComplaintService;
import filehandler.FileManager;

public class UserUI {

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.File 2.Check 3.Exit");
            int ch = Integer.parseInt(sc.nextLine());

            try {
                List<Complaint> list = FileManager.load();

                if (ch == 1) {
                    int id = ComplaintService.generateId(list);

                    System.out.print("Desc: ");
                    String d = sc.nextLine();

                    System.out.print("Loc: ");
                    String l = sc.nextLine();

                   Complaint c = new Complaint(id, d, l, Status.PENDING);

                    // Save in main tracking file
                    FileManager.save(c);

                    // ALSO create separate file
                    FileManager.saveAsSeparateFile(c);

                    ComplaintService.saveComplaintToDB(c);

                    System.out.println("Complaint saved and file created!");
                    
                    System.out.println("Your Complaint ID is: " + id);

                } else if (ch == 2) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    ComplaintService.viewStatus(list, id);

                } else break;

            } catch (Exception e){
                e.printStackTrace();
                }
        }
    }
}
