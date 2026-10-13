import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By applicantLastName = By.cssSelector("input[id=\"TextInputField-1\"]");
    By applicantFirstName = By.cssSelector("input[id=\"TextInputField-2\"]");
    By applicantMiddleName = By.cssSelector("input[id=\"TextInputField-3\"]");
    By applicantPhone = By.cssSelector("input[id=\"TextInputField-4\"]");
    By applicantPassport = By.cssSelector("input[id=\"TextInputField-5\"]");
    By applicantAddress = By.cssSelector("input[id=\"TextInputField-6\"]");
    By applicantNextButton = By.xpath("//button[contains(text(), \"Далее\")]");


    public void fillUserData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantLastName)).sendKeys("Иванов");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantFirstName)).sendKeys("Иван");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantMiddleName)).sendKeys("Иванович");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantPhone)).sendKeys("1234567");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantPassport)).sendKeys("123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantAddress)).sendKeys("Минск");
        wait.until(ExpectedConditions.visibilityOfElementLocated(applicantNextButton)).click();
    }

    public UserRegistrationPage() {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
