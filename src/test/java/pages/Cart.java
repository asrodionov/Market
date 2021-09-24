package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Cart page object.
 */
public class Cart {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Close popup button.
     */
    @FindBy(css = "div[data-widget='alertPopup'] button svg")
    private WebElement closePopupButton;

    /**
     * Product favorite links.
     */
    @FindBy(xpath = "//span[contains(text(),'В избранное')]")
    private List<WebElement> favoriteLinks;

    /**
     * Delete product link.
     */
    @FindBy(xpath = "//div[@id='split-Main-0']//span[contains(text(),'Удалить')]")
    private WebElement deleteProductLink;

    /**
     * Confirm delete button.
     */
    @FindBy(css = "div[qa-id$=confirm-button]")
    private WebElement confirmDeleteButton;

    /**
     * H1 element.
     */
    @FindBy(css = "h1")
    private WebElement headerH1;

    /**
     * Page object constructor.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public Cart(final WebDriver webDriver) throws
            IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Getting product count text.
     *
     * @return count text
     */
    public int getProductCountInCart() {
        Waiters.waitNumberOfElementsToBeMoreThan(
                driver, "//span[contains(text(),'В избранное')]", 0);
        return favoriteLinks.size();
    }

    /**
     * Closing popup.
     *
     * @return Cart page
     */
    public Cart closePopup() {
        closePopupButton.click();
        return this;
    }

    /**
     * Deleting product is cart.
     *
     * @return Cart page
     */
    public Cart deleteProduct() {
        deleteProductLink.click();
        confirmDeleteButton.click();
        Waiters.waitUntilElementVisibility(
                driver, headerH1);
        return this;
    }

    /**
     * Deleting product is cart.
     *
     * @return header text
     */
    public String getHeaderText() {
        return headerH1.getText();
    }
}
