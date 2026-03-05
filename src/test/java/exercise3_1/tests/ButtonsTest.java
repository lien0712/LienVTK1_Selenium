package exercise3_1.tests;

import base.BaseTest;
import exercise3_1.pages.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    ButtonsPage buttonsPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("urlbutton"));
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testDoubleClick(){
        String doubleMessage = buttonsPage.doubleClick();
        Assert.assertEquals(doubleMessage,con.getDataInput("doublemessage"));
    }

    @Test
    public void testRightClick(){
        String rightMessage = buttonsPage.rightClick();
        Assert.assertEquals(rightMessage,con.getDataInput("rightmessage"));
    }

    @Test
    public void testClick(){
        String clickMessage = buttonsPage.clickMe();
        Assert.assertEquals(clickMessage,con.getDataInput("clickmessage"));
    }

}
