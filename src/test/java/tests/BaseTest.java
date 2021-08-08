package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverFactory;

import java.lang.reflect.Method;

import static constants.Browser.CHROME;

public abstract class BaseTest {
    private Logger LOG = Logger.getLogger(BaseTest.class);


    @BeforeMethod
    public void setUp(final Method method) {
        DriverFactory.initDriver(CHROME);
        LOG.info(String.format("Test '%s' started.",method.getName()));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(final Method method) {
        LOG.info(String.format("Test '%s' is completed", method.getName()));
        DriverFactory.quitDriver();
    }

}
