package IndexTest;

import BaseTest.BaseTest;
import Page.Basket;
import Page.Product;
import Page.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BasketTest extends BaseTest {

    @Test
    @Order(1)
    public void priceEqualShouldReturnTrue(){
        Basket basket = new Basket(this.driver);
        new Search(this.driver).init();
        new Product(this.driver).init();
        Assertions.assertTrue(basket.countCheck());
    }

    @Test
    @Order(2)
    public void basketIsClear(){
        Basket basket = new Basket(this.driver);
        this.driver.get("https://www.beymen.com");
        new Search(this.driver).init();
        new Product(this.driver).init();
        Assertions.assertTrue(basket.basket());
    }
}
