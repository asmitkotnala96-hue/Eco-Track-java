package ui;

import java.util.*;
import model.*;
import service.ComplaintService;
import filehandler.FileManager;

public class AdminUI {

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.View 2.Update 3.Exit");
            int ch = Integer.parseInt(sc.nextLine());
            try {
                List<Complaint> list = FileManager.load();

                if (ch == 1) {
                    for (Complaint c : list) {
                        System.out.println(
                            c.getId()+" "+c.getDescription()+" "+c.getStatus()
                        );
                    }

                } else if (ch == 2) {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Status: ");
                    String s = sc.nextLine();

                    ComplaintService.updateStatus(list, id, Status.valueOf(s.toUpperCase()));
                    FileManager.overwrite(list);
                    
                    for (Complaint c : list) {
                        if (c.getId() == id) {
                            FileManager.updateSeparateFile(c);
                            break;
                        }
                    }

                } else break;

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
