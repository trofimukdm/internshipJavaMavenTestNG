import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectServicePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By marriageSelect =
            By.xpath("//button[contains(text(), \"Регистрация брака\")]");

    private final By birthSelect =
            By.xpath("//button[contains(text(), \"Регистрация рождения\")]");

    private final By deathSelect =
            By.xpath("//button[contains(text(), \"Регистрация смерти\")]");

    public SelectServicePage () {
        this.driver = MyDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMarriageSelect() {
        wait.until(ExpectedConditions.elementToBeClickable(marriageSelect)).click();
    }

    public void clickBirthSelect() {
        wait.until(ExpectedConditions.elementToBeClickable(birthSelect)).click();
    }

    public void clickDeathSelect() {
        wait.until(ExpectedConditions.elementToBeClickable(deathSelect)).click();
    }
}
