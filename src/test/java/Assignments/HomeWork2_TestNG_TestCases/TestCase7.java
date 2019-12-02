package Assignments.HomeWork2_TestNG_TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase7 {


         @Test
         public void FileUploadTEst() {

             WebDriver driver = BrowserFactory.getDriver("chrome");

            driver.get("https://practice-cybertekschool.herokuapp.com/");


             driver.findElement(By.linkText("File Upload")).click();

             driver.findElement(By.id("file-upload")).sendKeys("/Users/ibrohimikromzoda/Desktop/MyCV.txt");

             driver.findElement(By.id("file-submit")).click();
             BrowserUtils.wait(4);

             String expectedFileName = "MyCV.txt";

             String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

             Assert.assertEquals(actualFileName,expectedFileName, "File is not uploaded!");

          driver.quit();


    }
}
