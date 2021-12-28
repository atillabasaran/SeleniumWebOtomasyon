package Page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Basket extends Page{
    public Basket(WebDriver driver) {
        this._driver = driver;
        init();
    }

    public void init(){
        basket();
    }

    private void basket(){
//      Product count is 2
        this._driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]")).click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      clear the basket
        this._driver.findElement(By.id("removeCartItemBtn0")).click();

//      basket cleared message check
        String page = this._driver.getPageSource();
        Document doc = Jsoup.parse(page);
        String message = doc.getElementsByClass("m-empty__messageTitle").text();
        if (message.equals("Sepetinizde Ürün Bulunmamaktadır")) {
            System.out.println("Project is done");
        }

    }

}
