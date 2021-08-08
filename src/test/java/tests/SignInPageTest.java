package tests;

import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "dP1")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"fsashaukr.net"}, {"@fsasha@ukr.net"}, {"fsasha@ukrnet"}, {"12345678901234567890123456789012345678901234567890123456789012345@ukr.net"}, {"fsasha@ukr.n"}, {"fsasha@ukr.netnetnetne"}};
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

    @DataProvider(name = "dP2")
    public Object[][] dataProviderMethod2() {
        return new Object[][]{{"1234567890123456789012345678901234567890123456789012345678901234@ukr.net"}, {"fsasha@i.ua"}, {"fsasha@ukr.netnetnetn"}};
    }

    @Test(description = "verify user was logged with bondary values in mail", dataProvider = "dP2")
    public void verifyUserWasLoggedInWithBondaryValuesInMail(String mail) {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .enterEmail(mail)
                .clickContinueButton()
                .checkPasswordFieldIsDisplayed();
    }

    @Test(description = "verify user wrote correct mail using softasserts")
    public void verifyUserWroteCorrectMail() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .checkPasswordFieldIsDisplayedBySoftAssert()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton();
        new HomePage()
                .verifyUserNameDisplayedBySoftAssert();
    }

}
