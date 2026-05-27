import model.Complaint;
import model.Status;
import service.ComplaintService;

public class TestComplaint {

    public static void main(String[] args) {

        Complaint complaint =
                new Complaint(
                        1,
                        "Street light not working",
                        "Sector 12",
                        Status.PENDING
                );

        ComplaintService.saveComplaintToDB(
                complaint
        );
    }
}