package Assignments.HomeWork3_Sychronization_Checkboxes_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sychronization {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement activityElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activityElement));
        wait.until(ExpectedConditions.elementToBeClickable(activityElement));
        activityElement.click();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEvents));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEvents));
        calendarEvents.click();

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }


    @Test(description = "Verify page subtitle Options is displayed")
    public void test1() {


        String expectedSubtitle = "Options";
        String actualSubtitle = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[2]/div")).getText();
        Assert.assertEquals(actualSubtitle, expectedSubtitle, "Subtitle is wrong!");


    }
    @Test(description = "Verify that page number is equal to 1")
    public void test2() {

       WebElement PageNumber = driver.findElement(By.xpath("//*[@type='number']"));
        System.out.println(PageNumber.getAttribute("value"));
        Assert.assertTrue(PageNumber.getAttribute("value").equals("1"));






    }
    @Test(description = "Verify that view per page number is equal to 25")
   public void test3() {

        WebElement PerPage = driver.findElement(By.xpath(""));
        System.out.println(PerPage.getAttribute("value"));
        Assert.assertTrue(PerPage.getAttribute("value").equals("25"));




   }

   @Test(description = "Verify that number calendar events (rows in the table) is equal to number of records")
   public void test4() {

       WebElement checkbox = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));
       checkbox.click();

       WebElement allTick = driver.findElement(By.xpath("/html/body/ul/li[1]/a"));
       allTick.click();


       List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@tabindex='-1'][@type='checkbox']"));
       System.out.println(checkboxes.size());
       checkbox.isDisplayed();
       int expectedResult = 22;
       Assert.assertEquals(checkboxes,expectedResult);











   }

   @Test(description = "Verify that all calendar events selected")
   public void test5() {

        WebElement checkbox = driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));
        checkbox.click();

        WebElement allTick = driver.findElement(By.xpath("/html/body/ul/li[1]/a"));
        allTick.click();

       List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@tabindex='-1'][@type='checkbox']"));
       System.out.println(checkboxes.size());

       for (WebElement each: checkboxes) {
           each.isDisplayed();
       }

   }


   @Test(description = "Verify that following data is displayed")
   public void test6() {
       driver.findElement(By.cssSelector("[class='grid-row row-click-action']:nth-of-type(13)")).click();

       List<String> list = new ArrayList<>(Arrays.asList(
               "Testers Meeting",
               "This is a a weekly testers meeting",
               "Nov 27, 2019, 9:30 PM",
               "Nov 27, 2019, 10:30 PM",
               "No",
               "Stephan Haley",
               "Tom Smith",
               "Weekly every 1 week on Wednesday",
               "No"));
       System.out.println(list);
       driver.findElement(By.className("form-horizontal")).getText();


   }






    @AfterMethod
    public void teardown() {
       // driver.quit();
    }
}
