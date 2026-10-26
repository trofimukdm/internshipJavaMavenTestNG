package api;

public enum ApiAction {
    APPROVED("approved"),
    REJECTED("rejected");

    private final String value;

    ApiAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
