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
        WebDriver driver = MyDriverManager.getDriverIfExists();
        if (driver != null){
            logger.info("Делаем скриншот упавшего теста");
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        logger.warn("Невозможно сделать скриншот: драйвер уже закрыт или не был создан");
        return new byte[0];
    }
}
