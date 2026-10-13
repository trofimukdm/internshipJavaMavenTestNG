package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeathInfoPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    By deathDate = By.cssSelector("input[id=\"TextInputField-14\"]");
    By deathPlace = By.cssSelector("input[id=\"TextInputField-15\"]");
    By completeButton = By.xpath("//button[contains(text(), \"Завершить\")]");

    void fillDeathInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deathDate)).sendKeys("03.03.2003");
        wait.until(ExpectedConditions.visibilityOfElementLocated(deathPlace)).sendKeys("Минск");
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeButton)).click();
    }

    public DeathInfoPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
