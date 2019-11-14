package tests.day7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNgPractice {
    @Test
    public void test() {
        /*
        to verify that expedcted and actual result is the same
        if no - it will throw exception and stop the program
        also, you will see in the console what was expected
        and what was actually
         */
        Assert.assertEquals("apple","apple");

        /*
        before

        if (str.equals(str)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        } */


    }
    @Test(description = "Verifying title of the practice website")
    public void verifyTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.get("https://practice-cybertekschool.herokuapp.com/");

       String expectedTitle = "Practice";
       String actualTitle = driver.getTitle();
       Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
       driver.quit();

    }

    // let's verify that Test Automation Practice heading is displayed
    @Test(description = "Verify that heading is displayed")
    public void verifyHeadingIsDisplayed() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //if there is no element with this locator, we will get NoSuchElementException
        //and our program will top on the findElement line

        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']")); // //span[text()='Test Automation Practice']
        //to make sure that element is visible to user
        //because element can be present, but not visible
        //we need to make sure element is visible

        //Element is not visible -- will be printed if element it there, but not visible
        //assertTrue - method that checks if something is true
        //if it's false, you will get exception
        // .isDisplayed() return true or false
        //if it returns true - that means element is visible
        // if this method returns false - element is not visible
        Assert.assertTrue(heading.isDisplayed(), "Element is not visible");

       // System.out.println(heading.getText());
        driver.quit();


    }
}
