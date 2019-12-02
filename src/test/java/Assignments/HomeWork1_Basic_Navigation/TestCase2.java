package Assignments.HomeWork1_Basic_Navigation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class TestCase2 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        List<WebElement> numbers= driver.findElements(By.className("list-group-item"));

        System.out.println(numbers.size());

        if(numbers.size()==48) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
      driver.quit();

    }
}
