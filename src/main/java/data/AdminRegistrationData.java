package data;

public class AdminRegistrationData {
    private final String adminLastName;
    private final String adminFirstName;
    private final String adminMiddleName;
    private final String adminPhone;
    private final String adminPassport;
    private final String adminBirthday;

    public AdminRegistrationData(String adminLastName, String adminFirstName, String adminMiddleName, String adminPhone, String adminPassport, String adminBirthday) {
        this.adminLastName = adminLastName;
        this.adminFirstName = adminFirstName;
        this.adminMiddleName = adminMiddleName;
        this.adminPhone = adminPhone;
        this.adminPassport = adminPassport;
        this.adminBirthday = adminBirthday;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public String getAdminMiddleName() {
        return adminMiddleName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public String getAdminPassport() {
        return adminPassport;
    }

    public String getAdminBirthday() {
        return adminBirthday;
    }
}
