package tests.api.tests;

import api.*;
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

@Epic("API тесты")
@Feature("Работа с заявками через API")
@Severity(SeverityLevel.CRITICAL)
@Owner("Дмитрий")
public class MarriageApplicationFullCaseApiTest {

    private static final Logger logger = LogManager.getLogger(MarriageApplicationFullCaseApiTest.class);

    @BeforeClass(description = "Инициализируем конфигурацию API")
    public void setUp() {
        ApiConfig.configure();
        logger.info("API конфигурация инициализирована");
    }

    @AfterClass(description = "Очистка контекста тестов")
    public void tearDown() {
        ApiTestContext.clearApplicationId();
        ApiTestContext.clearStaffId();
        logger.info("Контекст тестов очищен");
    }


    @Test(description = "Создание заявки 'Регистрация брака' через API и сохранение её ID")
    public void createMarriageApplicationTest() {

        ApiData data = ApiTestDataFactory.createMarriageData();
        logger.info("Создаем заявку на регистрацию брака");

        int applicationId = given()
                .spec(ApiSpecs.requestWithAuth())
                .body(data)
                .log().ifValidationFails()
                .when()
                .post("/sendUserRequest")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .extract()
                .path("data.applicationid");

        Assert.assertNotNull(applicationId, "Сервер не вернул ID созданной заявки!");
        ApiTestContext.setApplicationId(applicationId);

        logger.info("Заявка успешно создана. Сохранен ID для следующих тестов: {}", applicationId);
    }

    @Test(description = "Получение заявки по ID через API", dependsOnMethods = "createMarriageApplicationTest")
    public void getApplicationByIdTest() {
        int applicationId = ApiTestContext.getApplicationId();
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

        int staffId = given()
                .spec(ApiSpecs.requestWithAuth())
                .body(data)
                .log().ifValidationFails()
                .when()
                .post("/sendAdminRequest")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .extract()
                .path("data.staffid");

        Assert.assertNotNull(staffId, "Сервер не вернул ID созданного пользователя Админ!");
        ApiTestContext.setStaffId(staffId);

        logger.info("Пользователь Админ создан. Сохранен его ID для следующих тестов: {}", staffId);
    }

    @Test(description = "Одобрение ранее созданной заявки через API", dependsOnMethods = "createAdminUserTest")
    public void approveApplicationByIdTest() {

        Map<String, Object> adminBody = new HashMap<>();
        adminBody.put("applId", ApiTestContext.getApplicationId());
        adminBody.put("staffid", ApiTestContext.getStaffId());
        adminBody.put("action", ApiAction.APPROVED.getValue());

        logger.info("Формируем данные заявки: {} Админом: {}", ApiTestContext.getApplicationId(), ApiTestContext.getStaffId());

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

        logger.info("Заявка с ID: {} успешно одобрена", ApiTestContext.getApplicationId());
    }
}
