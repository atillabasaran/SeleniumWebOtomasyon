package com.swo;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class SWO {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/mrbasaran/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        Page index = new Index(driver);
        Page search = new Search(driver);
        Page product = new Product(driver);
        Page basket = new Basket(driver);
    }
}
