package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static helpers.DataClass.IMPLICITLY_TIMEOUT;
import static helpers.DataClass.URL;

/**
 * Hooks for cucumber.
 */
public class Hooks {
    /**
     * Driver.
     */
    private static WebDriver driver;

    /**
     * Get Driver.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Before test.
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(
                IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    /**
     * After test.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
