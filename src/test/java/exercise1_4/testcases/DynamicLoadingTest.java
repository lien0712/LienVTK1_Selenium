package exercise1_4.testcases;

import base.BaseTest;
import exercise1_4.pages.DynamicLoadingPage;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    DynamicLoadingPage loadingPage;

    @Test
    public void dynamicTest(){
        loadingPage = new DynamicLoadingPage(driver);
        driver.get(con.getDataInput("urlloading"));
        loadingPage.clickButton();
        loadingPage.waitForLoadingDisappear();
        loadingPage.verifySuccess();
    }
}
