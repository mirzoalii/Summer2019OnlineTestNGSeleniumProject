package tests.day14;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Test
    public void test1() {
        //read url value from properties file
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() - will return webdriver object
        // and then we can call webdriver methods like get(), findElements()....
        //  WebDriver driver = Driver.get();
        Driver.get().get(url);
        //print page title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();
    }
    @Test
    public void test2() {
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}
