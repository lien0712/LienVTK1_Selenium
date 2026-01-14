package base;

import exercise1_2.elementLocators.ElementLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void getDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
