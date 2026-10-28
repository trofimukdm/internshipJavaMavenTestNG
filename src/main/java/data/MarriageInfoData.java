package data;

import enums.ServiceType;

public final class MarriageInfoData implements ServiceInfoData{
    private final String registrationDate;
    private final String newLastName;
    private final String spouseLastName;
    private final String spouseFirstName;
    private final String spouseMiddleName;
    private final String spouseBirthDate;
    private final String spousePassport;

    public MarriageInfoData(String registrationDate, String newLastName, String spouseLastName, String spouseFirstName, String spouseMiddleName, String spouseBirthDate, String spousePassport) {
        this.registrationDate = registrationDate;
        this.newLastName = newLastName;
        this.spouseLastName = spouseLastName;
        this.spouseFirstName = spouseFirstName;
        this.spouseMiddleName = spouseMiddleName;
        this.spouseBirthDate = spouseBirthDate;
        this.spousePassport = spousePassport;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.MARRIAGE;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public String getSpouseMiddleName() {
        return spouseMiddleName;
    }

    public String getSpouseBirthDate() {
        return spouseBirthDate;
    }

    public String getSpousePassport() {
        return spousePassport;
    }
}
