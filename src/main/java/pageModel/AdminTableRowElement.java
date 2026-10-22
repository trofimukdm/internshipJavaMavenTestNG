package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminTableRowElement {

    private final WebElement row;

    public AdminTableRowElement(WebElement row) {
        this.row = row;
    }

    public String getType() {
        return row.findElement(By.cssSelector("td:nth-child(3)")).getText();
    }

    public String getStatus() {
        return row.findElement(By.cssSelector("td:nth-child(5)")).getText();
    }
}
