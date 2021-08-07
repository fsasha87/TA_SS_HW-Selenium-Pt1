package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        wait = new WebDriverWait(driver, 10);
        executor = (JavascriptExecutor) driver;
    }

    void proceedToPage(final String url) {
        getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }


    List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    void moveToElement(By locator) {
        Actions actions = new Actions(getDriver());
        WebElement webElement = getElement(locator);
        actions.moveToElement(webElement);
    }
    void clickWithJavaScript(WebElement element) {
        executor.executeScript("arguments[0].click()", element);
    }


}
