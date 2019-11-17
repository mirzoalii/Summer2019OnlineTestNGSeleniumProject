package Homework_TestNG_TestCases;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase7 {


         @Test
         public void FileUploadTEst() {

             WebDriver driver = BrowserFactory.getDriver("chrome");

            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.linkText("File Upload")).click();



        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/Ibrohim/Desktop/Hi.txt");
        driver.findElement(By.id("file-submit")).click();



    }
}
