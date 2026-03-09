package exercise5_3.tests;

import base.BaseTest;
import com.deque.html.axecore.results.Rule;
import exercise5_3.pages.BookStorePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BookStoreTest extends BaseTest {
    BookStorePage bookStorePage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("BOOK_PAGE"));
        bookStorePage = new BookStorePage(driver);
    }

    @Test
    public void testKeyboardNavi(){
        String tagname = bookStorePage.keyboardNavi();
        Assert.assertEquals(tagname,"a");
    }

    @Test
    public void testColorConstrast(){
        double ratio = bookStorePage.colorConstract();
        Assert.assertEquals(ratio,1.0);
    }

    @Test
    public void testScreenReaderCompatibility(){

        List<Rule> violations = bookStorePage.checkScreenReader();

        for (Rule v : violations) {
            System.out.println("Violation: " + v.getId());
            System.out.println("Description: " + v.getDescription());
            System.out.println("Help: " + v.getHelp());
        }

        Assert.assertEquals(violations.size(), 7, "Accessibility violations found!");
    }
}
