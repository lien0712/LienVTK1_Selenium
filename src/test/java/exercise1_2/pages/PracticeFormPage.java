package exercise1_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeFormPage extends BasePage {

    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("userEmail");
    private By mobileInput = By.xpath("//input[@id='userNumber']");
    // /preceding-sibling::input
    private By stateDropdown = By.xpath("//div[@id='state']");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public By genderRadio(String text){
        String xpathGender = String.format("//div[@id='genterWrapper']//label[text()='%s']", text);
        return By.xpath(xpathGender);
    }

    public By hobbiesCheckbox(String text){
        String xpathHobbies = String.format("//div[@id='hobbiesWrapper']//label[text()='%s']", text);
       return By.xpath(xpathHobbies);
    }

    public void inputInformation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(firstNameInput).sendKeys(con.getDataInput("firstname"));
        driver.findElement(lastNameInput).sendKeys(con.getDataInput("lastname"));
        driver.findElement(emailInput).sendKeys(con.getDataInput("email"));
        By gender = genderRadio(con.getDataInput("gender"));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(gender));
        driver.findElement(gender).click();
        driver.findElement(mobileInput).sendKeys(con.getDataInput("phone"));
        By hobbie = hobbiesCheckbox(con.getDataInput("hobbie"));
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hobbie));
        driver.findElement(hobbie).click();
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(stateDropdown));
        driver.findElement(stateDropdown).click();
        String xpathOption = "//div[contains(@class, 'option') and text()='NCR']";
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOption)));
        option.click();
    }
}
