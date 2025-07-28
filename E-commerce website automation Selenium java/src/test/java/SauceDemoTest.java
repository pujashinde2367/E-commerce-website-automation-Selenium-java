import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class SauceDemoTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1, description = "Login")
    public void testSauceDemoFlow() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addToCart();
        products.goToCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillDetails("John", "Doe", "12345");

        FinishPage finish = new FinishPage(driver);
        finish.finishOrder();

        String msg = finish.getSuccessMessage();
        Assert.assertEquals(msg, "Thank you for your order!");
    }

    @Test(priority = 2)
    public void validateAboutPageTitle() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.clickAboutAndSwitchTab();

        // Wait and switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
