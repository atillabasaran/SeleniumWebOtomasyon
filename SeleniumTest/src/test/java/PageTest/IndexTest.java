package PageTest;

import BaseTest.BaseTest;
import Page.Index;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndexTest extends BaseTest {


    @Test
    public void accCheckShouldReturnTrue(){
        Index indexPage = new Index(this.driver);
        Assertions.assertTrue(indexPage.accCheck());
    }
    @Test
    public void favCheckShouldReturnTrue(){
        Index indexPage = new Index(this.driver);
        Assertions.assertTrue(indexPage.favCheck());
    }
    @Test
    public void basketCheckShouldReturnTrue(){
        Index indexPage = new Index(this.driver);
        Assertions.assertTrue(indexPage.basketCheck());
    }
}
