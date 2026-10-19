package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriverManager {

    private static final Logger logger = LogManager.getLogger(MyDriverManager.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private MyDriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            logger.info("Создаём новый экземпляр ChromeDriver");
            WebDriver newDriver = new ChromeDriver();
            newDriver.manage().window().maximize();
            driver.set(newDriver);
            logger.debug("ChromeDriver успешно создан и максимизирован");
        } else {
            logger.debug("Используем существующий ChromeDriver");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            logger.info("Закрываем ChromeDriver");
            driver.get().quit();
            driver.remove();
            logger.debug("ChromeDriver успешно закрыт и удалён из ThreadLocal");
        } else {
            logger.warn("Попытка закрыть несуществующий ChromeDriver");
        }
    }
}
