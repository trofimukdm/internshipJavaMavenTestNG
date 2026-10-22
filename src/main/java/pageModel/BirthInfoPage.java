package pageModel;

import dataModel.BirthInfoData;
import org.openqa.selenium.By;

public class BirthInfoPage extends BasePage {

    public BirthInfoPage() {
        super();
    }

    private final By placeOfBirth = By.xpath("//input[@id = //label[normalize-space(text()) = 'Место рождения']/@for]");
    private final By mother = By.xpath("//input[@id = //label[normalize-space(text()) = 'Мать']/@for]");
    private final By father = By.xpath("//input[@id = //label[normalize-space(text()) = 'Отец']/@for]");
    private final By grandmother = By.xpath("//input[@id = //label[normalize-space(text()) = 'Бабушка']/@for]");
    private final By grandfather = By.xpath("//input[@id = //label[normalize-space(text()) = 'Дедушка']/@for]");
    private final By completeButton = By.xpath("//button[normalize-space(text()) = 'Завершить']");

    public void fillBirthInfo(BirthInfoData data) {
        type(placeOfBirth, data.getPlaceOfBirth());
        type(mother, data.getMother());
        type(father, data.getFather());
        type(grandmother, data.getGrandmother());
        type(grandfather, data.getGrandfather());
    }
    public void clickCompleteButton(){
        click(completeButton);
    }
}
