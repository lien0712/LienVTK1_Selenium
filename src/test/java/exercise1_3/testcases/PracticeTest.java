package exercise1_3.testcases;

import base.BaseTest;
import exercise1_3.pages.PracticePage;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {
    PracticePage practicePage;

    @Test
    public void loginTest(){
        practicePage = new PracticePage(driver);
        driver.navigate().to(con.getDataInput("urllogin"));
        practicePage.loginAccount(con.getDataInput("username"), con.getDataInput("password"));
        practicePage.verifySuccessMessage();
    }
}
