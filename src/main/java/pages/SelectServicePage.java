package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectServicePage extends BasePage {

    public SelectServicePage() {
        super();
    }

    private final By marriageSelect =
            By.xpath("//button[normalize-space(text()) = 'Регистрация брака']");

    private final By birthSelect =
            By.xpath("//button[normalize-space(text()) = 'Регистрация рождения']");

    private final By deathSelect =
            By.xpath("//button[normalize-space(text()) = 'Регистрация смерти']");

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
