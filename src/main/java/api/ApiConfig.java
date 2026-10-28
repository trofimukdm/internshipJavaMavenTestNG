package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import utils.TestConfig;

public class ApiConfig {
    public static void configure() {
        RestAssured.baseURI = TestConfig.getBaseUrl();
        RestAssured.filters(new AllureRestAssured());
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(
                        HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 10000)
                                .setParam("http.socket.timeout", 15000)
                );
    }
}
