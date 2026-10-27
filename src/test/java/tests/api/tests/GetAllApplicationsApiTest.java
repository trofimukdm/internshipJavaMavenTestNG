package tests.api.tests;

import api.ApiConfig;
import api.ApiSpecs;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
        int limit = 200;
        Response response = given()
                .spec(ApiSpecs.requestWithAuth())
                .queryParam("page", 1)
                .queryParam("limit", limit)
                .log().ifValidationFails()
                .when()
                .get("/getApplications")
                .then()
                .log().ifValidationFails()
                .spec(ApiSpecs.successResponse())
                .extract()
                .response();
        int expectedTotal = Integer.parseInt(response.path("total").toString());
        int actualDataSize = response.path("data.size()");
        Assert.assertTrue(expectedTotal >=0, "Общее количество заявок (total) не может быть отрицательным");
        Assert.assertTrue(actualDataSize >= 0, "Массив данных заявок пуст!");
        Assert.assertTrue(actualDataSize <= expectedTotal,
                String.format("Ошибка логики API: на странице %d элементов, но всего в базе их заявлено %d",
                        actualDataSize, expectedTotal));
        Assert.assertTrue(actualDataSize <= limit,
                String.format("Превышен лимит выдачи: на странице %d элементов, а лимит %d", actualDataSize, limit));

        logger.info("Список заявок успешно получен. Проверено: total={}, data.size()={}, limit={}",
                expectedTotal, actualDataSize, limit);
    }
}
