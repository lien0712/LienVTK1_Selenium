package exercise2_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPage extends BasePage {
    @FindBy(xpath = "//h1[containsIgnoreCase(text(),'Successfully')]")
    private By successText;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessText(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successText));
        return driver.findElement(successText).getText();
    }

    public boolean isLoggedIn(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successText));
        String parentWindow = driver.getWindowHandle();
        String currentURL = driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(currentURL);
        driver.switchTo().window(parentWindow);
        return driver.findElement(successText).isDisplayed();
    }
}
