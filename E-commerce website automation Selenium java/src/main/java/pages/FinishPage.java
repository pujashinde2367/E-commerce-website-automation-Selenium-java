package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage {
    WebDriver driver;
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
