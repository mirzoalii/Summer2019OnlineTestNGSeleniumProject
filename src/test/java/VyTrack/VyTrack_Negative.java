package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class VyTrack_Negative {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa2.vytrack.com/user/login");

        WebElement username = driver.findElement(By.name("_username"));
        username.sendKeys("I_DONT_KNOW");


        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");

        WebElement button = driver.findElement(By.id("_submit"));
        button.click();

        WebElement message = driver.findElement(By.cssSelector("[class='alert alert-error']>div"));
        System.out.println(message.getText());

        String actualMessage =  message.getText();

        String expectedMessage = "Invalid user name or password";

        if (actualMessage.equalsIgnoreCase(expectedMessage)) {
            System.out.println("Test passed");
        } else {

            System.out.println("Expected Result is "+expectedMessage);
            System.out.println("Actual Result is "+actualMessage);
            System.out.println("Test failed");
        }
        driver.close();

    }
}
