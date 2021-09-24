package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Search page object.
 */
public class Search {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Search result container.
     */
    @FindBy(css = ".widget-search-result-container")
    private WebElement searchResultContainer;

    /**
     * Cart buttons element.
     */
    @FindBy(css = ".widget-search-result-container button > div > div")
    private List<WebElement> cartButtons;

    /**
     * Cart link element.
     */
    @FindBy(css = "a[href='/cart']")
    private WebElement cartLink;

    /**
     * Page object constructor.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public Search(final WebDriver webDriver) throws
            IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Adding product in cart.
     *
     * @return Cart page
     */
    public Cart addProductInCart() {
        Waiters.waitUntilElementVisibility(driver, searchResultContainer);
        cartButtons.get(0).click();
        cartLink.click();
        return new Cart(driver);
    }
}
