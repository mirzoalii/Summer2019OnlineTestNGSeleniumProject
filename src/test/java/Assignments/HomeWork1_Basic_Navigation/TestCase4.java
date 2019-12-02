package Assignments.HomeWork1_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.VerifyStringEquality;

public class TestCase4 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registration = driver.findElement(By.linkText("Registration Form"));
        registration.click();

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("123");

        WebElement message = driver.findElement(By.xpath("//small[.='The last name can only consist of alphabetical letters and dash']"));

        System.out.println(message.getText());

        String expectedMessage = "The last name can only consist of alphabetical letters and dash";

        String actualMessage = driver.findElement(By.xpath("//small[.='The last name can only consist of alphabetical letters and dash']")).getText();

        if (expectedMessage.equalsIgnoreCase(actualMessage)) {
            System.out.println("TEST PASSED");

        } else {
            System.out.println("TEST FAILED");
        }

        VerifyStringEquality.verifyStrings(expectedMessage, actualMessage);

       driver.quit();
    }
}
