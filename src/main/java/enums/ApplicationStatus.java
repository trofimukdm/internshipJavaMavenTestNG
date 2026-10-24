package enums;

public enum ApplicationStatus {
    UNDER_REVIEW("На рассмотрении"),
    APPROVED("Одобрена"),
    REJECTED("Отклонена");

    private final String value;

    ApplicationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
