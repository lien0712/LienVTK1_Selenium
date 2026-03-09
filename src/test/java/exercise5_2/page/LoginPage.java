package exercise5_2.page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    By loginButton = By.xpath("//button[text()='Login']");
    By usernameInput = By.xpath("//input[contains(@id, 'user')]");
    By passwordInput = By.id("password");
    By welcomeMessage = By.cssSelector("form>div:first-child>h5");
    By newUser = By.id("newUser");
    By userName = By.cssSelector("#userName-value");
    By registerText = By.cssSelector("#userForm>div:first-child>h4");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username){
        super.sendKeys(usernameInput,username);
        return this;
    }

    public LoginPage enterPassword(String password){
        super.sendKeys(passwordInput,password);
        return this;
    }

    public ProfilePage clickSubmit(){
        super.click(loginButton);
        return new ProfilePage(driver);
    }

    public String getName(){
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        return name.getText();
    }

    public String getWelcome(){
        return driver.findElement(welcomeMessage).getText();
    }

    public String goCreateUser(){
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(newUser));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", button
        );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerText)).getText();
    }

}
