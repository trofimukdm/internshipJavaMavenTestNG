package tests;

import data.*;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Регистрация заявок на портале")
@Feature("Проверки регистрации всех видов заявок")
@Owner("Дмитрий")
public class PagesTests extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PagesTests.class);

    public PagesTests() {
        super();
    }

    @Test(description = "Регистрация заявки и проверка статуса и типа -> Регистрация брака")
    @Severity(CRITICAL)
    @Story("Автотест для сценария регистрации свадьбы")
    @Description("Регистрации заявки о браке. Проверка статуса и типа заявки в режиме Администратора")
    public void checkMarriageRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        MarriageInfoData marriageInfoData = new MarriageInfoData("08.08.2008", "Иванова", "Сидорова", "Анна", "Сергеевна", "01.02.2001", "123123");
        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");

        String orderNumber = MarriageRegistration(userRegistrationData, citizenData, marriageInfoData, adminRegistrationData);

        Allure.step("Проверяем тип и статус зарегистрированной заявки -> Регистрация брака", () -> {
            AdminTablePage table = new AdminTablePage();
            AdminTableRowElement order = table.findByNumber(orderNumber);
            Assert.assertEquals(order.getType(), "Получение свидетельства о браке");
            logger.info("Проверен тип заявки -> {}", order.getType());
            Assert.assertEquals(order.getStatus(), "На рассмотрении");
            logger.info("Проверен статус заявки -> {}", order.getStatus());
        });
    }

    @Test(description = "Регистрация заявки и проверка статуса и типа -> Регистрация рождения")
    @Severity(CRITICAL)
    @Story("Автотест для сценария регистрации рождения")
    @Description("Регистрации заявки о рождении. Проверка статуса и типа заявки в режиме Администратора")
    public void checkBirthRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        BirthInfoData birthInfoData = new BirthInfoData("Минск", "Анна", "Иван", "Елена", "Андрей");
        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");

        String orderNumber = BirthRegistration(userRegistrationData, citizenData, birthInfoData, adminRegistrationData);
        Allure.step("Проверяем тип и статус зарегистрированной заявки -> Регистрация рождения", () -> {
            AdminTablePage table = new AdminTablePage();
            AdminTableRowElement order = table.findByNumber(orderNumber);
            Assert.assertEquals(order.getType(), "Получение свидетельства о рождении");
            logger.info("Проверен тип заявки -> {}", order.getType());
            Assert.assertEquals(order.getStatus(), "На рассмотрении");
            logger.info("Проверен статус заявки -> {}", order.getStatus());
        });
    }

    @Test(description = "Регистрация заявки и проверка статуса и типа -> Регистрация смерти")
    @Description("Регистрации заявки о смерти. Проверка статуса и типа заявки в режиме Администратора")
    @Severity(CRITICAL)
    @Story("Автотест для сценария регистрации смерти")
    public void checkDeathRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        DeathInfoData deathInfoData = new DeathInfoData("03.03.2003", "Минск");
        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");

        String orderNumber = DeathRegistration(userRegistrationData, citizenData, deathInfoData, adminRegistrationData);
        Allure.step("Проверяем тип и статус зарегистрированной заявки -> Регистрация смерти", () -> {
            AdminTablePage table = new AdminTablePage();
            AdminTableRowElement order = table.findByNumber(orderNumber);
            Assert.assertEquals(order.getType(), "Получение свидетельства о смерти");
            logger.info("Проверен тип заявки -> {}", order.getType());
            Assert.assertEquals(order.getStatus(), "На рассмотрении");
            logger.info("Проверен статус заявки -> {}", order.getStatus());
        });
    }

    @Test(description = "Проверка недоступности кнопки 'Отправить' при формировании документа")
    @Description("Проверка, что если поля заявки на формирование документа не заполнены, кнопка 'Отправить' будет недоступной")
    @Step("Проверка недоступности кнопки Отправить")
    public void submitButtonIsDisabledForEmptyForm() {
        Allure.step("Входим чтобы заказать справку. Нажимаем кнопку -> Заказать справку", () -> {
            MainPage mainPage = new MainPage();
            mainPage.clickOrderCertificate();
            logger.info("Вошли в форму -> Заявка на формирование документа");
        });
        Allure.step("Проверяем, что кнопка Отправить недоступна", () -> {
            ApplicationFormPage applicationFormPage = new ApplicationFormPage();
            Assert.assertFalse(applicationFormPage.isSubmitEnabled());
            logger.info("Проверено: кнопка недоступна");
        });
    }

    @Test(description = "Проверка доступности кнопки 'Отправить' при формировании документа")
    @Description("Проверка, что если поля заявки на формирование документа заполнены, кнопка 'Отправить' будет доступной")
    @Step("Проверка доступности кнопки Отправить")
    public void submitButtonIsEnabledForValidData() {
        Allure.step("Входим чтобы заказать справку. Нажимаем кнопку -> Заказать справку", () -> {
            MainPage mainPage = new MainPage();
            mainPage.clickOrderCertificate();
            logger.info("Вошли в форму -> Заявка на формирование документа");
        });
        Allure.step("Заполняем заявку для справки. Проверяем, что кнопка Отправить доступна", () -> {
            ApplicationFormData applicationFormData = new ApplicationFormData("Иванов", "Иван", "ivanov@example.com", "12345");
            ApplicationFormPage applicationFormPage = new ApplicationFormPage();
            applicationFormPage.fillForm(applicationFormData);
            Assert.assertTrue(applicationFormPage.isSubmitEnabled());
            logger.info("Проверено: кнопка доступна");
        });
    }
}
