package pages;

import data.DeathInfoData;
import org.openqa.selenium.By;

public class DeathInfoPage extends BasePage {

    public DeathInfoPage() {
        super();
    }

    private final By deathDate = By.xpath("//input[@id = //label[contains(., 'Дата смерти')]/@for]");
    private final By deathPlace = By.xpath("//input[@id = //label[contains(., 'Место смерти')]/@for]");
    private final By completeButton = By.xpath("//button[contains(text(), 'Завершить')]");

    public void fillDeathInfo(DeathInfoData data) {
        type(deathDate, data.getDeathDate());
        type(deathPlace, data.getDeathPlace());
        click(completeButton);
    }
}
