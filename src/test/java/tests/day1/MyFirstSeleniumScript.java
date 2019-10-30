package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) throws Throwable {
        // we have to set up webdriver based on the browser what we use
        WebDriverManager.chromedriver().setup();
        // we need to create an object of appropriate class
        ChromeDriver drivers = new ChromeDriver();
        // lets opne google.com

        drivers.get("http://google.com");

        // to read page title, there is method .getTitle();
        drivers.navigate().to("http:amazon.com");


        Thread.sleep(5000);
        //Test1. Verify that title of the page is a "Google"
        String actualResult = drivers.getTitle();
        String expectedResult = drivers.getTitle();
        if (actualResult.equals(actualResult)) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test failed");
        }
        //to close browser
        drivers.close();
    }
}
