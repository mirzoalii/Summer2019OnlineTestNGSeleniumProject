package tests.day7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");

        //how to find all links?
        //every link as a tag name <a>
        //findElement vs findElements
        //findElement = only 1 webElements
        //findElements = 0 or more elements
        // if list is empty, that means that element is not there
        // in this way, we can ensure that element doesn't present
        // //a[.='Home'] or //a[text()='Home'] - find link with text name Home

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());
        //what if I want to print text of all links, one by one
        //loop through the collection of links

        for (WebElement each : links) {
            //print text of very link
            System.out.println(each.getText());
        }



        driver.quit();

    }
}
