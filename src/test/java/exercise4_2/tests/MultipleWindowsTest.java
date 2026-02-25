package exercise4_2.tests;

import base.BaseTest;
import exercise4_2.pages.MultipleWindowsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends BaseTest {
    MultipleWindowsPage mPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("BROWSER_WINDOWS"));
        mPage = new MultipleWindowsPage(driver);
    }

    @Test
    public void testMultipleWindows(){
        String mainWindow = mPage.getWindowHandle();
        String newWindow = mPage.openNewWindow();
        String newWindowMess = mPage.getMessage();
        System.out.println(newWindowMess);
        Assert.assertEquals(newWindowMess,"This is a sample page", "Could not switch to new window");

        mPage.switchToWindow(mainWindow);
        String newTab = mPage.openNewTab();
        String newTabTitle = mPage.getMessage();
        System.out.println(newTabTitle);
        Assert.assertEquals(newTabTitle,"This is a sample page", "Could not switch to new tab");

        mPage.switchToWindow(mainWindow);
        String newMessageWindow = mPage.openNewWindowMess();

        mPage.closeAllNewWindow(mainWindow);
        mPage.switchToWindow(mainWindow);
        Assert.assertEquals(mPage.getTotalWindows(),1, "Could not close the window");
    }
}
