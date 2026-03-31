package ui;
import java.util.*;

public class UserUI {

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.File 2.Check 3.Exit");
            int ch = sc.nextInt(); sc.nextLine();

            try {
                List<Complaint> list = FileManager.load();

                if (ch == 1) {
                    int id = ComplaintService.generateId(list);

                    System.out.print("Desc: ");
                    String d = sc.nextLine();

                    System.out.print("Loc: ");
                    String l = sc.nextLine();

                    Complaint c = new Complaint(id, d, l, Status.PENDING);
                    FileManager.save(c);

                } else if (ch == 2) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    ComplaintService.viewStatus(list, id);

                } else break;

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
