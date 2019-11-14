package Homework_TestNG_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        WebElement DOB = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input"));
        DOB.sendKeys("wrong_dob");

        String actualResult = "The date of birth is not valid";

        String expectedResult = DOB.getText();



    }
}