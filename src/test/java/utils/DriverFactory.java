package utils;

import constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;
    private static final String DRIVER_PATH = "src/main/resources/";
    public static WebDriver getDriver(Browser browser) {
        File file;
        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case IE:
                file = new File(DRIVER_PATH + "IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH + "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
            case OPERA:
                file = new File(DRIVER_PATH + "operadriver.exe");
                System.setProperty("webdriver.opera.driver", file.getAbsolutePath());
                driver = new OperaDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

