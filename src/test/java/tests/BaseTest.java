package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import constants.Browser;
import pages.BlogPage;
import pages.HomePage;
import pages.SignInPage;
import pages.TrainingListPage;
import utils.DriverFactory;

import java.lang.reflect.Method;

import static org.openqa.selenium.Keys.ENTER;

public abstract class BaseTest {
    private static WebDriver driver;
    private Logger LOG = Logger.getLogger(BaseTest.class);

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "dP1")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"fsashaukr.net"}, {"@fsasha@ukr.net"}, {"fsasha@ukrnet"}, {"12345678901234567890123456789012345678901234567890123456789012345@ukr.net"}, {"fsasha@ukr.n"}, {"fsasha@ukr.netnetnetne"}};
    }

    @DataProvider(name = "dP2")
    public Object[][] dataProviderMethod2() {
        return new Object[][]{{"1234567890123456789012345678901234567890123456789012345678901234@ukr.net"}, {"fsasha@i.ua"}, {"fsasha@ukr.netnetnetn"}};
    }


}
