package base;

import org.example.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected ConfigReader con;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.con = new ConfigReader();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
