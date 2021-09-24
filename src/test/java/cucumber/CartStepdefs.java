package cucumber;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import pages.Cart;
import pages.Ozon;
import pages.Search;

public class CartStepdefs {

    /**
     * Ozon page.
     */
    private Ozon ozon = new Ozon(Hooks.getDriver());
    /**
     * Cart page.
     */
    private Cart cart;
    /**
     * Search page.
     */
    private Search search;

    /**
     * Поиск товара.
     *
     * @param productName название товара
     */
    @Когда("Пользователь ищет товар {string}")
    public void searchProduct(String productName) {
        search = ozon.searchProduct(productName);
    }

    /**
     * Добавление товара в корзину.
     */
    @И("Кладет его в корзину")
    public void addProductInCart() {
        cart = search.addProductInCart()
                .closePopup();
    }

    /**
     * Проверка присутствия товара в корзине.
     */
    @Тогда("Пользователь проверяет что в корзине присутствует товаров {int}")
    public void checkCountProductInCart(int productCount) {
        Assertions.assertEquals(productCount, cart.getProductCountInCart());
    }

    /**
     * Удаление товара из корзины.
     */
    @Когда("Пользователь удаляет товар из корзины")
    public void deleteProductInCart() {
        cart.deleteProduct();
    }

    /**
     * Проверка отсутствия товара в корзине.
     */
    @Тогда("Пользователь проверяет что корзина пуста")
    public void checkCartIsEmpty() {
        Assertions.assertEquals("Корзина пуста", cart.getHeaderText());
    }
}
