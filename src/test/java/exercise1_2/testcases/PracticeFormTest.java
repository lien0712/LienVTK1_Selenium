package exercise1_2.testcases;

import base.BaseTest;
import exercise1_2.pages.PracticeFormPage;
import org.example.ConfigReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PracticeFormTest extends BaseTest {

    @Test
    public void elementLocatorsTest() {
        ConfigReader con = new ConfigReader();
        driver.navigate().to(con.getDataInput("urldemoqa"));
        PracticeFormPage pr = new PracticeFormPage(driver);
        pr.inputInformation();
    }
}
