package pages;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }

    void  proceedToPage(final String url) {
        getDriver().get(url);
    }

}
