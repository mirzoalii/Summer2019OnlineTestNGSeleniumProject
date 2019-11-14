package HomeWork_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase5 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("123");


        WebElement error = driver.findElement(By.xpath("//small[.='The last name can only consist of alphabetical letters and dash']"));


        System.out.println(error.getText());
    }
}
