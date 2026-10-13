package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminTable {
    private WebDriver driver;
    private final WebDriverWait wait;

    private By rows = By.cssSelector("table.MuiTable-root");

    public AdminTable() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AdminTableRow findByNumber(String number) {
        By applicationRow = By.xpath("//tr[contains(@class,'MuiTableRow-root')]" + "[td[1][normalize-space(.)='" + number + "']]");
        WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(applicationRow));
        return new AdminTableRow(row);
    }

    public AdminTableRow getLatestAdminTableRow() {
        By rowsLocator = By.xpath("//tr[contains(@class,'MuiTableRow-root')][td[1]]");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(rowsLocator, 0));
        List<WebElement> allRows = driver.findElements(rowsLocator);
        return new AdminTableRow(allRows.get(0));
    }
}
