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

        if (line == null || line.trim().isEmpty()) {
            return null;
        }
    
        String[] parts = line.split("\\|");
    
        if (parts.length < 4) {
            return null;
        }
    
        int id = Integer.parseInt(parts[0].trim());
        String desc = parts[1].trim();
        String loc = parts[2].trim();
        Status status = Status.valueOf(parts[3].trim());
    
        return new Complaint(id, desc, loc, status);
    }
}
