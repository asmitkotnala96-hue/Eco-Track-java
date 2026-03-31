package filehandler;

import java.io.*;
import java.util.*;
import model.Complaint;

public class FileManager {

    private static final String FILE = "data/complaints.txt";

    public static List<Complaint> load() throws IOException {
        List<Complaint> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;

        while ((line = br.readLine()) != null) {
            list.add(Complaint.fromFileString(line));
        }
        br.close();
        return list;
    }

    public static void save(Complaint c) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true));
        bw.write(c.toFileString());
        bw.newLine();
        bw.close();
    }

    public static void overwrite(List<Complaint> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE));
        for (Complaint c : list) {
            bw.write(c.toFileString());
            bw.newLine();
        }
        bw.close();
    }
}
