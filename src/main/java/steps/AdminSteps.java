package steps;

import data.AdminRegistrationData;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.AdminRegistrationPage;
import pages.MainPage;

public class AdminSteps {
    private static final Logger logger = LogManager.getLogger(AdminSteps.class);

    @Step("Вход в систему в режиме Администратора")
    public void loginAsAdmin(AdminRegistrationData data) {
        MainPage mainPage = new MainPage();
        mainPage.clickLoginAsAdmin();
        logger.info("Вошли как Администратор");

        AdminRegistrationPage adminPage = new AdminRegistrationPage();
        adminPage.fillAdminData(data);
        adminPage.clickAdminNextButton();
        logger.info("Заполнили данные для регистрации Администратора");
    }
}
