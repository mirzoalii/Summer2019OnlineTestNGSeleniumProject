package HomeWork_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase7 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(" https://practice-cybertekschool.herokuapp.com");

        WebElement registration = driver.findElement(By.linkText("Registration Form"));
        registration.click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("testers@email");

        WebElement error = driver.findElement(By.xpath("//small[.='email address is not a valid']"));
        System.out.println(error.getText());

        driver.quit();

    }
}
