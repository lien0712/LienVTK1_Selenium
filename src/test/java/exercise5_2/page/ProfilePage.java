package exercise5_2.page;

import base.BaseAuthenticatedPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BaseAuthenticatedPage {
    By deleteButton = By.xpath("//button[text()='Delete Account']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDeleteButtonDisplayed(){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton)).isDisplayed();
//            return driver.findElement(By.id("delete-btn")).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}

