package tests;

import data.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.MyDriverManager;
import utils.ScreenshotUtil;
import utils.TestConfig;

import java.net.URI;
import java.util.function.Predicate;

@Listeners(AllureTestNg.class)
public class BaseTest {
    protected final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        Allure.getLifecycle().updateFixture(fixture -> fixture.setName("Открываем браузер, вводим логин/пароль и заходим в приложение"));
        logger.info("=== Начало теста ===");
        String expectedHost = URI.create(TestConfig.getBaseUrl()).getHost();
        WebDriver driver = MyDriverManager.getDriver();
        if (driver instanceof HasAuthentication) {
            logger.debug("Настраиваем Basic Auth для драйвера");
            Predicate<URI> hostFilter = uri -> uri.getHost() != null && uri.getHost().equals(expectedHost);
            ((HasAuthentication) driver).register(hostFilter, UsernameAndPassword.of(TestConfig.getUsername(), TestConfig.getPassword()));
        }
        logger.info("Открываем страницу: {}", TestConfig.getBaseUrl());
        driver.get(TestConfig.getBaseUrl());
        logger.info("Страница успешно открыта");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        Allure.getLifecycle().updateFixture(fixture -> fixture.setName("Закрываем браузер"));
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Тест '{}' упал с ошибкой: {}",
                    result.getName(),
                    result.getThrowable() != null ? result.getThrowable().getMessage() : "неизвестная ошибка");
            ScreenshotUtil.takeScreenshot();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Тест '{}' успешно завершён", result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Тест '{}' был пропущен", result.getName());
        }
        MyDriverManager.quitDriver();
        logger.info("=== Конец теста ===\n");
    }

    @Step("Входим как Пользователь")
    protected void performUserRegistrationSteps(UserRegistrationData data) {
        Allure.step("Нажимаем на кнопку -> Войти как пользователь", () -> {
            MainPage mainPage = new MainPage();
            mainPage.clickLoginAsUser();
            logger.info("Вошли как Пользователь");
        });
        Allure.step("Заполняем регистрационную форму 'Данные заявителя'", () -> {
            UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
            userRegistrationPage.fillUserRegistrationData(data);
            userRegistrationPage.clickApplicantNextButton();
            logger.info("Заполнили данные для регистрации Заявителя");
        });
    }

    @Step("Заполняем данные гражданина ")
    protected void performFillCitizenData(CitizenData data) {
        CitizenPage citizenPage = new CitizenPage();
        citizenPage.fillCitizenData(data);
        citizenPage.clickCitizenNextButton();
        logger.info("Заполнили данные гражданина");
    }

    @Step("Заполняем данные для услуги - Регистрации брака")
    protected void performFillMarriageInfoData(MarriageInfoData data) {
        MarriageInfoPage marriageInfoPage = new MarriageInfoPage();
        marriageInfoPage.fillMarriageInfo(data);
        marriageInfoPage.clickCompleteButton();
        logger.info("Заполнили данные для услуги - Регистрация брака");
    }

    @Step("Заполняем данные для услуги - Регистрации рождения")
    protected void performFillBirthInfoData(BirthInfoData data) {
        BirthInfoPage birthInfoPage = new BirthInfoPage();
        birthInfoPage.fillBirthInfo(data);
        birthInfoPage.clickCompleteButton();
        logger.info("Заполнили данные для услуги - Регистрация рождения");
    }

    @Step("Заполняем данные для услуги - Регистрации смерти")
    protected void performFillDeathInfoData(DeathInfoData data) {
        DeathInfoPage deathInfoPage = new DeathInfoPage();
        deathInfoPage.fillDeathInfo(data);
        deathInfoPage.clickCompleteButton();
        logger.info("Заполнили данные для услуги - Регистрация смерти");
    }

    @Step("Получаем номер заявки")
    protected String performResultPageSteps() {
        ResultPage resultPage = new ResultPage();
        String orderNumber = resultPage.getOrderNumber();
        resultPage.clickFinishButton();
        logger.info("Номер новой заявки получен: {}", orderNumber);
        return orderNumber;
    }

    @Step("Входим как Администратор")
    protected void performAdminRegistrationSteps(AdminRegistrationData data) {
        Allure.step("Нажимаем на кнопку -> Войти как Администратор", () -> {
            MainPage mainPage = new MainPage();
            mainPage.clickLoginAsAdmin();
            logger.info("Вошли как Администратор");
        });
        Allure.step("Заполняем регистрационную форму 'Данные регистрации'", () -> {
            AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
            adminRegistrationPage.fillAdminData(data);
            adminRegistrationPage.clickAdminNextButton();
            logger.info("Заполнили данные для регистрации Администратора");
        });
    }

    @Step("Выбираем услугу -> Регистрация брака")
    protected void marriageSelection() {
        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickMarriageSelect();
        logger.info("Услуга выбрана -> Регистрация брака");
    }

    @Step("Выбираем услугу -> Регистрация рождения")
    protected void birthSelection() {
        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickBirthSelect();
        logger.info("Услуга выбрана -> Регистрация рождения");
    }

    @Step("Выбираем услугу -> Регистрация смерти")
    protected void deathSelection() {
        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickDeathSelect();
        logger.info("Услуга выбрана -> Регистрация смерти");
    }

    @Step("Заполняем данные граждан для регистрации услуги -> Регистрация брака")
    protected String MarriageRegistration(UserRegistrationData userRegistrationData, CitizenData citizenData, MarriageInfoData marriageInfoData, AdminRegistrationData adminRegistrationData) {
        performUserRegistrationSteps(userRegistrationData);
        marriageSelection();
        performFillCitizenData(citizenData);
        performFillMarriageInfoData(marriageInfoData);
        String requestNumber = performResultPageSteps();
        performAdminRegistrationSteps(adminRegistrationData);
        logger.info("Услуга -> Регистрация брака зарегистрирована. Номер заявки проверен: {}", requestNumber);
        return requestNumber;
    }

    @Step("Заполняем данные граждан для регистрации услуги -> Регистрация рождения")
    protected String BirthRegistration(UserRegistrationData userRegistrationData, CitizenData citizenData, BirthInfoData birthInfoData, AdminRegistrationData adminRegistrationData) {
        performUserRegistrationSteps(userRegistrationData);
        birthSelection();
        performFillCitizenData(citizenData);
        performFillBirthInfoData(birthInfoData);
        String requestNumber = performResultPageSteps();
        performAdminRegistrationSteps(adminRegistrationData);
        logger.info("Услуга -> Регистрация рождения зарегистрирована. Номер заявки проверен: {}", requestNumber);
        return requestNumber;
    }

    @Step("Заполняем данные граждан для регистрации услуги -> Регистрация смерти")
    protected String DeathRegistration(UserRegistrationData userRegistrationData, CitizenData citizenData, DeathInfoData deathInfoData, AdminRegistrationData adminRegistrationData) {
        performUserRegistrationSteps(userRegistrationData);
        deathSelection();
        performFillCitizenData(citizenData);
        performFillDeathInfoData(deathInfoData);
        String requestNumber = performResultPageSteps();
        performAdminRegistrationSteps(adminRegistrationData);
        logger.info("Услуга -> Регистрация смерти зарегистрирована. Номер заявки проверен: {}", requestNumber);
        return requestNumber;
    }
}
