package dataModel;

public class UserRegistrationData {

    private final String applicantLastName;
    private final String applicantFirstName;
    private final String applicantMiddleName;
    private final String applicantPhone;
    private final String applicantPassport;
    private final String applicantAddress;

    public UserRegistrationData(String applicantLastName, String applicantFirstName, String applicantMiddleName, String applicantPhone, String applicantPassport, String applicantAddress) {
        this.applicantLastName = applicantLastName;
        this.applicantFirstName = applicantFirstName;
        this.applicantMiddleName = applicantMiddleName;
        this.applicantPhone = applicantPhone;
        this.applicantPassport = applicantPassport;
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantLastName() {
        return applicantLastName;
    }

    public String getApplicantFirstName() {
        return applicantFirstName;
    }

    public String getApplicantMiddleName() {
        return applicantMiddleName;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public String getApplicantPassport() {
        return applicantPassport;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }
}
