package dataModel;

public class CitizenData {
    private final String citizenLastName;
    private final String citizenFirstName;
    private final String citizenMiddleName;
    private final String citizenBirthDate;
    private final String citizenPassport;
    private final String citizenGender;
    private final String citizenAddress;

    public CitizenData(String citizenLastName, String citizenFirstName, String citizenMiddleName, String citizenBirthDate, String citizenPassport, String citizenGender, String citizenAddress) {
        this.citizenLastName = citizenLastName;
        this.citizenFirstName = citizenFirstName;
        this.citizenMiddleName = citizenMiddleName;
        this.citizenBirthDate = citizenBirthDate;
        this.citizenPassport = citizenPassport;
        this.citizenGender = citizenGender;
        this.citizenAddress = citizenAddress;
    }

    public String getCitizenLastName() {
        return citizenLastName;
    }

    public String getCitizenFirstName() {
        return citizenFirstName;
    }

    public String getCitizenMiddleName() {
        return citizenMiddleName;
    }

    public String getCitizenBirthDate() {
        return citizenBirthDate;
    }

    public String getCitizenPassport() {
        return citizenPassport;
    }

    public String getCitizenGender() {
        return citizenGender;
    }

    public String getCitizenAddress() {
        return citizenAddress;
    }
}
