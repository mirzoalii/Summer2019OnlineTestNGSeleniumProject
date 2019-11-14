package tests.day5;

public class notes {

    /*
    Today is 10/22/2019
Agenda:
    WebElement
    findElement
    click()
    sendKeys()
    getText()
    getAttribute()
#####################################################
Open inspector in Chrome. Right click --> inspect.
In the inspector we are reading a source to create locators.
Locator, it's thing that helps selenium to find element, and later work with that element. For example: click, enter text, read text/attributes, select, etc.
In the Selenium, we have a WebElement Interface
Interface is like class, but has different purpose.
WebElement represents any kind of element on the page.
purple - tag
orange - attribute
blue - value of attribute
black - text
click command + F on mac, or control + F on windows.
When you have a task, to automate something, first you need to read and analyze. Based on acceptance criteria/business requirements you develop a test script. Before any automation, test it manually.
#####For automation
First, you need to find elements. For this, we have 8 locators.
 id
 name
 tagname
 className
 xpath // will work everywhere and always
 cssSelector
 linkText
 partialLinkText
 As of today, we are using id.
 Id it's the best way to find element. ID must be unique. Also, in terms of performance, it's the fastest way to find element.
WebElement element = new WebElement(); // it will not work
Because it's an interface.
Instead, we do:
WebElement element = driver.findElement(By.id("value"));
Then, to click, we use click() method.
element.click();
###Test 1: Verify that URL has not changed
Go to http://practice.cybertekschool.com/forgot_password
Click on retrieve password button
Verify that page title didn't change (in this case, we verify that same page is still open)
To check if id is unique, put # before id in the inspector search:
#form_submit
 WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //once we opened the page, we have to capture a title
        BrowserUtils.wait(2);
        String expectedTitle = driver.getTitle();
        // Step 1. Open inspector in chrome and find locator for the element
        // Step 2. Create object of WebElement
        // Step 3. Use webelement
        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
        //read title again, after clicking
        String actualTitle = driver.getTitle();
        //in this way, we're making sure that after clicking
        //we stay on the same page
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected title: "+expectedTitle);
            System.out.println("Actual title: "+actualTitle);
        }
        //wait for 2 seconds
        BrowserUtils.wait(2);
        driver.close();
When you have opened an inspector tool in Chrome, press command + F or control + F and you will see input box. That input box stands for locators verification. You have to enter your lcoator and hit enter. It will show you how many element were found based on your locator. For id, put # to search specifically ids.
To enter the text, we use .sendKeys("text") method.
locator - it's an address of element on the page. There are different lcoators, but goal is the same - to find element.
WebElement element = driver.findElement(By.id("value"));
element.sendKeys("text");
###Test 2, Verify that URL changed
1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"
###Test 3, Verify that confirmation message is displayed
1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that message "Your e-mail's been sent!" is displayed
         WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        //to read value of any attribute
        //name="email" name it's an attribute, email it's a value of attribute
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random_email@email.com");
        //how to read entered text?
        //it's gonna be inside value attribute
        System.out.println(input.getAttribute("value"));
        //if button has a type "submit"
        //we can use .submit() method instead of click() as well
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //alternative to click, only if type="submit"
        retrievePasswordButton.submit();
        driver.close();

     */
}
