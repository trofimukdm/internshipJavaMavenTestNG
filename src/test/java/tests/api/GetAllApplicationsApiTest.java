package tests.api;

import api.ApiConfig;
import api.ApiSpecs;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

@Epic("API тесты")
@Feature("Работа с заявками через API")
@Owner("Дмитрий")
public class GetAllApplicationsApiTest {

    private static final Logger logger = LogManager.getLogger(GetAllApplicationsApiTest.class);

    @BeforeMethod(description = "Инициализируем конфигурацию API")
    public void setUp() {
        ApiConfig.configure();
        logger.info("API конфигурация инициализирована");
    }

    @Test(description = "Получение списка всех заявок через API")
    @Severity(SeverityLevel.CRITICAL)
    @Story("API: Получение заявок")
    public void getAllApplicationsTest() {
        logger.info("Отправляем GET запрос для получения списка всех заявок");

        given()
                .spec(ApiSpecs.requestWithAuth())
                .log().all()
                .when()
                .get("/getApplications")
                .then()
                .log().all()
                .spec(ApiSpecs.successResponse())
                .body("size()", greaterThan(0));
        logger.info("Список всех заявок успешно получен");
    }
}
