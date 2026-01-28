package exercise2_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPage extends BasePage {
    @FindBy(xpath = "//h1[@class='post-title' and contains(text(),'Successfully')]")
    private WebElement successText;

    public SuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSuccessText(){
        wait.until(ExpectedConditions.visibilityOf(successText));
        return successText.getText();
    }

    public boolean isLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(successText));
        return successText.isDisplayed();
    }
}
