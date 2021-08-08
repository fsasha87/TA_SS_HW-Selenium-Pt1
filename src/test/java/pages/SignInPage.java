package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class SignInPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));
    private By mailField = By.id("username");
    private By continueButton = By.id("kc-login-next");
    private By passField = By.id("password");
    private By signInButtonOnPassWindow = By.id("kc-login");
    private By errorMessage = By.id("alert-error");

    public SignInPage() {
        super();
    }

    public SignInPage enterEmail(String email) {
        getElement(mailField).sendKeys(email);
        LOG.info(String.format("Mail '%s' was written.", email));
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passField).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButtonOnPassWindow).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public SignInPage login(String email, String password){
        enterEmail(email);
        clickContinueButton();
        enterPassword(password);
        clickSignInButton();
        return  this;
    }

    public SignInPage verifyFailedLoginErrorMessageDisplayed() {
        WebElement errorMessageElement = getElement(errorMessage);
        Assert.assertTrue(errorMessageElement.isDisplayed(), "Error message is not enabled");
        LOG.info("Error message is displayed");
        return this;
    }

    public SignInPage checkContinueButtonIsDisable() {
        WebElement continueButtonElement = getElement(continueButton);
        Assert.assertFalse(continueButtonElement.isEnabled(), "Continue button is enabled");
        LOG.info("Continue button is disabled");
        return this;
    }

    public SignInPage checkPasswordFieldIsDisplayed() {
        WebElement passFieldElement = getElement((passField));
        Assert.assertTrue(passFieldElement.isDisplayed(), "Password field is disabled");
        LOG.info("Password field is displayed");
        return this;
    }
    public SignInPage checkPasswordFieldIsDisplayedBySoftAssert() {
        SoftAssert softAssert = new SoftAssert();
        WebElement passFieldElement = getElement((passField));
        softAssert.assertTrue(passFieldElement.isDisplayed(), "Password field is disabled");
        LOG.info("Password field is displayed");
        softAssert.assertAll();
        return this;
    }
}
