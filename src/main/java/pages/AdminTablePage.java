package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminTablePage extends BasePage {

    public AdminTablePage() {
        super();
    }

    public AdminTableRowElement findByNumber(String number) {
        By applicationRow = By.xpath("//tr[contains(@class,'MuiTableRow-root')]" + "[td[1][normalize-space(.)='" + number + "']]");
        WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(applicationRow));
        return new AdminTableRowElement(row);
    }
}
