package db;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBActions {
    private static final Logger logger = LogManager.getLogger(DBActions.class);
    @Step("Формируем и отправляем SELECT запрос в БД")
    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {

        List<Map<String, Object>> results = new ArrayList<>();
        Connection connection = DBManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setParameters(statement, params);

            try (ResultSet resultSet = statement.executeQuery()) {
                logger.info("Выполняем SELECT запрос в БД");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = resultSet.getObject(i);
                        row.put(columnName, value);
                    }
                    results.add(row);
                }
            }
        } catch (SQLException e) {
            logger.error("Ошибка выполнения SELECT запроса: {}", e.getMessage());
            throw new RuntimeException("SELECT query execution failed", e);
        }
        return results;
    }
    @Step("Формируем и отправляем DELETE запрос в БД")
    public static int executeUpdate(String sql, Object... params) {

        Connection connection = DBManager.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setParameters(statement, params);
            int affectedRows = statement.executeUpdate();
            logger.info("Запрос выполнен успешно. Затронуто строк: {}", affectedRows);
            return affectedRows;
        } catch (SQLException e) {
            logger.error("Ошибка выполнения запроса: {}", e.getMessage());
            throw new RuntimeException("DELETE query execution failed", e);
        }
    }

    private static void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    @Attachment(value = "Результат SQL запроса", type = "text/plain")
    public static String attachQueryResult(List<Map<String, Object>> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("Найдено записей: ").append(results.size()).append("\n\n");

        for (Map<String, Object> row : results) {
            sb.append("Запись: ").append(row).append("\n");
        }
        return sb.toString();
    }
}
