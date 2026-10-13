import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PagesTests {

    @BeforeMethod
    void setUp() {
        String username = "user";
        String password = "senlatest";
        String host = "regoffice.senla.eu";
        String authUrl = "https://" + username + ":" + password + "@" + host;
        MyDriverManager.getDriver().get(authUrl);

    }

    @Test
    public void checkMarriageRegistration() {
        MainPage mainPage = new MainPage();
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        SelectServicePage selectServicePage = new SelectServicePage();
        CitizenDataPage citizenDataPage = new CitizenDataPage();
        MarriageInfoPage marriageInfoPage = new MarriageInfoPage();
        mainPage.clickLoginAsUser();
        userRegistrationPage.fillUserData();
        selectServicePage.clickMarriageSelect();
        citizenDataPage.fillCitizenData();
        marriageInfoPage.fillMarriageInfo();
        WebElement result = MyDriverManager.getDriver().findElement(By.xpath("//span[contains(text(), 'Спасибо за обращение!')]"));
        Assert.assertEquals(result.getText(), "Спасибо за обращение!");
    }

    @Test
    public void checkBirthRegistration() {
        MainPage mainPage = new MainPage();
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        SelectServicePage selectServicePage = new SelectServicePage();
        CitizenDataPage citizenDataPage = new CitizenDataPage();
        BirthInfoPage birthInfoPage = new BirthInfoPage();
        mainPage.clickLoginAsUser();
        userRegistrationPage.fillUserData();
        selectServicePage.clickBirthSelect();
        citizenDataPage.fillCitizenData();
        birthInfoPage.fillBirthInfo();
        WebElement result = MyDriverManager.getDriver().findElement(By.xpath("//span[contains(text(), 'Спасибо за обращение!')]"));
        Assert.assertEquals(result.getText(), "Спасибо за обращение!");
    }

    @Test
    public void checkDeathRegistration() {
        MainPage mainPage = new MainPage();
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage();
        SelectServicePage selectServicePage = new SelectServicePage();
        CitizenDataPage citizenDataPage = new CitizenDataPage();
        DeathInfoPage deathInfoPage = new DeathInfoPage();
        mainPage.clickLoginAsUser();
        userRegistrationPage.fillUserData();
        selectServicePage.clickDeathSelect();
        citizenDataPage.fillCitizenData();
        deathInfoPage.fillDeathInfo();
        WebElement result = MyDriverManager.getDriver().findElement(By.xpath("//span[contains(text(), 'Спасибо за обращение!')]"));
        Assert.assertEquals(result.getText(), "Спасибо за обращение!");
    }

    @Test(enabled = false)
    public void checkOrderNumberTypeStatus() {
        MainPage mainPage = new MainPage();
        AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
        AdminTable table = new AdminTable();

        mainPage.clickLoginAsAdmin();
        adminRegistrationPage.fillAdminData();
        AdminTableRow order = table.findByNumber("71540");

        Assert.assertEquals(order.getNumber(), "71540");
        Assert.assertEquals(order.getType(), "Получение свидетельства о браке");
        Assert.assertEquals(order.getStatus(), "На рассмотрении");

    }

    @Test
    public void checkLatestOrderStatus() {
        MainPage mainPage = new MainPage();
        AdminRegistrationPage adminRegistrationPage = new AdminRegistrationPage();
        AdminTable table = new AdminTable();

        mainPage.clickLoginAsAdmin();
        adminRegistrationPage.fillAdminData();
        AdminTableRow latestAdminTableRow = table.getLatestAdminTableRow();
        Assert.assertEquals(latestAdminTableRow.getStatus(), "На рассмотрении", "Статус последней заявки не соответствует ожидаемому");
    }

    @Test
    public void submitButtonIsDisabledForEmptyForm() {
        MainPage mainPage = new MainPage();
        ApplicationFormPage form = new ApplicationFormPage();
        mainPage.clickOrderCertificate();
        Assert.assertFalse(form.isSubmitEnabled());
    }

    @Test
    public void submitButtonIsEnabledForValidData() {
        MainPage mainPage = new MainPage();
        ApplicationData data = new ApplicationData("Иванов", "Иван", "ivanov@example.com", "12345");
        ApplicationFormPage form = new ApplicationFormPage();
        mainPage.clickOrderCertificate();
        form.fillForm(data);
        Assert.assertTrue(form.isSubmitEnabled());
    }

    @AfterMethod
    void tearDown() {
        MyDriverManager.quitDriver();
    }
}
