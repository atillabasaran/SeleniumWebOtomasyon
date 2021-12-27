package com.swo;

import Page.Index;
import Page.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class SWO {
    public static void main(String[] args) {
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);

        File file = new File("/home/mrbasaran/IdeaProjects/SeleniumTest/src/main/resources/log4j.properties");

        context.setConfigLocation(file.toURI());
        System.setProperty("webdriver.chrome.driver","/home/mrbasaran/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        Page index = new Index(driver);

    }
}
