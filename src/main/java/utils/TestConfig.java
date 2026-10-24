package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Logger logger = LogManager.getLogger(TestConfig.class);
    private static final Properties properties = new Properties();

    static {
        logger.info("Загружаем конфигурацию из config.properties");
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("Не удалось найти файл config.properties в resources!");
                throw new RuntimeException("Не удалось найти файл config.properties в resources!");
            }
            properties.load(input);
            logger.info("Конфигурация успешно загружена");
        } catch (IOException ex) {
            logger.error("Ошибка при чтении config.properties", ex);
            throw new RuntimeException("Ошибка при чтении config.properties", ex);
        }
    }

    public static String getBaseUrl() {
        logger.debug("Запрашиваем базовый URL");
        return properties.getProperty("app.base.url");
    }

    public static String getUsername() {
        logger.debug("Запрашиваем username из конфигурации");
        return properties.getProperty("app.username");
    }

    public static String getPassword() {
        logger.debug("Запрашиваем password из конфигурации");
        return properties.getProperty("app.password");
    }
}
