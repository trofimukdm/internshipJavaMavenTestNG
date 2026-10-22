package pageModel;

import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultPage extends BasePage {

    public ResultPage() {
        super();
    }

    private final By successMessageLocator = By.xpath("//span[starts-with(normalize-space(.), 'Ваша заявка №')" + " and contains(normalize-space(.), 'отправлена на рассмотрение')]");
    private final By finishButton = By.xpath("//button[normalize-space(text()) = 'Закрыть']");

    public String getOrderNumber() {
        wait.until(driver -> {
            String text = driver.findElement(successMessageLocator).getText();
            return text.matches(".*\\d+.*") && !text.contains("null");
        });
        String requestText = driver.findElement(successMessageLocator).getText();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(requestText);
        String requestNumber = "";
        if (matcher.find()) {
            String matchedText = matcher.group();
            requestNumber = (matchedText != null && !matchedText.isEmpty()) ? matchedText : "";
        }
        return requestNumber;
    }
    public void clickFinishButton() {
        click(finishButton);
    }
}
