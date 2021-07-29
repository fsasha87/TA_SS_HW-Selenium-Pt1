import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardCodedTests {
    WebDriver driver;

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

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccesefullyLoggedIn() {
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailField = driver.findElement(By.id("username"));
        mailField.sendKeys("fsasha87@ukr.net");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("MyPass");
        WebElement signInButtonOnPassWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPassWindow.click();
        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed());
    }

    @Test(description = "verify user was not logged in with incorrect password")
    public void verifyUserWasNotLoggedIn() {
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailField = driver.findElement(By.id("username"));
        mailField.sendKeys("fsasha87@ukr.net");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("xxx");
        WebElement signInButtonOnPassWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPassWindow.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert-error")));
        WebElement errorMessage = driver.findElement(By.id("alert-error"));
        Assert.assertTrue(errorMessage.isEnabled(), "Element is not Enabled");
    }
}
