package exercise1_2.tests;

import base.BaseTest;
import exercise1_2.elementLocators.ElementLocators;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElementLocatorsTest extends BaseTest {

    @Test
    public void elementLocatorsTest() {
        Properties prop = new Properties();
        ElementLocators elementLocators;

        try {
            InputStream input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            driver.navigate().to(prop.getProperty("urldemoqa"));
            elementLocators = new ElementLocators(driver);
            elementLocators.getAllElements();
            input.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }
}
