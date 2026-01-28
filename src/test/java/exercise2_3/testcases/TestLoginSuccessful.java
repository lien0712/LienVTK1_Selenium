package exercise2_3.testcases;

import base.BaseTest;
import exercise2_3.pages.LoginPage;
import exercise2_3.pages.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
        boolean result = successPage.isLoggedIn();
        Assert.assertTrue(result, "Login should be successful");
        Assert.assertTrue(successPage.getSuccessText().contains("Successfully"), "Success message not displayed correctly");

    }

    @Test(groups = {"loginfail"})
    public void testInvalidUser() {
        loginPage.enterUsername(con.getDataInput("incorrectusername"));
        loginPage.enterPassword(con.getDataInput("password"));
        loginPage.clickSubmit();
        Assert.assertEquals(loginPage.getErrorMessage(), con.getDataInput("errorUsername"), "Error message mismatch");
    }

    @Test(groups = {"loginfail"})
    public void testInvalidPassword() {
        loginPage.enterUsername(con.getDataInput("username"));
        loginPage.enterPassword(con.getDataInput("incorrectpassword"));
        loginPage.clickSubmit();
        Assert.assertEquals(loginPage.getErrorMessage(), con.getDataInput("errorPassword"), "Error message mismatch");
    }

}
