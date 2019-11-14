package HomeWork_Basic_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.VerifyStringEquality;

public class TestCase3 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Multiple Buttons")).click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        button.click();

        WebElement message = driver.findElement(By.id("result"));

        System.out.println(message.getText());

        String expectedMessage = "Clicked on button one!";

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

        if (expectedMessage.equalsIgnoreCase(actualMessage)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        VerifyStringEquality.verifyStrings(expectedMessage,actualMessage);



        driver.quit();






    }
}
