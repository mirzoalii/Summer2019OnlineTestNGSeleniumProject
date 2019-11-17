package Homework_TestNG_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class TestCase8 {

        @Test
        public void AutoComplete() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult = "You selected: United States of America";
        Assert.assertEquals(actualResult,expectedResult,"Message is wrong");

        driver.quit();





    }
}