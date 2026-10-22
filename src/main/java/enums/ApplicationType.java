package enums;

public enum ApplicationType {
    MARRIAGE_CERTIFICATE("Получение свидетельства о браке"),
    BIRTH_CERTIFICATE("Получение свидетельства о рождении"),
    DEATH_CERTIFICATE("Получение свидетельства о смерти");

    private final String value;

    ApplicationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
