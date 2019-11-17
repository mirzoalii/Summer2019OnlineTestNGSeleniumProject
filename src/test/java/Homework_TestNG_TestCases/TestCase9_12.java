package Homework_TestNG_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class TestCase9_12 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();


    }
    @DataProvider(name = "TestData")
    public static Object[] TestData() {
        return new Object[] {"200","301","404","500"};
    }
    @Test(dataProvider = "TestData") //description = "Verify that correct status code messages displayed"
     public void StatusCodes(String errorCode) {
         driver.findElement(By.linkText(errorCode)).click();

         // To verify the displayed text
         WebElement result = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]"));
        Assert.assertTrue(result.getText().contains(errorCode),"Wrong Error code");

        driver.findElement(By.linkText("here")).click();

        driver.quit();

     }
}
