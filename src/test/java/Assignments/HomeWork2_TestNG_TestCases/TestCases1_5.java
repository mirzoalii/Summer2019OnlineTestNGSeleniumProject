package Assignments.HomeWork2_TestNG_TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCases1_5 {

    private  WebDriver driver;
       @BeforeMethod
       public void setup() {
           driver = BrowserFactory.getDriver("chrome");
           driver.get("https://practice-cybertekschool.herokuapp.com");
           driver.findElement(By.linkText("Registration Form")).click();



       }

       @Test(description = "Verify that DOB error message is displayed")
       public void TestCase1() {
           String expectedResult = "The date of birth is not valid";
           WebElement DOB = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input"));
           DOB.sendKeys("wrong_dob");

           String actualResult = driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
           WebElement errorMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
           System.out.println(errorMessage.getText());
           Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
           Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");

       }

       @Test(description = "Verify that c++ java and Javascript is dispalyed")
       public void TestCase2() {
           WebElement cPlusPlus =  driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[1]/label"));
           System.out.println(cPlusPlus.getText());

           WebElement java =  driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[2]/label"));
           System.out.println(java.getText());

           WebElement javaScript =  driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[3]/label"));
           System.out.println(javaScript.getText());
           Assert.assertTrue(cPlusPlus.isDisplayed(),"C++ is not displayed");
           Assert.assertTrue(java.isDisplayed(),"Java is not displayed");
           Assert.assertTrue(javaScript.isDisplayed(),"javaScript is not displayed");

       }

       @Test(description = "Verify that invalid input to first name box gives error message")
       public void TestCase3() {
           String expectedResult = "first name must be more than 2 and less than 64 characters long";
           driver.findElement(By.name("firstname")).sendKeys("a");
           String actualResult = driver.findElement(By.xpath("//small[text( )='first name must be more than 2 and less than 64 characters long']")).getText();
           WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));
           System.out.println(errorMessage.getText());
           Assert.assertTrue(errorMessage.isDisplayed(),"Error message is not displayed");
           Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");

       }
       @Test(description = "Verify that invalid input to last name box gives error message")
       public void TestCase4() {
           String expectedResult = "The last name must be more than 2 and less than 64 characters long";
           driver.findElement(By.name("lastname")).sendKeys("a");
           String actualResult = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']")).getText();
           WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]"));
           System.out.println(errorMessage.getText());
           Assert.assertTrue(errorMessage.isDisplayed(),"Error message is not is displayed");
           Assert.assertEquals(actualResult,expectedResult,"Warning message is not correct");
       }

       @Test(description = "Verify that after successful sign up verification message is displayed")
       public void TestCase5() {
          String expectedResult = "You've successfully completed registration!";

           driver.findElement(By.name("firstname")).sendKeys("Ibrohim");


           driver.findElement(By.name("lastname")).sendKeys("Ikromzoda");


           driver.findElement(By.name("username")).sendKeys("IbrohimJke");


           driver.findElement(By.name("email")).sendKeys("email@email.com");

           driver.findElement(By.name("password")).sendKeys("cybertek");


           driver.findElement(By.name("phone")).sendKeys("720-227-3433");

           driver.findElement(By.name("birthday")).sendKeys("02/02/1993");


           driver.findElement(By.name("department")).sendKeys("DE");

           driver.findElement(By.name("job_title")).sendKeys("SDET");

           driver.findElement(By.id("inlineCheckbox2")).click();

           driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[7]/div/div[1]/label/input")).click();

           driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]")).click();

           WebElement accessMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div"));
           System.out.println( accessMessage.getText());

           Assert.assertTrue(accessMessage.isDisplayed(),"Error message is not is displayed");





       }

       @AfterMethod
       public void teardown() {
           driver.quit();
       }

    }
