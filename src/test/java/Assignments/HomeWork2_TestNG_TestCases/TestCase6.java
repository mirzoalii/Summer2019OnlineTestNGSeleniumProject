package Assignments.HomeWork2_TestNG_TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");


    }

    @Test
    public void registration() {
        String TempEmail = driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Ibrohim Ikromzoda");
        driver.findElement(By.name("email")).sendKeys(TempEmail);
        driver.findElement(By.name("wooden_spoon")).click();
       WebElement SignUp =  driver.findElement(By.name("signup_message"));
       Assert.assertTrue(SignUp.isDisplayed(),"Sign Up Message is not displayed");
       BrowserUtils.wait(5);

        driver.get("https://www.tempmailaddress.com/");
       WebElement RecieveEmail =  driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
        String ActualEmail = RecieveEmail.getText();
        ActualEmail = ActualEmail.trim();
        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(ActualEmail,ExpectedEmail, "Email is not received");
        RecieveEmail.click();

        String fromEmail = driver.findElement(By.id("odesilatel")).getText();
        String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(fromEmail, expectedFromEmail, "Wrong Sender");
        String ActualSubject = driver.findElement(By.id("predmet")).getText();
        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject line is wrong");
        driver.quit();




    }
}