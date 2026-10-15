package internship;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MyDriverManager;
import utils.TestConfig;

public class MarriageTest {
    @Test
    public void testMarriage() {
        WebDriver driver = MyDriverManager.getDriver();

        if (driver instanceof HasAuthentication) {
            ((HasAuthentication) driver).register(
                    UsernameAndPassword.of(TestConfig.getUsername(), TestConfig.getPassword())
            );
        }
        driver.get(TestConfig.getBaseUrl());


        WebElement userSelect = driver.findElement(By.xpath("//*[contains(text(), \"Войти как пользователь\")]"));
        userSelect.click();

        WebElement applicantLastNameField = driver.findElement(By.cssSelector("input[id=\"TextInputField-1\"]"));
        applicantLastNameField.sendKeys("Иванов");

        WebElement applicantFirstNameField = driver.findElement(By.cssSelector("input[id=\"TextInputField-2\"]"));
        applicantFirstNameField.sendKeys("Иван");

        WebElement applicantMiddleNameField = driver.findElement(By.cssSelector("input[id=\"TextInputField-3\"]"));
        applicantMiddleNameField.sendKeys("Иванович");

        WebElement applicantPhoneField = driver.findElement(By.cssSelector("input[id=\"TextInputField-4\"]"));
        applicantPhoneField.sendKeys("1234567");

        WebElement applicantPassportField = driver.findElement(By.cssSelector("input[id=\"TextInputField-5\"]"));
        applicantPassportField.sendKeys("123123");

        WebElement applicantAddressField = driver.findElement(By.cssSelector("input[id=\"TextInputField-6\"]"));
        applicantAddressField.sendKeys("Минск");

        WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(), \"Далее\")]"));
        nextButton.click();

        WebElement marriageSelect = driver.findElement(By.xpath("//button[contains(text(), \"Регистрация брака\")]"));
        marriageSelect.click();

        WebElement citizenLastName = driver.findElement(By.cssSelector("input[id=\"TextInputField-7\"]"));
        citizenLastName.sendKeys("Иванов");

        WebElement citizenFirstName = driver.findElement(By.cssSelector("input[id=\"TextInputField-8\"]"));
        citizenFirstName.sendKeys("Иван");

        WebElement citizenMiddleName = driver.findElement(By.cssSelector("input[id=\"TextInputField-9\"]"));
        citizenMiddleName.sendKeys("Иванович");

        WebElement citizenBirthDate = driver.findElement(By.cssSelector("input[id=\"TextInputField-10\"]"));
        citizenBirthDate.sendKeys("01.02.2001");

        WebElement citizenPassport = driver.findElement(By.cssSelector("input[id=\"TextInputField-11\"]"));
        citizenPassport.sendKeys("123123");

        WebElement citizenGender = driver.findElement(By.cssSelector("input[id=\"TextInputField-12\"]"));
        citizenGender.sendKeys("муж");

        WebElement citizenAddress = driver.findElement(By.cssSelector("input[id=\"TextInputField-13\"]"));
        citizenAddress.sendKeys("Минск");

        WebElement citizenNext = driver.findElement(By.xpath("//button[contains(text(), \"Далее\")]"));
        citizenNext.click();

        WebElement registrationDate = driver.findElement(By.cssSelector("input[id=\"TextInputField-14\"]"));
        registrationDate.sendKeys("08.08.2008");

        WebElement newLastName = driver.findElement(By.cssSelector("input[id=\"TextInputField-15\"]"));
        newLastName.sendKeys("Иванова");

        WebElement spouseLastName = driver.findElement(By.cssSelector("input[id=\"TextInputField-16\"]"));
        spouseLastName.sendKeys("Сидорова");

        WebElement spouseFirstName = driver.findElement(By.cssSelector("input[id=\"TextInputField-17\"]"));
        spouseFirstName.sendKeys("Анна");

        WebElement spouseMiddleName = driver.findElement(By.cssSelector("input[id=\"TextInputField-18\"]"));
        spouseMiddleName.sendKeys("Сергеевна");

        WebElement spouseBirthDate = driver.findElement(By.cssSelector("input[id=\"TextInputField-19\"]"));
        spouseBirthDate.sendKeys("01.02.2001");

        WebElement spousePassport = driver.findElement(By.cssSelector("input[id=\"TextInputField-20\"]"));
        spousePassport.sendKeys("123123");

        WebElement completeButton = driver.findElement(By.xpath("//button[contains(text(),'Завершить')]"));
        completeButton.click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(), 'Спасибо за обращение!')]"));

        Assert.assertEquals(result.getText(), "Спасибо за обращение!");

        driver.quit();
    }
}
