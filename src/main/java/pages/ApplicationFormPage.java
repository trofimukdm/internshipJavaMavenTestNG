package pages;

import data.ApplicationFormData;
import org.openqa.selenium.By;

public class ApplicationFormPage extends BasePage {

    private final By lastNameInput = By.xpath("//input[@id = //label[contains(., 'Фамилия')]/@for]");
    private final By firstNameInput = By.xpath("//input[@id = //label[contains(., 'Имя')]/@for]");
    private final By emailInput = By.xpath("//input[@id = //label[contains(., 'Электронная почта')]/@for]");
    private final By requestNumberInput = By.xpath("//input[@id = //label[contains(., 'Номер заявки')]/@for]");
    private final By submitButton = By.xpath("//button[contains(text(), 'Отправить')]");

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
