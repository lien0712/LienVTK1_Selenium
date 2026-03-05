package exercise5_2.tests;

import Utils.CSVUtils;
import Utils.ExcelUtils;
import base.BaseTest;
import exercise5_2.page.LoginPage;
import exercise5_2.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("LOGIN_PAGE"));
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData1")
    public Object[][] getLoginData1() {
        return new Object[][] {
                {"student", "Aa@123456", true},
                {"invalid", "invalid", false},
                {"student", "", false}
        };
    }

    @DataProvider(name = "loginData2")
    public Object[][] getLoginData2() throws Exception {
        return CSVUtils.readCSV("src/test/resources/account.csv");
    }

    @DataProvider(name = "loginData3")
    public Object[][] getLoginData() throws Exception {
        return ExcelUtils.readExcel(
                "src/test/resources/account.xlsx",
                "account"
        );
    }

    @Test(dataProvider = "loginData1")
    public void testLogin1(String username, String password, boolean expectedResult){
        ProfilePage profilePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickSubmit();
        boolean check = profilePage.isDeleteButtonDisplayed();
        if (expectedResult) {
            Assert.assertTrue(check, "Expected login SUCCESS but FAILED - user: " + username);
        } else {
            Assert.assertFalse(check, "Expected login FAIL but SUCCEEDED - user: " + username);
        }
    }

    @Test(dataProvider = "loginData2")
    public void testLogin2(String username, String password, String expectedResult){
        ProfilePage profilePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickSubmit();
        boolean check = profilePage.isDeleteButtonDisplayed();
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(check, "Expected login FAILED - user: " + username);
        } else {
            Assert.assertFalse(check, "Expected login FAIL - user: " + username);
        }
    }

    @Test(dataProvider = "loginData3")
    public void testLogin3(String username, String password, String expectedResult){
        ProfilePage profilePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickSubmit();
        boolean check = profilePage.isDeleteButtonDisplayed();
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(check, "Expected login FAILED - user: " + username);
        } else {
            Assert.assertFalse(check, "Expected login FAIL - user: " + username);
        }
    }
}
