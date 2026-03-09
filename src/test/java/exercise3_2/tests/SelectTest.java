package exercise3_2.tests;

import base.BaseTest;
import exercise3_2.pages.SelectPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest extends BaseTest {
    SelectPage selectPage;

    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/select-menu");
        selectPage = new SelectPage(driver);
    }

    @Test
    public void verifySelectOneValue(){
        String value = con.getDataInput("VALUE1");
        String returnText = selectPage.selectOneValue(value);
        Assert.assertEquals(returnText, value);
    }

    @Test
    public void verifyMultiSelectDropdown(){
        selectPage.standardMultiSelect(con.getDataInput("VALUE2"), con.getDataInput("VALUE3"));
    }
}
