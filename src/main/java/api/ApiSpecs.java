package api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.TestConfig;

public class ApiSpecs {
    @Step("Формируем и отправляем API запрос")
    public static RequestSpecification requestWithAuth() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Basic " + getBase64Auth())
                .setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .addFilter(new AllureRestAssured())
                .build();
    }

    @Step("Проверяем ответ API запроса")
    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    private static String getBase64Auth() {
        String credentials = TestConfig.getUsername() + ":" + TestConfig.getPassword();
        return java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
