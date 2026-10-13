import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BirthInfoPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By placeOfBirth = By.cssSelector("input[id=\"TextInputField-14\"]");
    By mother = By.cssSelector("input[id=\"TextInputField-15\"]");
    By father = By.cssSelector("input[id=\"TextInputField-16\"]");
    By grandmother = By.cssSelector("input[id=\"TextInputField-17\"]");
    By grandfather = By.cssSelector("input[id=\"TextInputField-18\"]");
    By completeButton = By.xpath("//button[contains(text(), \"Завершить\")]");

    public void fillBirthInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOfBirth)).sendKeys("Минск");
        wait.until(ExpectedConditions.visibilityOfElementLocated(mother)).sendKeys("Анна");
        wait.until(ExpectedConditions.visibilityOfElementLocated(father)).sendKeys("Иван");
        wait.until(ExpectedConditions.visibilityOfElementLocated(grandmother)).sendKeys("Елена");
        wait.until(ExpectedConditions.visibilityOfElementLocated(grandfather)).sendKeys("Андрей");
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeButton)).click();
    }

    public BirthInfoPage() {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
