package tests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.TrainingListPage;

public class TrainingListTest extends BaseTest {
    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’")
    public void verifyFilterInSkills() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .login("ivanhorintest@gmail.com", "ivanhorintestPassword");
        new TrainingListPage()
                .moveToTrainingsFilter()
                .clickTrainingsFilterInput()
                .clickSkillsFilter()
                .clickCheckboxFilter("Java")
                .verifySearchResultsCoursesInLowerCase("java")
                .uncheckCheckboxFilter("Java")
                .clickCheckboxFilter("Ruby")
                .verifyNoResultsMessageDisplayed();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifyFilterInLocations() {
        new HomePage()
                .proceedToHomePage()
                .clickButton();
        new SignInPage()
                .login("ivanhorintest@gmail.com", "ivanhorintestPassword");
        new TrainingListPage()
                .moveToTrainingsFilter()
                .clickTrainingsFilterInput()
                .clickLocationFilter()
                .clickLocationCountry("Ukraine")
                .clickLocationCity("Lviv")
                .verifySearchResultsHaveCountryAndMulti("Ukraine");
    }
}
