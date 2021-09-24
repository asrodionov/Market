package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static helpers.DataClass.*;

public class BaseSetUpTests {
    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Getting driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Test setup.
     */
    @BeforeEach
    public final void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(
                IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    /**
     * Suite teardown.
     */
    @AfterEach
    public final void tearDown() {
        driver.quit();
    }
}
