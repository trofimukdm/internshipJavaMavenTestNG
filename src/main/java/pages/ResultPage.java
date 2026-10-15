package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {

    public ResultPage() {
        super();
    }

    private final By successMessageLocator = By.xpath("//span[contains(normalize-space(.), 'Ваша заявка')]");
    private final By finishButton = By.xpath("//button[contains(text(), 'Закрыть')]");

    public String getOrderNumber() {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(successMessageLocator, "null")));
        String requestText = driver.findElement(successMessageLocator).getText();
        String requestNumber = requestText.replaceAll("\\D+", "");
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        return requestNumber;
    }
}
