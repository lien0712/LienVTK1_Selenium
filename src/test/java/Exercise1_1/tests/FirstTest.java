package Exercise1_1.tests;

import Base.BaseTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FirstTest extends BaseTest {

    @Test
    public void testOpenDriver() {
        Properties prop = new Properties();

        try {
            InputStream input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            driver.navigate().to(prop.getProperty("url"));
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
