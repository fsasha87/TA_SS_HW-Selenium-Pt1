package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        driver.findElement(mailField).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public SignInPage clickContinueButton() {
        driver.findElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password) {
        driver.findElement(passField).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public HomePage clickSignInButton() {
        driver.findElement(signInButtonOnPassWindow).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        WebElement errorMessageElement = driver.findElement(errorMessage);
        Assert.assertTrue(errorMessageElement.isEnabled(), "Error message is not enabled");
        LOG.info("Error message is displayed");
    }

    public void checkContinueButtonIsDisable() {
        WebElement continueButtonElement = driver.findElement((continueButton));
        Assert.assertFalse(continueButtonElement.isEnabled(), "Continue button is enabled");
        LOG.info("Continue button is disabled");
    }

    public void checkPasswordFieldIsEnable() {
        WebElement passFieldElement = driver.findElement((passField));
        Assert.assertTrue(passFieldElement.isEnabled(), "Password field is disabled");
        LOG.info("Password field is enabled");
    }
}
