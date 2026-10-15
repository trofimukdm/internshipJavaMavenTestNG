package tests;

import data.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.MyDriverManager;
import utils.TestConfig;


public class PagesTests extends BaseTest {

    public PagesTests() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = MyDriverManager.getDriver();
        if (driver instanceof HasAuthentication) {
            ((HasAuthentication) driver).register(
                    UsernameAndPassword.of(TestConfig.getUsername(), TestConfig.getPassword())
            );
        }
        driver.get(TestConfig.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MyDriverManager.quitDriver();
    }

    @Test
    public void checkMarriageRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        performUserRegistrationSteps(userRegistrationData);

        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickMarriageSelect();

        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        performFillCitizenData(citizenData);

        MarriageInfoData marriageInfoData = new MarriageInfoData("08.08.2008", "Иванова", "Сидорова", "Анна", "Сергеевна", "01.02.2001", "123123");
        performFillMarriageInfoData(marriageInfoData);

        ResultPage resultPage = new ResultPage();
        String orderNumber = resultPage.getOrderNumber();

        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");
        performAdminRegistrationSteps(adminRegistrationData);

        AdminTablePage table = new AdminTablePage();
        AdminTableRowElement order = table.findByNumber(orderNumber);
        Assert.assertEquals(order.getType(), "Получение свидетельства о браке");
        Assert.assertEquals(order.getStatus(), "На рассмотрении");
    }

    @Test
    public void checkBirthRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        performUserRegistrationSteps(userRegistrationData);

        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickBirthSelect();

        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        performFillCitizenData(citizenData);

        BirthInfoData birthInfoData = new BirthInfoData("Минск", "Анна", "Иван", "Елена", "Андрей");
        performFillBirthInfoData(birthInfoData);

        ResultPage resultPage = new ResultPage();
        String orderNumber = resultPage.getOrderNumber();

        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");
        performAdminRegistrationSteps(adminRegistrationData);

        AdminTablePage table = new AdminTablePage();
        AdminTableRowElement order = table.findByNumber(orderNumber);
        Assert.assertEquals(order.getType(), "Получение свидетельства о рождении");
        Assert.assertEquals(order.getStatus(), "На рассмотрении");
    }

    @Test
    public void checkDeathRegistration() {
        UserRegistrationData userRegistrationData = new UserRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "Минск");
        performUserRegistrationSteps(userRegistrationData);

        SelectServicePage selectServicePage = new SelectServicePage();
        selectServicePage.clickDeathSelect();

        CitizenData citizenData = new CitizenData("Иванов", "Иван", "Иванович", "01.02.2001", "123123", "Муж", "Минск");
        performFillCitizenData(citizenData);

        DeathInfoData deathInfoData = new DeathInfoData("03.03.2003", "Минск");
        performFillDeathInfoData(deathInfoData);

        ResultPage resultPage = new ResultPage();
        String orderNumber = resultPage.getOrderNumber();

        AdminRegistrationData adminRegistrationData = new AdminRegistrationData("Иванов", "Иван", "Иванович", "1234567", "123123", "01.02.2001");
        performAdminRegistrationSteps(adminRegistrationData);

        AdminTablePage table = new AdminTablePage();
        AdminTableRowElement order = table.findByNumber(orderNumber);
        Assert.assertEquals(order.getType(), "Получение свидетельства о смерти");
        Assert.assertEquals(order.getStatus(), "На рассмотрении");
    }

    @Test
    public void submitButtonIsDisabledForEmptyForm() {
        MainPage mainPage = new MainPage();
        ApplicationFormPage applicationFormPage = new ApplicationFormPage();
        mainPage.clickOrderCertificate();
        Assert.assertFalse(applicationFormPage.isSubmitEnabled());
    }

    @Test
    public void submitButtonIsEnabledForValidData() {
        MainPage mainPage = new MainPage();
        ApplicationFormData applicationFormData = new ApplicationFormData("Иванов", "Иван", "ivanov@example.com", "12345");
        ApplicationFormPage applicationFormPage = new ApplicationFormPage();
        mainPage.clickOrderCertificate();
        applicationFormPage.fillForm(applicationFormData);
        Assert.assertTrue(applicationFormPage.isSubmitEnabled());
    }
}
