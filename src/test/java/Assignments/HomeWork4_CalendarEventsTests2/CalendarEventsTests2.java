package Assignments.HomeWork4_CalendarEventsTests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CalendarEventsTests2 {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;


    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));


}

    @Test(description = "Hover on three dots “...” for “Testers meeting calendar event")
    public void test1() {
        actions = new Actions(driver);
        WebElement threeDots = driver.findElement(By.cssSelector("tr[class='grid-row row-click-action']:nth-of-type(1)>td:nth-of-type(9)"));
        actions.moveToElement(threeDots).perform();

        List<WebElement> list = driver.findElements(By.xpath("//body/ul//a"));

        for(WebElement each : list) {
            Assert.assertTrue(each.isDisplayed(), each + " in not displayed");
            System.out.println(each.getAttribute("title"));
        }


    }

@Test(description = "Deselect all options except “Title”")
public void test2() {

    driver.findElement(By.xpath("//a[@title='Grid Settings']")).click();

   BrowserUtils.wait(2);

   for (int i=2; i <=7; i++) {
       driver.findElement(By.xpath("//tbody[@class='ui-sortable']//tr["+i+"]//td[3]")).click();
       BrowserUtils.wait(1);

   }
   Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Title']")).isDisplayed(),"Title is not displayed");


    }

    @Test(description ="Verify that  Save and Close, Save and New, Save options are available" )
    public void test3() {
     driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
    BrowserUtils.wait(3);
     WebElement verify = driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']"));
        verify.click();
        System.out.println(verify.getText());

        String SaveAndClose = driver.findElement(By.xpath("//button[@class='action-button dropdown-item']")).getText();
        Assert.assertEquals(SaveAndClose,"Save And Close");
        BrowserUtils.wait(2);

        String SaveAndNew = driver.findElement(By.xpath("//button[@class='main-group action-button dropdown-item']")).getText();
        Assert.assertEquals(SaveAndNew,"Save And New");
        BrowserUtils.wait(2);

        String Save = driver.findElement(By.xpath("//div[@class='app-page__main']//li[3]")).getText();
        Assert.assertEquals(Save,"Save");
        BrowserUtils.wait(2);
    }

   @Test(description = "All Calendar Events” page subtitle is displayed")
   public void test4() {
       driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
       BrowserUtils.wait(3);
       driver.findElement(By.xpath("//a[@title='Cancel']")).click();
       BrowserUtils.wait(2);

       String actualSubtitle = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();
       String expectedSubtitle = "All Calendar Events";
       Assert.assertEquals(actualSubtitle,expectedSubtitle);

    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {
       //
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.wait(3);


    }

    @Test(description = "Verify that end time is equals to “10:00 PM”")
    public void test6() {
        driver.findElement(By.cssSelector("[class='btn-group']>a")).click();

        BrowserUtils.wait(3);

        WebElement startTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        startTime.click();
        driver.findElement(By.xpath("//li[contains(text(), '9:00 PM')]")).click();



        String endTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).getAttribute("value");
        Assert.assertEquals(endTime, "10:00 PM", "Time is not 10:00 PM");

    }

    @Test(description = "Verify that start & end time are not displayed")
    public void test7() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.wait(3);
        WebElement AllDayEvent = driver.findElement(By.cssSelector("[type='checkbox']"));
        AllDayEvent.click();
        BrowserUtils.wait(3);
        Assert.assertTrue(AllDayEvent.isSelected(),"All day event button is not selected");

        WebElement startTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        WebElement endTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));
        Assert.assertFalse(startTime.isDisplayed(),"Start time is displayed");
        Assert.assertFalse(endTime.isDisplayed(),"End time is displayed");



    }

    @Test(description = "Verify that “Daily” is selected by default and following options are available in  “Repeats” drop-down:")
    public void test8() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        WebElement mask = driver.findElement(By.cssSelector("[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(mask));

        WebElement repeatCheckBox = driver.findElement(By.cssSelector("input[data-name='recurrence-repeat']"));
        repeatCheckBox.click();
        Assert.assertTrue(repeatCheckBox.isSelected());

        WebElement others = driver.findElement(By.cssSelector("select[data-name='recurrence-repeats']"));
        Select select = new Select(others);

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Daily");

        List<WebElement> list = select.getOptions();

        List<String> options = new ArrayList<>(Arrays.asList("Daily", "Weekly", "Monthly","Yearly"));

        for(int i=0; i<options.size(); i++){
            Assert.assertEquals(list.get(i).getText(), options.get(i));
            System.out.print(list.get(i).getText()+" ");
        }

    }

    @Test(description = "Print out the summary message")
    public void test9() {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatCheckBox = driver.findElement(By.cssSelector("input[data-name='recurrence-repeat']"));
        repeatCheckBox.click();
        Assert.assertTrue(repeatCheckBox.isSelected());
        WebElement repeatEvery = driver.findElement(By.cssSelector("[checked='checked']"));
        repeatEvery.click();
        Assert.assertTrue(repeatEvery.isSelected(),"Repeat Every checkbox is not selected");
        WebElement NeverButton = driver.findElement(By.cssSelector("[type='radio'][checked='']"));
        Assert.assertTrue(NeverButton.isSelected());

        WebElement SummaryMessage = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        String actualMessage = SummaryMessage.getText();
        String expectedMessage = "Daily every 1 day";
        Assert.assertEquals(actualMessage,expectedMessage,"Summary message is not displayed");

    }

    @Test(description = "Summary: Daily every 1 day, end after 10 occurrences”")
    public void test10() {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


        WebElement repeatCheckBox = driver.findElement(By.cssSelector("input[data-name='recurrence-repeat']"));
        repeatCheckBox.click();
        Assert.assertTrue(repeatCheckBox.isSelected());
        WebElement repeatEvery = driver.findElement(By.cssSelector("[checked='checked']"));
        repeatEvery.click();

        driver.findElement(By.xpath("//*[contains(text(),'After')]")).click();
        Assert.assertTrue(repeatEvery.isSelected(),"Repeat Every checkbox is not selected");
        WebElement AfterButton = driver.findElement(By.cssSelector("[data-related-field='occurrences']"));
        AfterButton.click();
        AfterButton.sendKeys("10");

        WebElement SummaryMessage = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        SummaryMessage.click();
        String actualMessage = SummaryMessage.getText();
        String expectedMessage = "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(actualMessage,expectedMessage,"Summary message is not displayed");


    }
    @Test(description = " Print out Daily every 1 day, end by Nov 18, 2021”")
    public void test11() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


        WebElement repeatCheckBox = driver.findElement(By.cssSelector("input[data-name='recurrence-repeat']"));
        repeatCheckBox.click();
        Assert.assertTrue(repeatCheckBox.isSelected());

        WebElement ByButton = driver.findElement(By.xpath("//*[@class='recurrence-subview-control__text'][contains(text(),'By')]"));
        ByButton.click();

        WebElement date = driver.findElement(By.cssSelector("[class='datepicker-input hasDatepicker']"));
        date.sendKeys("Nov 18, 2021",Keys.ESCAPE);

        WebElement SummaryMessage = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        SummaryMessage.click();
        String actualMessage = SummaryMessage.getText();
        String expectedMessage = "Daily every 1 day, end by Nov 18, 2021";
        Assert.assertEquals(actualMessage,expectedMessage,"Summary message is not displayed");






    }

    @Test
    public void test12() {

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


        WebElement repeatCheckBox = driver.findElement(By.cssSelector("input[data-name='recurrence-repeat']"));
        repeatCheckBox.click();
        Assert.assertTrue(repeatCheckBox.isSelected());

        WebElement options = driver.findElement(By.cssSelector("[data-name='recurrence-repeats']"));
        Select select = new Select(options);
        select.selectByVisibleText("Weekly");

        WebElement mondaytick = driver.findElement(By.cssSelector("[type='checkbox'][value='monday']"));
        mondaytick.click();
        WebElement fridaytick = driver.findElement(By.cssSelector("[type='checkbox'][value='friday']"));
        fridaytick.click();
        Assert.assertTrue(mondaytick.isSelected(),"Monday tick is not selected");
        Assert.assertTrue(fridaytick.isSelected(),"Friday tick is not selected");


        WebElement SummaryMessage = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        SummaryMessage.click();
        String actualMessage = SummaryMessage.getText();
        String expectedMessage = "Weekly every 1 week on Monday, Friday";
        Assert.assertEquals(actualMessage,expectedMessage,"Summary message is not displayed");




    }






@AfterMethod
public void teardown() {
        driver.quit();
    }
}