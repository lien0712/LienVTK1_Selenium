package exercise1_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PracticePage extends BasePage {
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By loginSuccessText = By.xpath("//h1[normalize-space()='Logged In Successfully']");
    private By loginFailText = By.id("error");

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    public void loginAccount(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public void verifySuccessMessage(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(loginSuccessText),
                ExpectedConditions.visibilityOfElementLocated(loginFailText)
        ));
        List<WebElement> success = driver.findElements(loginSuccessText);
        List<WebElement> fail = driver.findElements(loginFailText);
        if (!success.isEmpty()){
            System.out.println("Success");
        }else if(!fail.isEmpty()){
            System.out.println("Fail");
        }
    }
}
