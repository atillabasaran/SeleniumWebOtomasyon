package PageTest;

import BaseTest.BaseTest;
import Page.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class SearchTest extends BaseTest{


    @Test
    @Order(1)
    public void searchWithCorrectLink(){
        Search searchpage = new Search(this.driver);
        searchpage.search();
        Assertions.assertEquals("https://www.beymen.com/search?q=pantolan", this.driver.getCurrentUrl());
    }

    @Test
    @Order(3)
    public void checkIfProductPageValid(){
        this.driver.get("https://www.beymen.com/");
        Search searchpage = new Search(this.driver);
        searchpage.search();
        searchpage.selectRandomProduct();
        Assertions.assertDoesNotThrow(() -> {this.driver.findElement(By.id("addBasket"));});
    }

    @Test
    @Order(2)
    public void checkIfProductPageInvalid(){
        this.driver.get("https://www.beymen.com/search?q=pantalon");
        Assertions.assertThrows(NoSuchElementException.class , ()->{
            this.driver.findElement(By.id("addBasket")).isEnabled();
        });
    }
}

