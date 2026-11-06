package tests.api.tests;

import api.*;
import db.DBActions;
import db.DBManager;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.api.data.ApiData;
import tests.api.factory.ApiTestDataFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API тесты")
@Feature("Работа с заявками через API")
@Severity(SeverityLevel.CRITICAL)
@Owner("Дмитрий")
public class MarriageApplicationFullCaseApiTest {

    private static final Logger logger = LogManager.getLogger(MarriageApplicationFullCaseApiTest.class);

    private Integer staffId;
    private Integer applicationId;

    @BeforeClass(description = "Инициализируем конфигурацию API")
    public void setUp() {
        ApiConfig.configure();
        logger.info("API конфигурация инициализирована");
    }

    @AfterClass(description = "Очистка контекста тестов")
    public void tearDown() {
        if (this.applicationId != null) {
            logger.info("Очищаем тестовые данные: удаляем заявку с ID {}", this.applicationId);
            int deletedApps = DBActions.executeUpdate("DELETE FROM reg_office.applications WHERE applicationid = ?;", this.applicationId);

            Assert.assertEquals(deletedApps, 1,
                    String.format("Не удалось удалить заявку с ID %d. Затронуто строк: %d", this.applicationId, deletedApps));
        }

        if (this.staffId != null) {
            logger.info("Очищаем тестовые данные: удаляем админа с ID {}", this.staffId);
            int deletedStaff = DBActions.executeUpdate("DELETE FROM reg_office.staff WHERE staffid = ?;", this.staffId);

            Assert.assertEquals(deletedStaff, 1,
                    String.format("Не удалось удалить админа с ID %d. Затронуто строк: %d", this.staffId, deletedStaff));
        }

        if (this.applicationId == null && this.staffId == null) {
            logger.warn("Тестовые данные не были созданы. Очистка БД не требуется");
        }
        DBManager.closeConnection();
        logger.info("Соединение с БД закрыто, тестовые данные очищены");
    }

    @Test(description = "Создание заявки 'Регистрация брака' через API и сохранение её ID")
    public void createMarriageApplicationTest() {
        ApiData data = ApiTestDataFactory.createMarriageData();
        logger.info("Создаем заявку на регистрацию брака");

        this.applicationId = given()
                .spec(ApiSpecs.requestWithAuth())
                .body(data)
                .log().ifValidationFails()
                .when()
                .post("/sendUserRequest")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .body("data.applicationid", notNullValue())
                .extract()
                .path("data.applicationid");

        logger.info("Заявка успешно создана. Сохранен ID для следующих тестов: {}", applicationId);
    }

    @Test(description = "Получение заявки по ID через API", dependsOnMethods = "createMarriageApplicationTest")
    public void getApplicationByIdTest() {
        logger.info("Запрашиваем данные для заявки с ID: {}", applicationId);

        given()
                .spec(ApiSpecs.requestWithAuth())
                .log().ifValidationFails()
                .when()
                .pathParam("id", applicationId)
                .get("/getApplStatus/{id}")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .body("data.kindofapplication", equalTo("Получение свидетельства о браке"))
                .body("data.statusofapplication", equalTo("under consideration"));

        logger.info("Данные заявки успешно получены и проверены");
    }

    @Test(description = "Создание пользователя Администратор через API и сохранение его ID", dependsOnMethods = "getApplicationByIdTest")
    public void createAdminUserTest() {
        ApiData data = ApiTestDataFactory.createAdminUserData();
        logger.info("Регистрируем пользователя Администратор");

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

        logger.info("Пользователь Админ создан. Сохранен его ID для следующих тестов: {}", staffId);
    }

    @Test(description = "Одобрение ранее созданной заявки через API", dependsOnMethods = "createAdminUserTest")
    public void approveApplicationByIdTest() {

        Map<String, Object> adminBody = new HashMap<>();
        adminBody.put("applId", this.applicationId);
        adminBody.put("staffid", this.staffId);
        adminBody.put("action", ApiAction.APPROVED.getValue());
        logger.info("Формируем данные заявки: {} Админом: {}", this.applicationId, this.staffId);

        given()
                .spec(ApiSpecs.requestWithAuth())
                .body(adminBody)
                .log().ifValidationFails()
                .when()
                .post("/requestProcess")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .body("data.statusofapplication", equalTo("approved"))
                .body("data.kindofapplication", equalTo("Получение свидетельства о браке"));

        logger.info("Заявка с ID: {} успешно одобрена", this.applicationId);
    }
}
