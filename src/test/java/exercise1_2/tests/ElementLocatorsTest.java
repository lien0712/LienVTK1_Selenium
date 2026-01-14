package exercise1_2.tests;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElementLocatorsTest extends BaseTest {

    @Test
    public void elementLocatorsTest() {
        Properties prop = new Properties();

        try {
            InputStream input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            driver.navigate().to(prop.getProperty("urldemoqa"));
            input.close();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

}
