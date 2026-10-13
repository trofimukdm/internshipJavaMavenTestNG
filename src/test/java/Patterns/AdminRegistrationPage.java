package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminRegistrationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By adminLastName = By.cssSelector("input[id=\"TextInputField-1\"]");
    By adminFirstName = By.cssSelector("input[id=\"TextInputField-2\"]");
    By adminMiddleName = By.cssSelector("input[id=\"TextInputField-3\"]");
    By adminPhone = By.cssSelector("input[id=\"TextInputField-4\"]");
    By adminPassport = By.cssSelector("input[id=\"TextInputField-5\"]");
    By adminBirthday = By.cssSelector("input[id=\"TextInputField-6\"]");
    By adminNextButton = By.xpath("//button[contains(text(), \"Далее\")]");


    void fillAdminData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminLastName)).sendKeys("Иванов");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminFirstName)).sendKeys("Иван");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminMiddleName)).sendKeys("Иванович");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPhone)).sendKeys("1234567");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPassport)).sendKeys("123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminBirthday)).sendKeys("01.02.2001");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminNextButton)).click();
    }

    public AdminRegistrationPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
