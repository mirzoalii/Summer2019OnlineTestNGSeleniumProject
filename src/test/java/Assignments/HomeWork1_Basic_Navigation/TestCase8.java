package Assignments.HomeWork1_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase8 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registration = driver.findElement(By.linkText("Registration Form"));
        registration.click();

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("5711234354");

        WebElement errormessage = driver.findElement(By.xpath("//small[.='Phone format is not correct']"));

        System.out.println(errormessage.getText());

        driver.quit();

    }
}
