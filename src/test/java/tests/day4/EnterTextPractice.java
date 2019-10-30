package tests.day4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));

        // we enter the text
        inputBox.sendKeys("random@gmail.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        // click on the element
        button.click();
        BrowserUtils.wait(2);

        String expectedURL  = "http://practice.cybertekschool.com/forgot_password";

        String actualURL = driver.getCurrentUrl();


        if (actualURL.equals(actualURL)) {
            System.out.println("Test Passed");

        } else {
            System.out.println("Test Failed");
        }


        driver.close();

    }
}
