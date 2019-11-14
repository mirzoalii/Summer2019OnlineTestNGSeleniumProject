package tests.day7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    // Which locator to use?
    // #1 id
    // #2 css
    // #3 xpath
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        //lets find all buttons, and click on them one by one
        // why i put . instead of space? because it's 2 class name .btn.btn-primary
        // in this case, we will find all buttons that have : class ="btn btn-primary"
        // or like this [class = 'btn btn-primary'], no need for . (dot)
        // . (dot) menas class name
        // # means id
        // all buttons
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        // loop through list of buttons
        for(WebElement each: buttons) {
            // and click on every button one by one
            each.click();
            BrowserUtils.wait(1);
            //get the message after click

            WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }

        WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText()); // Multiple buttons

        WebElement p = driver.findElement(By.cssSelector("[class = 'container'] > p"));
        System.out.println(p.getText());

        driver.quit();



    }
}
