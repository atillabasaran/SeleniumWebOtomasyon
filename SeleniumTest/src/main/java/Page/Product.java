package Page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Product extends Page {
    public Product(WebDriver driver) {
        this._driver = driver;
        init();
    }

    public void init() {

        priceCheck(product());
    }

    private String product(){
        // select minimum size and add basket after then I keep the price of the product,
        // so I can to compare in basket price
        this._driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[2]/div[3]/div/div/span[1]")).click();
        WebElement addBasket = this._driver.findElement(By.id("addBasket"));
        addBasket.click();
        String page = this._driver.getPageSource();
        Document doc = Jsoup.parse(page);
        String price = doc.getElementsByClass("m-price__new").text();
        WebElement basket = this._driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/a[3]/span"));
        basket.click();
        return price;
    }

    private void priceCheck(String productPrice){
//      This function compare the price
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String page = this._driver.getPageSource();
        Document doc = Jsoup.parse(page);
        String price = doc.getElementsByClass("m-productPrice__salePrice").text();
        if (productPrice.equals(price)){
            System.out.println("Urun fiyati dogrudur.");
        }else{
            System.out.println("Urun fiyati yanlis.");
        }
    }
}
