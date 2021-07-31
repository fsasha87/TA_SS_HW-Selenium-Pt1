package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by");
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
