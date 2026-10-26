package data;

import enums.ServiceType;

public final class DeathInfoData implements ServiceInfoData{
    private final String deathDate;
    private final String deathPlace;

    public DeathInfoData(String deathDate, String deathPlace) {
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DEATH;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }
}
