package exercise4_1.tests;

import base.BaseTest;
import exercise4_1.pages.AlertPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    AlertPage alertPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("ALERT_PAGE1"));
        alertPage = new AlertPage(driver);
    }

    @Test
    public void testAlert(){
        String text = alertPage.getAlertOKResult();
        Assert.assertEquals(text, con.getDataInput("ALERT_RESULT"),"Could not access the alert");
    }

    @Test
    public void testConfirmOK(){
        String text = alertPage.getConfirmOKResult();
        Assert.assertEquals(text, con.getDataInput("CONFIRM_OK"),"Could not access the confirm");
    }

    @Test
    public void testConfirmCancel(){
        String text = alertPage.getConfirmCancelResult();
        Assert.assertEquals(text, con.getDataInput("CONFIRM_CANCEL"), "Could not access the confirm");
    }

    @Test
    public void testPromptOK(){
        String text = alertPage.getPromptTextOKResult(con.getDataInput("TEXT_INPUT"));
        Assert.assertEquals(text, con.getDataInput("PROMPT_OK"),"Could not access the prompt");
    }

    @Test
    public void testPromptCancel(){
        String text = alertPage.getPromptTextCancelResult(con.getDataInput("TEXT_INPUT"));
        Assert.assertEquals(text, con.getDataInput("PROMPT_CANCEL"), "Could not access the prompt");
    }

    @Test
    public void testTwoPrompt(){
        driver.get(con.getDataInput("ALERT_PAGE2"));
        String text1 = alertPage.getFirstPrompt(con.getDataInput("TEXT_INPUT"));
        Assert.assertEquals(text1, "First", "Could not access the alert");
        String text2 = alertPage.getSecondPrompt(con.getDataInput("TEXT_INPUT"));
        Assert.assertEquals(text2, "Second", "Could not access the alert");
    }

    @Test
    public void testSlowAlert(){
        driver.get(con.getDataInput("ALERT_PAGE2"));
        String text = alertPage.getSlowAlertResult();
        Assert.assertEquals(text, "Slow", "Could not access the slow alert");
    }
}
