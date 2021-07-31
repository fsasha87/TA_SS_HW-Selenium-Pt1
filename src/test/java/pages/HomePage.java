package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.logging.Logger;

public class HomePage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));
    private By signInButton = By.className("header-auth__signin");
    private By userName = By.className("user-info__name");

    public HomePage() {
        super();
    }

    public SignInPage clickButton() {
        driver.findElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public void isUserNameDisplayed() {
        WebElement userNameElement = driver.findElement(userName);
        Assert.assertTrue(userNameElement.isDisplayed(), "Element isn't displayed");
        LOG.info("User Name is displayed on the top-right conner");
    }
}
