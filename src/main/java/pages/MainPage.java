package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage() {
        super();
    }

    private final By loginAsUserButton =
            By.xpath("//button[contains(text(), 'Войти как пользователь')]");
    private final By loginAsAdminButton =
            By.xpath("//button[contains(text(), 'Войти как администратор')]");
    private final By orderCertificateButton =
            By.xpath("//button[contains(text(), 'Заказать справку')]");

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
