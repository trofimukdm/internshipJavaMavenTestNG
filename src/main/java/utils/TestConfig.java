package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти файл config.properties в resources!");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при чтении config.properties", ex);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("app.base.url");
    }

    public static String getUsername() {
        return properties.getProperty("app.username");
    }

    public static String getPassword() {
        return properties.getProperty("app.password");
    }
}
