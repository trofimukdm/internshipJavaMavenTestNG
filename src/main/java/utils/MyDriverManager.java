package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private MyDriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriver newDriver = new ChromeDriver();
            newDriver.manage().window().maximize();
            driver.set(newDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
