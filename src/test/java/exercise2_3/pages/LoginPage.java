package exercise2_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private By usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private By passwordInput;
    @FindBy(xpath = "//button[@id='submit']")
    private By submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(passwordInput));
        driver.findElement(usernameInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

}
