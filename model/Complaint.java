package model;
public class Complaint {
    private int id;
    private String description;
    private String location;
    private Status status;

    public Complaint(int id, String description, String location, Status status) {
        this.id = id;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public Status getStatus() { return status; }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toFileString() {
        return id + "|" + description + "|" + location + "|" + status;
    }

    public static Complaint fromFileString(String line) {
        String[] p = line.split("\\|");
        return new Complaint(
            Integer.parseInt(p[0]),
            p[1],
            p[2],
            Status.valueOf(p[3])
        );
    }
}
