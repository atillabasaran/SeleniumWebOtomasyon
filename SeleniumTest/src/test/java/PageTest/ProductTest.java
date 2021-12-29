package PageTest;

import BaseTest.BaseTest;
import Page.Product;
import Page.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    public void priceIsEqual(){
        Search search = new Search(this.driver);
        Product product = new Product(this.driver);
        search.search();
        search.selectRandomProduct();
        Assertions.assertTrue(product.priceCheck(product.product()));
    }
}
