package RandomPractices.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MyFirstPurchase {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void login() {

        WebElement email = driver.findElement(By.id("nav-link-accountList"));
        email.click();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("ibrohim.mirzoali@gmail.com");
        driver.findElement(By.id("continue")).click();

    }

    @AfterTest
    public void password() {
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("123456789");
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();



    }
    @AfterTest
    public void searchbar() {
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("camera cover");
    }


    @AfterMethod
    public void teardown() {
        //driver.quit();
    }
}
