package exercise1_2.testcases;

import base.BaseTest;
import exercise1_2.pages.PracticeFormPage;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void elementLocatorsTest() {
        driver.navigate().to(con.getDataInput("urldemoqa"));
        PracticeFormPage pr = new PracticeFormPage(driver);
        pr.inputInformation();
    }
}
