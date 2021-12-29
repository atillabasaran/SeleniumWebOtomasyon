package BaseTest;

import PageTest.TestLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public class BaseTest {

    protected WebDriver driver ;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/home/mrbasaran/Documents/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

}