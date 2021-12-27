package com.swo;

import Page.Index;
import Page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class SWO {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/mrbasaran/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        Page index = new Index(driver);
    }
}
