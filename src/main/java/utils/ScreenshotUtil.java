package utils;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] takeScreenshot() {
        WebDriver driver = MyDriverManager.getDriver();
        if (driver != null){
            logger.error("Сделан скриншот падения теста");
            return ((TakesScreenshot) MyDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
}
