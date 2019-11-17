package Amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class MySecondPurchase {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/?ref_=nav_signin&");
        BrowserUtils.wait(3000);
    }

    @Test
    public void searchBar() {

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
