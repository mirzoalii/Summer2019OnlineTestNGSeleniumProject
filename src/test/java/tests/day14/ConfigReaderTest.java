package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void test1() {
        String expectedBrowser = "chrome";
        //we write in "keys" as a string
        //as a return, you will get value
        //key=value
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        //read value of user_name property
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        //read value of password property
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }
}
