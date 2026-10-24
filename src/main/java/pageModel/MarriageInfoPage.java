package pageModel;

import dataModel.MarriageInfoData;
import org.openqa.selenium.By;

public class MarriageInfoPage extends BasePage {

    public MarriageInfoPage() {
        super();
    }

    private final By registrationDate = By.xpath("//input[@id = //label[normalize-space(text()) = 'Дата регистрации']/@for]");
    private final By newLastName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Новая фамилия']/@for]");
    private final By spouseLastName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Фамилия супруга/и']/@for]");
    private final By spouseFirstName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Имя супруга/и']/@for]");
    private final By spouseMiddleName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Отчество супруга/и']/@for]");
    private final By spouseBirthDate = By.xpath("//input[@id = //label[normalize-space(text()) = 'Дата рождения супруга/и']/@for]");
    private final By spousePassport = By.xpath("//input[@id = //label[normalize-space(text()) = 'Номер паспорта супруга/и']/@for]");
    private final By completeButton = By.xpath("//button[normalize-space(text()) = 'Завершить']");

    public void fillMarriageInfo(MarriageInfoData data) {
        type(registrationDate, data.getRegistrationDate());
        type(newLastName, data.getNewLastName());
        type(spouseLastName, data.getSpouseLastName());
        type(spouseFirstName, data.getSpouseFirstName());
        type(spouseMiddleName, data.getSpouseMiddleName());
        type(spouseBirthDate, data.getSpouseBirthDate());
        type(spousePassport, data.getSpousePassport());
    }
    public void clickCompleteButton(){
        click(completeButton);
    }
}
