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
    public static void saveAsSeparateFile(Complaint c) throws IOException {

    String fileName = "data/complaint_" + c.getId() + ".txt";

    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

    bw.write("===== Complaint Details =====");
    bw.newLine();
    bw.write("ID: " + c.getId());
    bw.newLine();
    bw.write("Description: " + c.getDescription());
    bw.newLine();
    bw.write("Location: " + c.getLocation());
    bw.newLine();
    bw.write("Status: " + c.getStatus());
    bw.newLine();

    bw.close();
}
}
