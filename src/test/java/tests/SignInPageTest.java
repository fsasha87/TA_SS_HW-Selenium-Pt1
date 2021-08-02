package tests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccesefullyLoggedIn() {
        HomePage homePage = new HomePage();
        homePage.proceedToHomePage();
        homePage.clickButton();
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail("ivanhorintest@gmail.com");
        signInPage.clickContinueButton();
        signInPage.enterPassword("ivanhorintestPassword");
        signInPage.clickSignInButton();
        homePage.isUserNameDisplayed();
    }

    @Test(description = "verify user was not logged in with incorrect password")
    public void verifyUserWasNotLoggedIn() {
        HomePage homePage = new HomePage();
        homePage.proceedToHomePage();
        homePage.clickButton();
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail("ivanhorintest@gmail.com");
        signInPage.clickContinueButton();
        signInPage.enterPassword("xxx");
        signInPage.clickSignInButton();
        signInPage.verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "verify user was not logged in with incorrect mail", dataProvider = "dP1")
    public void verifyUserWasNotLoggedInWithIncorrectMail(String mail) {
        HomePage homePage = new HomePage();
        homePage.proceedToHomePage();
        homePage.clickButton();
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail(mail);
        signInPage.checkContinueButtonIsDisable();
    }

    @Test(description = "verify user was logged with bondary values in mail", dataProvider = "dP2")
    public void verifyUserWasLoggedInWithBondaryValuesInMail(String mail) {
        HomePage homePage = new HomePage();
        homePage.proceedToHomePage();
        homePage.clickButton();
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail(mail);
        signInPage.clickContinueButton();
        signInPage.checkPasswordFieldIsEnable();
    }

    @Test(description = "verify user wrote correct mail")
    public void verifyUserWroteCorrectMail() {
        HomePage homePage = new HomePage();
        homePage.proceedToHomePage();
        homePage.clickButton();
        SignInPage signInPage = new SignInPage();
        signInPage.enterEmail("ivanhorintest@gmail.com");
        signInPage.clickContinueButton();
        signInPage.checkPasswordFieldIsEnable();
    }
}
