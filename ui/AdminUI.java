import java.util.*;

public class AdminUI {

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.View 2.Update 3.Exit");
            int ch = sc.nextInt(); sc.nextLine();

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
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Status: ");
                    String s = sc.nextLine();

                    ComplaintService.updateStatus(list, id, Status.valueOf(s.toUpperCase()));
                    FileManager.overwrite(list);

                } else break;

            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
