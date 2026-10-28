package tests.ui.tests;

import data.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.AdminSteps;
import steps.RegistrationSteps;
import enums.ApplicationStatus;
import enums.ApplicationType;
import tests.ui.dataprovider.MyDataProvider;
import utils.TestDataFactory;

@Epic("Регистрация заявок на портале")
@Feature("Проверки регистрации всех видов заявок")
@Owner("Дмитрий")
public class RegistrationTests extends BaseTest {

    public RegistrationTests() {
        super();
    }

    private final RegistrationSteps registrationSteps = new RegistrationSteps();
    private final AdminSteps adminSteps = new AdminSteps();

    @Test(dataProvider = "registrationCaseData", dataProviderClass = MyDataProvider.class, description = "Проверка регистрации услуги")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Автотест для сценариев регистрации заявок")
    public void checkRegistrationFlow(ServiceInfoData serviceInfoData, ApplicationType applicationType) {
        UserRegistrationData userData = TestDataFactory.getDefaultUser();
        CitizenData citizenData = TestDataFactory.getDefaultCitizen();
        AdminRegistrationData adminData = TestDataFactory.getDefaultAdmin();

        String orderNumber = registrationSteps.submitApplication(userData, citizenData, serviceInfoData);

        adminSteps.loginAsAdmin(adminData);

        assertOrder(orderNumber, applicationType);
    }

    @Step("Проверка типа и статуса заявки")
    private void assertOrder(String orderNumber, ApplicationType applicationType) {
        AdminTablePage table = new AdminTablePage();
        AdminTableRowElement order = table.findByNumber(orderNumber);

        Assert.assertEquals(order.getType(), applicationType.getValue(), "Тип заявки не совпадает с ожидаемым");
        Assert.assertEquals(order.getStatus(), ApplicationStatus.UNDER_REVIEW.getValue(), "Статус заявки не совпадает с ожидаемым");
        logger.info("Успешно проверен тип '{}' и статус '{}' для заявки №{}", order.getType(), order.getStatus(), orderNumber);
    }
}
