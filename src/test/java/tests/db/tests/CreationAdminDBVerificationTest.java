package tests.db.tests;

import api.ApiConfig;
import api.ApiSpecs;
import db.DBActions;
import db.DBManager;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.api.data.ApiData;
import tests.api.factory.ApiTestDataFactory;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Проверки создания пользователя через API и добавление данных в БД ")
@Owner("Дмитрий")
public class CreationAdminDBVerificationTest {

    private static final Logger logger = LogManager.getLogger(CreationAdminDBVerificationTest.class);
    private Integer staffId;

    @BeforeClass(description = "Инициализируем конфигурацию API")
    public void setUp() {
        ApiConfig.configure();
        logger.info("API конфигурация инициализирована");
    }

    @AfterClass(alwaysRun = true, description = "Очистка тестовых данных из БД")
    public void tearDown() {
        if (this.staffId != null) {
            DBActions.executeUpdate("DELETE FROM reg_office.staff WHERE staffid = ?;", staffId);
        } else {
            logger.warn("ID для Администратора не был сохранен в контексте. Очистка БД не требуется");
        }
        DBManager.closeConnection();
        logger.info("Очистили данные контекста и закрыли соединение с БД");
    }

    @Test(description = "Создание пользователя Администратор через API и проверка в БД")
    @Description("Проверка регистрации Администратора в системе и контроль создания его сущности в БД")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateAdminAndVerifyInDatabase() {
        ApiData data = ApiTestDataFactory.createAdminUserData();

        this.staffId = given()
                .spec(ApiSpecs.requestWithAuth())
                .body(data)
                .log().ifValidationFails()
                .when()
                .post("/sendAdminRequest")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .body("data.staffid", notNullValue())
                .extract()
                .path("data.staffid");

        logger.info("Регистрируем пользователя Админ через API. Получен ID: {}", staffId);

        verifyAdminInDatabase(staffId, data);
        logger.info("Все данные Админа в БД проверены и совпадают с отправленными!");
    }

    @Step("Проверяем данные Админа в базе данных")
    public void verifyAdminInDatabase(Integer staffId, ApiData data){
        List<Map<String, Object>> dbResult = DBActions.executeQuery("SELECT * FROM reg_office.staff s WHERE s.staffid = ?;", staffId);
        DBActions.attachQueryResult(dbResult);
        Assert.assertEquals(dbResult.size(), 1, "Админ с staffid=" + staffId + " не найден в БД");

        Map<String, Object> adminRecord = dbResult.getFirst();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(adminRecord.get("surname")), data.getPersonalLastName(), "Фамилия в БД не совпадает с отправленной в запросе!");
        softAssert.assertEquals(String.valueOf(adminRecord.get("name")), data.getPersonalFirstName(), "Имя в БД не совпадает с отправленным в запросе!");
        softAssert.assertEquals(String.valueOf(adminRecord.get("middlename")), data.getPersonalMiddleName(), "Отчество в БД не совпадает с отправленным в запросе!");
        softAssert.assertEquals(String.valueOf(adminRecord.get("dateofbirth")), data.getDateofbirth(), "Дата рождения в БД не совпадает с отправленной в запросе!");
        softAssert.assertEquals(String.valueOf(adminRecord.get("passportnumber")), data.getPersonalNumberOfPassport(), "Паспорт в БД не совпадает с отправленным в запросе!");
        softAssert.assertEquals(String.valueOf(adminRecord.get("phonenumber")), data.getPersonalPhoneNumber(), "Телефон в БД не совпадает с отправленным в запросе!");
        softAssert.assertAll();
    }
}
