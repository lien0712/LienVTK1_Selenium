package exercise4_2.tests;

import base.BaseTest;
import exercise4_2.pages.NestedFramePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTest extends BaseTest {
    NestedFramePage nestedFramePage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("NESTED_FRAME"));
        nestedFramePage = new NestedFramePage(driver);
    }

    @Test
    public void testNestedFrame(){
        String childText = nestedFramePage.switchToChild();
        Assert.assertEquals(childText, "Child Iframe", "Could not switch to child frame");
        String parentText = nestedFramePage.switchToParent();
        Assert.assertTrue(parentText.contains("Parent frame") ,"Could not switch to parent frame");
    }
}
