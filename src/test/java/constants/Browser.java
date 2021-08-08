package constants;

public enum Browser {
    CHROME ("src/main/resources/chromedriver.exe", "webdriver.chrome.driver"),
    IE ("src/main/resources/geckodriver.exe","webdriver.ie.driver"),
    FIREFOX ("src/main/resources/geckodriver.exe", "webdriver.gecko.driver"),
    OPERA ("src/main/resources/operadriver.exe", "webdriver.opera.driver");
    private String DRIVER_LOCATION;
    private String DRIVER_NAME;

    Browser(String DRIVER_LOCATION, String DRIVER_NAME) {
        this.DRIVER_LOCATION = DRIVER_LOCATION;
        this.DRIVER_NAME = DRIVER_NAME;
    }

    public String getDRIVER_LOCATION() {
        return DRIVER_LOCATION;
    }

    public String getDRIVER_NAME() {
        return DRIVER_NAME;
    }
}
