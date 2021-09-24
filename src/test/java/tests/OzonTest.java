package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.Cart;
import pages.Ozon;

public class OzonTest extends BaseSetUpTests {

    /**
     * Test case OZN-1. Adding and delete product in cart.
     */
    @Test
    public void checkAddAndDeleteProductInCart() {
        Cart cart =
                new Ozon(getDriver())
                        .searchProduct("whey gold standard 5 lb")
                        .addProductInCart()
                        .closePopup();
        Assertions.assertEquals(1, cart.getProductCountInCart());
        String headerText = cart.deleteProduct()
                .getHeaderText();
        Assertions.assertEquals("Корзина пуста", headerText);
    }
}
