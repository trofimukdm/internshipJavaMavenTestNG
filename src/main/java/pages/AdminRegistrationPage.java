package pages;

import data.AdminRegistrationData;
import org.openqa.selenium.By;

public class AdminRegistrationPage extends BasePage {

    public AdminRegistrationPage() {
        super();
    }

    private final By adminLastName = By.xpath("//input[@id = //label[contains(., 'Фамилия')]/@for]");
    private final By adminFirstName = By.xpath("//input[@id = //label[contains(., 'Имя')]/@for]");
    private final By adminMiddleName = By.xpath("//input[@id = //label[contains(., 'Отчество')]/@for]");
    private final By adminPhone = By.xpath("//input[@id = //label[contains(., 'Телефон')]/@for]");
    private final By adminPassport = By.xpath("//input[@id = //label[contains(., 'Номер паспорта')]/@for]");
    private final By adminBirthday = By.xpath("//input[@id = //label[contains(., 'Дата рождения')]/@for]");
    private final By adminNextButton = By.xpath("//button[contains(text(), 'Далее')]");

    public void fillAdminData(AdminRegistrationData data) {
        type(adminLastName, data.getAdminLastName());
        type(adminFirstName, data.getAdminFirstName());
        type(adminMiddleName, data.getAdminMiddleName());
        type(adminPhone, data.getAdminPhone());
        type(adminPassport, data.getAdminPassport());
        type(adminBirthday, data.getAdminBirthday());
        click(adminNextButton);
    }
}
