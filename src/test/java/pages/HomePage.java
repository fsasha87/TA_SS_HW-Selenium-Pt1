package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.logging.Logger;

import static utils.Constants.HOME_PAGE_URL;

public class HomePage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));
    private By signInButton = By.className("header-auth__signin");
    private By userName = By.className("user-info__name");

    public HomePage() {
        super();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Proceeded to '%s' URL.",HOME_PAGE_URL));
        return this;
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
