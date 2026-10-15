package tests;

import data.*;
import pages.*;

public class BaseTest {

    protected void performUserRegistrationSteps(UserRegistrationData data) {
        MainPage mainPage = new MainPage();
        mainPage.clickLoginAsUser();
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        userRegistrationPage.fillUserRegistrationData(data);
    }

    protected void performFillCitizenData(CitizenData data) {
        CitizenPage citizenPage = new CitizenPage();
        citizenPage.fillCitizenData(data);
    }

    protected void performFillMarriageInfoData(MarriageInfoData data) {
        MarriageInfoPage marriageInfoPage = new MarriageInfoPage();
        marriageInfoPage.fillMarriageInfo(data);
    }

    protected void performFillBirthInfoData(BirthInfoData data) {
        BirthInfoPage birthInfoPage = new BirthInfoPage();
        birthInfoPage.fillBirthInfo(data);
    }

    protected void performFillDeathInfoData(DeathInfoData data) {
        DeathInfoPage deathInfoPage = new DeathInfoPage();
        deathInfoPage.fillDeathInfo(data);
    }

    protected void performAdminRegistrationSteps(AdminRegistrationData data) {
        MainPage mainPage = new MainPage();
        mainPage.clickLoginAsAdmin();
        AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
        adminRegistrationPage.fillAdminData(data);
    }
}
