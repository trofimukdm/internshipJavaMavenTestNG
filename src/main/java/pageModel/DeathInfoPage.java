package pageModel;

import dataModel.DeathInfoData;
import org.openqa.selenium.By;

public class DeathInfoPage extends BasePage {

    public DeathInfoPage() {
        super();
    }

    private final By deathDate = By.xpath("//input[@id = //label[normalize-space(text()) = 'Дата смерти']/@for]");
    private final By deathPlace = By.xpath("//input[@id = //label[normalize-space(text()) = 'Место смерти']/@for]");
    private final By completeButton = By.xpath("//button[normalize-space(text()) = 'Завершить']");

    public void fillDeathInfo(DeathInfoData data) {
        type(deathDate, data.getDeathDate());
        type(deathPlace, data.getDeathPlace());
    }
    public void clickCompleteButton(){
        click(completeButton);
    }
}
