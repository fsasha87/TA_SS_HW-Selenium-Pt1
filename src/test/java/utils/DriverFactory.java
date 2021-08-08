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
    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty(Browser.CHROME.getDRIVER_NAME(), Browser.CHROME.getDRIVER_LOCATION());
                driver = new ChromeDriver();
                break;
            case IE:
                System.setProperty(Browser.IE.getDRIVER_NAME(), Browser.IE.getDRIVER_LOCATION());
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                System.setProperty(Browser.FIREFOX.getDRIVER_NAME(), Browser.FIREFOX.getDRIVER_LOCATION());
                driver = new FirefoxDriver();
                break;
            case OPERA:
                System.setProperty(Browser.OPERA.getDRIVER_NAME(), Browser.OPERA.getDRIVER_LOCATION());
                driver = new OperaDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

