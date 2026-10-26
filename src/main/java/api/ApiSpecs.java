package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.TestConfig;

public class ApiSpecs {
    @Step("Формируем и отправляем запрос")
    public static RequestSpecification requestWithAuth() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Basic " + getBase64Auth())
                .build();
    }

    @Step("Проверяем ответ запроса")
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
