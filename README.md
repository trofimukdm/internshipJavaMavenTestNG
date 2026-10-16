## Учебный проект по автоматизации тестирования на Java с использованием Selenium, TestNG и Maven.

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-4.50.0-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.12.0-red?style=for-the-badge&logo=testng)
![Maven](https://img.shields.io/badge/Maven-4.0-C71A36?style=for-the-badge&logo=apachemaven)

---

## 🛠 Технологии

- **Java 25** — актуальный LTS-релиз с долгосрочной поддержкой.
- **Selenium WebDriver 4.50.0** — для управления браузером и эмуляции действий пользователя.
- **TestNG 7.12.0** — мощный фреймворк для написания и структурирования тестов.
- **Maven 4.0** — управление зависимостями и сборка проекта.
- **Google Chrome** — браузер по умолчанию для запуска тестов (требуется последняя версия).

---

## ⚙️ Настройка перед запуском

1. **Клонируйте репозиторий:**
   ```text
   git clone https://github.com/trofimukdm/internshipJavaMavenTestNG.git
   ```

2. **Создайте файл конфигурации из шаблона:**
   ```text
   cp src/test/resources/config.properties.example src/test/resources/config.properties
   ```

3. **Заполните конфигурацию реальными данными:**
   Откройте файл `src/test/resources/config.properties` и укажите актуальные значения:
   ```text
   app.base.url=https://your-test-environment.com
   app.username=your_username
   app.password=your_password
   ```

## ▶️ Запуск тестов

### Вариант 1: Через Maven
```text
mvn clean test
```
    
### Вариант 2: Через IntelliJ IDEA
Кликните правой кнопкой по папке `src/test/java` → **Run 'All Tests'**.

---
*Разработано в рамках стажировки*