package Page;

import org.openqa.selenium.*;

public class Index extends Page{

    String URL = "https://www.beymen.com";

    public Index(WebDriver driver) {
        this._driver = driver;
    }

    public void init() {
        this._driver.manage().window().maximize();
        _driver.get(URL);
        accCheck();
        favCheck();
        basketCheck();
    }

    private boolean check(String xpath){
        try {
            this._driver.findElement(By.xpath(xpath));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


    public boolean accCheck(){
        return check("/html/body/header/div/div/div[3]/div/a[1]");
    }

    public boolean favCheck(){
        return check("/html/body/header/div/div/div[3]/div/a[2]");
    }

    public boolean basketCheck(){
        return check("/html/body/header/div/div/div[3]/div/a[3]");
    }


}
