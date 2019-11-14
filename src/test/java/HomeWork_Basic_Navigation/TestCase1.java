package HomeWork_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase1 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        WebElement fullname = driver.findElement(By.name("full_name"));
        fullname.sendKeys("Ibrohim Ikromzoda");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("ibrohim.ikromzoda@gmail.com");

       WebElement button = driver.findElement(By.name("wooden_spoon"));
       button.click();

       WebElement subheader = driver.findElement(By.name("signup_message"));
        System.out.println(subheader.getText());

        String actual="“Thank you for signing up. Click the button below to return to the home page.";
        String expected=subheader.getText();

        if(actual.contains(expected)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();



    }
}
