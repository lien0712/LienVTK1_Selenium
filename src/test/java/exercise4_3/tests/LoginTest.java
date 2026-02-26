package exercise4_3.tests;

import base.BaseTest;
import exercise4_3.pages.LoginPage;
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
    public void testUserInput(){
        String name = loginPage.inputUserName(con.getDataInput("USERNAME"));
        Assert.assertEquals(name, con.getDataInput("USERNAME"));
    }

    @Test
    public void testLogin(){
        loginPage.login(con.getDataInput("USERNAME"), con.getDataInput("PASSWORD") );
        String name = loginPage.getName();
        Assert.assertEquals(name,con.getDataInput("USERNAME"), "Login failed.");
    }

    @Test
    public void testAccessLogin(){
        String message = loginPage.getWelcome();
        Assert.assertEquals(message, "Login in Book Store", "Access Login failed.");
    }

    @Test
    public void testAccessSignUp(){
        String text = loginPage.goCreateUser();
        Assert.assertEquals(text, "Register to Book Store", "Access Sign Up page failed.");
    }
}
