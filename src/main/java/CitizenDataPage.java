import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitizenDataPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By citizenLastName = By.cssSelector("input[id=\"TextInputField-7\"]");
    By citizenFirstName = By.cssSelector("input[id=\"TextInputField-8\"]");
    By citizenMiddleName = By.cssSelector("input[id=\"TextInputField-9\"]");
    By citizenBirthDate = By.cssSelector("input[id=\"TextInputField-10\"]");
    By citizenPassport = By.cssSelector("input[id=\"TextInputField-11\"]");
    By citizenGender = By.cssSelector("input[id=\"TextInputField-12\"]");
    By citizenAddress = By.cssSelector("input[id=\"TextInputField-13\"]");
    By citizenNextButton = By.xpath("//button[contains(text(), \"Далее\")]");


    public void fillCitizenData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenLastName)).sendKeys("Иванов");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenFirstName)).sendKeys("Иван");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenMiddleName)).sendKeys("Иванович");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenBirthDate)).sendKeys("01.02.2001");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenPassport)).sendKeys("123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenGender)).sendKeys("Муж");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenAddress)).sendKeys("Минск");
        wait.until(ExpectedConditions.visibilityOfElementLocated(citizenNextButton)).click();
    }

    public CitizenDataPage() {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
