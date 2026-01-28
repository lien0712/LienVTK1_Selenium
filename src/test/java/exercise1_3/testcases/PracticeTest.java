package exercise1_3.testcases;

import base.BaseTest;
import exercise1_3.pages.PracticePage;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest extends BaseTest {
    PracticePage practicePage;

    @BeforeMethod
    public void initPage(){
        practicePage = new PracticePage(driver);
        driver.navigate().to(con.getDataInput("urllogin"));
        String parentWindow = driver.getWindowHandle();
        String currentURL = driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(currentURL);
        driver.switchTo().window(parentWindow);
    }

    @Test
    public void testLoginSuccessful(){
        practicePage.loginAccount(con.getDataInput("username"), con.getDataInput("password"));
        practicePage.verifySuccessMessage();
    }

    @Test
    public void testInvalidUsername(){
        practicePage.loginAccount(con.getDataInput("invalidusername"), con.getDataInput("password"));
        practicePage.verifyFailMessage(con.getDataInput("errorUsername"));
    }

    @Test
    public void testInvalidPassword(){
        practicePage.loginAccount(con.getDataInput("username"), con.getDataInput("invalidpassword"));
        practicePage.verifyFailMessage(con.getDataInput("errorPassword"));
    }
}
