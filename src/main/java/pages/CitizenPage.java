package pages;

import data.CitizenData;
import org.openqa.selenium.By;

public class CitizenPage extends BasePage {

    public CitizenPage() {
        super();
    }

    private final By citizenLastName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Фамилия']/@for]");
    private final By citizenFirstName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Имя']/@for]");
    private final By citizenMiddleName = By.xpath("//input[@id = //label[normalize-space(text()) = 'Отчество']/@for]");
    private final By citizenBirthDate = By.xpath("//input[@id = //label[normalize-space(text()) = 'Дата рождения']/@for]");
    private final By citizenPassport = By.xpath("//input[@id = //label[normalize-space(text()) = 'Номер паспорта']/@for]");
    private final By citizenGender = By.xpath("//input[@id = //label[normalize-space(text()) = 'Пол']/@for]");
    private final By citizenAddress = By.xpath("//input[@id = //label[normalize-space(text()) = 'Адрес прописки']/@for]");
    private final By citizenNextButton = By.xpath("//button[normalize-space(text()) = 'Далее']");


    public void fillCitizenData(CitizenData data) {
        type(citizenLastName, data.getCitizenLastName());
        type(citizenFirstName, data.getCitizenFirstName());
        type(citizenMiddleName, data.getCitizenMiddleName());
        type(citizenBirthDate, data.getCitizenBirthDate());
        type(citizenPassport, data.getCitizenPassport());
        type(citizenGender, data.getCitizenGender());
        type(citizenAddress, data.getCitizenAddress());
    }
    public void clickCitizenNextButton(){
        click(citizenNextButton);
    }
}
