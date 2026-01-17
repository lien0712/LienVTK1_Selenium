package exercise1_2.pages;

import base.BasePage;
import org.example.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {

    ConfigReader con = new ConfigReader();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.cssSelector("input[placeholder='name@example.com'");
    private By genderRadio = By.xpath("//label[normalize-space()='Male']");
    private By mobileInput = By.xpath("//input[@id='userNumber']");
    private By hobbiesCheckbox = By.xpath("//label[text()='Reading']");
    // /preceding-sibling::input
    private By stateDropdown = By.xpath("//div[@id='state']");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void inputInformation() {
        driver.findElement(firstNameInput).sendKeys(con.getDataInput("firstname"));
        driver.findElement(lastNameInput).sendKeys(con.getDataInput("lastname"));
        driver.findElement(emailInput).sendKeys(con.getDataInput("email"));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(genderRadio));
        driver.findElement(genderRadio).click();
        driver.findElement(mobileInput).sendKeys(con.getDataInput("phone"));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hobbiesCheckbox));
        driver.findElement(hobbiesCheckbox).click();
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(stateDropdown));
        driver.findElement(stateDropdown).click();
        String xpathOption = "//div[contains(@class, 'option') and text()='NCR']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOption)));
        option.click();
    }
}
