package tests.day10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class myPopUpPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/");

    }
    @Test
    public void test1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]")).click();
        BrowserUtils.wait(2);
       driver.switchTo().alert().accept();
       BrowserUtils.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
        String expectedResult = "You successfuly clicked an alert";
        String actualResult = result.getText();
        Assert.assertEquals(actualResult,expectedResult, "The message is not correct!");

    }
    @Test
    public void test2() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

    }

    @Test
    public void test3() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is fun");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
