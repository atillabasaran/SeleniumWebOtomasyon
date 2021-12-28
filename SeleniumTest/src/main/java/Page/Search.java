package Page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Search extends Page{


    public Search(WebDriver driver) {
        this._driver = driver;
        init();
    }

    public void init(){
        search();
        Soup();
    }

    private void search(){
//      find input and enter "pantalon"
        JavascriptExecutor js = (JavascriptExecutor) this._driver;
        WebElement search = this._driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));
        search.sendKeys("Pantalon");
//      Press the Enter key
        search.sendKeys(Keys.ENTER);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      Scroll down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//      show more
        this._driver.findElement(By.id("moreContentButton")).click();
    }

    private void Soup(){
        Random rn = new Random();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String page = this._driver.getPageSource();
        Document doc = Jsoup.parse(page);
//      find out how many products in page and pick a randomly
        Elements products = doc.getElementsByClass("col-sm-4 col-md-4 col-lg-4 o-productList__itemWrapper");
//        int randNumber = rn.nextInt(products.size())+2;
//        System.out.println(randNumber);
        int randNumber = 32;

//      enter the randomly selected product
        String xpath = String.format("/html/body/div[5]/div/div[1]/div[2]/div[%d]",randNumber);
        WebElement product = this._driver.findElement(By.xpath(xpath));
        product.click();
    }

}
