package utils;

import data.*;

public class TestDataFactory {

    public static UserRegistrationData getDefaultUser() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        return userRegistrationData;
    }

    public static CitizenData getDefaultCitizen() {
        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        return citizenData;
    }

    public static AdminRegistrationData getDefaultAdmin() {
        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");
        return adminRegistrationData;
    }

    public static MarriageInfoData getMarriageInfo() {
        MarriageInfoData marriageInfoData = new MarriageInfoData("08.08.2008", "Иванова", "Сидорова", "Анна", "Сергеевна", "01.02.2001", "123123");
        return marriageInfoData;
    }

    public static BirthInfoData getBirthInfo() {
        BirthInfoData birthInfoData = new BirthInfoData("Минск", "Анна", "Иван", "Елена", "Андрей");
        return birthInfoData;
    }

    public static DeathInfoData getDeathInfo() {
        DeathInfoData deathInfoData = new DeathInfoData("03.03.2003", "Минск");
        return deathInfoData;
    }
}
