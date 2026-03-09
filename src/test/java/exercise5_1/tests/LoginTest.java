package exercise5_1.tests;

import base.BaseTest;
import exercise5_1.data.TestDataFactory;
import exercise5_1.models.TestUser;
import exercise5_1.pages.LoginPage;
import exercise5_1.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("LOGIN_PAGE"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin(){
        TestUser user = TestDataFactory.getNormalUser();
        ProfilePage profilePage = loginPage
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickSubmit();
        boolean check = profilePage.isDeleteButtonDisplayed();
        Assert.assertTrue(check, "Login failed.");
    }
}
