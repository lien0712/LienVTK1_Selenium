package exercise4_2.tests;

import base.BaseTest;
import exercise4_2.pages.IFramePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    IFramePage iFramePage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("BROWSER_FRAME"));
        iFramePage = new IFramePage(driver);
    }

    @Test
    public void testSwitchByIndex(){
        int size = iFramePage.getSizeFrame();
        System.out.println(size);
        int index = 1;
        Assert.assertTrue(index< size, "Index out of bounds");
        iFramePage.switchByIndex(index);
        String message = iFramePage.getMessage();
        Assert.assertEquals(message, "This is a sample page", "Could not switch to iframe");
        iFramePage.switchMain();
        Assert.assertTrue(iFramePage.checkMain(), "Could not switch to main");
    }
}
