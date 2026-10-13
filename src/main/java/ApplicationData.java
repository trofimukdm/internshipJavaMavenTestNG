public class ApplicationData {

    private final String lastName;
    private final String firstName;
    private final String email;
    private final String requestNumber;

    public ApplicationData(String lastName, String firstName, String email, String requestNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.requestNumber = requestNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getRequestNumber() {
        return requestNumber;
    }
}
