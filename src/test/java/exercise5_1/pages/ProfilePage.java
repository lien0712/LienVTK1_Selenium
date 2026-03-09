package exercise5_1.pages;

import base.BaseAuthenticatedPage;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BaseAuthenticatedPage {
    By deleteButton = By.xpath("//button[text()='Delete Account']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDeleteButtonDisplayed(){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        return webElement.isDisplayed();
    }
}

