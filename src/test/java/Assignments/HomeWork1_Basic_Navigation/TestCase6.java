package Assignments.HomeWork1_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase6 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regisration = driver.findElement(By.linkText("Registration Form"));
        regisration.click();

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("user");

        WebElement errorMessage = driver.findElement(By.xpath("//small[.='The username must be more than 6 and less than 30 characters long']"));

        System.out.println(errorMessage.getText());

        driver.quit();



    }
}
