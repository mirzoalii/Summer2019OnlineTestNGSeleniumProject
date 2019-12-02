package RandomPractices.Brix24;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Britx24 {

     private WebDriver driver;

     @BeforeMethod
     public void setup() {

         driver = BrowserFactory.getDriver("chrome");
         driver.get("https://login1.nextbasecrm.com/");


     }

     @Test(description = "Verifying login with credentials")
     public void login() {
         driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com ");
         driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
         driver.findElement(By.className("login-btn")).click();
     }

     @Test
     public void event() {
         driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-calendar']//span[contains(text(),'Event')]")).click();
     }









     @AfterMethod
     public void teardown() {

     }
}
