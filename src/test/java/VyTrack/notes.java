package VyTrack;

public class notes {

    /*

   Today is 12/3/2019
    Agenda: Page Object Model day 2
#################################
    Page Object Model - it's a design pattern that is commonly used in test automation. The idea is to create java class for every page of application. By doing this, we are separating test from page elements. Name of page class corresponds to name of web page. For example: Login page = LoginPage.java.
    Also, we use PageFactory to enhance POM. PageFactory enables @FindBy, @FindBys, @FindAll annotation that helps to find elements easier.
//according to page object model design
//we have to create corresponded page class
//for each page of application
//login page = login page class
//every page class will store webelements and methods related to that page
public class LoginPage extends BasePage{
    @FindBy(id = "prependedInput") //this line will initialize web element
    public WebElement userNameInput;
    @FindBy(id = "prependedInput2")//without findby, web element will be null
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement loginButton;
    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;
    public LoginPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }
    /**
     * reusable login method
     * just call this method to login
     * provide username and password as parameters
     * @param userName
     * @param password
     */

    }




