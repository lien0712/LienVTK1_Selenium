package exercise5_3.tests;

import base.BaseTest;
import exercise5_2.page.LoginPage;
import exercise5_3.pages.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/checkbox");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void testAriaLabel(){
        String text = checkBoxPage.checkAriaLabels();
        Assert.assertNotNull(text);
    }

    @Test
    public void testRole(){
        String role = checkBoxPage.getRole();
        Assert.assertEquals(role, "treeitem");
    }
}
