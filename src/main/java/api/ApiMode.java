package api;

public enum ApiMode {
    WEDDING("wedding"),
    BIRTH("birth"),
    DEATH("death");

    private final String value;

    ApiMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
