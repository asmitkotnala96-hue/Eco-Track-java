package service;
import java.util.*;
import model.User;
public class AuthService {

    public static User login(List<User> users, String u, String p) {
        for (User user : users) {
            if (user.getUsername().equals(u) &&
                user.getPassword().equals(p)) {
                return user;
            }
        }
        return null;
    }
}
