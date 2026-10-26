package tests;

import data.ApplicationFormData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApplicationFormPage;
import pages.MainPage;

@Epic("Регистрация заявок на формирование документов")
@Feature("Проверки запросов на формирование справок")
@Owner("Дмитрий")
public class RequestDocumentTests extends BaseTest {
    public RequestDocumentTests() {
        super();
    }

    @Test(description = "Проверка недоступности кнопки -> 'Отправить' при формировании документа")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка, что если поля заявки на формирование документа не заполнены, кнопка -> 'Отправить' будет недоступной")
    public void submitButtonIsDisabledForEmptyForm() {
        MainPage mainPage = new MainPage();
        mainPage.clickOrderCertificate();
        logger.info("Вошли в форму -> Заявка на формирование документа");

        ApplicationFormPage applicationFormPage = new ApplicationFormPage();
        Assert.assertFalse(applicationFormPage.isSubmitEnabled());
        logger.info("Проверено: кнопка недоступна");
    }

    @Test(description = "Проверка доступности кнопки -> 'Отправить' при формировании документа")
    @Description("Проверка, что если поля заявки на формирование документа заполнены, кнопка -> 'Отправить' будет доступной")
    public void submitButtonIsEnabledForValidData() {
        MainPage mainPage = new MainPage();
        mainPage.clickOrderCertificate();
        logger.info("Вошли в форму -> Заявка на формирование документа");

        ApplicationFormData applicationFormData = new ApplicationFormData("Иванов", "Иван", "ivanov@example.com", "12345");
        ApplicationFormPage applicationFormPage = new ApplicationFormPage();
        applicationFormPage.fillForm(applicationFormData);
        Assert.assertTrue(applicationFormPage.isSubmitEnabled());
        logger.info("Проверено: кнопка доступна");
    }
}
