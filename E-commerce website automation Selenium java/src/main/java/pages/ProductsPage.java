package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By menuBtn = By.id("react-burger-menu-btn");
    By aboutLink = By.id("about_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickAboutAndSwitchTab() {
        driver.findElement(menuBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink));
        driver.findElement(aboutLink).click();
    }
}
