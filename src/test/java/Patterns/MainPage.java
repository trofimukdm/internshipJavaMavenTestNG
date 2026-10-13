package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginAsUserButton =
            By.xpath("//*[contains(text(), \"Войти как пользователь\")]");
    private final By loginAsAdminButton =
            By.xpath("//*[contains(text(), \"Войти как администратор\")]");
    private final By orderCertificateButton =
            By.xpath("//*[contains(text(), \"Заказать справку\")]");

    public MainPage () {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginAsUser() {
        wait.until(ExpectedConditions.elementToBeClickable(loginAsUserButton)).click();
    }
    public void clickLoginAsAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginAsAdminButton)).click();
    }
    public void clickOrderCertificate() {
        wait.until(ExpectedConditions.elementToBeClickable(orderCertificateButton)).click();
    }
}
