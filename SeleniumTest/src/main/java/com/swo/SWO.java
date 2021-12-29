package com.swo;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SWO {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/mrbasaran/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        new Index(driver).init();
        new Search(driver).init();
        new Product(driver).init();
        new Basket(driver).init();
    }
}
