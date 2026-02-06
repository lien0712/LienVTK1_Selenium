package exercise3_2.tests;

import base.BaseTest;
import exercise3_2.pages.FormsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    FormsPage formsPage;
    @BeforeMethod
    public void initPage(){
        driver.get("https://demoqa.com/automation-practice-form");
        formsPage = new FormsPage(driver);
    }

    @Test
    public void verifyForms(){
        formsPage.inputFirstName(con.getDataInput("firstname"));
        formsPage.inputLastName(con.getDataInput("lastname"));
        formsPage.inputEmail(con.getDataInput("email"));
        formsPage.selectDropdownValue(con.getDataInput("state"));
        formsPage.selectGender(con.getDataInput("gender"));
        formsPage.selectHobbies(con.getDataInput("hobbie"));
        String birthday = con.getDataInput("birthday");
        formsPage.chooseBirthdate(birthday.split("/")[0], birthday.split("/")[1],birthday.split("/")[2]);
    }
}
