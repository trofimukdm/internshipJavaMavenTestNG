package pages;

import data.UserRegistrationData;
import org.openqa.selenium.By;

public class UserRegistrationPage extends BasePage {

    public UserRegistrationPage() {
        super();
    }

    private final By applicantLastName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Фамилия']/@for]");
    private final By applicantFirstName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Имя']/@for]");
    private final By applicantMiddleName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Отчество']/@for]");
    private final By applicantPhone = By.xpath("//input[@id = //label[normalize-space(text()) = 'Телефон']/@for]");
    private final By applicantPassport = By.xpath("//input[@id = //label[normalize-space(text()) = 'Номер паспорта']/@for]");
    private final By applicantAddress = By.xpath("//input[@id = //label[normalize-space(text()) = 'Адрес прописки']/@for]");
    private final By applicantNextButton = By.xpath("//button[normalize-space(text()) = 'Далее']");

    public void fillUserRegistrationData(UserRegistrationData data) {
        type(applicantLastName, data.getApplicantLastName());
        type(applicantFirstName, data.getApplicantFirstName());
        type(applicantMiddleName, data.getApplicantMiddleName());
        type(applicantPhone, data.getApplicantPhone());
        type(applicantPassport, data.getApplicantPassport());
        type(applicantAddress, data.getApplicantAddress());
    }
    public void clickApplicantNextButton(){
        click(applicantNextButton);
    }
}
