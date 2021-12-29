package Page;

import Logger.Log;
import Util.CurrencyUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class Basket extends Page{

    public Basket(WebDriver driver) {
        this._driver = driver;
    }

    public void init(){
        countCheck();
        basket();
    }

    public boolean is2ProductsAvailable(){
        try {
            this._driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]"));
            this._driver.findElement(By.id("removeCartItemBtn0")).click();
            return true;
        }catch (NoSuchElementException e){
            this._driver.findElement(By.id("removeCartItemBtn0")).click();
            return false;
        }
    }

    public boolean countCheck(){
        String page = this._driver.getPageSource();
        Document doc = Jsoup.parse(page);
        String price = doc.getElementsByClass("m-productPrice__salePrice").text();
        try {
            this._driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]")).click();
        }catch (NoSuchElementException e){
            return false;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page = this._driver.getPageSource();
        doc = Jsoup.parse(page);
        String afterChangeCountPrice = doc.getElementsByClass("m-productPrice__salePrice").text();
        Double before = CurrencyUtils.StringCurrencyToInt(price);
        Double after = CurrencyUtils.StringCurrencyToInt(afterChangeCountPrice);
        if ((before*2) == after){
            return true;
        }
        return false;
    }

    public boolean basket(){
//        this._driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]")).click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      clear the basket
        this._driver.findElement(By.id("removeCartItemBtn0")).click();

//      basket cleared message check
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            this._driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/a"));
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
