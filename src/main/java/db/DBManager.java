package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final Logger logger = LogManager.getLogger(DBManager.class);
    private static final ThreadLocal<Connection> connection = new ThreadLocal<>();

    private DBManager() {
    }

    public static Connection getConnection() {
        try {
            if (connection.get() == null || connection.get().isClosed()) {

                Connection newConnection = DriverManager.getConnection(TestConfig.getDbUrl(), TestConfig.getDbUsername(), TestConfig.getDbPassword());
                connection.set(newConnection);
                logger.info("Соединение с базой данных установлено");
            } else {
                logger.debug("Используем существующее активное соединение с базой данных");
            }
        } catch (SQLException e) {
            logger.error("Не удалось подключиться к базе данных: {}", e.getMessage());
            throw new RuntimeException("Database connection failed", e);
        }
        return connection.get();
    }

    public static void closeConnection() {
        if (connection.get() != null) {
            try {
                connection.get().close();
                logger.info("Соединение с базой данных закрыто");
            } catch (SQLException e) {
                logger.error("Ошибка при закрытии соединения: {}", e.getMessage());
                throw new RuntimeException("Connection closing error", e);
            } finally {
                connection.remove();
            }
        } else {
            logger.warn("Попытка закрыть несуществующее соединение с базой данных");
        }
    }
}
