package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    // we gonna create a method
    //that will return a webdriver object
    // this method will take one parameter  - String browser
    // based on the value of the browser parameter
    // method will retrun corresponded webdriver object
    // if browser  = chrome, the return chromedriver object

    public static  WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.chromedriver().setup();
            return  new FirefoxDriver();
        }
        return null;
    }
}
