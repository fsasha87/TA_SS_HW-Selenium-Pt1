package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.Browser;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
    }

    @AfterMethod
    public void tearDown() {
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
