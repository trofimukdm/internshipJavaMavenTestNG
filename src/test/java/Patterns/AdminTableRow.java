package Patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminTableRow {

    private WebElement row;

    public AdminTableRow(WebElement row) {
        this.row = row;
    }

    public String getNumber() {
        return row.findElement(By.cssSelector("td:nth-child(1)")).getText();
    }

    public String getType() {
        return row.findElement(By.cssSelector("td:nth-child(3)")).getText();
    }

    public String getStatus() {
        return row.findElement(By.cssSelector("td:nth-child(5)")).getText();
    }
}
