package exercise2_3.testcases;

import base.BaseTest;
import exercise2_3.pages.LoginPage;
import exercise2_3.pages.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLoginSuccessful extends BaseTest {
    LoginPage loginPage;
    SuccessPage successPage;

    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage(driver);
        successPage = new SuccessPage(driver);
        driver.navigate().to(con.getDataInput("urllogin"));
    }

    @Test(groups = {"loginsuccess"})
    public void testValidLogin() {
        loginPage.enterUsername(con.getDataInput("username"));
        loginPage.enterPassword(con.getDataInput("password"));
        loginPage.clickSubmit();
    }

    @Test(groups = {"loginfail"})
    public void testInvalidUser() {
        loginPage.enterUsername(con.getDataInput("invalidusername"));
        loginPage.enterPassword(con.getDataInput("password"));
        loginPage.clickSubmit();
    }

    @Test(groups = {"loginfail"})
    public void testInvalidPassword() {
        loginPage.enterUsername(con.getDataInput("username"));
        loginPage.enterPassword(con.getDataInput("invalidpassword"));
        loginPage.clickSubmit();
    }

    @Test(groups = {"loginsuccess"})
    public void testVerifyLoginSuccessful() {
        String successText = successPage.getSuccessText();
        Assert.assertTrue(!successText.isEmpty(), "Expected success message not found");
    }

    @Test(groups = {"loginfail"})
    public void testVerifyLoginFail() {
        boolean result = successPage.isLoggedIn();
        Assert.assertTrue(!result, "Login fail");
    }
}
