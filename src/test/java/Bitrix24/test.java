package Bitrix24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class test {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/auth/?logout=yes&backurl=%2Fstream%2F");

    }
    @Test
    public void login() {
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")).sendKeys("helpdesk1@cybertekschool.com");
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[2]/input")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

         WebElement message = driver.findElement(By.name("'xhpc_message']"));
         message.click();
         message.sendKeys("Hello World");




    }



}
