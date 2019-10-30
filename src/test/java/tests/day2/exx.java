package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class exx {
    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        String url1 = "http://google.com";
        String url2 = "http://amazon.com";

        driver.navigate().to(url1);


       driver.close();



    }
}
