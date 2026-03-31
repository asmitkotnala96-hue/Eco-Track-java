package ui;
import java.util.*;

public class MainUI {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        List<User> users = UserFileManager.load();
        User current = AuthService.login(users, u, p);

        if (current == null) {
            System.out.println("Invalid login");
            return;
        }

        if (current.getRole().equals("USER")) {
            UserUI.start();
        } else {
            AdminUI.start();
        }
    }
}
