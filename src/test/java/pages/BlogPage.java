package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

public class BlogPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(BlogPage.class));
    String links = "//a[contains(@href,'#!/News/Category/'%s'')]";

    public BlogPage verifyNavLinksDisplayed(String link) {

        List<WebElement> linksList = getElements(By.xpath(String.format("(links)", link)));
        LOG.info(String.format("Link '%s' is displayed", link));
        for (WebElement webElement : linksList) {
            Assert.assertTrue(webElement.isDisplayed(), String.format("Link '%s' is not displayed", link));
        }
        return new BlogPage();
    }


}
