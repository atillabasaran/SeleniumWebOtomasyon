package Page;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.jsoup.Jsoup;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Index extends Page{

    String URL = "https://www.beymen.com";

    public Index(WebDriver driver) {
        this._driver = driver;
        init();
    }

    public void init() {
        _driver.get(URL);
        this._driver.manage().window().maximize();
        accCheck();
        favCheck();
        basketCheck();
        search();
        Soup();
        String price = Product();
        priceCheck(price);
        Basket();
    }

    private boolean check(String xpath){
        try {
            this._driver.findElement(By.xpath(xpath));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


    private void accCheck(){
        if(check("/html/body/header/div/div/div[3]/div/a[1]")){
            System.out.println("Hesap Kontrol Basarili");
        }else{
            System.out.println("Hesap Kontrol Basarisiz");
        }
    }

    private void favCheck(){
        if(check("/html/body/header/div/div/div[3]/div/a[2]")){
            System.out.println("Favoriler Kontrol Basarili");
        }else{
            System.out.println("Favoriler Kontrol Basarisiz");
        }
    }

    private void basketCheck(){
        if(check("/html/body/header/div/div/div[3]/div/a[3]")){
            System.out.println("Sepet Kontrol Basarili");
        }else{
            System.out.println("Sepet Kontrol Basarisiz");
        }
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

    private String Product(){
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

    private void Basket(){
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
