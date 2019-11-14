package VyTrack;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class VyTrack {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa2.vytrack.com/user/login");

        WebElement input = driver.findElement(By.name("_username"));
        input.sendKeys("user171");

        WebElement input2 = driver.findElement(By.name("_password"));
        input2.sendKeys("UserUser123");



        WebElement button = driver.findElement(By.id("_submit"));
        button.click();

        String expectedURL = "https://qa2.vytrack.com/user/login";

        String actualURL = driver.getCurrentUrl();

        if (actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        //driver.quit();





        driver.quit();
    }
}
