package tests.day2;

public class notes {

    /*
    Today 10/18/2019
Agenda:
    Short review
    I will push project to github
    We will learn how to read page title
    And some basic navigation commands
#########################################
Dependency - used inside a pom.xml file. pom.xml it's a brain of maven project. We create maven project, it's like better organized project. Dependency will describe what library we want to add into the project. This is how we added selenium webdriver library. Otherwise, we would have to add library manually.
Also, we added WebDrivermanager. It helps to download and use different webdriver easily. Selenium cannot work without webdriver. Because, it cannot contact with a browser directly.
<dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId> -- name
      <version>3.141.59</version> -- version of library
</dependency>
We have to add dependencies manually. But, it's the easiest way to manage libraries. Since you are not gonna create a new project every day, it's very easy solution. Most likely, you will just change versions. maven will automatically download library with a new version.
In the simple words - maven, it's a project builder and management tool.
Make sure you have chrome browser.
//shortcut for system out
sout -- and hit enter
the problem about equalsIgnoreCase (in terms of testing), not good, because wrong spelling is also a bug.
This what happens, when you try to run tests without webdriver. Before running tests, we must setup webdriver.
Exception in thread "main" java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.chrome.driver system property; for more information, see https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver. The latest version can be downloaded from http://chromedriver.storage.googleapis.com/index.html
To import a class, click Option + enter.
As of now, we always create a driver before running tests. Later, we will create a class that will be use to call driver. In that case, we setup driver once, and use it forever.
https://www.google.com - it calls URL, address of the website.
getCurrentUrl() - method that returns URL as a string of current website.
package tests.day2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
public class BasicNavigation {
    public static void main(String[] args) {
        //if you have exception: cannot load a class
        //that means that package name, doesn't match with location of the class itself
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //to maximize browser
        driver.manage().window().maximize();
        driver.get("http://google.com");
        //we want to navigate, to the different page
        //within same browser
        //we not gonna open new browser or new tab
        //URL can be passed as an object
        //or as a string
        //we use string
        driver.navigate().to("http://amazon.com");
        //if I want to comeback, to the previous page
        driver.navigate().back();
        //if I want to know URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);
        //selenium cannot close browser automatically
        //for this, we use method close()
        driver.close();
    }
}
     */
}
