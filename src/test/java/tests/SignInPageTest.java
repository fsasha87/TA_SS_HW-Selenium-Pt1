package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccesefullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .login("ivanhorintest@gmail.com", "ivanhorintestPassword");
        new HomePage()
                .verifyUserNameDisplayed();
    }

    @Test(description = "verify user was not logged in with incorrect password")
    public void verifyUserWasNotLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .login("ivanhorintest@gmail.com", "xxx")
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify user was not logged in with incorrect mail", dataProvider = "dP1")
    public void verifyUserWasNotLoggedInWithIncorrectMail(String mail) {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .enterEmail(mail)
                .checkContinueButtonIsDisable();
    }

    @Test(description = "verify user was logged with bondary values in mail", dataProvider = "dP2")
    public void verifyUserWasLoggedInWithBondaryValuesInMail(String mail) {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .enterEmail(mail)
                .clickContinueButton()
                .checkPasswordFieldIsEnable();
    }

    @Test(description = "verify user wrote correct mail")
    public void verifyUserWroteCorrectMail() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .checkPasswordFieldIsEnable();
    }

}
