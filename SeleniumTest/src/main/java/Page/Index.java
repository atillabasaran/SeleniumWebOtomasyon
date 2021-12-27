package Page;

import org.openqa.selenium.*;

public class Index extends Page{

    String URL = "https://www.beymen.com";

    public Index(WebDriver driver) {
        this._driver = driver;
        init();
    }

    public void init() {
        _driver.get(URL);
        accCheck();
        favCheck();
        basketCheck();
        search();
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
        WebElement search = this._driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));
        search.sendKeys("Pantalon");
        search.sendKeys(Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) this._driver;
    }
}
