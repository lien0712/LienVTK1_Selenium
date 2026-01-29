package exercise1_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PracticePage extends BasePage {
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By loginSuccessText = By.xpath("//h1[contains(text(),'Successfully')]");
    private By loginFailText = By.id("error");

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    public void loginAccount(String username, String password){
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameField.clear();
        usernameField.sendKeys(username);
        WebElement passwordField= wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        button.click();
    }

    public void verifySuccessMessage(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(loginSuccessText)
        ));
        List<WebElement> success = driver.findElements(loginSuccessText);
        if (!success.isEmpty()) {
            Assert.assertTrue(success.get(0).isDisplayed(), "Login successful");
        }
    }

    public void verifyFailMessage(String failMessage){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(loginFailText)
        ));
        List<WebElement> fail = driver.findElements(loginFailText);
        if(!fail.isEmpty()){
            String errorMessage = fail.get(0).getText();
            Assert.assertEquals(errorMessage,failMessage);
        }else {
            Assert.fail("Fail message not displayed");
        }

    }
}
