package filehandler;

import java.io.*;
import java.util.*;
import model.User;

public class UserFileManager {

    private static final String FILE = "data/users.txt";

    public static List<User> load() throws IOException {
        List<User> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;

        while ((line = br.readLine()) != null) {
            list.add(User.fromFileString(line));
        }
        br.close();
        return list;
    }
}
