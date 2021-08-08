package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.logging.Logger;
import static constants.Constants.HOME_PAGE_URL;

public class HomePage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));
    private By signInButton = By.className("header-auth__signin");
    private By userName = By.className("user-info__name");
    private By trainingsListButton = By.xpath("//nav[@class = 'main-nav']//a[contains(@class, 'training')]");
    private By blogButton = By.xpath("//nav[@class = 'main-nav']//a[contains(@class, 'news')]");

    public HomePage() {
        super();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public SignInPage clickButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public SignInPage verifyUserNameDisplayed() {
        WebElement userNameElement = getElement(userName);
        LOG.info("User Name is displayed on the top-right conner");
        Assert.assertTrue(userNameElement.isDisplayed(), "Element isn't displayed");
        return new SignInPage();
    }

    public SignInPage verifyUserNameDisplayedBySoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        WebElement userNameElement = getElement(userName);
        LOG.info("User Name is displayed on the top-right conner");
        softAssert.assertTrue(userNameElement.isDisplayed(), "Element isn't displayed");
        softAssert.assertAll();
        return new SignInPage();
    }

    public TrainingListPage clicktTrainingsListButton() {
        getElement(trainingsListButton).click();
        LOG.info("'Trainings List' button is clicked");
        return new TrainingListPage();
    }

    public BlogPage clickBlogPageButton() {
        getElement(blogButton).click();
        LOG.info("'Blog' button is clicked");
        return new BlogPage();
    }
}
