package pages;

import data.UserRegistrationData;
import org.openqa.selenium.By;

public class UserRegistrationPage extends BasePage {

    public UserRegistrationPage() {
        super();
    }

    private final By applicantLastName = By.xpath("//input[@id = //label[contains(., 'Фамилия')]/@for]");
    private final By applicantFirstName = By.xpath("//input[@id = //label[contains(., 'Имя')]/@for]");
    private final By applicantMiddleName = By.xpath("//input[@id = //label[contains(., 'Отчество')]/@for]");
    private final By applicantPhone = By.xpath("//input[@id = //label[contains(., 'Телефон')]/@for]");
    private final By applicantPassport = By.xpath("//input[@id = //label[contains(., 'Номер паспорта')]/@for]");
    private final By applicantAddress = By.xpath("//input[@id = //label[contains(., 'Адрес прописки')]/@for]");
    private final By applicantNextButton = By.xpath("//button[contains(text(), 'Далее')]");

    public void fillUserRegistrationData(UserRegistrationData data) {
        type(applicantLastName, data.getApplicantLastName());
        type(applicantFirstName, data.getApplicantFirstName());
        type(applicantMiddleName, data.getApplicantMiddleName());
        type(applicantPhone, data.getApplicantPhone());
        type(applicantPassport, data.getApplicantPassport());
        type(applicantAddress, data.getApplicantAddress());
        click(applicantNextButton);
    }
}
