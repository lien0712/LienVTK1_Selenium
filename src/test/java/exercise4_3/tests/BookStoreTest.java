package exercise4_3.tests;

import base.BaseTest;
import exercise4_3.pages.BookStorePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTest extends BaseTest {
    BookStorePage bookStorePage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("BOOK_PAGE"));
        bookStorePage = new BookStorePage(driver);
    }

    @Test
    public void testGitBookName(){
        String name = bookStorePage.getGitBookName("Git Pocket Guide");
        Assert.assertEquals(name, "Git Pocket Guide", "Could not get name");
    }

    @Test
    public void testNumberButton(){
        int number = bookStorePage.numberButton();
        Assert.assertEquals(number, 4, "Get the wrong number");
    }

    @Test
    public void testLoginButton(){
        String title = bookStorePage.bookGitDetail();
        Assert.assertEquals(title,"Git Pocket Guide", "Could not access detail book" );
    }

    @Test
    public void testAuthorName(){
        String title = bookStorePage.getBook("Learning JavaScript Design Patterns");
        Assert.assertEquals(title,"Addy Osmani", "Could not get author" );
    }
}
