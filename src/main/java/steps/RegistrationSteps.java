package steps;

import data.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.*;
import enums.ServiceType;

public class RegistrationSteps {
    private static final Logger logger = LogManager.getLogger(RegistrationSteps.class);

    @Step("Выбираем услугу: {0}")
    private void selectService(ServiceType serviceType) {
        SelectServicePage selectPage = new SelectServicePage();
        switch (serviceType) {
            case MARRIAGE:
                selectPage.clickMarriageSelect();
                break;
            case BIRTH:
                selectPage.clickBirthSelect();
                break;
            case DEATH:
                selectPage.clickDeathSelect();
                break;
        }
        logger.info("Услуга выбрана -> {}", serviceType.getDescription());
    }

    private void fillServiceData(ServiceInfoData serviceInfoData){
        switch (serviceInfoData) {
            case MarriageInfoData data:
                MarriageInfoPage marriageInfoPage = new MarriageInfoPage();
                marriageInfoPage.fillMarriageInfo(data);
                marriageInfoPage.clickCompleteButton();
                logger.info("Заполнили данные для услуги - Регистрация брака");
                break;

            case BirthInfoData data:
                BirthInfoPage birthInfoPage = new BirthInfoPage();
                birthInfoPage.fillBirthInfo(data);
                birthInfoPage.clickCompleteButton();
                logger.info("Заполнили данные для услуги - Регистрация рождения");
                break;

            case DeathInfoData data:
                DeathInfoPage deathInfoPage = new DeathInfoPage();
                deathInfoPage.fillDeathInfo(data);
                deathInfoPage.clickCompleteButton();
                logger.info("Заполнили данные для услуги - Регистрация смерти");
                break;
        }
    }

    @Step("Подача заявки пользователем и получение её номера")
    public String submitApplication(UserRegistrationData userData, CitizenData citizenData, ServiceInfoData serviceInfoData) {

        MainPage mainPage = new MainPage();
        mainPage.clickLoginAsUser();
        logger.info("Вошли как Пользователь");

        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        userRegistrationPage.fillUserRegistrationData(userData);
        userRegistrationPage.clickApplicantNextButton();
        logger.info("Заполнили данные для регистрации Заявителя");

        selectService(serviceInfoData.getServiceType());

        CitizenPage citizenPage = new CitizenPage();
        citizenPage.fillCitizenData(citizenData);
        citizenPage.clickCitizenNextButton();
        logger.info("Заполнили данные гражданина");

        fillServiceData(serviceInfoData);

        ResultPage resultPage = new ResultPage();
        String orderNumber = resultPage.getOrderNumber();
        resultPage.clickFinishButton();

        logger.info("Заявка подана. Получен номер: {}", orderNumber);
        return orderNumber;
    }
}
