package pages;

import data.BirthInfoData;
import org.openqa.selenium.By;

public class BirthInfoPage extends BasePage {

    public BirthInfoPage() {
        super();
    }

    private final By placeOfBirth = By.xpath("//input[@id = //label[contains(., 'Место рождения')]/@for]");
    private final By mother = By.xpath("//input[@id = //label[contains(., 'Мать')]/@for]");
    private final By father = By.xpath("//input[@id = //label[contains(., 'Отец')]/@for]");
    private final By grandmother = By.xpath("//input[@id = //label[contains(., 'Бабушка')]/@for]");
    private final By grandfather = By.xpath("//input[@id = //label[contains(., 'Дедушка')]/@for]");
    private final By completeButton = By.xpath("//button[contains(text(), 'Завершить')]");

    public void fillBirthInfo(BirthInfoData data) {
        type(placeOfBirth, data.getPlaceOfBirth());
        type(mother, data.getMother());
        type(father, data.getFather());
        type(grandmother, data.getGrandmother());
        type(grandfather, data.getGrandfather());
        click(completeButton);
    }
}
