package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class amazon1 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement email = driver.findElement(By.id("nav-link-accountList"));
        email.click();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("ibrohim.mirzoali@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("amazon12345");

    }
}
