public class WebDriverTest {

    private WebDriver driver;

    @Parameters({"username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("vijayasekhar") String username,
                      @Optional("04828aa7-a7d9-41a0-8b41-0a6aff7ee14d") String key,
                      @Optional("Windows 7") String os,
                      @Optional("firefox") String browser,
                      @Optional("18") String browserVersion,
                      Method method) throws Exception {

        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", Platform.valueOf(os));
        capabilities.setCapability("name", method.getName());
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @Test
    public void webDriver() throws Exception {
        // Make the browser get the page and check its title
        driver.get("http://www.amazon.com/");
        assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
