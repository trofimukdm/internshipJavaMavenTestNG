package data;

public class DeathInfoData {
    private final String deathDate;
    private final String deathPlace;

    public DeathInfoData(String deathDate, String deathPlace) {
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }
}
