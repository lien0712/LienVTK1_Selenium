package exercise4_1.pages;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage {
    By alertButton = By.xpath("//button[normalize-space()='Click for JS Alert']");
    By confirmButton = By.xpath("//button[normalize-space()='Click for JS Confirm']");
    By promptButton = By.xpath("//button[normalize-space()='Click for JS Prompt']");
    By resultText = By.id("result");
    By twoPromptLink = By.id("double-prompt");
    By slowAlertLink = By.id("slow-alert");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertOKResult(){
        driver.findElement(alertButton).click();
        driver.switchTo().alert().accept();
        return driver.findElement(resultText).getText();
    }

    public String getConfirmOKResult(){
        driver.findElement(confirmButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return driver.findElement(resultText).getText();
    }

    public String getConfirmCancelResult(){
        driver.findElement(confirmButton).click();
        driver.switchTo().alert().dismiss();
        return driver.findElement(resultText).getText();
    }

    public String getPromptTextOKResult(String text){
        driver.findElement(promptButton).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return driver.findElement(resultText).getText();
    }

    public String getPromptTextCancelResult(String text){
        driver.findElement(promptButton).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.dismiss();
        return driver.findElement(resultText).getText();
    }

    public String getFirstPrompt(String text){
        driver.findElement(twoPromptLink).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        String result = alert.getText();
        alert.accept();
        return result;
    }

    public String getSecondPrompt(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        String resutl = alert.getText();
        alert.accept();
        return resutl;
    }

    public String getSlowAlertResult(){
        driver.findElement(slowAlertLink).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String result = alert.getText();
        alert.accept();
        return result;
    }
}
