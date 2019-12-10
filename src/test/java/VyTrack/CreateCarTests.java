package VyTrack;

import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;

public class CreateCarTests extends TestBase {

    @Test(description = "Create some random car")
    public void test1(){
        extentTest = extentReports.createTest("Create a new car");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        CreateCarPage createCarPage = new CreateCarPage();

        loginPage.login("storemanager85", "UserUser123");
        loginPage.navigateTo("Fleet", "Vehicles");

        loginPage.waitUntilLoaderMaskDisappear();

        vehiclesPage.clickToCreateACar();

        loginPage.waitUntilLoaderMaskDisappear();

        createCarPage.licensePlateElement.sendKeys("911");
        createCarPage.selectTags("Convertible");
        createCarPage.driverElement.sendKeys("Ibrohim Ikromzoda");
        createCarPage.locationElement.sendKeys("Los Angelees");
        createCarPage.modelYearElement.sendKeys("2019");
        createCarPage.lastOdometerElement.sendKeys("450");
        createCarPage.seatsNumberElement.sendKeys("5");
        createCarPage.doorsNumberElement.sendKeys("4");
        createCarPage.colorElement.sendKeys("MatteBlack");
        createCarPage.selectFuelType("Electric");

        loginPage.waitUntilLoaderMaskDisappear();
        createCarPage.saveAndCloseButtonElement.click();

        extentTest.pass("New car was created");
    }
}
