import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MarriageInfoPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By registrationDate = By.cssSelector("input[id=\"TextInputField-14\"]");
    By newLastName = By.cssSelector("input[id=\"TextInputField-15\"]");
    By spouseLastName = By.cssSelector("input[id=\"TextInputField-16\"]");
    By spouseFirstName = By.cssSelector("input[id=\"TextInputField-17\"]");
    By spouseMiddleName = By.cssSelector("input[id=\"TextInputField-18\"]");
    By spouseBirthDate = By.cssSelector("input[id=\"TextInputField-19\"]");
    By spousePassport = By.cssSelector("input[id=\"TextInputField-20\"]");
    By completeButton = By.xpath("//button[contains(text(), \"Завершить\")]");


    public void fillMarriageInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationDate)).sendKeys("08.08.2008");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newLastName)).sendKeys("Иванова");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spouseLastName)).sendKeys("Сидорова");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spouseFirstName)).sendKeys("Анна");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spouseMiddleName)).sendKeys("Сергеевна");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spouseBirthDate)).sendKeys("01.02.2001");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spousePassport)).sendKeys("123123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeButton)).click();
    }

    public MarriageInfoPage() {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
