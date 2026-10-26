package enums;

public enum ServiceType {
    MARRIAGE("Регистрация брака"),
    BIRTH("Регистрация рождения"),
    DEATH("Регистрация смерти");

    private final String description;

    ServiceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
