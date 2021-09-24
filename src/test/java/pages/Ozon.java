package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Ozon page object.
 */
public class Ozon {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Search input element.
     */
    @FindBy(css = ".search-bar-wrapper input[type='text']")
    private WebElement searchInput;

    /**
     * Search button element.
     */
    @FindBy(css = ".search-bar-wrapper button")
    private WebElement searchButton;

    /**
     * Page object constructor.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public Ozon(final WebDriver webDriver) throws
            IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Searching product.
     *
     * @param productName name of product
     * @return search page object
     */
    public Search searchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchButton.click();
        return new Search(driver);
    }
}
