package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

public class TrainingListPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(TrainingListPage.class));
    private By trainingsFilter = By.xpath("//input[@name = 'training-filter-input']");
    private By skillsFilter = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click, 'Skill')]");
    String checkboxFilter = "(//label[normalize-space()='%s']/input)[1]";
    private By noResultsMessage = By.xpath("//div[@class = 'training-list__subscribe-text']/span[1]");
    String searchResultsCourses = "//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']";
    private By locationFilter = By.xpath("//div[contains(@ng-click, 'Location')]");
    String locationCountry = "//div[contains(text(),'%s')]";
    String locationCity = "(//label[normalize-space()='Lviv']/input)[1]";
    String searchResultsByCityAndMulti = "//div[contains(@class, 'training-list__desktop')]//span[normalize-space()='%s'] | //div[contains(@class, 'training-list__desktop')]//div[normalize-space()='Multi-location']";

    public TrainingListPage clickTrainingsFilterInput() {
        getElement(trainingsFilter).click();
        LOG.info("'Trainings Filter' button is clicked");
        return this;
    }

    public TrainingListPage moveToTrainingsFilter() {
        moveToElement(trainingsFilter);
        LOG.info("Scroll to trainings filter button.");
        return this;
    }


    public TrainingListPage clickSkillsFilter() {
        getElement(skillsFilter).click();
        LOG.info("'Skills Filter' button is clicked");
        return this;
    }

    public TrainingListPage clickCheckboxFilter(String value) {
        WebElement checkboxFilterElement = driver.findElement(By.xpath(String.format(checkboxFilter, value)));
        if (!checkboxFilterElement.isSelected()) {
            clickWithJavaScript(checkboxFilterElement);
        }
        LOG.info(String.format("'CheckBox' '%s' is clicked", value));
        return this;
    }

    public TrainingListPage uncheckCheckboxFilter(String value) {
        WebElement checkboxFilterElement = driver.findElement(By.xpath(String.format(checkboxFilter, value)));
        if (checkboxFilterElement.isSelected()) {
            clickWithJavaScript(checkboxFilterElement);
        }
        LOG.info(String.format("'CheckBox' '%s' is unclicked", value));
        return this;
    }

    public TrainingListPage verifySearchResultsCoursesInLowerCase(String value) {
        boolean isTrue = false;
        List<WebElement> coursesList = getElements(By.xpath(String.format(searchResultsCourses, value)));
        for (WebElement course : coursesList) {
            if ((course.getText().toLowerCase().contains(value))) {
                isTrue = true;
            }
        }
        LOG.info(String.format("All cources contain '%s'. It is '%s'", value, isTrue));
        return this;
    }

    public void verifyNoResultsMessageDisplayed() {
        WebElement noResultsMessageElement = getElement(noResultsMessage);
        LOG.info("Without results message is displayed");
        Assert.assertTrue(noResultsMessageElement.isDisplayed(), "There is no without-results message");
    }

    public TrainingListPage clickLocationFilter() {
        getElement(locationFilter).click();
        LOG.info("'Locations Filter' button is clicked");
        return this;
    }

    public TrainingListPage clickLocationCountry(String country) {
        getElement(By.xpath(String.format(locationCountry, country))).click();
        LOG.info(String.format("Country '%s' Filter' button is clicked", country));
        return this;
    }

    public TrainingListPage clickLocationCity (String value) {
        WebElement locationCityElement = driver.findElement(By.xpath(String.format(locationCity, value)));
        if (!locationCityElement.isSelected()) {
            clickWithJavaScript(locationCityElement);
        }
        LOG.info(String.format("'CheckBox City' '%s' is clicked", value));
        return this;
    }

    public TrainingListPage verifySearchResultsHaveCountryAndMulti(String county) {
        boolean isTrue = false;
        List<WebElement> coursesList = getElements(By.xpath(String.format(searchResultsByCityAndMulti, county)));
        for (WebElement course : coursesList) {
            if ((course.getText().contains(county))) {
                isTrue = true;
            }
        }
        LOG.info(String.format("All cources contain '%s'. It is '%s'", county, isTrue));
        return this;
    }
}