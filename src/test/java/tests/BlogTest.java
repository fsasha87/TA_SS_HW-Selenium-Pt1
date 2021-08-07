package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;
import pages.SignInPage;
import pages.TrainingListPage;

public class BlogTest extends BaseTest {
    @DataProvider(name = "dP3")
    public Object[][] dataProviderMethod3() {
        return new Object[][]{{"news"}, {"real-stories"}, {"materials"}, {"hard-skills"}, {"soft-skills"}, {"events"}};
    }

    @Test (description = "Verify navigation links are displayed", dataProvider = "dP3")
    public void verifyFilterInTrainings(String link) {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .login("ivanhorintest@gmail.com", "ivanhorintestPassword");
        new BlogPage()
                .verifyNavLinksDisplayed(link);
    }
}
