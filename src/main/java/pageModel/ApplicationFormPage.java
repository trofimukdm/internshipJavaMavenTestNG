package pageModel;

import dataModel.ApplicationFormData;
import org.openqa.selenium.By;

public class ApplicationFormPage extends BasePage {

    private final By lastNameInput = By.xpath("//input[@id = //label[normalize-space(text()) = 'Фамилия']/@for]");
    private final By firstNameInput = By.xpath("//input[@id = //label[normalize-space(text()) = 'Имя']/@for]");
    private final By emailInput = By.xpath("//input[@id = //label[normalize-space(text()) = 'Электронная почта']/@for]");
    private final By requestNumberInput = By.xpath("//input[@id = //label[normalize-space(text()) = 'Номер заявки']/@for]");
    private final By submitButton = By.xpath("//button[normalize-space(text()) = 'Отправить']");

    public ApplicationFormPage() {
        super();
    }

    public void fillForm(ApplicationFormData data) {
        type(lastNameInput, data.getLastName());
        type(firstNameInput, data.getFirstName());
        type(emailInput, data.getEmail());
        type(requestNumberInput, data.getRequestNumber());
    }

    public boolean isSubmitEnabled() {
        return driver.findElement(submitButton).isEnabled();
    }
}
