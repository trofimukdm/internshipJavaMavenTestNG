package tests.ui.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.MyDriverManager;
import utils.ScreenshotUtil;
import utils.TestConfig;

import java.net.URI;
import java.util.function.Predicate;

public abstract class BaseTest {
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeMethod(description = "Открываем браузер, вводим логин/пароль и заходим в приложение")
    public void setUp() {
        logger.info("=== Начало теста ===");
        String expectedHost = URI.create(TestConfig.getBaseUrl()).getHost();
        WebDriver driver = MyDriverManager.getDriver();
        if (driver instanceof HasAuthentication) {
            logger.debug("Настраиваем Basic Auth для драйвера");
            Predicate<URI> hostFilter = uri -> uri.getHost() != null && uri.getHost().equals(expectedHost);
            ((HasAuthentication) driver).register(hostFilter, UsernameAndPassword.of(TestConfig.getUsername(), TestConfig.getPassword()));
        }
        logger.info("Открываем страницу: {}", TestConfig.getBaseUrl());
        driver.get(TestConfig.getBaseUrl());
        logger.info("Страница успешно открыта");
    }

    @AfterMethod(alwaysRun = true, description = "Закрываем браузер")
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Тест '{}' упал с ошибкой: {}",
                    result.getName(),
                    result.getThrowable() != null ? result.getThrowable().getMessage() : "неизвестная ошибка");
            ScreenshotUtil.takeScreenshot();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Тест '{}' успешно завершён", result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Тест '{}' был пропущен", result.getName());
        }
        MyDriverManager.quitDriver();
        logger.info("=== Конец теста ===\n");
    }
}
