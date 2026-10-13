import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationFormPage {

    private final By lastNameInput = By.cssSelector("input[id=\"TextInputField-1\"]");
    private final By firstNameInput = By.cssSelector("input[id=\"TextInputField-2\"]");
    private final By emailInput = By.cssSelector("input[id=\"TextInputField-3\"]");
    private final By requestNumberInput = By.cssSelector("input[id=\"TextInputField-4\"]");
    private final By submitButton = By.xpath("//button[contains(text(), \"Отправить\")]");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ApplicationFormPage() {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm(ApplicationData data) {
        typeText(lastNameInput, data.getLastName());
        typeText(firstNameInput, data.getFirstName());
        typeText(emailInput, data.getEmail());
        typeText(requestNumberInput, data.getRequestNumber());
    }

    public boolean isSubmitEnabled() {
        return driver.findElement(submitButton).isEnabled();
    }

    private void typeText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
}
